package com.ys.inventory.mapper;

import com.ys.inventory.entity.Product;
import java.util.List;

public interface ProductMapper {

    int insert(Product record);

    Product selectByPrimaryKey(String productId);

    List<Product> selectAll();

    int updateByPrimaryKey(Product record);
}