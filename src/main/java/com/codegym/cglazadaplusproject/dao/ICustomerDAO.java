package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.model.Customer;

public interface ICustomerDAO {
    Customer getCustomerByUserid(int userId);
    Customer getCustomerById(int id);
    boolean updateCustomer(int customerId,String customerName,String customerAddress,double customerBalance);
}
