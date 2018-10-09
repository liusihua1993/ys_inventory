package com.ys.inventory.mapper;

import com.ys.inventory.entity.Material;
import com.ys.inventory.entity.Product;
import com.ys.inventory.vo.ProductSearchVO;

import java.util.List;
import java.util.Map;

public interface ProductMapper {

    int insert(Product product);

    Product selectByPrimaryKey(String productId);

    List<Product> selectAll();

    int updateByPrimaryKey(Product record);

    void updateProduct(Product updateProduct);

    List<Product> find(ProductSearchVO product);

    Product get(String productId);

    void delete(Map<String, String> mapperParam);
}