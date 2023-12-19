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

@WebServlet(name = "CheckoutController", urlPatterns = "/checkOut")
public class CheckoutController extends HttpServlet {
    CartItem cartItemRemove = new CartItem();
    IProductDAO productDAO = new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action = request.getParameter("action");
       if(action == null) {
           action = "";
       }
       switch (action) {
           default:
               displayCart(request, response);
               break;
       }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        if (action.equals("removeCartItem")) {
            removeCartItem(request, response);
        }
    }
    private void displayCart(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<CartItem> cartItems = ShoppingCartSingleton.getInstance().getProductItems();
            double totalCartCost = 0;
            double totalCartQuantity = 0;
            for (CartItem cartItem: cartItems
                 ) {
                totalCartCost += cartItem.getProductQuantity() * cartItem.getProduct().getProductCost();
                totalCartQuantity += cartItem.getProductQuantity();
            }

            request.setAttribute("cartItems", cartItems);
            request.setAttribute("totalCartCost", totalCartCost);
            request.setAttribute("totalCartAmount", totalCartQuantity);
            request.setAttribute("deliveryFee", VarConstant.deliveryFee);
            request.setAttribute("totalCartCostWithDeliveryFee", totalCartCost + VarConstant.deliveryFee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/cart/cartCheckout.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void removeCartItem(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.parseInt(request.getParameter("productId"));
            Product productRemove = productDAO.getProductById(productId);
            cartItemRemove.setProduct(productRemove);
            ShoppingCartSingleton.getInstance().removeFromCart(cartItemRemove);
            displayCart(request, response);
    }
}
