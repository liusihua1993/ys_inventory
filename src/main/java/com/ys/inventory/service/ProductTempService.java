package com.ys.inventory.service;

import com.ys.inventory.entity.ProductTemp;
import com.ys.inventory.entity.ProductTempMaterial;
import com.ys.inventory.mapper.ProductTempMapper;
import com.ys.inventory.mapper.ProductTempMaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;
import java.util.UUID;

/**
 * @author liusihua.
 * @date 2018/09/04.
 * 注:  需要回归接口添加 注解 ：@Transactional(rollbackFor = Exception.class)
 */


@Service
@EnableTransactionManagement
public class ProductTempService  {
    @Autowired(required = false)
    private ProductTempMapper productTempMapper;

    @Autowired(required = false)
    private ProductTempMaterialMapper productTempMaterialMapper;

    public void insert(ProductTemp productTemp) {
        //产品模板入库
        productTemp.setProductTempId(UUID.randomUUID().toString().replaceAll("-", ""));
        productTemp.setCreateTime(System.currentTimeMillis());
        productTemp.setUpdateTime(System.currentTimeMillis());
        productTemp.setDeleteFlag("0");
        productTempMapper.insert(productTemp);
        //产品模板原料消耗入库
        List<ProductTempMaterial> productTempMaterialList = productTemp.getProductTempMaterialList();
        for (ProductTempMaterial productTempMaterial : productTempMaterialList) {
            productTempMaterial.setProductTempMaterialId(UUID.randomUUID().toString().replaceAll("-", ""));
            productTempMaterial.setProductTempId(productTemp.getProductTempId());
        }
        productTempMaterialMapper.insertBatch(productTempMaterialList);
    }

    public ProductTemp checkProductTempExistByProductTempName(String productTempName) {
        return productTempMapper.checkProductTempExistByProductTempName(productTempName);
    }

    public void updateByPrimaryKey(ProductTemp productTemp) {
        //修改产品模板
        productTemp.setUpdateTime(System.currentTimeMillis());
        productTempMapper.updateByPrimaryKey(productTemp);
        //删除产品模板属性
        productTempMaterialMapper.deleteForUpdate(productTemp.getProductTempId());
        //添加产品模板属性
        productTempMaterialMapper.insertBatch(productTemp.getProductTempMaterialList());
    }

    public void deleteByPrimaryKey(String id) {
        ProductTemp productTemp = new ProductTemp();
        productTemp.setDeleteFlag("1");
        productTemp.setProductTempId(id);
        productTemp.setUpdateTime(System.currentTimeMillis());
        productTempMapper.updateByPrimaryKey(productTemp);
    }

    public ProductTemp selectByPrimaryKey(String id) {
        return productTempMapper.selectByPrimaryKey(id);
    }

    public List<ProductTemp> selectAll() {
        return productTempMapper.selectAll();
    }
}


