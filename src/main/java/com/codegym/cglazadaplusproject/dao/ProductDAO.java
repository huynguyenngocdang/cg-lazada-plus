package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.constant.QueryConstant;
import com.codegym.cglazadaplusproject.model.CartItem;
import com.codegym.cglazadaplusproject.model.Product;
import com.codegym.cglazadaplusproject.model.PurchaseOrder;
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
    public List<Product> getProductByUserId() {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.GET_PRODUCT_BY_USER_ID);
//            preparedStatement.setInt(1, userIdParam);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                int productQuantity = resultSet.getInt("product_quantity");
                double productCost = resultSet.getDouble("product_cost");
                boolean isActive = resultSet.getBoolean("is_delete");
                Product product = new Product(productId, userId, productName, productQuantity, productCost ,isActive);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
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

    @Override
    public boolean updateProduct(int productID, String productName, double productQuantity, double productCost) {
        boolean rowStatement = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.UPDATE_PRODUCT_BY_ID);
            preparedStatement.setString(1, productName);
            preparedStatement.setDouble(2, productQuantity);
            preparedStatement.setDouble(3, productCost);
            preparedStatement.setInt(4, productID);
            rowStatement = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowStatement;
    }
    @Override
    public boolean deleteProduct(int productId) {
        boolean rowUpdate = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.DELETE_PRODUCT_BY_ID);
            preparedStatement.setInt(1, productId);
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public void createProduct(Product product) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.INSERT_PRODUCT_SQL)){
            preparedStatement.setInt(1, product.getProductUserId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setDouble(3, product.getProductQuantity());
            preparedStatement.setDouble(4, product.getProductCost());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
