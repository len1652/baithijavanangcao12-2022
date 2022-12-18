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
<%@include file="headerAdmin.jsp" %>
 <table class="table table-hover">

	
	
	
	  <div style="TEXT-ALIGN: center;">
	     <h2 style="font-weight: 600; color: red;">Quản lý tài khoản</h2>
	  </div>
	    
	
      <tr>
      	<th>STT</th>
      	<th>Tên đăng nhập</th>
      	<th>Mật khẩu</th>
      	<th>Tên khách hàng</th>
      	<th>Email</th>
      	<th>Số điện thoại</th>
      	
      </tr>
	<c:if test="${dskh != null }">
		<c:set var = "count" value = "1"/>
		<c:forEach var="h" items="${dskh}" >
			<tr>
			  <td> ${count}</td>	
			  <c:set var = "count" value = '${count+1}'/>
			  
			  <td> ${h.getMaKhachHang()}</td>
			  <td> ${h.getPass()}</td>
			  <td> ${h.getTenKhachHang()}</td>
			  <td> ${h.getEmail()}</td>
			  
			  <td> ${h.getSdt()}</td>
			  
		  	  
		  	  
		  	  <td>
			  	  <form  action="quanlytaikhoanController">
			  	  	<button type="submit" name="xoa" value='${h.getMaKhachHang()}'>Xoá</button>
			  	  </form>
		  	  <td>
		   	</tr>
		</c:forEach>
	</c:if>
	</table>
</body>
</html>