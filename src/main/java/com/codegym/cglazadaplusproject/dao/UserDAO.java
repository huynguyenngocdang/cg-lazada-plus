package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.constant.QueryConstant;
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
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.get_all_user);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 int userId = resultSet.getInt("user_id");
                 String username = resultSet.getString("user_name");
                 String userPassword = resultSet.getString("user_password");
                 int userRoleId = resultSet.getInt("user_role_id");
                boolean isActive = resultSet.getBoolean("is_active");
                boolean isDelete = resultSet.getBoolean("is_delete");
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

            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.get_user_by_id);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String username = resultSet.getString("user_name");
                String userPassword = resultSet.getString("user_password");
                int userRoleId = resultSet.getInt("user_role_id");
                boolean isActive = resultSet.getBoolean("is_active");
                boolean isDelete = resultSet.getBoolean("is_delete");
                selectUser = new User(userId, username, userPassword, userRoleId, isActive, isDelete);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return selectUser;
    }

    @Override
    public User getUserByName(String username) {
        User user = null;
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement  = connection.prepareStatement(QueryConstant.get_user_by_name);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String userPassword = resultSet.getString("user_password");
                int userRoleId = resultSet.getInt("user_role_id");
                boolean isActive = resultSet.getBoolean("is_active");
                boolean isDelete = resultSet.getBoolean("is_delete");
                user = new User(userId, username, userPassword, userRoleId, isActive, isDelete);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean updateUser(int userId, String newUsername, String newUserPassword) {
        boolean rowStatement = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.update_user_by_id);

            preparedStatement.setString(1, newUsername);
            preparedStatement.setString(2, newUserPassword);
            preparedStatement.setInt(3, userId);
            rowStatement = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowStatement;
    }
    @Override
    public boolean insertUser(String userName, String password) {
        boolean rowUpdate = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QueryConstant.insert_user);
            statement.setString(1, userName);
            statement.setString(2, password);
            System.out.println(statement);
            rowUpdate = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }
    @Override
    public boolean deleteUser(int userId) {
        boolean rowDeleted;
        try {
            PreparedStatement statement = connection.prepareStatement(QueryConstant.delete_user);
            statement.setInt(1,userId);
            rowDeleted = statement.executeUpdate() > 0;
            return rowDeleted;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return  false;
    }
}


