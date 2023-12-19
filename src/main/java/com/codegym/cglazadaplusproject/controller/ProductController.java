package com.codegym.cglazadaplusproject.controller;


import com.codegym.cglazadaplusproject.dao.IProductDAO;
import com.codegym.cglazadaplusproject.dao.ProductDAO;
import com.codegym.cglazadaplusproject.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

@WebServlet(name = "ProductController", urlPatterns = "/products")
public class ProductController extends HttpServlet {
    private final IProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showProductById":
                showProductById(request, response);
                break;
//            case "searchProduct":
//                searchProduct(request, response);
//                break;
            default:
                searchProduct(request, response);
                break;
        }
    }


    private void showProductById(HttpServletRequest request, HttpServletResponse response) {
        try {
            int productId = Integer.parseInt(request.getParameter("productId"));
            Product product = productDAO.getProductById(productId);
            request.setAttribute("currentProduct", product);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/product/productDetail.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String keyword = request.getParameter("search-input");
        List<Product> searchResult = productDAO.searchProductByName(keyword);
        request.setAttribute("keyword", keyword);
        request.setAttribute("searchResult", searchResult);

        RequestDispatcher dispatcher = null;
        if (searchResult.isEmpty()) {
            dispatcher = request.getRequestDispatcher("/view/search/searchNotFound.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/view/search/searchProduct.jsp");
        }

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addProductToCart":
                addProductToCart(request, response);
                break;
        }
    }

    private void addProductToCart(HttpServletRequest request, HttpServletResponse response) {

    }
}
