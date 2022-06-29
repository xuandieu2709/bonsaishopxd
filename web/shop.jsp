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
        <title>Cửa hàng cây cảnh XD | Sản phẩm</title>
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

            <div class="shop_sidebar_area">

                <!-- ##### Single Widget ##### -->
                <div class="widget catagory mb-50">
                    <!-- Widget Title -->
                    <h6 class="widget-title mb-30">Danh Mục</h6>

                    <!--  Catagories  -->
                    <div class="catagories-menu">
                        <ul>
                            <li class="${tag == tag1? "active" : ""}"><a href="shopControl">Tất Cả</a></li>
                            <c:forEach items="${listC}" var="o">
                            <li class="${tag == o.idCategory? "active" : ""}"><a href="clickControl?id=${o.idCategory}">${o.nameCategory}</a></li>
                            </c:forEach>
                    </ul>
                </div>
            </div>

            <!-- ##### Single Widget ##### -->
            <div class="widget brands mb-50">
                <!-- Widget Title -->
                <h6 class="widget-title mb-30">Nhà Cung Cấp</h6>
                <div class="catagories-menu">
                    <ul>
                    <c:forEach items="${listS}" var="o">
                        <!-- Single Form Check -->
                        <li class="${tag2 == o.idSupplier? "active" : ""}"><a href="clickControl1?sid=${o.idSupplier}">${o.nameAbbreviations}</a></li>
                    </c:forEach>
                    </ul>
                </div>
            </div>

            <!-- ##### Single Widget ##### -->


            <!-- ##### Single Widget ##### -->
            <!--<div class="widget price mb-50">
            <!-- Widget Title ----
            <h6 class="widget-title mb-30">Giá</h6>

            <div class="widget-desc">
                <div class="slider-range">
                    <div data-min="10000" data-max="100000000" data-unit="đ" class="slider-range-price ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all" data-value-min="10000" data-value-max="10000000" data-label-result="">
                        <div class="ui-slider-range ui-widget-header ui-corner-all"></div>
                        <span class="ui-slider-handle ui-state-default ui-corner-all" tabindex="0"></span>
                        <span class="ui-slider-handle ui-state-default ui-corner-all" tabindex="0"></span>
                    </div>
                    <div class="range-price">10000 ₫ - 100000000 ₫ </div>
                </div>
            </div>
        </div> -->
        </div>
        <div class="amado_product_area section-padding-100">
            <div class="row">
                <div class="col-12">
                    <div class="newsearch">
                        <form action="searchControl" method="Post">
                            <input class="search-content alert-info" value="${search}" type="search" name="search" id="search" placeholder="Nhập thông tin sản phẩm cần tìm...">
                            <button class="btn btn-block" type="submit"><img src="img/core-img/search.png" alt=""></button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="product-topbar d-xl-flex align-items-end justify-content-between">
                            <!-- Total Products -->
                            <div class="total-products">
                                <p>Hiển thị 1 - 10 của <b style="color: #00cc66">Trang ${page}</b></p>
                                <div class="view d-flex">
                                    <a href="#"><i class="fa fa-th-large" aria-hidden="true"></i></a>
                                    <a href="#"><i class="fa fa-bars" aria-hidden="true"></i></a>
                                </div>
                            </div>
                            <!-- Sorting -->
                            <div class="product-sorting d-flex">
                                <div class="sort-by-date d-flex align-items-center mr-15">
                                    <p>Sắp Xếp Theo</p>
                                    <form action="#" method="get">
                                        <select name="select" id="sortBydate">
                                            <option value="value">Tên</option>
                                        </select>
                                    </form>
                                </div>
                                <div class="view-product d-flex align-items-center">
                                    <p>Chế Độ Xem</p>
                                    <form action="#" method="get">
                                        <select name="select" id="viewProduct">
                                            <option value="value">10</option>
                                        </select>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <!-- Single Product Area -->
                    <c:forEach items="${listP}" var="o"> 
                        <div class="col-12 col-sm-6 col-md-12 col-xl-6">
                            <div class="single-product-wrapper">
                                <!-- Product Image -->
                                <div class="product-img">
                                    <img src="${o.image}" alt="">
                                    <!-- Hover Thumb -->
                                    <img class="hover-img" src="img/core-img/logoweb.jpg" alt="">
                                </div>
                                <!-- Product Description -->
                                <div class="product-description d-flex align-items-center justify-content-between">
                                    <!-- Product Meta Data -->
                                    <div class="product-meta-data">
                                        <div class="line"></div>
                                        <p class="product-price"><fmt:formatNumber value="${o.exPrice}" pattern="###,###"/> ₫</p>
                                        <a href="detailControl?pid=${o.idProducts}">
                                            <h6>${o.nameProducts}</h6>
                                        </a>
                                    </div>
                                    <!-- Ratings & Cart -->
                                    <div class="ratings-cart text-right ">
                                        <div class="ratings">
                                            <i class="fa fa-star" aria-hidden="true"></i>
                                            <i class="fa fa-star" aria-hidden="true"></i>
                                            <i class="fa fa-star" aria-hidden="true"></i>
                                            <i class="fa fa-star" aria-hidden="true"></i>
                                            <i class="fa fa-star" aria-hidden="true"></i>
                                        </div>
                                        <c:if test="${(sessionScope.a.idfunction != 1 and sessionScope.a.idfunction != 2)}">
                                        <div class="cart">
                                            <a href="cartControl?id=${o.idProducts}" data-toggle="tooltip" data-placement="left" title="Thêm vào giỏ hàng"><img src="img/core-img/cart.png" alt=""></a>
                                        </div>
                                        </c:if>
                                        <c:if test="${(sessionScope.a.idfunction == 1 or sessionScope.a.idfunction == 2)}">
                                        <div class="cart">
                                            <a href="#" data-toggle="tooltip" data-placement="left" title="Thêm vào giỏ hàng"><img src="img/core-img/cart.png" alt=""></a>
                                        </div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

                <div class="row">
                    <div class="col-12">
                        <!-- Pagination -->
                        <nav aria-label="navigation">
                            <ul class="pagination justify-content-end mt-50">        
                                <c:forEach begin="1" end="${endpage}" var="i">
                                    <c:if test="${tag1 != null && tag != null }">
                                    <li class="page-item ${i==page?"active":""}"><a class="page-link" href="shopControl?index=${i}">${i}&ensp;</a></li>
                                    </c:if>
                                    <c:if test="${tag != null && tag1 == null}">
                                    <li class="page-item ${i==page?"active":""}"><a class="page-link" href="clickControl?index=${i}">${i}&ensp;</a></li>
                                    </c:if>
                                    <c:if test="${tag2 != null && tag1 != null}">
                                    <li class="page-item ${i==page?"active":""}"><a class="page-link" href="clickControl1?index=${i}">${i}&ensp;</a></li>
                                    </c:if>
                                    </c:forEach>
                            </ul>
                        </nav>
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
