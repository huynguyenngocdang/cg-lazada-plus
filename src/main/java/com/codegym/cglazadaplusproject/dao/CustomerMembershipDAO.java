package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.constant.QueryConstant;
import com.codegym.cglazadaplusproject.constant.VarConstant;
import com.codegym.cglazadaplusproject.model.CustomerMembership;
import com.codegym.cglazadaplusproject.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMembershipDAO implements ICustomerMembershipDAO {
    private final Connection connection = JDBCConnection.getConnection();
    @Override
    public double getCustomerMembershipReduction(int customerMembershipId) {
        double percent = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.GET_CUSTOMER_MEMBERSHIP_RANK);
            preparedStatement.setInt(1, customerMembershipId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                percent = resultSet.getDouble("customer_membership_promotion_percent") / VarConstant.PERCENT;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return percent;
    }

    @Override
    public String getCustomerRank(int customerMembershipId) {
        String membershipName = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.GET_CUSTOMER_MEMBERSHIP_RANK);
            preparedStatement.setInt(1, customerMembershipId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 membershipName = resultSet.getString("customer_membership_name");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return membershipName;
    }
}
