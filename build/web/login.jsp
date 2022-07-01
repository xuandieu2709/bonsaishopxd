<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Đăng nhập</title>
      <link rel="stylesheet" href="css/login.css">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="icon" href="img/core-img/logoweb.ico">
   </head>
   <body>
      <div class="wrapper">
         <div class="title-text">
            <div class="title login">
                <p><h2>Đăng Nhập</h2></p>
            </div>
         </div>
            <div class="form-inner">
                <form action="loginControl" class="login" method="Post">
                  <div class="field">
                      <h4 class="text-danger">${message}</h4>
                  </div>
                  <div class="field">
                      <h4 style="margin: 0px 10px">Tài khoản</h4>
                      <input name="username" value="${username}" type="text" size="50" maxlength="50" placeholder="Email hoặc số điện thoại" required>
                  <br>
                  </div> <br>
                  <div class="field"> 
                      <h4 style="margin: 0px 10px">Mật khẩu</h4>
                      <input name="password" value="${password}" type="password" size="8" maxlength="8" placeholder="********" required>
                  <br>
                  </div>
                  <br>
                  <div class="pass-link" style="margin-top: 30px">
                     <a href="mess.jsp">Quên mật khẩu?</a>
                  </div>
                  <div class="field btn">
                     <div class="btn-layer"></div>
                     <a href="loginControl"><input id="btnlogin" type="submit" value="Đăng nhập"></a>
                  </div>
                  <div class="signup-link">
                      Chưa có tài khoản? <a href="signup.jsp">Đăng ký ngay</a>
                  </div>
                  <div class="signup-link" >
                      <a href="homeControl"><h4>Quay lại</h4></a>
                  </div>
               </form>
            </div>
         </div>
      </div>
      <script src="js/loginsignin.js"></script>
   </body>
</html>