package com.codegym.cglazadaplusproject.constant;

public interface Query {
    String get_all_user = "Select * from user";
    String get_user_by_id = "Select * from user where user_id = ?";
    String update_user_by_id = "UPDATE `user` SET `user_name` = ?, `user_password` = ? WHERE (`user_id` = ?);";
    String get_all_product = "SELECT * FROM product;";
    String insert_product_sql = "INSERT INTO product(user_id,product_name,product_quantity,product_cost) VALUES (?, ?, ?, ?);";
    String update_product_by_id = "UPDATE `product` SET  `product_name` = ?, `product_quantity` = ?, `product_cost` = ? WHERE (`product_id` = ?);";
    String get_product_by_id = "SELECT * FROM product WHERE product_id = ?";
}
