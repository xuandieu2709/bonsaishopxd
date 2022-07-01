<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Sửa sản phẩm</title>
        <link rel="icon" href="img/core-img/logoweb.ico">
        <link rel="stylesheet" href="../style_manager.css"> 
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <div id="editProductModal" >
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="editProduct" method="POST" enctype="multipart/form-data">
                        <div class="modal-header">						
                            <h4 class="modal-title"><b>Chỉnh sửa sản phẩm</b></h4>
                            <a href="p_managerControl"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button></a>
                        </div>
                        <div><h4 style="color: #009999;text-align: center" >${mess}</h4></div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>Mã sản phẩm</label>
                                <input value="${p.idProducts}" readonly="" name="idProducts" type="text" class="form-control"  required>
                            </div>
                            <div class="form-group">
                                <label>Tên sản phẩm</label>
                                <textarea laceholder="Nhập tên sản phẩm" name="nameProducts" class="form-control" required>${p.nameProducts}</textarea>
                            </div>
                            <div class="form-group">
                                <label>Hình ảnh</label><br>
                                <h6 >(Vui lòng không chọn nếu không muốn thay đổi)</h6>
                                <img src="${p.image}" height="50px" width="50px">
                                <input id ="image" name = "image" type="file">
                            </div>
                            <div class="form-group">
                                <label>Mô tả</label>
                                <textarea laceholder="Nhập mô tả sản phẩm" name="description" class="form-control" required style="height: 400px">${p.desciption}</textarea>
                            </div>
                            <div class="form-group">
                                <label>Đơn vị tính</label>
                                <input laceholder="Nhập đơn vị tính" value="${p.unit}" name="unit" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Số lượng tồn<h6 style="color: #cc0000">(giá trị số)<h6></label>
                                            <input laceholder="Nhập hàng tồn(Vui lòng nhập số)" value="${p.inventory}" name="inventory" type="number" class="form-control" required>
                                            </div>	
                                            <c:if test="${sessionScope.a.idfunction == 1}">
                                            <div class="form-group">
                                                <label>Giá nhập<h6 style="color: #cc0000">(giá trị số)<h6></label>
                                                            <input laceholder="Nhập giá nhập(Vui lòng nhập số)" value="${p.imPrice}" name="imPrice" type="number" class="form-control" required>
                                                            </div>
                                            </c:if>
                                                            <div class="form-group">
                                                                <label>Giá xuất<h6 style="color: #cc0000">(giá trị số)<h6></label>
                                                                            <input laceholder="Nhập giá xuất(Vui lòng nhập số)" value="${p.exPrice}" name="exPrice" type="number" class="form-control" required>
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label>Ghi chú</label>
                                                                                <textarea class="form-control" >${p.note}</textarea>
                                                                            </div>
                                                                            <label>Nghành hàng</label>
                                                                            <div class="data text-light">
                                                                                <select name="idIndustry" > 
                                                                                    <c:forEach items="${listC}" var="o">
                                                                                        <c:if test="${o.idCategory == c.idCategory}">
                                                                                            <option value="${o.idCategory}" selected style="color: #009999">${o.nameCategory}</option>
                                                                                        </c:if>
                                                                                        <c:if test="${o.idCategory != c.idCategory}">
                                                                                            <option value="${o.idCategory}" >${o.nameCategory}</option>
                                                                                        </c:if>
                                                                                    </c:forEach>
                                                                                </select>
                                                                            </div>						
                                                                            </div>
                                                                            <div class="modal-footer">
                                                                                <a href="p_managerControl"><input type="button" class="btn btn-default" data-dismiss="modal" value="Hủy"></a>
                                                                                <input type="submit" class="btn btn-info" value="Lưu">
                                                                            </div>
                                                                            </form>
                                                                            </div>
                                                                            </div>
                                                                            </div>
                                                                            </body>
                                                                            </html>
                                                                            <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
                                                                            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
                                                                            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
                                                                            <script src="manager/active_manager.js">