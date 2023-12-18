<%@ page import="com.codegym.cglazadaplusproject.model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product detail</title>
    <script src="https://kit.fontawesome.com/94d7aff8f4.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto" rel="stylesheet">
    <link rel="shortcut icon" href="../images/title.png">
    <link rel="stylesheet" type="text/css" href="../../css/base.css">
    <link rel="stylesheet" type="text/css" href="../../css/productDetail.css">
</head>
<body>
<div class="noti-container" id="noti-container">
    <div class="noti-content">
        <div class="noti-icon">
            <img src="../images/logo/logo-heart.png" alt="this is lazada icon">
        </div>

        <div class="noti-title">
            <p>Bạn có thông báo mới!</p>
        </div>

        <div class="noti-description">
            <p>Write something here. Write something here. Write something here.</p>
        </div>
    </div>
    <div class="noti-exit-button">
        <button id="hide-noti">Bỏ qua</button>
    </div>
</div>

<div class="header">
    <div class="header-ad">
        <a href="">
            <img src="/images/head-banner/head-banner-1.webp" alt="">
        </a>
    </div>

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
                        <span>NGÔN NGỮ</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="menu-container">
    <div class="menu">
        <div class="menu-logo">
            <a href="">
                <img src="../images/logo/logo-heart.png" alt="This is Lazada logo icon" class="logo-heart">
                <img src="../images/logo/logo-text.png" alt="This is Lazada logo text" class="logo-text">
            </a>
        </div>
        <div class="menu-bar">
            <form class="menu-search-bar" action="" method="get">
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
                    <img src="../images/vib.png" alt="">
                </a>
            </div>
        </div>
    </div>
</div>
<div class="body-container">
    <div class="body">
        <div class="content-frame">
            <form action="" method="post" onsubmit="" id="addToCartForm">
                <div class="product-detail-thumbnail">
                    <img src="../../images/just-for-you/product1.webp" alt="This is product thumbnail">
                </div>

                <div class="product-detail-description">
                    <div class="product-detail-title-container">
                        <div class="product-detail-title">
                            <p>Cây thông NOEL cao 1m5 1m6 1m8 - Cây thông Giáng Sinh noel 1,5m 1,6m 1,8m đủ phụ kiện đèn led,
                                chữ MERRY CHRISTMAS , dây kim tuyến , chuông giáng sinh , nơ và nhiều phụ kiện khác</p>
                        </div>

                        <div class="product-detail-stars">
                            <i class="fa-solid fa-star" style="color: #faca51"></i>
                            <i class="fa-solid fa-star" style="color: #faca51"></i>
                            <i class="fa-solid fa-star" style="color: #faca51"></i>
                            <i class="fa-solid fa-star" style="color: #faca51"></i>
                            <i class="fa-solid fa-star" style="color: #faca51"></i>
                        </div>
                    </div>

                    <div class="product-detail-cart-container">
                        <div class="product-detail-price">
                            <p>đ144.000</p>
                        </div>

                        <div class="product-detail-quantity">
                            <div class="product-quantity-input">
                                <label for="quantity">Số lượng:</label>
                                <input type="number" name="quantity" id="quantity" min="0" max="99" value="1">
                            </div>

                            <button type="submit">THÊM VÀO GIỎ HÀNG</button>
                        </div>
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>

<script src="../../js/animation.js"></script>

</body>
</html>