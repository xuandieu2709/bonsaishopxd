<%@page import="dao.DAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Product"%>
<%@page import="java.text.NumberFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <!-- Title  -->
        <title>Cửa hàng cây cảnh XD | Đơn hàng</title>

        <!-- Favicon  -->
        <link rel="icon" href="img/core-img/logoweb.ico">

        <!-- Core Style CSS -->
        <link rel="stylesheet" href="css/core-style.css">
        <link rel="stylesheet" href="style.css">

    </head>

    <body>
        <!-- Search Wrapper Area Start -->
        <jsp:include page="menu.jsp"></jsp:include>
            <!-- Header Area End -->
            <div class="cart-table-area section-padding-50">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12 ">
                            <div class="cart-title mt-50">
                                <h2>Đơn hàng của tôi</h2>
                            </div>
                        <c:set value="0" var="count"/>
                        <c:forEach items="${listO}" var="or1">
                             <c:set value="${count+1}" var="count"/>
                            <div class="col-md-12 float-left">
                                <h6>Đơn hàng <b id="count"><c:out value="${count}"/></b></h6>
                                <img class="img-thumbnail" height="30" width="30" src="img/core-img/logoweb.jpg">
                            </div>
                            <div class="col-md-5 float-left">
                                <h6>Tên người nhận: <b>${or1.nameCustommer}</b></h6>
                            </div>
                            <div class="col-md-7 text-right float-right">
                                <h6>Địa chỉ nhận hàng: <b>${or1.address}</b></h6>
                            </div>
                            <div class="col-md-4 float-left">
                                <h6>Số điện thoại: <b>${or1.numberphone}</b></h6>
                            </div>
                            <div class="col-md-4 text-center float-left">
                                <h6>Ngày đặt: <b>${or1.dateOrder}</b></h6>
                            </div>
                            <div class="col-md-4 text-right float-right">
                                <h6>Số lượng: <b>${or1.amount}</b></h6>
                            </div>
                            <div class="col-md-6 text-left float-left">
                                <h6>Hình thức thanh toán: <b>${or1.payments}</b></h6>
                            </div>
                            <div class="col-md-6 text-right float-right">
                                <h4>Tổng cộng: <b><fmt:formatNumber value="${or1.sum}" pattern="###,###"/> ₫</b></h4>
                            </div>
                            <div style="margin: 10px auto; margin-left: 5px">
                                <a href="showDetailOrder?oid=${or1.idOrder}"><button id="detail" class="btn btn-success">Chi tiết</button></a>
                            </div>
                            <c:if test="${condition == or1.idOrder}">
                                <div class="cart-table">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th>Tên sản phẩm</th>
                                                <th>Giá</th>
                                                <th>Số lượng</th>
                                            </tr>
                                        </thead>
                                        <c:forEach items="${listP}" var="p">
                                            <tbody>
                                                <tr>
                                                    <td class="cart_product_img">
                                                        <a href="#"><img src="${p.image}" alt="Product" height="80px" width="80px"></a>
                                                    </td>
                                                    <td class="cart_product_desc">
                                                        <h5>${p.nameProducts}</h5>
                                                    </td>
                                                    <td class="price">
                                                        <span><fmt:formatNumber value="${p.exPrice}" pattern="###,###"/></span>
                                                    </td>
                                                    <td class="qty">
                                                        <div class="qty-btn d-flex">
                                                            <div class="quantity">
                                                                <b class="text-center text-info">${p.amount}</b>
                                                            </div>
                                                            <div style="margin-left: 20px;">
                                                            </div>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </c:forEach>

                                    </table>
                                </div>
                                <c:set value="0" var="condition"/>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Main Content Wrapper End ##### -->

    <!-- ##### Newsletter Area Start ##### -->
    <jsp:include page="page/discount.jsp"></jsp:include>
        <!-- ##### Newsletter Area End ##### -->

        <!-- ##### Footer Area Start ##### -->
    <jsp:include page="page/footer.jsp"></jsp:include>
    <!-- ##### Footer Area End ##### -->
    <!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
    <script src="js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="js/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Plugins js -->
    <script src="js/plugins.js"></script>
    <!-- Active js -->
    <script src="js/active.js"></script>

</body>

</html>
