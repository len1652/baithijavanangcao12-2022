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
	     <h2 style="font-weight: 600; color: red;">Duyệt ảnh</h2>
	  </div>
	    
	
      <tr>
      	<th>STT</th>
      	
      	<th>Tiêu đề</th>
      	<th>Ảnh</th>
      	<th>Mã khách hàng</th>
      	<th>Ghi chú</th>
      </tr>
	<c:if test="${dss != null }">
		<c:set var = "count" value = "1"/>
		<c:forEach var="h" items="${dss}" >
			<tr>
			  <td> ${count}</td>	
			  <c:set var = "count" value = '${count+1}'/>
			  
			  
			  <td> ${h.getTieuDe()}</td>
			  <td> <img alt="" src="${h.getAnh()}" style="width: 400px"></td>
			  <td> ${h.getMaKhachHang()}</td>
			  <td> ${h.getGhiChu()}</td>
			  
		  	  <td>
			  	  <form id='${h.getMaAnhChe()}+"form"' action="duyetanhController">
			  	  	<button type="submit" name="duyet" value='${h.getMaAnhChe()}' form='${h.getMaAnhChe()}+"form"'>Duyệt</button>
			  	  </form>
		  	  <td>
		  	  
		  	  <td>
			  	  <form id='${h.getMaAnhChe()}+"form"' action="duyetanhController">
			  	  	<button type="submit" name="xoa" value='${h.getMaAnhChe()}' form='${h.getMaAnhChe()}+"form"'>Xoá</button>
			  	  </form>
		  	  <td>
		   	</tr>
		</c:forEach>
	</c:if>
	</table>
</body>
</html>