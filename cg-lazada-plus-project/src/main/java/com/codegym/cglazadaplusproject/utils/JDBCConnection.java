package com.codegym.cglazadaplusproject.utils;

import com.codegym.cglazadaplusproject.constant.Variable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(Variable.jdbc_driver);
            connection = DriverManager.getConnection(Variable.jdbc_url, Variable.jdbc_user, Variable.jdbc_password);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
