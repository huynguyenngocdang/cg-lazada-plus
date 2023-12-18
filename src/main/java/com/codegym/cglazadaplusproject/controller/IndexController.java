package com.codegym.cglazadaplusproject.controller;

import com.codegym.cglazadaplusproject.dao.CategoryDAO;
import com.codegym.cglazadaplusproject.dao.ICategoryDAO;
import com.codegym.cglazadaplusproject.dao.IProductDAO;
import com.codegym.cglazadaplusproject.dao.ProductDAO;
import com.codegym.cglazadaplusproject.model.Category;
import com.codegym.cglazadaplusproject.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", urlPatterns = "/")
public class IndexController extends HttpServlet {
    private final ICategoryDAO categoryDAO = new CategoryDAO();
    private final IProductDAO productDao = new ProductDAO();
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

    private void displayIndex(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Category> categories = categoryDAO.getAllCategory();
            List<Product> products = productDao.getAllProduct();
            req.setAttribute("categories", categories);
            req.setAttribute("products", products);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/index.jsp");
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
