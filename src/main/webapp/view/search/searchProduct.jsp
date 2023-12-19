<%--
  Created by IntelliJ IDEA.
  User: Hgiang
  Date: 19/12/2023
  Time: 11:31 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <!--  Thay keyword vào title-->
    <title><c:out value="${keyword}"/> - Tìm kiếm</title>
    <script src="https://kit.fontawesome.com/94d7aff8f4.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto" rel="stylesheet">
    <link rel="shortcut icon" href="../../images/titleIcon.png">
    <link rel="stylesheet" type="text/css" href="../../css/base.css">
    <link rel="stylesheet" type="text/css" href="../../css/searchProduct.css">
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
            <img src="/images/header/head-banner-1.webp" alt="">
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
                    <img src="../images/header/vib.png" alt="">
                </a>
            </div>
        </div>
    </div>
</div>

<div class="body-container">
    <form class="body" name="sortResultForm">
        <div class="bookmark">
            <a href="${pageContext.request.contextPath}/index">
                <span>Trang chủ</span>
            </a>
            <span>></span>
            <span>Kết quả tìm kiếm</span>
        </div>

        <hr>

        <div class="search-result">
            <div class="search-keyword-setting">
                <div class="keyword-setting">
                    <!--            Thay keyword-->
                    <p><c:out value="${keyword}"/></p>
                </div>

                <div class="search-result-setting">
                    <p><c:out value="${searchResult.size()}"/> kết quả cho "<c:out value="${keyword}"/>"</p>

                    <div class="display-sort-result">
                        <div class="sort-result">
                            <p>Sắp xếp theo: </p>
                            <select name="sort" id="sort" class="sort-result">
                                <option value="sortById">Phù hợp nhất</option>
                                <option value="sortByPriceMin" onsubmit="">Giá từ thấp tới cao</option>
                                <option value="sortByPriceMax" onsubmit="">Giá từ cao xuống thấp</option>
                            </select>
                        </div>
                        <div class="display-result">
                            <p>Hiển thị: </p>
                            <div class="display-options">
                                <i class="fa-solid fa-table-cells-large"></i>
                                <i class="fa-solid fa-table-list"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="search-result-list">
                <div class="product-container">
                    <c:forEach var="product" items="${searchResult}">
                        <a href="/products?action=showProductById&productId=<c:out value="${product.getProductId()}"/>">
                            <div class="product-item">
                                <div class="product-thumbnail">
                                    <img src="../../images/products/<c:out value="${product.getProductId()}"/>.jpg" alt="product-thumbnail">
                                </div>

                                <div class="product-description">
                                    <div class="product-detail">
                                        <div class="product-name">
                                            <p><c:out value="${product.getProductName()}"/></p>
                                        </div>
                                        <div class="product-price">
                                            <p>đ<c:out value="${product.getProductCost()}"/></p>
                                        </div>
                                    </div>

                                    <div class="product-sale">
                                        <i class="fa-solid fa-star" style="color: #faca51;"></i>
                                        <i class="fa-solid fa-star" style="color: #faca51;"></i>
                                        <i class="fa-solid fa-star" style="color: #faca51;"></i>
                                        <i class="fa-solid fa-star" style="color: #faca51;"></i>
                                        <i class="fa-solid fa-star" style="color: #faca51;"></i>
                                        <span></span>
                                        <span></span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </c:forEach>

                </div>
            </div>
        </div>
    </form>
</div>

<script src="../../js/animation.js"></script>

</body>
</html>
