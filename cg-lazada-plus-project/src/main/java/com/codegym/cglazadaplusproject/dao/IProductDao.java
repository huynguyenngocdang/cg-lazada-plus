package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.model.Product;

import java.util.List;

public interface IProductDao {
    List<Product> getAllProduct();

    void createProduct(Product product);

    Product getProductById(int id);

    boolean updateProduct(String productName, int productQuantity, double productCost);
}
