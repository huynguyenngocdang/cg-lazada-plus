package com.codegym.cglazadaplusproject.service;

import com.codegym.cglazadaplusproject.dao.IUserDAO;
import com.codegym.cglazadaplusproject.dao.UserDAO;
import com.codegym.cglazadaplusproject.model.User;

import java.util.List;

public class UserLoginValidator implements Validator{
    private String username;
    private String password;

    public UserLoginValidator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean isCheck() {
        IUserDAO userDAO = new UserDAO();
        List<User> users = userDAO.getAllUser();
        for (User user: users
             ) {
            if(user.getUsername().equals(username) && user.getUserPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
