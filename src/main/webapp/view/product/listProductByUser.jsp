<%--<%@ page import="com.codegym.cglazadaplusproject.model.User" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="com.codegym.cglazadaplusproject.dao.IProductDAO" %>--%>
<%--<%@ page import="com.codegym.cglazadaplusproject.dao.ProductDAO" %>--%>
<%--<%@ page import="com.codegym.cglazadaplusproject.model.Product" %>--%>
<%--<%@ page import="com.codegym.cglazadaplusproject.dao.ICategoryDAO" %>--%>
<%--<%@ page import="com.codegym.cglazadaplusproject.dao.CategoryDAO" %>--%>
<%--<%@ page import="com.codegym.cglazadaplusproject.model.Category" %>--%>
<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>


<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    &lt;%&ndash;    <base href="${pageContext.request.contextPath}">&ndash;%&gt;--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>Lazada - Mua Sắm Hàng Chất Giá Tốt Online</title>--%>
<%--    <script src="https://kit.fontawesome.com/94d7aff8f4.js" crossorigin="anonymous"></script>--%>
<%--    <link rel="preconnect" href="https://fonts.googleapis.com">--%>
<%--    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>--%>
<%--    <link href="https://fonts.googleapis.com/css2?family=Roboto" rel="stylesheet">--%>
<%--    <link rel="shortcut icon" href="../images/title.png">--%>
<%--    &lt;%&ndash;    <link rel="stylesheet" type="text/css" href="<c:url value='../css/base.css'/>">&ndash;%&gt;--%>
<%--    &lt;%&ndash;    <link rel="stylesheet" type="text/css" href="/css/base.css">&ndash;%&gt;--%>
<%--    &lt;%&ndash;    <link rel="stylesheet" type="text/css" href="/css/home.css">&ndash;%&gt;--%>
<%--    &lt;%&ndash;    <link rel="stylesheet" type="text/css" href="<c:url value='../css/home.css'/>">&ndash;%&gt;--%>
<%--    <style type="text/css">--%>
<%--        <%@include file="/css/base.css" %>--%>
<%--    </style>--%>
<%--    <style type="text/css">--%>
<%--        <%@include file="/css/home.css" %>--%>
<%--    </style>--%>

<%--</head>--%>
<%--<body>--%>

<%--<c:if test='${not empty requestScope["message"]}'>--%>
<%--    <div class="noti-container" id="noti-container">--%>
<%--        <div class="noti-content">--%>
<%--            <div class="noti-icon">--%>
<%--                <img src="<c:url value="/images/header/logo-heart.png"/>" alt="this is lazada icon">--%>
<%--            </div>--%>

<%--            <div class="noti-title">--%>
<%--                <p>Bạn có thông báo mới!</p>--%>
<%--            </div>--%>

<%--            <div class="noti-description">--%>
<%--                <p>${requestScope["message"]}</p>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="noti-exit-button">--%>
<%--            <button id="hide-noti">Bỏ qua</button>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</c:if>--%>

<%--<div class="header">--%>
<%--    <div class="header-ad">--%>
<%--        <a href="">--%>
<%--            <img src="../images/header/head-banner-1.webp" alt="">--%>
<%--        </a>--%>
<%--    </div>--%>

<%--    <div class="navbar-container">--%>
<%--        <div class="navbar">--%>
<%--            <div class="navbar-item header-item-1">--%>
<%--                <a href="">--%>
<%--                    <span>GÓP Ý</span>--%>
<%--                </a>--%>
<%--            </div>--%>
<%--            <div class="navbar-other-item">--%>
<%--                <div class="navbar-item">--%>
<%--                    <a href="">--%>
<%--                        <span>TIẾT KIỆM HƠN VỚI ỨNG DỤNG</span>--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--                <div class="navbar-item">--%>
<%--                    <a href="">--%>
<%--                        <span>BÁN HÀNG CÙNG LAZADA</span>--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--                <div class="navbar-item">--%>
<%--                    <a href="">--%>
<%--                        <span>CHĂM SÓC KHÁCH HÀNG</span>--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--                <div class="navbar-item">--%>
<%--                    <a href="">--%>
<%--                        <span>KIỂM TRA ĐƠN HÀNG</span>--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--                <%--%>
<%--                    User currentUser = (User) request.getSession().getAttribute("currentUser");--%>
<%--                    String currentUsername = (currentUser != null) ? currentUser.getUsername() : null;--%>
<%--                    boolean isLoggedIn = (currentUsername != null);--%>
<%--                %>--%>

<%--                <%--%>
<%--                    if (isLoggedIn) {--%>
<%--                        // User is logged in, display username--%>
<%--                %>--%>
<%--                <div class="navbar-item">--%>
<%--                    <a href="">--%>
<%--                        <span>XIN CHÀO, <%= currentUsername %> </span>--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--                <div class="navbar-item">--%>
<%--                    <a href="/users?action=logOut">--%>
<%--                        <span>ĐĂNG XUẤT</span>--%>
<%--                    </a>--%>
<%--                </div>--%>


<%--                <%--%>
<%--                } else {--%>
<%--                    // User is not logged in, display login link--%>
<%--                %>--%>
<%--                <div class="navbar-item">--%>
<%--                    <a href="/users?action=displayLogin">--%>
<%--                        <span>ĐĂNG NHẬP</span>--%>
<%--                    </a>--%>
<%--                </div>--%>

<%--                <div class="navbar-item">--%>
<%--                    <a href="">--%>
<%--                        <span>ĐĂNG KÝ</span>--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--                <%--%>
<%--                    }--%>
<%--                %>--%>


<%--                <div class="navbar-item">--%>
<%--                    <a href="">--%>
<%--                        <span>NGÔN NGỮ</span>--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--    <div class="menu-container">--%>
<%--        <div class="menu">--%>
<%--            <div class="menu-logo">--%>
<%--                <a href="">--%>
<%--                    <img src="../images/header/logo-heart.png" alt="This is Lazada logo icon" class="logo-heart">--%>
<%--                    <img src="../images/header/logo-text.png" alt="This is Lazada logo text" class="logo-text">--%>
<%--                </a>--%>
<%--            </div>--%>
<%--            <div class="menu-bar">--%>
<%--                <form class="menu-search-bar" action="" method="get">--%>
<%--                    <div class="search-input">--%>
<%--                        <label for="search-input"></label>--%>
<%--                        <input type="text" name="search-input" id="search-input"--%>
<%--                               placeholder="Tìm kiếm trên Lazada">--%>
<%--                    </div>--%>

<%--                    <div class="search-icon">--%>
<%--                        <button type="submit">--%>
<%--                            <i class="fa-solid fa-magnifying-glass fa-flip-horizontal fa-2xl"--%>
<%--                               style="color: #ffffff;"></i>--%>
<%--                        </button>--%>
<%--                    </div>--%>
<%--                </form>--%>

<%--                <div class="menu-cart">--%>
<%--                    <a href="">--%>
<%--                        <i class="fa-solid fa-cart-shopping fa-xl" style="color: #ffffff;"></i>--%>
<%--                    </a>--%>
<%--                </div>--%>

<%--                <div class="menu-ad">--%>
<%--                    <a href="">--%>
<%--                        <img src="../images/header/vib.png" alt="">--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>


<%--</div>--%>

<%--<div class="body-container">--%>
<%--    <div class="body">--%>

<%--        <div class="body-column-1 categories-container">--%>
<%--            <div class="categories-title">--%>
<%--                <p>Danh mục</p>--%>
<%--            </div>--%>
<%--            <div class="categories-content">--%>
<%--                <c:forEach var="category" items="${categories}">--%>
<%--                    <p><c:out value="${category.getCategoryName()}"/></p>--%>
<%--                </c:forEach>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <div class="body-column-2">--%>
<%--            <div class="just-for-you product-section">--%>
<%--                <div class="title-bar">--%>
<%--                    <div class="title">--%>
<%--                        <p>Dành riêng cho bạn</p>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                &lt;%&ndash;            List product dùng c:forEach&ndash;%&gt;--%>
<%--                <div class="product-container">--%>
<%--                    &lt;%&ndash;                    <c:set var="products" value="new ProductDAO()"></c:set>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    <&lt;%&ndash;%>--%>
<%--                    &lt;%&ndash;                        IProductDAO productDAO = new ProductDAO();&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        List<Product> products = productDAO.getAllProduct();&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        for (Product product : products&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    &lt;%&ndash;                        ) { %>&ndash;%&gt;>&ndash;%&gt;--%>
<%--                    <c:forEach var="product" items="${products}">--%>
<%--                        <a href="">--%>
<%--                            <div class="product-item">--%>
<%--                                <div class="product-thumbnail">--%>
<%--                                    <img src="../images/just-for-you/product1.webp" alt="product-thumbnail">--%>
<%--                                </div>--%>

<%--                                <div class="product-description">--%>
<%--                                    <div class="product-name">--%>
<%--                                        <p><c:out value="${product.getProductName()}"/></p>--%>
<%--                                    </div>--%>
<%--                                    <div class="product-price">--%>
<%--                                        <p><c:out value="${product.getProductCost()}"/></p>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </a>--%>
<%--                    </c:forEach>--%>


<%--                    &lt;%&ndash;                    <% } %>&ndash;%&gt;--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<script src="../js/animation.js"></script>--%>
<%--</body>--%>
<%--</html>--%>


<%--Lê Phi Long - C0823H1--%>
<%--9:50 AM--%>
<%--<div class="product-container">--%>
<%--    <c:if test="${empty param.categoryId}">--%>
<%--        <%--%>
<%--            IProductDAO productDAO = new ProductDAO();--%>
<%--            List<Product> products = productDAO.getAllProduct();--%>
<%--        %>--%>
<%--        <c:set var="products" value="<%= products %>" scope="request" />--%>
<%--    </c:if>--%>

<%--    <c:if test="${not empty products}">--%>
<%--        <c:forEach items="${products}" var="product">--%>
<%--            <a href="/products?action=showProductById&productId=${product.getProductId()}">--%>
<%--                <div class="product-item">--%>
<%--                    <div class="product-thumbnail">--%>
<%--                        <img src="../images/just-for-you/${product.getProductId()}.jpg" alt="product-thumbnail">--%>
<%--                    </div>--%>

<%--                    <div class="product-description">--%>
<%--                        <div class="product-name">--%>
<%--                            <p>${product.getProductName()}</p>--%>
<%--                        </div>--%>
<%--                        <div class="product-price">--%>
<%--                            <p>${product.getProductCost()}</p>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </a>--%>
<%--        </c:forEach>--%>
<%--    </c:if>--%>
<%--</div>--%>
<%--9:52--%>
<%--<div class="categories-title">--%>
<%--    <p>Danh mục</p>--%>
<%--</div>--%>
<%--<div class="categories-content">--%>
<%--    <%--%>
<%--        ICategoryDAO categoryDAO = new CategoryDAO();--%>
<%--        List<Category> categories = categoryDAO.getAllCategory();--%>
<%--        for (Category category : categories) { %>--%>
<%--    <button type="submit" name="categoryID" value="<%=category.getCategoryId()%>">--%>
<%--        <a href="/products?action=displayProductByCategory&categoryId=<%=category.getCategoryId()%>"><%=category.getCategoryName()%></a>--%>
<%--    </button>--%>
<%--    <% } %>--%>
<%--</div>--%>


<%--Lê Phi Long - C0823H1--%>
<%--9:37 AM--%>
<%--/products?action=displayProductByUserId&userId=${currentUser.userId}--%>
<%--:white_check_mark:--%>
<%--1--%>

<%--New--%>
<%--9:37--%>
<%@ page import="com.codegym.cglazadaplusproject.model.User" %>
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
                <%
                    User currentUser = (User) request.getSession().getAttribute("currentUser");
                    String currentUsername = (currentUser != null) ? currentUser.getUsername() : null;
                    boolean isLoggedIn = (currentUsername != null);
                %>

                <%
                    if (isLoggedIn) {
                        // User is logged in, display username
                %>
                <div class="navbar-item user-overlay">
                    <a href="" id="AccountOverlayButton">
                        <span>XIN CHÀO, <%= currentUsername %> </span>
                    </a>

                    <div class="account-overlay-container" id="AccountOverlay">
                        <a href="<c:out value="/view/account/editAccountInfo.jsp"/>">
                            <i class="fa-solid fa-user" style="color: #d6d6d6;"></i>
                            <span>Thông tin cá nhân</span>
                        </a>
                        <a href="/products?action=displayProductByUserId&userId=${currentUser.userId}">
                            <i class="fa-solid fa-bag-shopping" style="color: #d6d6d6;"></i>
                            <span>Danh sách mặt hàng</span>
                        </a>
                        <a href="">
                            <i class="fa-regular fa-credit-card" style="color: #d6d6d6;"></i>
                            <span>Lịch sử giao dịch</span>
                        </a>
                    </div>
                </div>
                <div class="navbar-item">
                    <a href="<c:url value="/users?action=logOut"/>">
                        <span>ĐĂNG XUẤT</span>
                    </a>
                </div>
                <%
                } else {
                    // User is not logged in, display login link
                %>
                <div class="navbar-item">

                    <a href="<c:url value="/users?action=displayLogin"/>">

                        <span>ĐĂNG NHẬP</span>
                    </a>
                </div>

                <div class="navbar-item">
                    <a href="<c:url value="/users?action=displayCreate"/>">
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
                <a href="<c:url value="/index"/>">
                    <img src="../images/header/logo-heart.png" alt="This is Lazada logo icon" class="logo-heart">
                    <img src="../images/header/logo-text.png" alt="This is Lazada logo text" class="logo-text">
                </a>
            </div>
            <div class="menu-bar">
                <form class="menu-search-bar" action="<c:url value="/products?action=searchProduct"/>" method="post">
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
                    <a href="<c:url value="/checkOut"/>">
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
    <form action="/products?action=displayProductByUserId" method="get" class="body">
        <div class="cart-product-list content-frame">

            <!--        Bắt đầu vòng lặp forEach-->
            <c:forEach var="product" items="${products}">
                <div class="product-checkout-item">
                    <div class="product-checkout-info">
                        <div class="product-checkout-thumbnail">
                            <img src="../../images/products/${product.productId}.jpg" alt="">
                        </div>

                        <div class="product-checkout-description">

                            <div class="product-checkout-name">
                                <p><c:out value="${product.productName}"/></p>
                            </div>

                            <div class="product-checkout-detail">
                                <p class="product-checkout-price"><c:out value="đ${product.productCost}"/></p>
                            </div>
                        </div>
                    </div>
                    <div class="product-checkout-delete">
                        <a style="font-size: medium"
                           href="${pageContext.request.contextPath}/products?action=showEditProductForm&productID=${product.productId}">Sửa
                            sản phẩm</a>
                    </div>
                    <div class="product-checkout-delete">
                        <a style="font-size: medium"
                           href="${pageContext.request.contextPath}/products?action=deleteProduct&productId=${product.productId}">
                            Xóa sản phẩm</a>
                    </div>
                </div>
                <hr>
            </c:forEach>
            <!--        Kết thúc vòng lặp-->
            <h1><a class="addUserProduct" href="/products?action=showCreateProductForm">Thêm sản phẩm</a></h1>

        </div>
    </form>
</div>
<script src="../../js/animation.js"></script>
<script>
    let accountOverlayButton = document.getElementById("AccountOverlayButton");
    let accountOverlay = document.getElementById("AccountOverlay");
    function displayAccountOverlay() {
        accountOverlay.style.opacity = "1";
        accountOverlay.style.visibility = "visible";
        accountOverlay.style.display = "flex";
    }

    function inDisplayAccountOverlay() {
        accountOverlay.style.opacity = "0";
        // accountOverlay.style.visibility = "hidden";
        accountOverlay.style.display = "none";
    }

    function inDisplayAccountOverlay2() {
        accountOverlay.style.opacity = "0";
        accountOverlay.style.visibility = "hidden";
        // accountOverlay.style.display = "none";
    }

    function displayOrangeAccountButton() {
        accountOverlayButton.style.color = "#f25c05";
    }

    function inDisplayOrangeAccountButton() {
        accountOverlayButton.style.color = "#9d9d9d";
    }
    accountOverlayButton.addEventListener("mouseover", displayAccountOverlay);
    accountOverlayButton.addEventListener("mouseout", inDisplayAccountOverlay2);
    accountOverlay.addEventListener("mouseover", displayAccountOverlay, displayOrangeAccountButton);
    accountOverlay.addEventListener("mouseout", inDisplayAccountOverlay, inDisplayOrangeAccountButton);
</script>

</body>
</html>