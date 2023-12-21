package com.codegym.cglazadaplusproject.controller;

import com.codegym.cglazadaplusproject.dao.CategoryDAO;
import com.codegym.cglazadaplusproject.dao.ICategoryDAO;
import com.codegym.cglazadaplusproject.dao.IProductDAO;
import com.codegym.cglazadaplusproject.dao.ProductDAO;
import com.codegym.cglazadaplusproject.model.Category;
import com.codegym.cglazadaplusproject.model.Product;
import com.codegym.cglazadaplusproject.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexController extends HttpServlet {
    private final ICategoryDAO categoryDAO = new CategoryDAO();
    private final IProductDAO productDAO = new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if( action == null) {
            action = "";
        }
        switch (action) {
            default:
                displayIndex(req, resp);
                break;
        }
    }

    private void displayIndex(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Category> categories = categoryDAO.getAllCategory();
            List<Product> products;
            User currentUser = (User) request.getSession().getAttribute("currentUser");
            if(currentUser != null) {
                products = productDAO.getAllProductNotOwnedByUser(currentUser.getUserId());
                System.out.println(products.size());
             } else {
                products = productDAO.getAllProduct();
            }
            System.out.println("display Index");
            System.out.println(products.size());
            for (Product product: products
                 ) {

                System.out.println(product.toString());
            }
            request.setAttribute("categories", categories);
            request.setAttribute("products", products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/index.jsp");
            dispatcher.forward(request, response);


        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}