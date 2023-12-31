package com.codegym.cglazadaplusproject.controller;

import com.codegym.cglazadaplusproject.constant.VarConstant;
import com.codegym.cglazadaplusproject.dao.IProductDAO;
import com.codegym.cglazadaplusproject.dao.ProductDAO;
import com.codegym.cglazadaplusproject.model.CartItem;
import com.codegym.cglazadaplusproject.model.Product;
import com.codegym.cglazadaplusproject.service.ShoppingCartSingleton;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartController", urlPatterns = "/carts")
public class CartController extends HttpServlet {
    private final IProductDAO productDAO = new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "addToCart":
                addToCart(request, response);
                break;
        }
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) {
        try {
            int productId = Integer.parseInt(request.getParameter("productId"));
            Product currentProduct = productDAO.getProductById(productId);
            double productAmount = Double.parseDouble(request.getParameter("productQuantity"));

            request.setAttribute("currentProduct", currentProduct);
            if(productAmount < 0) {
                String message = "Invalid quantity. Please enter a non-negative quantity.";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/view/product/productDetail.jsp");
                dispatcher.forward(request, response);
                return;
            }

            CartItem currentCartItem = new CartItem(currentProduct, productAmount);

            // If the cart item already exists, update the quantity
            if (ShoppingCartSingleton.getInstance().itemExistInCart(currentCartItem)) {
                double newQuantity = productAmount + ShoppingCartSingleton.getInstance().getCartItem(currentCartItem).getProductQuantity();
                double remainingAmount = Math.max(0, currentProduct.getProductQuantity() - newQuantity);
                request.setAttribute("productAmount", remainingAmount);
                currentCartItem.setProductQuantity(newQuantity);
            } else {
                // If the cart item does not exist, add it to the cart
                request.setAttribute("productAmount", Math.max(0, currentProduct.getProductQuantity() - productAmount));
            }

            ShoppingCartSingleton.getInstance().addToCart(currentCartItem);
            String message = VarConstant.ADD_TO_CART_NOTI;
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/product/productDetail.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
