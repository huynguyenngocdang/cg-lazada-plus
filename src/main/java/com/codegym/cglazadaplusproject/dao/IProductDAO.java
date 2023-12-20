package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.model.CartItem;
import com.codegym.cglazadaplusproject.model.Product;
import com.codegym.cglazadaplusproject.model.PurchaseOrder;

import java.util.List;

public interface IProductDAO {
    List<Product> getAllProduct();

    Product getProductById(int id);

    List<Product> getProductByCategory(int categoryID);

}
