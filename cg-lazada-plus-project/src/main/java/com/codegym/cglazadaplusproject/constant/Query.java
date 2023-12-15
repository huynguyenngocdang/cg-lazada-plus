package com.codegym.cglazadaplusproject.constant;

public interface Query {
    String get_all_user = "Select * from user";
    String get_user_by_id = "Select * from user where user_id = ?";
    String get_user_by_name = "Select * from user where user_name = ?";
    String update_user_by_id =
            "UPDATE `user` SET `user_name` = ?, `user_password` = ? WHERE (`user_id` = ?);";
}
