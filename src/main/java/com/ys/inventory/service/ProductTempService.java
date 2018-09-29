package com.ys.inventory.service;

import com.ys.inventory.common.exception.BusinessException;
import com.ys.inventory.common.utils.SecurityUtil;
import com.ys.inventory.common.utils.UUIDUtil;
import com.ys.inventory.common.validator.Validator;
import com.ys.inventory.entity.ProductTemp;
import com.ys.inventory.mapper.ProductTempMapper;
import com.ys.inventory.mapper.ProductTempMaterialMapper;
import com.ys.inventory.vo.ProductTempInsertVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liusihua.
 * @date 2018/09/04.
 * 注:  需要回归接口添加 注解 ：@Transactional(rollbackFor = Exception.class)
 */


@Service
@EnableTransactionManagement
public class ProductTempService {
    @Autowired
    private ProductTempMapper productTempMapper;

    @Autowired
    private ProductTempMaterialMapper productTempMaterialMapper;

    public void insert(ProductTempInsertVO vo) {
        // 插入验证
        ValidatorInsert(vo);
        Map<String, String> mapperMap = new HashMap<>(1);
        mapperMap.put("productTempName", vo.getProductTempName());
        //查看是否有同名的
        ProductTemp productTemp = productTempMapper.getProductTempByName(mapperMap);
        if (productTemp != null) {
            //抛异常不能新增
            throw new BusinessException("已存在相同模板,请尝试修改模板.");
        } else {
            // 插入公司表
            productTemp = createProductTempInsert(vo);
            productTempMapper.insert(productTemp);
        }
        //产品模板原料消耗入库
        if (vo.getProductTempMaterialList() != null && vo.getProductTempMaterialList().size() > 0) {
            ProductTemp finalProductTemp = productTemp;
            vo.getProductTempMaterialList().forEach(ProductTempMaterial -> {
                ProductTempMaterial.setProductTempMaterialId(UUIDUtil.getUUID());
                ProductTempMaterial.setProductTempId(finalProductTemp.getProductTempId());
                ProductTempMaterial.setCreateUser(SecurityUtil.getUserId());
            });
            productTempMaterialMapper.insertBatch(vo.getProductTempMaterialList());
        }
    }

    private ProductTemp createProductTempInsert(ProductTempInsertVO vo) {
        ProductTemp productTemp = new ProductTemp();
        productTemp.setProductTempId(UUIDUtil.getUUID());
        productTemp.setProductTempName(vo.getProductTempName());
        productTemp.setProductTempDescribe(vo.getProductTempDescribe());
        productTemp.setCreateUser(SecurityUtil.getUserId());
        return productTemp;
    }

    private void ValidatorInsert(ProductTempInsertVO vo) {
        // 模板名称
        Validator.notNull(vo.getProductTempName(), "模板名称不能为空");
        checkLength(vo.getProductTempName(), 30, "公司名称长度不得超过 100 个字符");
        // 模板描述
        Validator.notNull(vo.getProductTempDescribe(), "模板描述不能为空");
        checkLength(vo.getProductTempDescribe(), 255, "模板描述长度不得超过 255 个字符");
    }


//    public void updateByPrimaryKey(ProductTemp productTemp) {
//        //修改产品模板
//        productTemp.setUpdateTime(System.currentTimeMillis());
//        productTempMapper.updateByPrimaryKey(productTemp);
//        //删除产品模板属性
//        productTempMaterialMapper.deleteForUpdate(productTemp.getProductTempId());
//        //添加产品模板属性
//        productTempMaterialMapper.insertBatch(productTemp.getProductTempMaterialList());
//    }

//
//    public void deleteByPrimaryKey(String id) {
//        ProductTemp productTemp = new ProductTemp();
//        productTemp.setDeleteFlag("1");
//        productTemp.setProductTempId(id);
//        productTemp.setUpdateTime(System.currentTimeMillis());
//        productTempMapper.updateByPrimaryKey(productTemp);
//    }

    public ProductTemp selectByPrimaryKey(String id) {
        return productTempMapper.selectByPrimaryKey(id);
    }

    public List<ProductTemp> selectAll() {
        return productTempMapper.selectAll();
    }

    private void checkLength(String str, int length, String message) {
        if (StringUtils.isNotEmpty(str) && str.length() > length) {
            throw new BusinessException(message);
        }
    }
}


