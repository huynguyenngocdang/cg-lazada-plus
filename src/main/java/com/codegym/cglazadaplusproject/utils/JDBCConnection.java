package com.codegym.cglazadaplusproject.utils;

import com.codegym.cglazadaplusproject.constant.VarConstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(VarConstant.JDBC_DRIVER);
            connection = DriverManager.getConnection(VarConstant.JDBC_URL, VarConstant.JDBC_USER, VarConstant.JDBC_PASSWORD);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
