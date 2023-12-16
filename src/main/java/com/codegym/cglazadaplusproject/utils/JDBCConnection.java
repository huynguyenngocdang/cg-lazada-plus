package com.codegym.cglazadaplusproject.utils;

import com.codegym.cglazadaplusproject.constant.VarConstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(VarConstant.jdbc_driver);
            connection = DriverManager.getConnection(VarConstant.jdbc_url, VarConstant.jdbc_user, VarConstant.jdbc_password);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
