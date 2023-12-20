package com.codegym.cglazadaplusproject.controller;

import com.codegym.cglazadaplusproject.constant.VarConstant;
import com.codegym.cglazadaplusproject.dao.CheckOutDAO;
import com.codegym.cglazadaplusproject.dao.CustomerDAO;
import com.codegym.cglazadaplusproject.dao.ICheckOutDAO;
import com.codegym.cglazadaplusproject.dao.ICustomerDAO;
import com.codegym.cglazadaplusproject.dao.IProductDAO;
import com.codegym.cglazadaplusproject.dao.IUserDAO;
import com.codegym.cglazadaplusproject.dao.ProductDAO;
import com.codegym.cglazadaplusproject.dao.UserDAO;
import com.codegym.cglazadaplusproject.model.CartItem;
import com.codegym.cglazadaplusproject.model.Customer;
import com.codegym.cglazadaplusproject.model.Product;
import com.codegym.cglazadaplusproject.model.PurchaseOrder;
import com.codegym.cglazadaplusproject.model.User;
import com.codegym.cglazadaplusproject.service.ShoppingCartSingleton;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "CheckoutController", urlPatterns = "/checkOut")
public class CheckoutController extends HttpServlet {
    CartItem cartItemRemove = new CartItem();
    IProductDAO productDAO = new ProductDAO();
    ICustomerDAO customerDAO = new CustomerDAO();
    ICheckOutDAO checkOutDAO = new CheckOutDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action = request.getParameter("action");
       if(action == null) {
           action = "";
       }
       switch (action) {
           case "removeCartItem":
               removeCartItem(request, response);
                   break;
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
        switch (action) {
            case "purchase":
                purchase(request, response);
                break;
        }
    }

    private void purchase(HttpServletRequest request, HttpServletResponse response) {
        try {
            User currentUser = (User) request.getSession().getAttribute("currentUser");
            String deliveryAddress = request.getParameter("deliveryAddress");
            if(currentUser == null) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/login/login.jsp");
                requestDispatcher.forward(request, response);
            } else {
                int buyerId = currentUser.getUserId();
                List<CartItem> cartItems = ShoppingCartSingleton.getInstance().getProductItems();
                Iterator<CartItem>cartItemIterator =cartItems.iterator();
                while (cartItemIterator.hasNext()) {
                    CartItem currentCartItem = cartItemIterator.next();

                    Customer currentBuyer = customerDAO.getCustomerByUserid(buyerId);

                    Customer currentSeller = customerDAO.getCustomerByUserid(currentCartItem.getProduct().getProductUserId());

                    double cost = calculateCost(currentCartItem);
                    updateProduct(currentCartItem);
                    updateBuyer(currentCartItem, cost, currentBuyer);
                    updateSeller(currentCartItem, cost, currentSeller);

                    PurchaseOrder po = createPurchaseOrder(currentCartItem, cost, currentBuyer, currentSeller, deliveryAddress);
                    checkOutDAO.addNewPO(po);
                    cartItemIterator.remove();
                }
            }
        } catch (ServletException| IOException e) {
            e.printStackTrace();
        }
    }

    private PurchaseOrder createPurchaseOrder(CartItem currentCartItem, double cost, Customer currentBuyer, Customer currentSeller, String deliveryAddress) {
            int productId = currentCartItem.getProduct().getProductId();
            int buyerId =  currentBuyer.getUserId();
            int sellerId = currentSeller.getUserId();
            double poQuantity = currentCartItem.getProductQuantity();
            double poUnitPrice = currentCartItem.getProduct().getProductCost();
            double poTotalCost = poQuantity * poUnitPrice;
            double poFinalCost = cost;
            return new PurchaseOrder(productId, buyerId, sellerId, deliveryAddress, poQuantity, poUnitPrice, poTotalCost, poFinalCost );

    }

    private void updateProduct(CartItem currentCartItem) {
            checkOutDAO.updateProductPurchase(currentCartItem);
    }

    private void updateSeller(CartItem currentCartItem, double cost,  Customer seller) {
            checkOutDAO.updateSeller(currentCartItem, cost, seller);
    }
    private void updateBuyer(CartItem currentCartItem, double cost, Customer buyer) {
            checkOutDAO.updateBuyer(currentCartItem, cost, buyer);
    }


    private double calculateCost(CartItem currentCartItem) {
        return currentCartItem.getProductQuantity() * currentCartItem.getProduct().getProductCost();
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
            User currentUser = (User) request.getSession().getAttribute("currentUser");
            if(currentUser == null) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/login/login.jsp");
                requestDispatcher.forward(request, response);
            } else {
                Customer currentCustomer = customerDAO.getCustomerByUserid(currentUser.getUserId());
                request.setAttribute("currentCustomer", currentCustomer);
                request.setAttribute("cartItems", cartItems);
                request.setAttribute("totalCartCost", totalCartCost);
                request.setAttribute("totalCartAmount", totalCartQuantity);
                request.setAttribute("deliveryFee", VarConstant.deliveryFee);
                request.setAttribute("totalCartCostWithDeliveryFee", totalCartCost + VarConstant.deliveryFee);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/view/cart/cartCheckout.jsp");
                dispatcher.forward(request, response);
            }

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
