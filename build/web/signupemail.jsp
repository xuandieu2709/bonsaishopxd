<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Đăng Ký</title>
      <link rel="stylesheet" href="css/login.css">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="icon" href="img/core-img/logoweb.ico">
   </head>
   <body>
      <div class="wrapper">
         <div class="title-text">
            <div class="title signup">
                <p><h2>Đăng Ký</h2></p>
            </div>
         </div>
            <div class="form-inner">
                <form action="signupemailControl" class="login" method="POST">
                  <div class="field">
                      <h4 class="text-danger">${message}</h4>
                  </div>
                  <div class="field">
                       <h4 style="margin: 0px 10px">Email</h4>
                       <input pattern="[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,}" name="user" value="${user}" type="text" size="50" maxlength="50" placeholder="Nhập Email của bạn" required>
                  <br>
                  </div> <br>
                  <div class="field">
                      <h4 style="margin: 0px 10px">Mật khẩu(<i style="color: #f60209">Bao gồm 8 ký tự</i>)</h4>
                      <input name="pass" value="${pass}" type="password" size="8" maxlength="8" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$" placeholder="Ít nhất một chữ hoa, chữ thường, ký tự đặc biệt và số" required>
                  <br>
                  </div> <br>
                  <div class="field">
                      <h4 style="margin: 0px 10px">Xác nhận mật khẩu(<i style="color: #f60209">Bao gồm 8 ký tự</i>)</h4>
                      <input  name="repass" value="${repass}" type="password" size="8" maxlength="8" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$" placeholder="Ít nhất một chữ hoa, chữ thường, ký tự đặc biệt và số" required="">
                  <br>
                  </div> <br>
                  <div style="margin-top: 10px">
                      <a href="signup.jsp" style="color: #63a185">Đăng ký bằng số điện thoại</a>
                  </div>
                  <div class="field btn">
                     <div class="btn-layer"></div>
                     <a href="signupemailControl"><input type="submit" value="Đăng ký" ></a>
                  </div>
                  <div class="signup-link">
                  <a href="login.jsp"><h4>Quay lại</h4></a>
                  </div>
               </form>
            </div>
         </div>
      </div>
      <script src="js/loginsignin.js"></script>
   </body>
</html>