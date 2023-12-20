package com.codegym.cglazadaplusproject.constant;

public interface QueryConstant {
    String get_all_user = "Select * from user";
    String get_user_by_id = "Select * from user where user_id = ?";
    String get_user_by_name = "Select * from user where user_name = ?";
    String update_user_by_id =
            "UPDATE `user` SET `user_name` = ?, `user_password` = ? WHERE (`user_id` = ?);";
    String get_all_category = "Select * from category WHERE is_delete = ? ";
    String get_all_product = "Select * from product WHERE is_delete = 0";
    String get_product_by_id = "Select * from product WHERE product_id = ? ";
    String select_product_by_category = "SELECT * FROM product p JOIN product_category pc ON p.product_id = pc.product_id WHERE pc.category_id = ? AND p.is_delete = 0 AND pc.is_delete = 0;";

    String select_customer_by_userId = "SELECT * FROM customer WHERE user_id = ?";
    String update_purchase_product = "UPDATE product SET product_quantity = ? WHERE product_id = ?";
    String update_purchase_seller = "UPDATE customer SET customer_balance = ? WHERE user_id = ? ";
    String update_purchase_buyer = "UPDATE customer SET customer_balance = ? WHERE user_id = ?";

    String insert_new_po = "INSERT INTO purchase_order (product_id, buyer_id, seller_id, purchase_order_date, purchase_order_address, purchase_order_quantity, purchase_order_unit_price, purchase_order_total_cost, purchase_order_final_cost) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
}
