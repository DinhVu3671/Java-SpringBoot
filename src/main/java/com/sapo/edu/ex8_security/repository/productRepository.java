package com.sapo.edu.ex8_security.repository;

import com.sapo.edu.ex8_security.model.Product;

import java.util.List;

public interface productRepository {
    List<Product> getAllProduct();
    Product getProductById(String product);
    int addProduct(Product product);
    int updateProduct(Product product);
    int deleteProduct(String product_id);
    List<Product> getProductByNameAndCategory(String name, String categoryName);
}
