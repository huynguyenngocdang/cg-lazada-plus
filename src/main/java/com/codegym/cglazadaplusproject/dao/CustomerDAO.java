package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.constant.QueryConstant;
import com.codegym.cglazadaplusproject.model.Customer;
import com.codegym.cglazadaplusproject.model.User;
import com.codegym.cglazadaplusproject.utils.JDBCConnection;

import java.sql.*;

public class CustomerDAO implements ICustomerDAO {
    private final Connection connection = JDBCConnection.getConnection();
    @Override
    public Customer getCustomerByUserid(int userId) {
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.SELECT_CUSTOMER_BY_USERID);
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

    @Override
    public boolean updateCustomer(int customerId,String customerName,String customerAddress,double customerBalance) {
        boolean rowUpdate = false;
        try {
            connection.setAutoCommit(false);
            Savepoint savepoint = connection.setSavepoint();
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.UPDATE_CUSTOMER_BY_ID);
            preparedStatement.setString(1, customerName);
            preparedStatement.setString(2, customerAddress);
            preparedStatement.setDouble(3, customerBalance);
            preparedStatement.setInt(4,customerId);
            rowUpdate = preparedStatement.executeUpdate() > 0;
            if(!rowUpdate) {
                connection.rollback(savepoint);
            } else {
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer selectCustomer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.GET_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
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
                selectCustomer = new Customer(customerId, currentUserId, customerName, customerAddress, customerBalance, customerPoint,customerMembershipId,isDelete);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return selectCustomer;
    }
}
