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
        <title>Cửa hàng cây cảnh XD | Thanh toán</title>

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
            <div class="cart-table-area section-padding-100">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12">
                            <div class="cart-title mt-50">
                                <h2>Gói hàng(<b>${count1} sp</b>)</h2>
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
                                            <a href="#"><img src="${o.image}" alt="Product" height="80px" width="80px"></a>
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
                                                    <b class="text-center text-info">${o.amount}</b>
                                                </div>
                                                <div style="margin-left: 20px;">
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                                </c:forEach>
                            </table>
                            <div class="col-12">
                                <h4 class="text-center text-info" style="float: right;margin-right: 0px">Tổng số lượng: ${countSum}</h4>

                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-lg-8">
                        <div class="checkout_details_area mt-50 clearfix">

                            <div class="cart-title">
                                <h2>Địa chỉ nhận hàng</h2>
                            </div>

                            <form action="checkoutControl" method="POST" onsubmit="return FormValidate()">
                                <div class="row">
                                    <div class="col-md-12">
                                        <h2 class="text-center text-warning">${mess}</h2>
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label>Họ đệm(*)<br><span style="color: red;font-size: 14px" id="errorFirst"></span></label>
                                        <input type="text" class="form-control" id="first_name"  name="first_name" size="35" maxlength="35"  placeholder="Nhập họ và tên đệm" >
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label>Tên(*)<br><span style="color: red;font-size: 14px" id="errorLast"></span></label>
                                        <input type="text" class="form-control"  id="last_name" name="last_name" size="15" maxlength="15"  placeholder="Tên(*)">
                                    </div>
                                    <div class="col-md-4 mb-3">
                                        <label>Số điện thoại(*)<br><span style="color: red;font-size: 14px" id="errorPhone"></span></label>
                                        <input type="text"  class="form-control" size="10" maxlength="10" id="phone_number" name="phone_number" placeholder="Nhập số điện thoại">
                                    </div>
                                    <div class="col-md-8 mb-3">
                                        <label>Email(*)<br><span style="color: red;font-size: 14px" id="errorEmail"></span></label>
                                        <input type="text"  size="50" maxlength="50" class="form-control" id="email" name="email" placeholder="Nhập email( VD:cobea@gmail.com )">
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label>Tỉnh/Thành Phố(*)<br><span style="color: red;font-size: 14px" id="errorCity"></span></label>
                                        <input type="text"  size="50" maxlength="50" class="form-control" id="city" name="city" placeholder="Nhập tỉnh/thành phố" >
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label>Phường/xã(*)<br><span style="color: red;font-size: 14px" id="errorWard"></label>
                                        <input type="text" class="form-control" id="ward"  name="ward" placeholder="Nhập phường/xã" >
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label>Quận/huyện(*)<br><span style="color: red;font-size: 14px" id="errorDistrict"></span></label>
                                        <input type="text" class="form-control" id="district"  name="district" placeholder="Nhập quận/huyện" >
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label>Số nhà và đường(*)<br><span style="color: red;font-size: 14px" id="errorStreet"></span></label>
                                        <input type="text"  class="form-control mb-3" id="street_address" name="street_address" placeholder="Nhập số nhà và đường" >
                                    </div>
                                    <div class="col-12 mb-3">
                                        <label>Ghi chú<span style="color: red;font-size: 14px" id="errorCommand"></span></label>
                                        <textarea name="comment" class="form-control w-100" id="comment" name="comment" cols="30" rows="8" placeholder="Nhập ghi chú về đơn hàng(nếu có)"></textarea>
                                    </div>
                                </div>
                        </div>
                    </div>
                    <div class="col-12 col-lg-4">
                        <div class="cart-summary">
                            <h5>Tổng</h5>
                            <ul class="summary-table">
                                <li><span>Giá sản phẩm</span> <span>${total}₫</span></li>
                                <li><span>Vận chuyển</span> <span>Miễn phí</span></li>
                                <li><span>VAT(10%)</span> <span>${vat}₫</span></li>
                                <li><span>Voucher</span></li>
                                <li><input class="border-success" size="10" type="text" placeholder="Nhập mã giảm giá(nếu có)" style="height: 40px;width: 300px;margin-top: 0px;padding-left: 20px"></li>
                                <li><span>Hình thức thanh toán</span></li>
                                <li>
                                <div class="payment-method">
                                    <!-- Cash on delivery -->
                                    <select name="payments">
                                            <option>
                                            <label class="custom-control-label" for="cod">Thanh toán khi nhận hàng</label>
                                            </option>
                                        <!-- Paypal -->
                                        <option disabled>
                                            <label class="custom-control-label" for="paypal">Thanh toán online</label><img class="ml-15" src="img/core-img/paypal.png" alt="">
                                            </option>
                                    </select>
                                </div>
                                </li>
                                <li><span>Tổng cộng</span> <span>${sum}₫</span></li>
                            </ul>
                            <div class="cart-btn mt-100">
                                <c:if test="${sum != '0'}">
                                    <button id="confirmcheck" type="submit" onsubmit="FormValidate()" class="btn amado-btn w-100">Xác nhận thanh toán</button>
                                </c:if>
                                <c:if test="${sum == '0'}">
                                    <button onclick="window.alert('Vui lòng thêm sản phẩm vào giỏ hàng để thanh toán!');" style="background-color: #2b4a58" class="btn btn-danger amado-btn w-100">Xác nhận thanh toán</button>
                                </c:if>
                            </div>
                        </div>
                    </div>
                    </form>
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
    <script type="text/javascript">
        function FormValidate(){
			var firstname = document.getElementById('first_name').value;
			var errorFirst = document.getElementById('errorFirst');
			var regexName = /^[^\d+]*[\d+]{0}[^\d+]*$/;
                        var regexAddress = /^([a-zA-Z0-9ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\s]+)$/i;
                        
                        var lastname = document.getElementById('last_name').value;
			var errorLast = document.getElementById('errorLast');

			var phone = document.getElementById('phone_number').value;
			var errorPhone = document.getElementById('errorPhone');
			var regexPhone = /[0]{1}[2-9]{1}[0-9]{8}/;

			var email = document.getElementById('email').value;
			var errorEmail = document.getElementById('errorEmail');
			var reGexEmail = /[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,}/;
			
                        var city = document.getElementById('city').value;
			var errorCity = document.getElementById('errorCity');
                        
                        var ward = document.getElementById('ward').value;
			var errorWard = document.getElementById('errorWard');
                        
                        var district = document.getElementById('district').value;
			var errorDistrict = document.getElementById('errorDistrict');
                        
                        var Street = document.getElementById('street_address').value;
			var errorStreet = document.getElementById('errorStreet');
                        //
			if (firstname === '' || firstname === null) {
				errorFirst.innerHTML = "Họ đệm không được để trống!";
                                event.preventDefault();
                                return false;
			}else if(!regexName.test(firstname)){
				errorFirst.innerHTML = "Họ đệm không hợp lệ!";
                                event.preventDefault();
				return false;
			}else{
				errorFirst.innerHTML = '';
			}
                        
                        if (lastname === '' || lastname === null) {
				errorLast.innerHTML = "Tên không được để trống!";
                                event.preventDefault();
                                return false;
			}else if(!regexName.test(lastname)){
				errorLast.innerHTML = "Tên không hợp lệ!";
                                event.preventDefault();
				return false;
			}else{
				errorLast.innerHTML = '';
			}
                        
                        

			if (phone === '' || phone === null) {
				errorPhone.innerHTML = "SĐT không được để trống!";
                                event.preventDefault();
                                return false;
			}else if(!regexPhone.test(phone)){
				errorPhone.innerHTML = "SĐT không hợp lệ!";
                                event.preventDefault();
				return false;
			}else{
				errorPhone.innerHTML = '';
			}

			if (email === '' || email === null) {
				errorEmail.innerHTML = "Email không được để trống!";
                                event.preventDefault();
                                return false;
			}else if(!reGexEmail.test(email)){
				errorEmail.innerHTML = "Email không hợp lệ!";
                                event.preventDefault();
                                return false;
			}else{
				errorEmail.innerHTML = '';
			}
                        if (city === '' || city === null) {
				errorCity.innerHTML = "Tỉnh/thành phố không được để trống!";
                                event.preventDefault();
                                return false;
			}else if(!regexName.test(city)){
				errorCity.innerHTML = "Tỉnh/thành phố không hợp lệ!";
                                event.preventDefault();
				return false;
			}else{
				errorCity.innerHTML = '';
			}
                        
                        if (ward === '' || ward === null) {
				errorWard.innerHTML = "Phường/xã không được để trống!";
                                event.preventDefault();
			}else if(!regexName.test(ward)){
				errorWard.innerHTML = "Phường/xã không hợp lệ!";
                                event.preventDefault();
				return false;
			}else{
				errorWard.innerHTML = '';
			}
                        
                        if (district === '' || district === null) {
				errorDistrict.innerHTML = "Quận/huyện không được để trống!";
                                event.preventDefault();
                                return false;
			}else if(!regexName.test(district)){
				errorDistrict.innerHTML = "Quận/huyện không hợp lệ!";
                                event.preventDefault();
				return false;
			}else{
				errorDistrict.innerHTML = '';
			}
                        
                        if (Street === '' || Street === null) {
				errorStreet.innerHTML = "Số nhà & đường không được để trống!";
                                event.preventDefault();
                                return false;
			}else if(!regexAddress.test(Street)){
				errorStreet.innerHTML = "Số nhà & đường không hợp lệ!";
                                event.preventDefault();
				return false;
			}else{
				errorStreet.innerHTML = '';
			}
                        if((firstname !== '' || firstname !== null) && (lastname !== '' || lastname !== null) &&
                                (phone !== '' || phone !== null) && (email !== '' || email !== null)
                                && (city !== '' || city !== null) && (ward !== '' || ward !== null)
                                && (district !== '' || district !== null) && (Street !== '' || Street !== null)) 
                        {
                            return true;
                        }
                        
		}
    </script>
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
