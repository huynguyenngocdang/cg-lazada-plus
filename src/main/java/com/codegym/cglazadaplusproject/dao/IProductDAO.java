package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.model.CartItem;
import com.codegym.cglazadaplusproject.model.Product;
import com.codegym.cglazadaplusproject.model.PurchaseOrder;

import java.util.List;

public interface IProductDAO {
    List<Product> getAllProduct();
    Product getProductById(int id);
    List<Product> searchProductByName(String keyword);

    List<Product> getProductByUserId(int userIdParam);

    List<Product> searchProductByPriceMin(String keyword);
    List<Product> searchProductByPriceMax(String keyword);
//    void sortById(List<Product> productList);
//    void sortByPriceMin(List<Product> productList));
//    void sortByPriceMax(List<Product> productList));




    List<Product> getProductByCategory(int categoryID);


    boolean updateProduct(int productID, String productName, double productQuantity, double productCost);

    boolean deleteProduct(int productId);

    void createProduct(Product product);
}
