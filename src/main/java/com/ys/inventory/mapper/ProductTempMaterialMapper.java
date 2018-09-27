package com.ys.inventory.mapper;

import com.ys.inventory.entity.ProductTempMaterial;

import java.util.List;

public interface ProductTempMaterialMapper {

    void insertBatch(List<ProductTempMaterial> productTempMaterialList);

    void deleteForUpdate(String productTempId);

    List<ProductTempMaterial> selectByProductTempId(String productTempId);
}