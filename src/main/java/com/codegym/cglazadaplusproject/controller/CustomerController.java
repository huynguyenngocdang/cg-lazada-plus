package com.codegym.cglazadaplusproject.controller;

import com.codegym.cglazadaplusproject.dao.CustomerDAO;
import com.codegym.cglazadaplusproject.dao.ICustomerDAO;
import com.codegym.cglazadaplusproject.dao.IUserDAO;
import com.codegym.cglazadaplusproject.dao.UserDAO;
import com.codegym.cglazadaplusproject.model.Customer;
import com.codegym.cglazadaplusproject.model.User;
import com.codegym.cglazadaplusproject.utils.JDBCConnection;
import com.codegym.cglazadaplusproject.validator.NotNegativeDoubleValidator;
import com.codegym.cglazadaplusproject.validator.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

@WebServlet(name = "CustomerController", urlPatterns = "/customers")
public class CustomerController extends HttpServlet {
    private final ICustomerDAO customerDAO = new CustomerDAO();
    private final IUserDAO userDAO = new UserDAO();
    private final Connection CONNECTION = JDBCConnection.getConnection();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "editCustomer":
                showUpdateForm(request, response);
                break;
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        int customerId = Integer.parseInt(request.getParameter("customerId"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "editCustomer":
                editCustomer(request, response);
                break;
            default:
                break;
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        String userPassword = request.getParameter("userPassword");
        String customerName = request.getParameter("customerName");
        String customerAddress = request.getParameter("customerAddress");
        Customer customer = customerDAO.getCustomerById(customerId);
        User user  = userDAO.getUserById(userId);
        double customerOriginalBalance = customer.getCustomerBalance();
        double customerBalance = Double.parseDouble(request.getParameter("customerBalance"));
        double customerNewBalance = customerOriginalBalance + customerBalance;
        Validator notNegative = new NotNegativeDoubleValidator(customerBalance);
        if (notNegative.isCheck()) {
            try {

                userDAO.updateUserPassword(userId, userPassword);
                 customerDAO.updateCustomer(customerId, customerName, customerAddress, customerNewBalance);

                customer = customerDAO.getCustomerById(customerId);
                user  = userDAO.getUserById(userId);
                request.setAttribute("currentUser", user);
                request.setAttribute("selectCustomer", customer);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/view/account/editAccountInfo.jsp");
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                String message = "You can't input negative value";
                request.setAttribute("message", message);
                customer = customerDAO.getCustomerById(customerId);
                user  = userDAO.getUserById(userId);
                request.setAttribute("currentUser", user);
                request.setAttribute("selectCustomer", customer);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/view/account/editAccountInfo.jsp");
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }

    }


}
