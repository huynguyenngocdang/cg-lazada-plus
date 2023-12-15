<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Log In </title>
    <script src="https://kit.fontawesome.com/94d7aff8f4.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto" rel="stylesheet">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/title.png">
    <link rel="stylesheet" type="text/css" href="/css/header.css">
    <link rel="stylesheet" type="text/css" href="/css/user.css"></head>
<body>
<div class="header-ad">
    <a href="">
        <img src="/images/header/head-banner-1.webp" alt="">
    </a>
</div>

<div class="header">
    <div class="header-container">
        <div class="navbar-container">
            <div class="navbar">
                <div class="navbar-item header-item-1">
                    <a href="">
                        <span>GÓP Ý</span>
                    </a>
                </div>
                <div class="navbar-other-item">
                    <div class="navbar-item">
                        <a href="">
                            <span>TIẾT KIỆM HƠN VỚI ỨNG DỤNG</span>
                        </a>
                    </div>
                    <div class="navbar-item">
                        <a href="">
                            <span>BÁN HÀNG CÙNG LAZADA</span>
                        </a>
                    </div>
                    <div class="navbar-item">
                        <a href="">
                            <span>CHĂM SÓC KHÁCH HÀNG</span>
                        </a>
                    </div>
                    <div class="navbar-item">
                        <a href="">
                            <span>KIỂM TRA ĐƠN HÀNG</span>
                        </a>
                    </div>
                    <div class="navbar-item">
                        <a href="">
                            <span>ĐĂNG NHẬP</span>
                        </a>
                    </div>
                    <div class="navbar-item">
                        <a href="">
                            <span>ĐĂNG KÝ</span>
                        </a>
                    </div>
                    <div class="navbar-item">
                        <a href="">
                            <span>NGÔN NGỮ</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <div class="menu-container">
            <div class="menu">
                <div class="menu-logo">
                    <a href="">
                        <img src="/images/header/logo-heart.png" alt="This is Lazada logo icon" class="logo-heart">
                        <img src="/images/header/logo-text.png" alt="This is Lazada logo text" class="logo-text">
                    </a>
                </div>
                <div class="menu-bar">

                    <form class="menu-search-bar" action="" method="post">
                        <div class="search-input">
                            <label for="search-input"></label>
                            <input type="text" name="search-input" id="search-input"
                                   placeholder="Tìm kiếm trên Lazada">
                        </div>

                        <div class="search-icon">
                            <button type="submit">
                                <i class="fa-solid fa-magnifying-glass fa-flip-horizontal fa-2xl"
                                   style="color: #ffffff;"></i>
                            </button>
                        </div>
                    </form>

                    <div class="menu-cart">
                        <a href="">
                            <i class="fa-solid fa-cart-shopping fa-xl" style="color: #ffffff;"></i>
                        </a>
                    </div>

                    <div class="menu-ad">
                        <a href="">
                            <img src="/images/header/vib.png" alt="">
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="body-container">
    <div class="body">
        <div class="user-container">
            <div class="user-title">
                <p>Chào mừng đến với Lazada. Đăng nhập ngay!</p>
            </div>
            <div class="user-frame">
                <form action="/users?action=login" method="post">
                    <div class="username form-input">
                        <label for="username">Tên đăng nhập*</label>
                        <input type="text" name="username" id="username" placeholder="Vui lòng nhập tên đăng nhập" required>
                    </div>

                    <div class="password form-input">
                        <label for="password">Mật khẩu*</label>
                        <input type="password" name="password" id="password" placeholder="Vui lòng nhập mật khẩu" required>
                    </div>

                    <div class="submit-button">
                        <button type="submit">ĐĂNG NHẬP</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>