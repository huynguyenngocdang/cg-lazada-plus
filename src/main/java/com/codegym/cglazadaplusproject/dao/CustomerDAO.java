package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.constant.QueryConstant;
import com.codegym.cglazadaplusproject.model.Customer;
import com.codegym.cglazadaplusproject.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO implements ICustomerDAO {
    private final Connection connection = JDBCConnection.getConnection();
    @Override
    public Customer getCustomerByUserid(int userId) {
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.select_customer_by_userId);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                int currentUserId = resultSet.getInt("user_id");
                String customerName = resultSet.getString("customer_name");
                String customerAddress = resultSet.getString("customer_address");
                double customerBalance = resultSet.getDouble("customer_balance");
                int customerPoint = resultSet.getInt("customer_point");
                int customerMembershipId = resultSet.getInt("customer_membership_id");
                boolean isDelete = resultSet.getBoolean("is_delete");
                customer = new Customer(customerId, currentUserId, customerName, customerAddress, customerBalance, customerPoint, customerMembershipId, isDelete);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
