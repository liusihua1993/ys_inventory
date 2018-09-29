package com.ys.inventory.mapper;

import com.ys.inventory.entity.ProductTemp;
import java.util.List;
import java.util.Map;

public interface ProductTempMapper {
    /**
     * 新增产品模板
     * @param record
     * @return
     */
    int insert(ProductTemp record);

    ProductTemp selectByPrimaryKey(String productTempId);

    List<ProductTemp> selectAll();

    int updateByPrimaryKey(ProductTemp record);

    /**
     * 查看是否存在同名模板
     * @param mapperMap
     * @return
     */
    ProductTemp getProductTempByName(Map<String, String> mapperMap);
}