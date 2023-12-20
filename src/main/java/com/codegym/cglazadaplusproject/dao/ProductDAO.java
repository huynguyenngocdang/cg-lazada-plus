package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.constant.QueryConstant;
import com.codegym.cglazadaplusproject.model.Product;
import com.codegym.cglazadaplusproject.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ProductDAO implements IProductDAO {
    private final Connection connection = JDBCConnection.getConnection();

    @Override
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.GET_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                int productId = resultSet.getInt("product_id");
                int userId = resultSet.getInt("user_id");
                String productName = resultSet.getString("product_name");
                double productQuantity = resultSet.getDouble("product_quantity");
                double productCost = resultSet.getDouble("product_cost");
                boolean isDelete = resultSet.getBoolean("is_delete");
                products.add(new Product(productId, userId, productName, productQuantity, productCost, isDelete));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getProductById(int id) {
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.GET_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                int userId = resultSet.getInt("user_id");
                String productName = resultSet.getString("product_name");
                double productQuantity = resultSet.getDouble("product_quantity");
                double productPrice = resultSet.getDouble("product_cost");
                boolean isDelete = resultSet.getBoolean("is_delete");
                product = new Product(productId, userId, productName, productQuantity, productPrice, isDelete);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
    private void generateSearchResult(String queryKeyword, String sortQuery, List<Product> searchResult) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sortQuery);
            preparedStatement.setString(1, queryKeyword);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                int userId = resultSet.getInt("user_id");
                String productName = resultSet.getString("product_name");
                double productQuantity = resultSet.getDouble("product_quantity");
                double productCost = resultSet.getDouble("product_cost");
                boolean isDelete = resultSet.getBoolean("is_delete");
                searchResult.add(new Product(productId, userId, productName, productQuantity, productCost, isDelete));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Product> searchProductByName(String keyword) {
        List<Product> searchResult = new ArrayList<>();
        String queryKeyword = "%" + keyword + "%";
        generateSearchResult(queryKeyword, QueryConstant.SEARCH_PRODUCT_BY_NAME, searchResult);
        return searchResult;
    }

    @Override
    public List<Product> searchProductByPriceMin(String keyword) {
        List<Product> searchResult = new ArrayList<>();
        String queryKeyword = "%" + keyword + "%";
        generateSearchResult(queryKeyword, QueryConstant.SEARCH_PRODUCT_SORT_BY_PRICE_MIN, searchResult);
        return searchResult;
    }

    @Override
    public List<Product> searchProductByPriceMax(String keyword) {
        List<Product> searchResult = new ArrayList<>();
        String queryKeyword = "%" + keyword + "%";
        generateSearchResult(queryKeyword, QueryConstant.SEARCH_PRODUCT_SORT_BY_PRICE_MAX, searchResult);
        return searchResult;    }

    public List<Product> getProductByCategory(int categoryID) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.SELECT_PRODUCT_BY_CATEGORY);
            preparedStatement.setInt(1, categoryID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productID = resultSet.getInt("product_id");
                int userID = resultSet.getInt("user_id");
                String productName = resultSet.getString("product_name");
                int productQuantity = resultSet.getInt("product_quantity");
                double productCost = resultSet.getDouble("product_cost");
                boolean isDelete = resultSet.getBoolean("is_delete");
                products.add(new Product(productID, userID, productName, productQuantity, productCost, isDelete));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
