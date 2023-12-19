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
    <link rel="shortcut icon" href="../../images/titleIcon.png">
    <link rel="stylesheet" type="text/css" href="../../css/base.css">
    <link rel="stylesheet" type="text/css" href="../../css/productDetail.css">
</head>
<body>
<c:if test='${not empty requestScope["message"]}'>
    <div class="noti-container" id="noti-container">
        <div class="noti-content">
            <div class="noti-icon">
                <img src="../../images/header/logo-heart.png" alt="this is lazada icon">
            </div>

            <div class="noti-title">
                <p>Bạn có thông báo mới!</p>
            </div>

            <div class="noti-description">
                <p>${requestScope["message"]}</p>
            </div>
        </div>
        <div class="noti-exit-button">
            <button id="hide-noti">Bỏ qua</button>
        </div>
    </div>
</c:if>

<div class="header">
    <div class="header-ad">
        <a href="">
            <img src="../../images/header/head-banner-1.webp" alt="">
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
                <%
                    User currentUser = (User) request.getSession().getAttribute("currentUser");
                    String currentUsername = (currentUser != null) ? currentUser.getUsername() : null;
                    boolean isLoggedIn = (currentUsername != null);
                %>

                <%
                    if (isLoggedIn) {
                        // User is logged in, display username
                %>
                <div class="navbar-item">
                    <a href="">
                        <span>XIN CHÀO, <%= currentUsername %> </span>
                    </a>
                </div>
                <div class="navbar-item">
                    <a href="${pageContext.request.contextPath}/users?action=logOut">
                        <span>ĐĂNG XUẤT</span>
                    </a>
                </div>


                <%
                } else {
                    // User is not logged in, display login link
                %>
                <div class="navbar-item">
                    <a href="${pageContext.request.contextPath}/users?action=displayLogin">
                        <span>ĐĂNG NHẬP</span>
                    </a>
                </div>

                <div class="navbar-item">
                    <a href="">
                        <span>ĐĂNG KÝ</span>
                    </a>
                </div>
                <%
                    }
                %>


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
                <a href="${pageContext.request.contextPath}/index">
                    <img src="../../images/header/logo-heart.png" alt="This is Lazada logo icon" class="logo-heart">
                    <img src="../../images/header/logo-text.png" alt="This is Lazada logo text" class="logo-text">
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
                    <a href="${pageContext.request.contextPath}/checkOut">
                        <i class="fa-solid fa-cart-shopping fa-xl" style="color: #ffffff;"></i>
                    </a>
                </div>

                <div class="menu-ad">
                    <a href="">
                        <img src="../../images/header/vib.png" alt="">
                    </a>
                </div>
            </div>
        </div>
    </div>


</div>

<div class="body-container">
    <div class="body">
        <div class="content-frame">
            <form action="${pageContext.request.contextPath}/carts?action=addToCart&productId=${currentProduct.productId}" method="post" id="addToCartForm">
                <div class="product-detail-thumbnail">
                    <img src="../../images/products/${currentProduct.productId}.jpg" alt="This is product thumbnail">
                </div>

                <div class="product-detail-description">
                    <div class="product-detail-title-container">
                        <div class="product-detail-title">
                            <p><c:out value="${currentProduct.productName}"></c:out></p>
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
                            <p>đ<c:out value="${currentProduct.productCost}"></c:out></p>
                        </div>

                        <div class="product-detail-quantity">
                            <div class="product-quantity-input">
                                <label for="productQuantity">Số lượng:</label>
                                <input type="number" name="productQuantity" id="productQuantity" min="0" max=${currentProduct.productQuantity} value="1">
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