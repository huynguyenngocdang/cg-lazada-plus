package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.constant.Query;
import com.codegym.cglazadaplusproject.model.Product;
import com.codegym.cglazadaplusproject.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    private final Connection connection = JDBCConnection.getConnection();
    @Override
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query.get_all_product);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productID = resultSet.getInt("product_id");
                int userID = resultSet.getInt("user_id");
                String productName = resultSet.getString("product_name");
                int productQuantity = resultSet.getInt("product_quantity");
                double productCost = resultSet.getDouble("product_cost");
                int isDelete = resultSet.getInt("is_delete");
                products.add(new Product(productID, userID, productName, productQuantity, productCost, isDelete));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void createProduct(Product product) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(Query.insert_product_sql)){
            preparedStatement.setInt(1, product.getUserID());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setInt(3, product.getProductQuantity());
            preparedStatement.setDouble(4, product.getProductCost());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product getProductById(int id) {
        Product selectProduct = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query.get_product_by_id);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//                int userId = resultSet.getInt("user_id");
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                int productQuantity = resultSet.getInt("product_quantity");
                double productCost = resultSet.getDouble("product_cost");
//                int isActive = resultSet.getInt("is_delete");
//                selectProduct = new Product(userId, productName, productQuantity, productCost ,isActive);
                selectProduct = new Product(productName, productQuantity, productCost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return selectProduct;
    }

    @Override
    public boolean updateProduct(String productName, int productQuantity, double productCost) {
        boolean rowStatement = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query.update_product_by_id);
            preparedStatement.setString(1, productName);
            preparedStatement.setInt(2, productQuantity);
            preparedStatement.setDouble(3, productCost);
            rowStatement = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowStatement;
    }
}
