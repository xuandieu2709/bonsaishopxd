<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Quản lý Đơn Hàng</title>
        <link rel="icon" href="img/core-img/logoweb.ico">
        <link rel="stylesheet" href="manager/style_manager.css">  
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <script src="manager/active_manager.js"></script>
    </head>
    <body>
        <div class="container-xl">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-12 ">
                                <h2 style="font-size: 40px"><b>
                                        <a href="o_managerControl" style="text-decoration: none">Quản Lý Đơn Hàng</a>
                                    </b>
                                </h2>
                            </div>
                            <div class="col-sm-6">
                                <a href="homeControl"><i class="material-icons img-thumbnail">home</i></a>
                            </div >
                            <div class="col-sm-6">
                                <!--<a href="#addProductModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Thêm mới</span></a>
                                 <a href="#deleteProductModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Xóa</span></a>		 -->				
                            </div>
                        </div>
                    </div>
                    <div class="newsearch">
                        <form action="#" method="Post">
                            <button type="submit">
                                <img src="img/core-img/search.png" alt="" ></button>
                            <input value="${search}" class="search-content alert-info" name="search" type="search" placeholder="Nhập thông tin đơn hàng cần tìm kiếm" required="Hãy sống chậm lại!\n Vui lòng nhập thứ bạn cần tìm">
                        </form>
                    </div>
                    <div><h4 style="color: #009999;text-align: center" >${mess}</h4></div>
                    <table class="table table-striped table-hover text-center">
                        <thead>
                            <tr>
                                <th>
                                    <span class="custom-checkbox">
                                        <input type="checkbox" id="selectAll">
                                        <label for="selectAll"></label>
                                    </span>
                                </th>
                                <th>Mã Đơn hàng</th>
                                <th>Tên Khách hàng</th>
                                <th>Số điện thoại</th>
                                <th>Địa chỉ nhận hàng</th>
                                <th>Số lượng</th>
                                <th>Tổng Cộng</th>
                                <th>Hình thức thanh toán</th>
                                <th>Tình trạng đơn hàng</th>
                                <th></th>
                            </tr>
                        </thead>
                        <c:forEach items="${listO}" var="o">
                            <tbody>
                                <tr>
                                    <td>
                                        <span class="custom-checkbox">
                                            <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                            <label for="checkbox1"></label>
                                        </span>
                                    </td>
                                    <td>${o.idOrder}</td>
                                    <td>${o.nameCustommer}</td>
                                    <td>${o.numberphone}</td>
                                    <td>${o.address}</td>
                                    <td>${o.amount}</td>
                                    <td><fmt:formatNumber value="${o.sum}" pattern="###,###"/></td>
                                    <td>${o.payments}</td>
                                    <td>${o.status=='0'?'Chưa giao':'Đã giao'}</td>
                                    <td>
                                        <a id="delete" href="#" class="delete" ><i class="material-symbols-outlined" data-toggle="tooltip" title="Chi tiết">info</i></a>
                                        <a href="#" class="edit"><i class="material-icons" data-toggle="tooltip" title="Cập nhật">&#xE254;</i></a>
                                        

                                    </td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
            </div>        
        </div>
    </body>
</html>
<script type="text/javascript">

        function showWaring()  {

             var result = confirm("Bạn muốn xóa sản phẩm này không?");
             if(result)  {
                 alert("Xác nhận");
             } 
        }

</script>