<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Quản lý sản phẩm</title>
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
                                        <a href="p_managerControl" style="text-decoration: none">Quản Lý Sản Phẩm</a>
                                    </b>
                                </h2>
                            </div>
                            <div class="col-sm-6">
                                <a href="homeControl"><i class="material-icons img-thumbnail">home</i></a>
                            </div >
                            <div class="col-sm-6">
                                <a href="#addProductModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Thêm mới</span></a>
                            </div>
                        </div>
                    </div>
                    <div class="newsearch">
                        <form action="SearchProduct" method="Post">
                            <button type="submit">
                                <img src="img/core-img/search.png" alt="" ></button>
                            <input value="${search}" class="search-content alert-info" name="search" type="search" placeholder="Nhập thông tin sản phẩm cần tìm kiếm" required="Hãy sống chậm lại!\n Vui lòng nhập thứ bạn cần tìm">
                        </form>
                    </div>
                    <div><h4 style="color: #009999;text-align: center" >${mess}</h4></div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>
                                    <span class="custom-checkbox">
                                        <input type="checkbox" id="selectAll">
                                        <label for="selectAll"></label>
                                    </span>
                                </th>
                                <th>Mã sản phẩm</th>
                                <th>Hình ảnh</th>
                                <th>Tên sản phẩm</th>
                                <th>Đơn vị tính</th>
                                <th>Giá bán</th>
                                <th>Hàng tồn</th>
                                <th>Chỉnh sửa</th>
                            </tr>
                        </thead>
                        <c:forEach items="${listP}" var="o">
                            <tbody>
                                <tr>
                                    <td>
                                        <span class="custom-checkbox">
                                            <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                            <label for="checkbox1"></label>
                                        </span>
                                    </td>
                                    <td>${o.idProducts}</td>
                                    <td><img class="img" src="${o.image}" alt="Hình"></td>
                                    <td>${o.nameProducts}</td>
                                    <td>${o.unit}</td>
                                    <td><fmt:formatNumber value="${o.exPrice}" pattern="###,###"/></td>
                                    <td>${o.inventory}</td>
                                    <td>
                                        <a href="editProduct?pid=${o.idProducts}" class="edit"><i class="material-icons" data-toggle="tooltip" title="Sửa">&#xE254;</i></a>
                                        <a id="delete" onclick="WarningDelete()" href="deleteProduct?pid=${o.idProducts}" class="delete" ><i class="material-icons" data-toggle="tooltip" title="Xóa">&#xE872;</i></a>

                                    </td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
            </div>        
        </div>
        <div id="addProductModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="addProduct" method="POST" enctype="multipart/form-data">
                        <div class="modal-header">						
                            <h4 class="modal-title">Tạo sản phẩm mới</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <h4>${messtb}</h4>
                        <div class="modal-body">	
                            <div class="form-group">
                                <label>Mã sản phẩm</label>
                                <input readonly="" placeholder="..." name="idProducts" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Tên sản phẩm</label>
                                <textarea placeholder="Nhập tên sản phẩm" name="nameProducts" class="form-control" required>${p.nameProducts}</textarea>
                            </div>
                            <div class="form-group">
                                <label>Hình ảnh</label> <br>
                                <input id ="image" name = "image" type="file"  required>

                            </div>
                            <div class="form-group">
                                <label>Mô tả</label>
                                <textarea placeholder="Nhập mô tả sản phẩm" name="description" class="form-control" required style="height: 400px"></textarea>
                            </div>
                            <div class="form-group">
                                <label>Đơn vị tính</label>
                                <input placeholder="Nhập đơn vị tính"name="unit" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Số lượng tồn</label>
                                <input placeholder="Nhập số lượng tồn(Vui lòng nhập số)" name="inventory" type="number" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Giá nhập</label>
                                <input placeholder="Nhập giá nhập(Vui lòng nhập số)" name="imPrice" type="number" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Giá xuất</label>
                                <input placeholder="Nhập giá xuất(Vui lòng nhập số)" name="exPrice" type="number" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Ghi chú</label>
                                <textarea class="form-control" ></textarea>
                            </div>
                            <label>Nghành hàng</label>
                            <div class="form-group">
                                <select name="idIndustry" >
                                    <c:forEach items="${listC}" var="o">
                                        <option value="${o.idCategory}">${o.nameCategory}</option>
                                    </c:forEach>
                                </select>
                            </div>					
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Hủy">
                            <input type="submit" class="btn btn-success" value="Thêm">
                        </div>
                    </form>
                </div>
            </div>
        </div>  
    </body>
</html>
<script type="text/javascript">
        function WarningDelete() {
            if (confirm('Bạn có muốn xóa sản phẩm này không?')) {
        } else {
            event.preventDefault();
        }
        };
</script>