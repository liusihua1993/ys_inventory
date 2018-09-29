package com.ys.inventory.service;

import com.ys.inventory.entity.Material;
import com.ys.inventory.entity.Product;
import com.ys.inventory.entity.ProductTempMaterial;
import com.ys.inventory.mapper.MaterialMapper;
import com.ys.inventory.mapper.ProductMapper;
import com.ys.inventory.mapper.ProductTempMapper;
import com.ys.inventory.mapper.ProductTempMaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;
import java.util.UUID;

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

    public void insert(Product product) {
        //产品信息入库
        product.setProductId(UUID.randomUUID().toString().replaceAll("-", ""));
        product.setCreateTime(System.currentTimeMillis());
        product.setUpdateTime(System.currentTimeMillis());
        product.setDeleteFlag("0");
        productMapper.insert(product);
        //修改对应的原料的数量
        //获取对应的模板信息
        List<ProductTempMaterial> productTempMaterialList = productTempMaterialMapper.selectByProductTempId(product.getProductTempId());
        for (ProductTempMaterial productTempMaterial : productTempMaterialList) {
            Material material = materialMapper.selectByPrimaryKey(productTempMaterial.getMaterialId());
            material.setMaterialNum(material.getMaterialNum() - ((productTempMaterial.getMaterialNum()) * product.getProductNum()));
           // material.setUpdateTime(System.currentTimeMillis());
            materialMapper.updateByPrimaryKey(material);
        }
    }

    public void deleteByPrimaryKey(String id) {
        Product product = new Product();
        product.setProductId(id);
        product.setDeleteFlag("1");
        product.setUpdateTime(System.currentTimeMillis());
        productMapper.updateByPrimaryKey(product);
    }

    public void updateByPrimaryKey(Product product) {
        product.setUpdateTime(System.currentTimeMillis());
        productMapper.updateByPrimaryKey(product);
    }
}


