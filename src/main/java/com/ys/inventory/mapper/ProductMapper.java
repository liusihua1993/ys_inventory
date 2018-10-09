package com.ys.inventory.mapper;

import com.ys.inventory.entity.Product;
import com.ys.inventory.vo.ProductSearchVO;

import java.util.List;

public interface ProductMapper {

    int insert(Product product);

    Product selectByPrimaryKey(String productId);

    List<Product> selectAll();

    int updateByPrimaryKey(Product record);

    void updateProduct(Product updateProduct);

    List<Product> find(ProductSearchVO product);
}