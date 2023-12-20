package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.model.Customer;

public interface ICustomerDAO {
    Customer getCustomerByUserid(int userId);
}
