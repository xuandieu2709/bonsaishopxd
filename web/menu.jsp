<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DAO"%>
<%@page import="java.util.List"%>
<%@page import="bean.Product"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
List<Product> list = new ArrayList();
try{
    Cookie arr[] = request.getCookies();
    DAO dao = new DAO();
    for (Cookie o : arr) {
                if (o.getName().equals("id")) {
            String txt[] = o.getValue().split("%x2C");
            for (String s : txt) {
                list.add(dao.getProductsByIDProduct(s));
            }
        }
    }
    int count = 0;
    for(Product p:list){
            count++;
    }
%>
<div class="main-content-wrapper d-flex clearfix">

    <!-- Mobile Nav (max width 767px)-->
    <div class="mobile-nav">
        <!-- Navbar Brand -->
        <div class="amado-navbar-brand">
            <a href="homeControl"><img style="border-radius: 10px" src="img/core-img/logoweb.jpg" alt=""></a>
        </div>
        <!-- Navbar Toggler -->
        <div class="amado-navbar-toggler">
            <span></span><span></span><span></span>
        </div>
    </div>

    <!-- Header Area Start -->
    <header class="header-area clearfix">
        <!-- Close Icon -->
        <div class="nav-close">
            <i class="fa fa-close" aria-hidden="true"></i>
        </div>
        <!-- Logo -->
        <div class="logo img img-rounded">
            <a href="homeControl"><img src="img/core-img/logoweb.jpg" alt=""></a>
        </div>
        <nav class="amado-nav">
            <ul>
                
                    <li class="${home == 'link'?"active":""}"><a id="home" href="homeControl">Trang Chủ</a></li>
                    <li class="${shop == 'link'?"active":""}"><a id="pro" href="shopControl">Sản Phẩm</a></li>
                    <!-- comment <li><a href="detailControl">Product</a></li> -->
                    <c:if test="${(sessionScope.a.idfunction != 1 && sessionScope.a.idfunction != 2)}">
                    <li class="${cart == 'link'?"active":""}"><a href="showCart">Giỏ Hàng</a></li>
                    <li class="${checkout == 'link'?"active":""}"><a href="showProductCheckout">Thanh Toán</a></li>
                    </c:if>
                    <c:if test="${(sessionScope.a.idfunction != 1 && sessionScope.a.idfunction != 2)}">
                    <li class="${order1 == 'link'?"active":""}"><a href="showOrder">Đơn hàng</a></li>
                    </c:if>
                    <c:if test="${sessionScope.a.idfunction == 1 or sessionScope.a.idfunction == 2}">
                    <li class="${pmanager == 'link'?"active":""}"><a href="p_managerControl">Quản lý Sản Phẩm</a></li>
                    <li class="${paccount == 'link'?"active":""}"><a href="o_managerControl">Quản lý Đơn Hàng</a></li>
                    <li class="${paccount == 'link'?"active":""}"><a href="manager/a_manager.jsp">Quản lý Khách Hàng</a></li>
                    </c:if>
                    <c:if test="${sessionScope.a.idfunction == 1}">
                    <li class="${paccount == 'link'?"active":""}"><a href="manager/a_manager.jsp">Quản lý Nhân Viên</a></li>
                    <li class="${paccount == 'link'?"active":""}"><a href="manager/a_manager.jsp">Quản lý Tài Khoản</a></li>
                    </c:if>
                    <c:if test="${sessionScope.a != null}">
                    <!--<li><a href="manager/a_manager.jsp">Chào, ${a.username}</a></li>
                    <li><a href="logoutControl">Đăng Xuất</a></li> -->
                    <div class="dropdown ">
                        <div data-toggle="dropdown">
                            <li class="${account == 'linkAC'?"active":""}"><a href="accountControl" >Chào, ${a.username}</a></li>
                        </div>
                        <div class="dropdown-menu border-dark" style="margin: 5px 0">
                            <c:if test="${sessionScope.a.idfunction == 3 or sessionScope.a.idfunction == 2}">
                                <ul><a class="dropdown-item alert" href="#">Thông tin tài khoản</a></ul>
                                <div class="dropdown-divider "></div>
                            </c:if>
                            <c:if test="${sessionScope.a.idfunction == 3}">
                                <ul><a class="dropdown-item alert" href="showOrder">Đơn hàng của tôi</a></ul>
                                <div class="dropdown-divider "></div>
                            </c:if>
                            <c:if test="${sessionScope.a.idfunction == 1 or sessionScope.a.idfunction == 2 or sessionScope.a.idfunction == 3}">
                                <ul><a class="dropdown-item alert" href="logoutControl">Đăng xuất</a></ul>
                            </c:if>
                        </div>
                    </div>
                </c:if>
                <c:if test="${sessionScope.a == null}">
                    <li><a href="login.jsp">Đăng Nhập</a></li>
                    </c:if>
            </ul>
        </nav>
        <c:if test="${(sessionScope.a.idfunction != 1 && sessionScope.a.idfunction != 2)}">
            <div class="amado-btn-group mt-30 mb-100" style="margin-top: auto">
                <c:if test="${sessionScope.a == null}">
                <a href="login.jsp" onclick="window.alert('Đăng nhập nhận ngay VOUCHER ưu đãi!\n\nClick OK ngay để đăng nhập');" class="btn amado-btn mb-15">Giảm giá 20%</a>
                </c:if>
                <a href="topsaleControl" class="btn amado-btn active">Bán chạy nhất</a>
            </div>
            <!-- Cart Menu -->
            <div class="cart-fav-search mb-100">
                <a href="showCart" class="cart-nav"><img src="img/core-img/cart.png" alt=""> Giỏ Hàng <span>(<b><%=count%></b>)</span></a>
                <a href="manager/a_manager.jsp" class="fav-nav"><img src="img/core-img/favorites.png" alt=""> Yêu Thích</a>

                <!--<a href="#" class="search-nav"><img src="img/core-img/search.png" alt="">Tìm Kiếm</a> -->
            </div>
        </c:if>
        <!-- Social Button -->
        <div class="social-info d-flex justify-content-between">
            <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
            <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
            <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
            <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
        </div>
    </header>
    <%}
catch(Exception e){
e.printStackTrace();
}%>
