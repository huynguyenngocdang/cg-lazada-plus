package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.model.User;

import java.util.List;

public interface IUserDAO {
    List<User> getAllUser();


    User getUserById(int id);

    boolean updateUser(int userId, String newUsername, String newUserPassword);

    boolean updateUserPassword(int userId, String newUserPassword);

    boolean insertUser(String userName, String password);

    User getUserByName(String username);

    boolean deleteUser(int userId);
}