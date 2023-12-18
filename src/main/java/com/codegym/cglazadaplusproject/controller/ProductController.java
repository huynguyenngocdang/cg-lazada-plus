package com.codegym.cglazadaplusproject.controller;

import com.codegym.cglazadaplusproject.dao.ProductDAO;
import com.codegym.cglazadaplusproject.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", urlPatterns = "/products")
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "showProductById":
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void listProduct(HttpServletRequest req, HttpServletResponse res) {
        List<Product> products = new ProductDAO().getAllProduct();
        try {
            req.setAttribute("products", products);
            RequestDispatcher dispatcher = req.getRequestDispatcher("../webapp/view/index.jsp");
            dispatcher.forward(req, res);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
