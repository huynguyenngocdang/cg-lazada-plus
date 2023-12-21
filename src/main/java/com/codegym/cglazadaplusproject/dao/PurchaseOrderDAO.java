package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.constant.QueryConstant;
import com.codegym.cglazadaplusproject.model.PurchaseOrder;
import com.codegym.cglazadaplusproject.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseOrderDAO implements IPurchaseOrderDAO {
    private final Connection connection = JDBCConnection.getConnection();
    @Override
    public List<PurchaseOrder> getPurchaseOrder(int userId) {
        List<PurchaseOrder> purchaseOrders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.GET_PO_BY_USER_ID);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                int sellerId = resultSet.getInt("seller_id");
                Date poDate = resultSet.getDate("purchase_order_date");
                String poAddress = resultSet.getString("purchase_order_address");
                double poQty = resultSet.getDouble("purchase_order_quantity");
                double poPrice = resultSet.getDouble("purchase_order_unit_price");
                double poTotalCost = resultSet.getDouble("purchase_order_total_cost");
                double poFinalCost = resultSet.getDouble("purchase_order_final_cost");
                purchaseOrders.add(new PurchaseOrder(productId, userId, sellerId, poDate, poAddress, poQty, poPrice, poTotalCost, poFinalCost ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchaseOrders;
    }
}
