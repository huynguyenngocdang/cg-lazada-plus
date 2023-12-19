package com.codegym.cglazadaplusproject.controller;

import com.codegym.cglazadaplusproject.dao.IProductDao;
import com.codegym.cglazadaplusproject.dao.ProductDao;
import com.codegym.cglazadaplusproject.model.Product;
import com.codegym.cglazadaplusproject.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private IProductDao productDao = new ProductDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "displayCreateProduct":
                showCreateProductForm(req, resp);
                break;
            case "displayEditProduct":
                showEditProductForm(req, resp);
                break;
            default:
                displayProduct(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(req, resp);
                break;
            case "edit":
                editProduct(req, resp);
                break;
            default:
                break;
        }
    }

    private void displayProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = productDao.getAllProduct();
        request.setAttribute("products", products);
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/product/listProduct.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void createProduct(HttpServletRequest request, HttpServletResponse response) {
        int userID = Integer.parseInt(request.getParameter("userID"));
        String productName = request.getParameter("productName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        Product newProduct = new Product(userID,productName,quantity,price);
        productDao.createProduct(newProduct);
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/product/createProduct.jsp");
            dispatcher.forward(request, response);

        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateProductForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/product/createProduct.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditProductForm(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.parseInt(request.getParameter("productID"));
        Product product = productDao.getProductById(productId);
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/product/editProduct.jsp");
            request.setAttribute("product", product);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        Product selectProduct = null;
        int productID = Integer.parseInt(request.getParameter("productID"));
        String newProductName = request.getParameter("productName");
        int newQuantity = Integer.parseInt(request.getParameter("quantity"));
        double newPrice = Double.parseDouble(request.getParameter("price"));
        try {
            productDao.updateProduct(newProductName, newQuantity, newPrice);
            selectProduct = productDao.getProductById(productID);
            request.setAttribute("selectProduct", selectProduct);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/product/editProduct.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    }
