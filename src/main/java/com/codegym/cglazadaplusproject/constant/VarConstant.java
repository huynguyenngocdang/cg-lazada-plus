package com.codegym.cglazadaplusproject.constant;

public interface VarConstant {
    String JDBC_URL = "jdbc:mysql://localhost:3306/cg_lazada_plus_project";
    String JDBC_USER = "root";
    String JDBC_PASSWORD = "12345678";
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String LOGIN_SUCCESS_NOTI = "Đăng nhập thành công";
    String LOGIN_FAILED_NOTI = "Tên đăng nhập hoặc mật khẩu không hợp lệ. Đăng nhập thất bại!";

    String REGISTER_SUCCESS_NOTI = "Đăng ký thành công";
    String REGISTER_FAILED_NOTI = "Tên đăng ký hoặc mật khẩu không hợp lệ. Đăng ký thất bại!";
    String ADD_TO_CART_NOTI = "Thêm sản phẩm vào giỏ hàng thành công";
    double DELIVERYFEE = 15000;
}
