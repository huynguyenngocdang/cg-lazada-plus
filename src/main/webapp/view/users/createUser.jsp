<%@ page import="com.codegym.cglazadaplusproject.model.User" %>
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
    <link rel="shortcut icon" href="../images/title.png">
    <link rel="stylesheet" type="text/css" href="../../css/base.css">
    <link rel="stylesheet" type="text/css" href="../../css/user.css">
<body>


<c:if test='${not empty requestScope["message"]}'>
    <div class="noti-container" id="noti-container">
        <div class="noti-content">
            <div class="noti-icon">
                <img src="../images/header/logo-heart.png" alt="this is lazada icon">
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
                        <a href="<c:out value="/products?action=displayProductByUserId&userId=${currentUser.userId}"/>">
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
                    <img src="../../images/header/logo-heart.png" alt="This is Lazada logo icon" class="logo-heart">
                    <img src="../../images/header/logo-text.png" alt="This is Lazada logo text" class="logo-text">
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
    <div class="body">
        <div class="user-container">
            <div class="user-title">
                <p>Chào mừng đến với Lazada. Đăng ký ngay!</p>
            </div>
            <div class="content-frame">
                <form action="<c:url value="/users?action=create"/>" method="post" id="signInForm">
                    <div class="form-input">
                        <label for="username">Tên đăng ký*</label>
                        <input type="text" name="username" id="username" placeholder="Vui lòng nhập tên đăng ký"
                               required>
                    </div>

                    <div class="form-input">
                        <label for="password">Mật khẩu*</label>
                        <input type="password" name="password" id="password" placeholder="Vui lòng nhập mật khẩu" oninput="checkConfirmPassword()" onchange="checkConfirmPassword()"
                               required>
                    </div>
                    <div class="form-input">
                        <label for="passwordConfirm">Nhập lại mật khẩu*</label>
                        <input type="password" name="passwordConfirm" id="passwordConfirm" oninput="checkConfirmPassword()" onchange="checkConfirmPassword()"
                               placeholder="Vui lòng nhập lại mật khẩu" required/>
                        <p class="re-enter-confirm-password" id="passwordNoti">Mật khẩu không trùng khớp</p>
                    </div>

                    <div class="form-checkbox">
                        <input type="checkbox" id="checkboxConfirm" required>
                        <label for="checkboxConfirm">Tôi đã đọc và đồng ý với <a href="">Điều Khoản Sử Dụng</a> và <a
                                href="">Chính Sách Bảo Mật</a> của Lazada, bao gồm quyền thu thập, sử dụng, và tiết lộ
                            dữ liệu cá nhân của tôi theo pháp luật quy định.*</label>
                    </div>

                    <div class="submit-button">
                        <button type="submit" id="submitButton">ĐĂNG KÝ</button>
                    </div>
                </form>
            </div>

            <div class="other-option">
                <p>Bạn đã là thành viên? <a href="<c:url value="/users?action=displayLogin"/>">Đăng nhập</a> tại đây</p>
            </div>
        </div>
    </div>
</div>

<script src="../../js/signInPasswordConfirm.js"></script>
<script src="../../js/animation.js"></script>
<script
        src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
        crossorigin="anonymous"></script>
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