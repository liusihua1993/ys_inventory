package com.ys.inventory.service;

import com.ys.inventory.common.exception.BusinessException;
import com.ys.inventory.common.utils.Constants;
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
import com.ys.inventory.vo.ProductUpdateVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

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
        //产品信息入库
        productMapper.insert(createInsertProduct(vo));
        //修改对应的原料的数量
        //获取对应的模板信息
        List<ProductTempMaterial> productTempMaterialList = productTempMaterialMapper.selectByProductTempId(vo.getProductTempId());
        for (ProductTempMaterial productTempMaterial : productTempMaterialList) {
            Material material = materialMapper.get(productTempMaterial.getMaterialId());
            material.setMaterialNum(material.getMaterialNum() - ((productTempMaterial.getMaterialNum()) * Integer.parseInt(vo.getProductNum())));
            materialMapper.updateMaterial(material);
        }
    }

    private Product createInsertProduct(ProductInsertVO vo) {
        Product product = new Product(UUIDUtil.getUUID(), vo.getProductTempId(), vo.getProductName(), vo.getProductDescription(), Integer.parseInt(vo.getProductNum()));
        product.setCreateUser(SecurityUtil.getUserId());
        return product;
    }

    private void ValidatorInsert(ProductInsertVO vo) {
        // 原料名称
        Validator.notNull(vo.getProductName(), "产品名称不能为空");
        checkLength(vo.getProductName(), 30, "公司名称长度不得超过 30 个字符");
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
        return new Product(vo.getProductId(), vo.getProductName(), vo.getProductDescription());
    }

//    public void deleteByPrimaryKey(String id) {
//        Product product = new Product();
//        product.setProductId(id);
//        product.setDeleteFlag("1");
//        product.setUpdateTime(System.currentTimeMillis());
//        productMapper.updateByPrimaryKey(product);
//    }

}


