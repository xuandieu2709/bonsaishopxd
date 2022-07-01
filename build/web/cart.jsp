
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title></title>
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
        <div class="cart-table-area section-padding-100-0">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12 col-lg-9">
                        <div class="cart-title mt-50">
                            <h2>Giỏ hàng</h2>
                        </div>
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
                                <c:forEach items="${list}" var="o">
                                    <tbody>
                                        <tr>
                                            <td class="cart_product_img">
                                                <a href="detailControl?pid=${o.idProducts}"><img src="${o.image}" alt="Product" height="80px" width="80px"></a>
                                            </td>
                                            <td class="cart_product_desc">
                                                <h5>${o.nameProducts}</h5>
                                            </td>
                                            <td class="price">
                                                <span><fmt:formatNumber value="${o.exPrice}" pattern="###,###"/></span>
                                            </td>
                                            <td class="qty">
                                                <div class="qty-btn d-flex">
                                                    <div class="quantity">
                                                        <a href="subControlCart?id=${o.idProducts}"><button class="btn btn-dark" style="margin: auto 20px"><b>-</b></button></a>
                                                        <br>
                                                        <input readonly name="amount" class="" type="number" max="${o.inventory ge 100?100:o.inventory}" value="${o.amount < o.inventory?o.amount:o.inventory}" style="text-align: center;width: auto;max-width: 80px; margin: 5px auto">
                                                        </br>
                                                        <c:if test="${(o.amount lt o.inventory) and (o.amount lt 100)}">
                                                            <a href="cartControl?id=${o.idProducts}"><button id="clickup" class="btn btn-success" style="margin: auto 20px"><b>+</b></button></a>
                                                        </c:if>
                                                        <c:if test="${(o.amount ge o.inventory) or (o.amount eq 100)}">
                                                            <button onclick="${((o.amount lt o.inventory) and (o.amount eq 100))}?showMess():showMess1()" class="btn btn-secondary" style="margin: auto 20px"><b>+</b></button>
                                                        </c:if>
                                                    </div>
                                                    <div style="margin-left: 20px; margin-bottom: auto;margin-top: auto">
                                                        <a href="removeCart?id=${o.idProducts}"><button class="btn btn-danger"><b>Xóa</b></button></a>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                    </tbody>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                    <div class="col-12 col-lg-3">
                        <div class="cart-summary">
                            <h5></h5>
                            <ul class="summary-table">
                                <li><span>Giá sản phẩm:</span> <span>${total}₫</span></li>
                                <li><span>Vận chuyển:</span> <span>Miễn phí</span></li>
                                <li><span>VAT(10%):</span> <span>${vat}₫</span></li>
                                </li>
                                <li><span>Tạm tính:</span> <span>${sum}₫</span></li>
                            </ul>
                               
                            <div class="cart-btn mt-100">
                                <c:if test="${sum != '0'}">
                                    <a id="clickcheck" href="showProductCheckout" class="btn amado-btn w-100">Thanh toán</a>
                                </c:if>
                                <c:if test="${sum == '0'}">
                                    <a style="background-color: #2b4a58" onclick="window.alert('Vui lòng thêm sản phẩm vào giỏ hàng để thanh toán!');" class="btn btn-danger amado-btn w-100">Thanh toán</a>
                                </c:if>
                            </div>
                                
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Main Content Wrapper End ##### -->
    <script type="text/javascript">

             function showMess()  {
                  alert("Hãy dừng lại!\n\nĐã quá số lượng cho phép");
             }
             function showMess1()  {
                  alert("Hãy dừng lại!\n\nSố lượng hàng tồn không đủ");
             }

    </script>
</script>
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
