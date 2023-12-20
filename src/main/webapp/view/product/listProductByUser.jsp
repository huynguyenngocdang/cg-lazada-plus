<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lazada - Mua Sắm Hàng Chất Giá Tốt Online</title>
    <script src="https://kit.fontawesome.com/94d7aff8f4.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto" rel="stylesheet">
    <link rel="shortcut icon" href="../images/title.png">
    <link rel="stylesheet" type="text/css" href="../../css/base.css">
    <link rel="stylesheet" type="text/css" href="../../css/cartCheckOut.css">
</head>
<body>
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

<div class="body-container">
    <form action="/products?action=displayProductByUserId" method="get" class="body">
        <div class="cart-product-list content-frame">

            <!--        Bắt đầu vòng lặp forEach-->
            <c:forEach var="product" items="${products}">
                <div class="product-checkout-item">
                    <div class="product-checkout-info">
                        <div class="product-checkout-thumbnail">
                            <img src="../../images/just-for-you/${product.productId}.jpg" alt="">
                        </div>

                        <div class="product-checkout-description">


                            <div class="product-checkout-name">
                                <p><c:out value="${product.productName}"></c:out> </p>
                            </div>

                            <div class="product-checkout-detail">
                                <p class="product-checkout-price"><c:out value="${product.productCost}"></c:out> </p>
                                <!--              Thay đổi tên trường name & id củ input trong vòng lặp-->
                            </div>


                        </div>
                    </div>
                    <div class="product-checkout-delete">
                        <form action="${pageContext.request.contextPath}/checkOut" method="post">
                            <input type="hidden" name="action" value="removeCartItem">
                            <input type="hidden" name="productId" value="${product.productId}">
                            <button type="submit">
                                <a href="/products?action=showEditProductForm&productID=${product.productId}">Sửa sản phẩm</a>
                            </button>
                        </form>
                    </div>
                    <div class="product-checkout-delete">
                        <form action="${pageContext.request.contextPath}/checkOut" method="post">
                            <input type="hidden" name="action" value="removeCartItem">
                            <input type="hidden" name="productId" value="${product.productId}">
                            <button type="submit">
                                <a href="/products?action=deleteProduct&productId=${product.productId}">Xóa sản phẩm</a>
                            </button>
                        </form>
                    </div>
                </div>

                <hr>
            </c:forEach>
            <div class="product-detail-quantity">
                <button type="submit">
                    <a href="/products?action=showCreateProductForm">THÊM SẢN PHẨM</a>
                </button>
            </div>
<script src="../../js/animation.js"></script>
</body>
</html>
