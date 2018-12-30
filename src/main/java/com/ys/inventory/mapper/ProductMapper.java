package com.ys.inventory.mapper;

import com.ys.inventory.entity.Product;
import com.ys.inventory.vo.ProductSearchVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ProductMapper {

    int insert(Product product);

    void updateProduct(Product updateProduct);

    List<Product> find(ProductSearchVO product);

    Product get(String productId);

    void delete(Map<String, String> mapperParam);

    void insertBatch(ArrayList<Product> products);

    boolean isNotExistProduct(String productName);
}