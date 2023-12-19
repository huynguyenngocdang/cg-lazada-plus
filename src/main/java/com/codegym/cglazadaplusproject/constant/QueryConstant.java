package com.codegym.cglazadaplusproject.constant;

public interface QueryConstant {
    String get_all_user = "Select * from user;";
    String get_user_by_id = "Select * from user where user_id = ?;";
    String get_user_by_name = "Select * from user where user_name = ?;";
    String update_user_by_id =
            "UPDATE `user` SET `user_name` = ?, `user_password` = ? WHERE (`user_id` = ?);";
    String search_product_by_name = "Select * from product WHERE product_name LIKE ? ORDER BY product_id";
    String search_product_sort_by_price_max = "Select * from product WHERE product_name LIKE ? ORDER BY product_cost DESC";
    String search_product_sort_by_price_min = "Select * from product WHERE product_name LIKE ? ORDER BY product_cost ASC";
    String get_all_category = "Select * from category WHERE is_delete = ? ";
    String get_all_product = "Select * from product WHERE is_delete = 0";
    String get_product_by_id = "Select * from product WHERE product_id = ? ";
    String select_product_by_category = "SELECT * FROM product p JOIN product_category pc ON p.product_id = pc.product_id WHERE pc.category_id = ? AND p.is_delete = 0 AND pc.is_delete = 0;";
}
