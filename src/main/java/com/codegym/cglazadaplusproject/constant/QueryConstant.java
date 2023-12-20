package com.codegym.cglazadaplusproject.constant;

public interface QueryConstant {
    String GET_ALL_USER = "Select * from user;";
    String GET_USER_BY_ID = "Select * from user where user_id = ?;";
    String GET_USER_BY_NAME = "Select * from user where user_name = ?;";
    String UPDATE_USER_BY_ID =
            "UPDATE `user` SET `user_name` = ?, `user_password` = ? WHERE (`user_id` = ?);";
    String SEARCH_PRODUCT_BY_NAME = "Select * from product WHERE product_name LIKE ? ORDER BY product_id";
    String SEARCH_PRODUCT_SORT_BY_PRICE_MAX = "Select * from product WHERE product_name LIKE ? ORDER BY product_cost DESC";
    String SEARCH_PRODUCT_SORT_BY_PRICE_MIN = "Select * from product WHERE product_name LIKE ? ORDER BY product_cost ASC";
    String GET_ALL_CATEGORY = "Select * from category WHERE is_delete = ? ";
    String GET_ALL_PRODUCT = "Select * from product WHERE is_delete = 0";
    String GET_PRODUCT_BY_ID = "Select * from product WHERE product_id = ? ";
    String SELECT_PRODUCT_BY_CATEGORY = "SELECT * FROM product p JOIN product_category pc ON p.product_id = pc.product_id WHERE pc.category_id = ? AND p.is_delete = 0 AND pc.is_delete = 0;";
}
