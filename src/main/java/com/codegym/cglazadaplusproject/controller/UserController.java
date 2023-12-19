package com.codegym.cglazadaplusproject.controller;

import com.codegym.cglazadaplusproject.dao.IUserDAO;
import com.codegym.cglazadaplusproject.dao.UserDAO;
import com.codegym.cglazadaplusproject.model.User;
import com.codegym.cglazadaplusproject.validator.UserValidator;
import com.codegym.cglazadaplusproject.validator.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserController extends HttpServlet {
    private final IUserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }

        switch (action) {
            case "displayLogin":
                displayLogin(request,response);
                break;
            case "logOut":
                logOut(request,response);
                break;
            case"displayCreate":
                displayCreate(request,response);
                break;
            case "showEdit":
                showEdit(request, response);
                break;
            case "deleteUser":
                deleteUser(request,response);
                break;
            default:
                displayAllUser(request, response);
                break;
        }
    }

    private void displayLogin(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/login/login.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void displayCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/users/create.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void logOut(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/view/index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int userId = Integer.parseInt(  request.getParameter("userId"));
        User selectUser = userDAO.getUserById(userId);
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/edit.jsp");
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
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/list.jsp");
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
            case "login":
                login(request,response);
                break;
            case "edit":
                editUser(request, response);
                break;
            case "create":
                addUser(request,response);
                break;

            default:
                displayAllUser(request,response);
                break;
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User currentUser = null;
        Validator validator = new UserValidator(username, password);
        try {
            String message = null;
            if (validator.isCheck()) {
                currentUser = userDAO.getUserByName(username);
                System.out.println(currentUser.toString());

                request.getSession().setAttribute("currentUser", currentUser);
                message = "Login successfully";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/view/index.jsp");
                dispatcher.forward(request, response);

            } else {
                message = "Wrong username or password";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/view/login/login.jsp");
                dispatcher.forward(request, response);
            }


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

            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/edit.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void addUser(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User newUser = new User(username,password);
        Validator validator = new UserValidator(username,password);
        try {
            String message = null;
            if (validator.checkUser()){
                message = "Account already exists";
                request.setAttribute("message",message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/view/users/create.jsp");
                dispatcher.forward(request,response);
            } else {
                userDAO.insertUser(username,password);
                message= "Successful account registration";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/view/users/create.jsp");
                dispatcher.forward(request,response);
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteUser(HttpServletRequest request,HttpServletResponse response){
        int userId = Integer.parseInt(request.getParameter("userId"));
        try {
            userDAO.deleteUser(userId);

            List<User> listUser = userDAO.getAllUser();
            request.getSession().setAttribute("users", listUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/users/list.jsp");
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e){
            e.printStackTrace();
        }
    }
}
