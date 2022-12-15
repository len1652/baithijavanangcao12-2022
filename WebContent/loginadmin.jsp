<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      rel="stylesheet"
      id="bootstrap-css" />
    <link rel="stylesheet" type="text/css" href="login.css" />
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <title>Document</title>
</head>
<body>
	<div class="sidenav">
      <div class="login-main-text">
        <h2>
          Phuc Blogs<br />
          Login Page
        </h2>
        <p>Login or register from here to access.</p>
      </div>
    </div>
    <div class="main">
      <div class="col-md-6 col-sm-12">
        <div class="login-form">
          <form action="loginadminController?kt=1" method="post">
    	
							<h3 style="text-align:center">ĐĂNG NHẬP</h3>
              
			                <input  class="form-control"  name="txtun" type="text" value=""  placeholder="Tài khoản"> <br>
			                
							<input  class="form-control"  name="txtpass" type="text" value=""  placeholder="Mật khẩu"> <br>
							<c:if test = "${ktra ==1}">
						         	<h4 style="color: red;"> tài khoản hoặc mật khẩu sai</h4>
						    </c:if>
							
				  			<input class="btn btn-primary"  name="butdn" type="submit" value="Đăng nhập">  
				  			
                       			                       
					</form>
          
        </div>
      </div>
    </div>
</body>
</html>