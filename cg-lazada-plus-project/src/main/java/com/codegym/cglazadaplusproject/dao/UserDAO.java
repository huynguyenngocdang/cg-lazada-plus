package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.constant.Query;
import com.codegym.cglazadaplusproject.model.User;
import com.codegym.cglazadaplusproject.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private final Connection connection = JDBCConnection.getConnection();
    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query.get_all_user);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 int userId = resultSet.getInt("user_id");
                 String username = resultSet.getString("user_name");
                 String userPassword = resultSet.getString("user_password");
                 int userRoleId = resultSet.getInt("user_role_id");
                 int isActive = resultSet.getInt("is_active");
                 int isDelete = resultSet.getInt("is_delete");
                users.add(new User(userId,username,userPassword,userRoleId,isActive,isDelete));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUserById(int id) {
        User selectUser = null;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(Query.get_user_by_id);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String username = resultSet.getString("user_name");
                String userPassword = resultSet.getString("user_password");
                int userRoleId = resultSet.getInt("user_role_id");
                int isActive = resultSet.getInt("is_active");
                int isDelete = resultSet.getInt("is_delete");
                selectUser = new User(userId, username, userPassword, userRoleId, isActive, isDelete);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return selectUser;
    }

    @Override
    public boolean updateUser(int userId, String newUsername, String newUserPassword) {
        boolean rowStatement = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query.update_user_by_id);

            preparedStatement.setString(1, newUsername);
            preparedStatement.setString(2, newUserPassword);
            preparedStatement.setInt(3, userId);
            rowStatement = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowStatement;
    }
}