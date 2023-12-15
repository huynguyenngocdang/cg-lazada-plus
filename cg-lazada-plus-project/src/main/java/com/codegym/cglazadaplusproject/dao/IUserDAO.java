package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.model.User;

import java.util.List;

public interface IUserDAO {
    List<User> getAllUser();
    User getUserById(int id);

    User getUserByName(String username);

    boolean updateUser(int userId, String newUsername, String newUserPassword);
}
