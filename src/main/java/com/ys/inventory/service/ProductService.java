package com.ys.inventory.service;


import com.github.pagehelper.PageHelper;
import com.ys.inventory.common.exception.BusinessException;
import com.ys.inventory.common.utils.Constants;
import com.ys.inventory.common.utils.Page;
import com.ys.inventory.common.utils.SecurityUtil;
import com.ys.inventory.common.utils.UUIDUtil;
import com.ys.inventory.common.validator.Validator;
import com.ys.inventory.entity.Material;
import com.ys.inventory.entity.Product;
import com.ys.inventory.entity.ProductTempMaterial;
import com.ys.inventory.mapper.MaterialMapper;
import com.ys.inventory.mapper.ProductMapper;
import com.ys.inventory.mapper.ProductTempMapper;
import com.ys.inventory.mapper.ProductTempMaterialMapper;
import com.ys.inventory.vo.ProductInsertVO;
import com.ys.inventory.vo.ProductSearchVO;
import com.ys.inventory.vo.ProductUpdateVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liusihua.
 * @date 2018/09/11.
 * 注:  需要回归接口添加 注解 ：@Transactional(rollbackFor = Exception.class)
 */

@Service
@EnableTransactionManagement
public class ProductService {
    @Autowired(required = false)
    private ProductMapper productMapper;

    @Autowired(required = false)
    private ProductTempMapper productTempMapper;

    @Autowired(required = false)
    private ProductTempMaterialMapper productTempMaterialMapper;

    @Autowired(required = false)
    private MaterialMapper materialMapper;

    public void insert(ProductInsertVO vo) {
        // 插入验证
        ValidatorInsert(vo);
        //是否存在重名产品
        boolean flag = productMapper.isNotExistProduct(vo.getProductName());
        if (flag) {
            throw new BusinessException("产品已经存在,请尝试进行入库、出库等操作.");
        }
        //产品信息入库
        productMapper.insert(createInsertProduct(vo));
    }

    private Product createInsertProduct(ProductInsertVO vo) {
        Product product = new Product();
        product.setCreateUser(SecurityUtil.getUserId());
        product.setProductId(UUIDUtil.getUUID());
        product.setProductName(vo.getProductName());
        product.setProductDescription(vo.getProductDescription());
        product.setProductNum(Integer.parseInt(vo.getProductNum()));
        return product;
    }

    private void ValidatorInsert(ProductInsertVO vo) {
        // 原料名称
        Validator.notNull(vo.getProductName(), "产品名称不能为空");
        checkLength(vo.getProductName(), 30, "产品名称长度不得超过 30 个字符");
        // 原料数量
        Validator.notNull(vo.getProductNum(), "个数不能为空");
        if (!vo.getProductNum().matches(Constants.REGEX_POSITIVE_INTEGER) || vo.getProductNum().length() > Integer.valueOf(Constants.SIX)) {
            throw new BusinessException("个数只能输入正整数,并且长度不得超过6位数");
        }
        // 原料描述
        Validator.notNull(vo.getProductDescription(), "原料描述不能为空");
        checkLength(vo.getProductDescription(), 255, "原料描述长度不得超过 255 个字符");
    }


    private void checkLength(String str, int length, String message) {
        if (StringUtils.isNotEmpty(str) && str.length() > length) {
            throw new BusinessException(message);
        }
    }

    public void updateProduct(ProductUpdateVO vo) {
        productMapper.updateProduct(createUpdateProduct(vo));
    }

    private Product createUpdateProduct(ProductUpdateVO vo) {
        Product product = new Product();
        product.setProductId(vo.getProductId());
        product.setProductName(vo.getProductName());
        product.setProductDescription(vo.getProductDescription());
        return product;
    }

    public Page<Product> find(ProductSearchVO product) {
        PageHelper.startPage(product);
        //查询数据
        List<Product> list = productMapper.find(product);
        return new Page<>(list);
    }

    public void delete(String productId, String updateTime) {
        Product product = productMapper.get(productId);
        Map<String, String> mapperParam = new HashMap<>(2);
        mapperParam.put("productId", productId);
        mapperParam.put("updateUser", SecurityUtil.getUserId());
        productMapper.delete(mapperParam);

        /*
        //恢复原料数据
        List<ProductTempMaterial> productTempMaterialList = productTempMaterialMapper.selectByProductTempId(product.getProductTempId());
        for (ProductTempMaterial productTempMaterial : productTempMaterialList) {
            Material material = materialMapper.get(productTempMaterial.getMaterialId());
            //param=模板中的原料数量*产品数量
            BigDecimal param = productTempMaterial.getMaterialNum().multiply(new BigDecimal(product.getProductNum()));
            //原料剩余+param
            material.setMaterialNum(material.getMaterialNum().add(param));
            materialMapper.updateMaterial(material);
        }
         */
    }

    public Product get(String productId) {
        return productMapper.get(productId);
    }

    @Transactional(rollbackFor = Exception.class)
    public void productStorage(ProductInsertVO vo) {
        //入库产品数量
        Product product = productMapper.get(vo.getProductId());
        if (product != null) {
            product.setProductNum(product.getProductNum() + Integer.valueOf(vo.getProductNum()));
            productMapper.updateProduct(product);
            //修改对应的原料的数量
            //获取对应的模板信息
            List<ProductTempMaterial> productTempMaterialList = productTempMaterialMapper.selectByProductTempId(vo.getProductTempId());
            for (ProductTempMaterial productTempMaterial : productTempMaterialList) {

                Material material = materialMapper.get(productTempMaterial.getMaterialId());
                //param=模板中的原料数量*产品数量
                BigDecimal param = productTempMaterial.getMaterialNum().multiply(new BigDecimal(vo.getProductNum()));
                //原料剩余-param
                if (material.getMaterialNum().compareTo(param) == -1) {
                    throw new BusinessException("所需要的原料: " + material.getMaterialName() + " 不足,请先补充该原料");
                }

                material.setMaterialNum(material.getMaterialNum().subtract(param));
                materialMapper.updateMaterial(material);
            }
        } else {
            throw new BusinessException("数据异常,请联系管理员.");
        }
    }

    public void productOutgoing(ProductInsertVO vo) {
        Product product = productMapper.get(vo.getProductId());
        if (product != null) {
            if (product.getProductNum() - Integer.valueOf(vo.getProductNum()) < 0) {
                throw new BusinessException("该产品库存不足,请先入库产品.");
            } else {
                product.setProductNum(product.getProductNum() - Integer.valueOf(vo.getProductNum()));
            }
            productMapper.updateProduct(product);
        } else {
            throw new BusinessException("数据异常,请联系管理员.");
        }
    }
}


