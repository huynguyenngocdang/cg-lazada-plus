package com.codegym.cglazadaplusproject.controller;

import com.codegym.cglazadaplusproject.dao.IUserDAO;
import com.codegym.cglazadaplusproject.dao.UserDAO;
import com.codegym.cglazadaplusproject.model.User;
import com.codegym.cglazadaplusproject.service.UserLoginValidator;
import com.codegym.cglazadaplusproject.service.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private IUserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }

        switch (action) {
            case "showEdit":
                showEdit(request, response);
                break;
            default:
                displayAllUser(request, response);
                break;
        }
    }


    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int userId = Integer.parseInt(  request.getParameter("userId"));
        User selectUser = userDAO.getUserById(userId);
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/users/edit.jsp");
            request.setAttribute("selectUser", selectUser);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void displayAllUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = userDAO.getAllUser();
        request.setAttribute("users", users);
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/users/list.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }

        switch (action) {
            case "edit":
                editUser(request, response);
                break;
            case "login":
                login(request, response);
            default:
                break;
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Validator validator = new UserLoginValidator(username, password);
        try {
            String message = null;
            if (validator.isCheck()) {
                message = "Login successfully";

            } else {
                message = "Wrong username or password";;
            }
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/index.jsp");
            dispatcher.forward(request, response);

        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) {
        User selectUser = null;
        int userId = Integer.parseInt(request.getParameter("userId"));
        String newUsername = request.getParameter("newUsername");
        String newPassword = request.getParameter("newUserPassword");
        try {
            userDAO.updateUser(userId, newUsername, newPassword);

            selectUser = userDAO.getUserById(userId);
            request.setAttribute("selectUser", selectUser);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/users/edit.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
