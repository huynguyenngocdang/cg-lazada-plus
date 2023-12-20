package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.constant.QueryConstant;
import com.codegym.cglazadaplusproject.constant.VarConstant;
import com.codegym.cglazadaplusproject.model.CartItem;
import com.codegym.cglazadaplusproject.model.Customer;
import com.codegym.cglazadaplusproject.model.PurchaseOrder;
import com.codegym.cglazadaplusproject.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class CheckOutDAO implements ICheckOutDAO {
    private final Connection connection = JDBCConnection.getConnection();
    @Override
    public boolean updateProductPurchase(CartItem cartItem) {
        boolean rowStatement = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.UPDATE_PURCHASE_PRODUCT);
            preparedStatement.setDouble(1, cartItem.getProduct().getProductQuantity() - cartItem.getProductQuantity());
            preparedStatement.setInt(2, cartItem.getProduct().getProductId());
            rowStatement = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowStatement;
    }
    @Override
    public boolean updateSeller(CartItem cartItem, double cost, Customer seller) {
        boolean rowStatement = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.UPDATE_PURCHASE_SELLER);
            preparedStatement.setDouble(1, seller.getCustomerBalance() + cost);
            preparedStatement.setInt(2, seller.getUserId());
            rowStatement = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowStatement;
    }

    @Override
    public boolean updateBuyer(CartItem cartItem, double cost, Customer buyer) {
        boolean rowStatement = false;
        try {

            double pointAdd = Math.round( cost / VarConstant.POINT_PER_BILL);
            double pointOrigin = buyer.getCustomerPoint();
            double pointFinal = pointAdd + pointOrigin;

            int newMembershipId = getNewMembershipId(pointFinal);
            PreparedStatement preparedStatement;
            if(newMembershipId > 0) {
                preparedStatement = connection.prepareStatement(QueryConstant.UPDATE_PURCHASE_BUYER_NEW_RANK);
                preparedStatement.setDouble(1,  buyer.getCustomerBalance() - cost);
                preparedStatement.setDouble(2, pointFinal);
                preparedStatement.setInt(3, newMembershipId);
                preparedStatement.setInt(4, buyer.getUserId());

            } else {
                preparedStatement = connection.prepareStatement(QueryConstant.UPDATE_PURCHASE_BUYER);
                preparedStatement.setDouble(1,  buyer.getCustomerBalance() - cost);
                preparedStatement.setDouble(2, pointFinal);
                preparedStatement.setInt(3, buyer.getUserId());
            }
            rowStatement = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowStatement;
    }

    private int getNewMembershipId(double points)  {
        // Query the database to retrieve the membership information based on points
        int newMembershipId = -1;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.GET_CUSTOMER_MEMBERSHIP_RANK_WITH_POINT);
            preparedStatement.setDouble(1, points);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                newMembershipId = resultSet.getInt("customer_membership_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newMembershipId;
    }
    @Override
    public boolean addNewPO(PurchaseOrder po) {
        boolean rowStatement = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.INSERT_NEW_PO);
            preparedStatement.setInt(1, po.getProductId());
            preparedStatement.setInt(2, po.getBuyerId());
            preparedStatement.setInt(3, po.getSellerId());
            preparedStatement.setTimestamp(4, new Timestamp(po.getPoDate().getTime()));
            preparedStatement.setString(5, po.getPoAddress());
            preparedStatement.setDouble(6, po.getPoQuantity());
            preparedStatement.setDouble(7, po.getPoUnitPrice());
            preparedStatement.setDouble(8, po.getPoTotalCost());
            preparedStatement.setDouble(9, po.getPoFinalCost());
            rowStatement = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowStatement;
    }
}
