<%@page import="java.text.NumberFormat"%>
<%@page import="bean.Product"%>
<%@page import="dao.DAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Cửa hàng cây cảnh XD | Chi tiết sản phẩm</title>

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
        <%
           /* DAO dao = new DAO();
            NumberFormat fm = NumberFormat.getNumberInstance();
            fm.setMinimumIntegerDigits(0);
            Product p = dao.getProductsByIDProduct(request.getParameter("pid")); */
        %>
        <!-- Product Details Area Start -->
        <div class="single-product-area section-padding-100 clearfix">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb mt-50">
                                <li class="breadcrumb-item"><a href="#">Chi tiết sản phẩm</a></li>
                                <li class="breadcrumb-item"><a href="#">Danh Mục</a></li>
                                <li class="breadcrumb-item"><a href="#">${c.nameCategory}</a></li>
                                <li class="breadcrumb-item active" aria-current="page">${p.nameProducts}</li>
                            </ol>
                        </nav>
                    </div>
                </div>
                <div class="row">
                    <!-- comment -->
                    <div class="col-12 col-lg-7">
                        <div class="single_product_thumb">
                            <div id="product_details_slider" class="carousel slide" data-ride="carousel">
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <a class="gallery_img" href="${p.image}">
                                            <img class="d-block w-100" src="${p.image}" alt="First slide">
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-lg-5">
                        <div class="single_product_desc">
                            <!-- Product Meta Data -->
                            <div class="product-meta-data">
                                <div class="line"></div>
                                <p class="product-price"><fmt:formatNumber value="${p.exPrice}" pattern="###,###"/> ₫</p>
                                <h6>${p.nameProducts}</h6>
                                <!-- Ratings & Review -->
                                <div class="ratings-review mb-15 d-flex align-items-center justify-content-between">
                                    <div class="ratings">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                    </div>
                                    <div class="review">
                                        <a href="#">Đánh giá</a>
                                    </div>
                                </div>
                                <!-- Avaiable -->
                                <p class="avaibility"><i class="fa fa-circle">${p.inventory >0?" Còn hàng":" Hết hàng"}</i></p>
                            </div>

                            <div class="short_overview my-5">
                                <p>${p.desciption}</p>
                            </div>

                            <!-- Add to Cart Form -->
                            <c:if test="${(sessionScope.a.idfunction != 1 and sessionScope.a.idfunction != 2)}">
                            <form class="cart clearfix text-center" method="post" action="cartControl?id=${p.idProducts}">
                                <button type="submit" name="addtocart" value="5" class="btn amado-btn">Thêm vào giỏ hàng</button>
                            </form>
                            </c:if>   
                            <c:if test="${(sessionScope.a.idfunction == 1 or sessionScope.a.idfunction == 2)}">
                                <button type="submit" name="addtocart" value="5" class="btn amado-btn">Thêm vào giỏ hàng</button>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Product Details Area End -->
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