package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.model.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> getAllProduct();
    Product getProductById(int id);
    List<Product> searchProductByName(String keyword);
    List<Product> searchProductByPriceMin(String keyword);
    List<Product> searchProductByPriceMax(String keyword);

    List<Product> getProductByCategory(int categoryID);
}
