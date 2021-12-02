package com.example.market.domain.repository;

import com.example.market.domain.Product;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product>  getAll();
    Optional<List<Product>> getByCategoryId(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete (int prodcutId);
}
