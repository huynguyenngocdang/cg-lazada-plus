package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.model.CartItem;
import com.codegym.cglazadaplusproject.model.Customer;
import com.codegym.cglazadaplusproject.model.PurchaseOrder;
import com.codegym.cglazadaplusproject.model.User;

public interface ICheckOutDAO {
    boolean updateProductPurchase(CartItem cartItem);
    boolean updateSeller(CartItem cartItem, double cost, Customer seller);
    boolean updateBuyer(CartItem cartItem, double cost, Customer buyer);

    boolean addNewPO(PurchaseOrder purchaseOrder);
}
