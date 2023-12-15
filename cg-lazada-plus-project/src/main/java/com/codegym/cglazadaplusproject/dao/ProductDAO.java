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

public class ProductDAO implements IProductDAO {
    private final Connection connection = JDBCConnection.getConnection();
    @Override
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query.get_all_product);
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
}
