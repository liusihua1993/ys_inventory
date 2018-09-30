package com.ys.inventory.mapper;

import com.ys.inventory.entity.ProductTempMaterial;

import java.util.HashMap;
import java.util.List;

public interface ProductTempMaterialMapper {
    /**
     * 新增
     * @param productTempMaterialList
     */
    void insertBatch(List<ProductTempMaterial> productTempMaterialList);

    /**
     * 更新时删除使用
     * @param productTempId
     */
    void deleteForUpdate(String productTempId);

    /**
     * 根据模板查询列表
     * @param productTempId
     * @return
     */
    List<ProductTempMaterial> selectByProductTempId(String productTempId);

    /**
     * 删除
     * @param mapperParam
     */
    void delete(HashMap<String, String> mapperParam);
}