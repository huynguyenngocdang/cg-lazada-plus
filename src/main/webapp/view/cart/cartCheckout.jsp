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
    <link rel="shortcut icon" href="../../images/titleIcon.png">
    <link rel="stylesheet" type="text/css" href="../../css/base.css">
    <link rel="stylesheet" type="text/css" href="../../css/cartCheckOut.css">
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
                <div class="navbar-item user-overlay">
                    <a href="" id="AccountOverlayButton">
                        <span>XIN CHÀO, <%= currentUsername %> </span>
                    </a>

                    <div class="account-overlay-container" id="AccountOverlay">
                        <a href="<c:out value="/view/account/editAccountInfo.jsp"/>">
                            <i class="fa-solid fa-user" style="color: #d6d6d6;"></i>
                            <span>Thông tin cá nhân</span>
                        </a>
                        <a href="">
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

    <form action="<c:url value="/checkOut?action=purchase"/>" method="post" class="body">

        <div class="cart-product-list content-frame">

            <!--        Bắt đầu vòng lặp forEach-->
            <c:forEach var="cartItem" items="${cartItems}">
                <div class="product-checkout-item">
                    <div class="product-checkout-info">
                        <div class="product-checkout-thumbnail">
                            <img src="../../images/products/${cartItem.product.productId}.jpg" alt="">
                        </div>

                        <div class="product-checkout-description">

                            <div class="product-checkout-name">
                                <p><c:out value="${cartItem.product.productName}"/></p>
                            </div>

                            <div class="product-checkout-detail">
                                <p class="product-checkout-price"><c:out value="đ${cartItem.product.productCost}"/></p>
                                <!--              Thay đổi tên trường name & id củ input trong vòng lặp-->
                                <div class="product-checkout-quantity">
                                    <label for="product-id-quantity">Số lượng:</label>
                                    <input type="number" name="product-id-quantity" id="product-id-quantity" min="1"
                                           max="99" value="${cartItem.productQuantity}">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="product-checkout-delete">
                        <a style="font-size: medium"
                           href="${pageContext.request.contextPath}/checkOut?action=removeCartItem&productId=${cartItem.product.productId}">
                            Xóa sản phẩm</a>
                    </div>
                </div>
                <hr>
            </c:forEach>
            <!--        Kết thúc vòng lặp-->

        </div>

        <div class="product-checkout-bill-confirm content-frame">
            <div class="product-checkout-bill-info">
                <p>Thông tin đơn hàng</p>
                <p>Địa chỉ </p>
                <input type="text" id="deliveryAddress" name="deliveryAddress" value="${currentCustomer.customerAddress}">
                <div class="product-checkout-bill-detail">
                    <div class="bill-product">
                        <!--              Đếm số lượng sản phẩm-->
                        <p>Tạm tính (<span class="product-count"><c:out value="${totalCartAmount}"/></span> sản phẩm)
                        </p>
                        <p><c:out value="$${totalCartCost}"/></p>

                    </div>
                    <div class="bill-shipment">
                        <p>Khuyến mãi</p>
                        <p><c:out value="$${totalCartReduction}" /> </p>
                    </div>

                    <div class="bill-shipment">
                        <p>Phí vận chuyển</p>
                        <p><c:out value="$${deliveryFee}"/></p>
                    </div>

                </div>
            </div>

            <hr>

            <div class="product-checkout-bill-overall">
                <div class="bill-overall">
                    <p>Tổng cộng</p>
                    <p><c:out value="$${totalCartCostWithDeliveryFee}"/></p>
                </div>

                <div class="bill-confirm">
                    <button type="submit">THANH TOÁN</button>
                    <p>đã bao gồm VAT (nếu có)</p>
                </div>
            </div>
        </div>
    </form>
</div>
<script src="../../js/animation.js"></script>


</body>
</html>
