<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<%@include file="headerNguoiDung.jsp" %>
<div style="TEXT-ALIGN: center;">
	     <h2 style="font-weight: 600;color: red;">Sửa thông tin cho tài khoản: ${tk.getMaKhachHang() }</h2>
	  </div>
	    
   <div style="width: 600px;    margin: auto; margin-bottom: 100px;">
   	<form method="post" action="suathongtinController">
	    
	    <div class="mb-3">
	      <label for="pwd">Mật khẩu <label style="color: red;">*</label>:</label> 
	      <input type="password" class="form-control"  placeholder="" name="txtmatkhau" value="${tk.getPass()}">
	    </div>
	    <div class="mb-3 mt-3">
	      <label for="email">Tên người dùng           :</label> 
	      <input type="text" class="form-control"  placeholder="" name="txttennguoidung" value="${tk.getTenKhachHang()}">
	    </div>
	    <div class="mb-3">
	      <label for="pwd">Email:</label>
	      <input type="email" class="form-control"  placeholder="" name="txtemail" value="${tk.getEmail()}">
	    </div>
	    <div class="mb-3">
	      <label for="pwd">Số điện thoại:</label>
	      <input type="text" class="form-control"  placeholder="" name="txtsodienthoai" value="${tk.getSdt()}">
	    </div>
	    
	    
	    
	    <button type="submit" class="btn btn-success" style="margin-top: 10px;
	    float: right;">Sửa</button>
  </form>
  		<c:if test = "${TB == 1}">
	         	<h4 style="color: red;"> Tài khoản đã tồn tại</h4>
	    </c:if>
	    <c:if test = "${TB == 2}">
	         	<h4 style="color: red;">Thông tin chưa được điền đủ</h4>
	    </c:if>
   </div>
</body>
<script
      src="https://code.jquery.com/jquery-3.6.0.min.js"
      integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
      crossorigin="anonymous"
    ></script>
<script>
      var selDiv = "";
      var storedFiles = [];
      $(document).ready(function () {
        $("#img").on("change", handleFileSelect);
        selDiv = $("#selectedBanner");
      });

      function handleFileSelect(e) {
        var files = e.target.files;
        var filesArr = Array.prototype.slice.call(files);
        filesArr.forEach(function (f) {
          if (!f.type.match("image.*")) {
            return;
          }
          storedFiles.push(f);

          var reader = new FileReader();
          reader.onload = function (e) {
            var html =
              '<img src="' +
              e.target.result +
              "\" data-file='" +
              f.name +
              "alt='Category Image' height='200px'>";
            selDiv.html(html);
          };
          reader.readAsDataURL(f);
        });
      }
    </script>
</html>