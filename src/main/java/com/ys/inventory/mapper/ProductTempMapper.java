package com.ys.inventory.mapper;

import com.ys.inventory.entity.ProductTemp;
import java.util.List;

public interface ProductTempMapper {

    int insert(ProductTemp record);

    ProductTemp selectByPrimaryKey(String productTempId);

    List<ProductTemp> selectAll();

    int updateByPrimaryKey(ProductTemp record);

    ProductTemp checkProductTempExistByProductTempName(String productTempName);
}