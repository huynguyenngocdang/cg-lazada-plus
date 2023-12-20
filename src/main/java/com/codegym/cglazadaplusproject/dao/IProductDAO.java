package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.model.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> getAllProduct();

    Product getProductById(int id);


    List<Product> getProductByUserId();

    List<Product> getProductByCategory(int categoryID);


    boolean updateProduct(int productID, String productName, double productQuantity, double productCost);

    boolean deleteProduct(int productId);

    void createProduct(Product product);
}
