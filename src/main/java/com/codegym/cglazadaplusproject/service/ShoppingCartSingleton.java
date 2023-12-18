package com.codegym.cglazadaplusproject.service;

import com.codegym.cglazadaplusproject.model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartSingleton {
    private List<CartItem> cartItems;

    private ShoppingCartSingleton() {
        this.cartItems = new ArrayList<>();
    }

    private static ShoppingCartSingleton instance;

    public static ShoppingCartSingleton getInstance() {
        if (instance == null) {
            instance = new ShoppingCartSingleton();
        }
        return instance;
    }

    public List<CartItem> getProductItems() {
        return cartItems;
    }

    public void setProductItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addToCart(CartItem cartItemAdd) {
        if (cartItems.isEmpty() || !itemExistInCart(cartItemAdd)) {
            cartItems.add(cartItemAdd);
        } else {
            for (CartItem currentCartItem : cartItems
            ) {
                if (currentCartItem.getProduct().getProductId() == cartItemAdd.getProduct().getProductId()) {
                    double newAmount = cartItemAdd.getProductQuantity();
                    double currentAmount = currentCartItem.getProductQuantity();
                    currentCartItem.setProductQuantity(currentAmount + newAmount);
                }
            }
        }
    }

    private boolean itemExistInCart(CartItem cartItem) {
        for (CartItem currentCartItem : cartItems
        ) {
            if (cartItem.getProduct().getProductId() == currentCartItem.getProduct().getProductId()) {
                return true;
            }
        }
        return false;
    }
}
