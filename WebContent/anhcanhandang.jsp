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
	     <h2 style="font-weight: 600; color: red;">Ảnh đã đăng</h2>
	  </div>
	    
		
      <tr>
      	<th>STT</th>
      	
      	<th>Tiêu đề</th>
      	<th>Lượt like</th>
      	<th>Lượt comment</th>
      	<th>Ảnh</th>

      	<th>Ghi chú</th>
      </tr>
	<c:if test="${dsanh != null }">
		<c:set var = "count" value = "1"/>
		<c:forEach var="h" items="${dsanh}" >
		
		
			<tr>
			  <td> ${count}</td>	
			  <c:set var = "count" value = '${count+1}'/>
			  
			 
			  <td> ${h.getTieuDe()}</td>
			  <td> ${h.getLuotLike()}</td>
			  <td> ${h.getLuotComment()}</td>
			  <td> <img alt="" src="${h.getAnh()}" style="width: 200px"></td>

			  <td> ${h.getGhiChu()}</td>
			  <td>
			  	  <form id='${h.getMaAnhChe()}+"form"' action="commentController">
			  	  	<button type="submit" name="idanh" value='${h.getMaAnhChe()}' form='${h.getMaAnhChe()}+"form"'>Xem chi tiết ảnh</button>
			  	  </form>
		  	  </td>
		  	  <td>
			  	  <form  action="anhcanhandangController">
			  	  	<button type="submit" name="xoaanh" value='${h.getMaAnhChe()}'>Xoá</button>
			  	  </form>
		  	  <td>
		  	  
		   	</tr>
		</c:forEach>
	</c:if>
	</table>
</body>
</html>