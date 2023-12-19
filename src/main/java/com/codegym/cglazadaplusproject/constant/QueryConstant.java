package com.codegym.cglazadaplusproject.constant;

public interface QueryConstant {
    String get_all_user = "Select * from user";
    String get_user_by_id = "Select * from user where user_id = ?";
    String get_user_by_name = "Select * from user where user_name = ?";
    String update_user_by_id =
            "UPDATE `user` SET `user_name` = ?, `user_password` = ? WHERE (`user_id` = ?);";
    String insert_user = "INSERT INTO `user`(user_name,user_password) VALUES(?,?)";
    String delete_user = "update user set is_delete = 1 where user_id = ?;";
    String get_all_category = "Select * from category WHERE is_delete = ? ";
    String get_all_product = "Select * from product WHERE is_delete = 0";
}
