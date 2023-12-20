package com.codegym.cglazadaplusproject.constant;

public interface QueryConstant {
    String GET_ALL_USER = "Select * from user";
    String GET_USER_BY_ID = "Select * from user where user_id = ?";
    String GET_USER_BY_NAME = "Select * from user where user_name = ?";
    String UPDATE_USER_BY_ID =
            "UPDATE `user` SET `user_name` = ?, `user_password` = ? WHERE (`user_id` = ?);";
    String GET_ALL_CATEGORY = "Select * from category WHERE is_delete = ? ";
    String GET_ALL_PRODUCT = "Select * from product WHERE is_delete = 0";
    String GET_PRODUCT_BY_ID = "Select * from product WHERE product_id = ? ";
    String SELECT_PRODUCT_BY_CATEGORY = "SELECT * FROM product p JOIN product_category pc ON p.product_id = pc.product_id WHERE pc.category_id = ? AND p.is_delete = 0 AND pc.is_delete = 0;";
    String INSERT_PRODUCT_SQL = "INSERT INTO product(user_id,product_name,product_quantity,product_cost) VALUES (?, ?, ?, ?);";
    String UPDATE_PRODUCT_BY_ID = "UPDATE `product` SET `product_name` = ?, `product_quantity` = ?, `product_cost` = ? WHERE (`product_id` = ?);";
    String DELETE_PRODUCT_BY_ID = "UPDATE `product` SET `is_delete` = 1 WHERE (`product_id` = ?);";
    String GET_PRODUCT_BY_USER_ID = "SELECT * FROM product WHERE user_id = 1 AND is_delete = 0;";

}
