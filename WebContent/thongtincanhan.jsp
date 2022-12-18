<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous" />
    <title>Document</title></head>
<body>
<%@include file="headerNguoiDung.jsp" %>
 <table class="table table-hover">

	
	
	
	  <div style="TEXT-ALIGN: center;">
	     <h2 style="font-weight: 600; color: red;">Thông tin cá nhân của tài khoản</h2>
	  </div>
	    
		<tr>
				<form  action="suathongtinController">
					<button >Chỉnh sửa thông tin</button>
			 	</form>
		</tr>
	    <tr>
	      		<th>Tên đăng nhập</th>
	      	
	      		<th>${tk.getMaKhachHang()}</th>
	      	
	    </tr>
		<tr>
	      		<th>Tên người dùng</th>
	      	
	      		<th>${tk.getTenKhachHang()}</th>
	      	
	    </tr>
	    <tr>
	      		<th>Email</th>
	      	
	      		<th>${tk.getEmail()}</th>
	      	
	    </tr>
	    <tr>
	      		<th>Số điện thoại</th>
	      	
	      		<th>${tk.getSdt()}</th>
	      	
	    </tr>
	</table>
</body>
</html>