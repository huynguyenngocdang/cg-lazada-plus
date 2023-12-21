package com.codegym.cglazadaplusproject.constant;

public interface QueryConstant {
    String GET_ALL_USER = "Select * from user";
    String GET_USER_BY_ID = "Select * from user where user_id = ?";
    String GET_USER_BY_NAME = "Select * from user where user_name = ?";

    String UPDATE_USER_BY_ID =
            "UPDATE `user` SET `user_name` = ?, `user_password` = ? WHERE (`user_id` = ?);";

    String UPDATE_USER_PASSWORD_BY_ID =
            "UPDATE `user` SET  `user_password` = ? WHERE (`user_id` = ?);";


    String INSERT_USER = "INSERT INTO `user`(user_name,user_password) VALUES(?,?)";
    String DELETE_USER = "update user set is_delete = 1 where user_id = ?;";
    String SEARCH_PRODUCT_BY_NAME = "Select * from product WHERE product_name LIKE ? ORDER BY product_id";
    String SEARCH_PRODUCT_SORT_BY_PRICE_MAX = "Select * from product WHERE product_name LIKE ? ORDER BY product_cost DESC";
    String SEARCH_PRODUCT_SORT_BY_PRICE_MIN = "Select * from product WHERE product_name LIKE ? ORDER BY product_cost ASC";
    String GET_ALL_CATEGORY = "Select * from category WHERE is_delete = ? ";
    String GET_ALL_PRODUCT = "Select * from product WHERE is_delete = 0";
    String GET_ALL_PRODUCT_NOT_OWNED_BY_USER = "Select * from product p1 WHERE NOT EXISTS (SELECT 1 FROM product p2 WHERE p2.user_id = ? and p1.product_id = p2.product_id)";
    String GET_PRODUCT_BY_ID = "Select * from product WHERE product_id = ? ";
    String SELECT_PRODUCT_BY_CATEGORY = "SELECT * FROM product p JOIN product_category pc ON p.product_id = pc.product_id WHERE pc.category_id = ? AND p.is_delete = 0 AND pc.is_delete = 0;";
    String INSERT_PRODUCT_SQL = "INSERT INTO product(user_id,product_name,product_quantity,product_cost) VALUES (?, ?, ?, ?);";
    String INSERT_PRODUCT_CATEGORY_SQL = "INSERT INTO product_category(category_id, product_id) VALUES (?, LAST_INSERT_ID())";
    String UPDATE_PRODUCT_BY_ID = "UPDATE `product` SET `product_name` = ?, `product_quantity` = ?, `product_cost` = ? WHERE (`product_id` = ?);";
    String DELETE_PRODUCT_BY_ID = "UPDATE `product` SET `is_delete` = 1 WHERE (`product_id` = ?);";
    String GET_PRODUCT_BY_USER_ID = "SELECT * FROM product WHERE user_id = ? AND is_delete = 0;";
    String SELECT_CUSTOMER_BY_USERID = "SELECT * FROM customer WHERE user_id = ?";
    String UPDATE_PURCHASE_PRODUCT = "UPDATE product SET product_quantity = ? WHERE product_id = ?";
    String UPDATE_PURCHASE_SELLER = "UPDATE customer SET customer_balance = ? WHERE user_id = ? ";
    String UPDATE_PURCHASE_BUYER = "UPDATE customer SET customer_balance = ?, customer_point = ? WHERE user_id = ?";
    String UPDATE_PURCHASE_BUYER_NEW_RANK = "UPDATE customer SET customer_balance = ?, customer_point = ?, customer_membership_id = ? WHERE user_id = ?";
    String INSERT_NEW_PO = "INSERT INTO purchase_order (product_id, buyer_id, seller_id, purchase_order_date, purchase_order_address, purchase_order_quantity, purchase_order_unit_price, purchase_order_total_cost, purchase_order_final_cost) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String GET_CUSTOMER_MEMBERSHIP_RANK = "SELECT * FROM customer_membership WHERE customer_membership_id = ?";
    String GET_CUSTOMER_MEMBERSHIP_RANK_WITH_POINT = "SELECT * FROM customer_membership WHERE customer_membership_point_reference <= ? ORDER BY customer_membership_point_reference DESC LIMIT 1";
    String UPDATE_CUSTOMER_BY_ID = "UPDATE customer SET customer_name = ?, customer_address = ?, customer_balance = ? WHERE (customer_id = ?);";
    String GET_CUSTOMER_BY_ID = "SELECT * from customer where customer_id = ?";
    String GET_PO_BY_USER_ID = "SELECT * from purchase_order where buyer_id = ?";
}
