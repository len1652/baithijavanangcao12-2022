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
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container">
        <a class="navbar-brand" href="anhcheController">Phuc Blogs</a>
        <a class="navbar-brand" href="cheanhController">Đăng ảnh</a>
        <a class="navbar-brand" href="xephanganhController">Bảng xếp hạng ảnh</a>
        <a class="navbar-brand" href="thongtincanhanController">Thông tin cá nhân</a>
        <a class="navbar-brand" href="anhcanhandangController">Ảnh cá nhân đã đăng</a>
        <div class="d-flex justify-content-end">
        <c:if test="${tkhoan==null}">
        	<a class="navbar-brand" href="loginController">Login</a>
        </c:if>
          <c:if test="${tkhoan!=null}">
        	<a class="navbar-brand" href="logoutController">Logout</a>
        </c:if>
        </div>
      </div>
    </nav>
    <div class="container mt-4">
      <h1>Welcome To <span class="badge badge-secondary">Phuc Blogs</span></h1>
    </div>
    <div class="container mt-4">
      <div class="row">
        <div class="col-8">
          <%--1 thẻ --%>
          <div >
          	
            <div class="col-12 mb-3">
              <div class="card" style="width: 70%">
                <img
                  class="card-img-top"
                  src="${l.getAnh() }"
                  alt="Card image cap" />
                <div class="card-body flex-md-row">
                  <h5 class="card-title">"${l.getTieuDe()}"</h5>
                  <p class="card-text">
                    ${l.getGhiChu()}
                  </p>
                  <p
                    class="card-text"
                    style="display: flex; flex-direction: row">
                    <a href="likeController?like=${l.getMaAnhChe()}" class="btn btn-secondary" >
                    <c:set var = "count" value = "1"/>
                    <c:forEach var="a" items="${dsanhdalike}">
                    	<c:if test="${a.equals(l.getMaAnhChe())}">
                    		<c:set var = "count" value = '${count+1}'/>
                    		<svg
		                        xmlns="http://www.w3.org/2000/svg"
		                        viewBox="0 0 16 16"
		                        width="16"
		                        background-color="white"
		                        height="16">
		                        <path
		                          fill-rule="evenodd"
		                          d="M8.834.066C7.494-.087 6.5 1.048 6.5 2.25v.5c0 1.329-.647 2.124-1.318 2.614-.328.24-.66.403-.918.508A1.75 1.75 0 002.75 5h-1A1.75 1.75 0 000 6.75v7.5C0 15.216.784 16 1.75 16h1a1.75 1.75 0 001.662-1.201c.525.075 1.067.229 1.725.415.152.043.31.088.475.133 1.154.32 2.54.653 4.388.653 1.706 0 2.97-.153 3.722-1.14.353-.463.537-1.042.668-1.672.118-.56.208-1.243.313-2.033l.04-.306c.25-1.869.265-3.318-.188-4.316a2.418 2.418 0 00-1.137-1.2C13.924 5.085 13.353 5 12.75 5h-1.422l.015-.113c.07-.518.157-1.17.157-1.637 0-.922-.151-1.719-.656-2.3-.51-.589-1.247-.797-2.01-.884zM4.5 13.3c.705.088 1.39.284 2.072.478l.441.125c1.096.305 2.334.598 3.987.598 1.794 0 2.28-.223 2.528-.549.147-.193.276-.505.394-1.07.105-.502.188-1.124.295-1.93l.04-.3c.25-1.882.189-2.933-.068-3.497a.922.922 0 00-.442-.48c-.208-.104-.52-.174-.997-.174H11c-.686 0-1.295-.577-1.206-1.336.023-.192.05-.39.076-.586.065-.488.13-.97.13-1.328 0-.809-.144-1.15-.288-1.316-.137-.158-.402-.304-1.048-.378C8.357 1.521 8 1.793 8 2.25v.5c0 1.922-.978 3.128-1.933 3.825a5.861 5.861 0 01-1.567.81V13.3zM2.75 6.5a.25.25 0 01.25.25v7.5a.25.25 0 01-.25.25h-1a.25.25 0 01-.25-.25v-7.5a.25.25 0 01.25-.25h1z"></path>
		                      </svg>
		                       Đã like ${l.getLuotLike()}
                    	</c:if>
                    </c:forEach>
                    	<c:if test="${count==1}">
                    		<svg
		                        xmlns="http://www.w3.org/2000/svg"
		                        viewBox="0 0 16 16"
		                        width="16"
		                        background-color="white"
		                        height="16">
		                        <path
		                          fill-rule="evenodd"
		                          d="M8.834.066C7.494-.087 6.5 1.048 6.5 2.25v.5c0 1.329-.647 2.124-1.318 2.614-.328.24-.66.403-.918.508A1.75 1.75 0 002.75 5h-1A1.75 1.75 0 000 6.75v7.5C0 15.216.784 16 1.75 16h1a1.75 1.75 0 001.662-1.201c.525.075 1.067.229 1.725.415.152.043.31.088.475.133 1.154.32 2.54.653 4.388.653 1.706 0 2.97-.153 3.722-1.14.353-.463.537-1.042.668-1.672.118-.56.208-1.243.313-2.033l.04-.306c.25-1.869.265-3.318-.188-4.316a2.418 2.418 0 00-1.137-1.2C13.924 5.085 13.353 5 12.75 5h-1.422l.015-.113c.07-.518.157-1.17.157-1.637 0-.922-.151-1.719-.656-2.3-.51-.589-1.247-.797-2.01-.884zM4.5 13.3c.705.088 1.39.284 2.072.478l.441.125c1.096.305 2.334.598 3.987.598 1.794 0 2.28-.223 2.528-.549.147-.193.276-.505.394-1.07.105-.502.188-1.124.295-1.93l.04-.3c.25-1.882.189-2.933-.068-3.497a.922.922 0 00-.442-.48c-.208-.104-.52-.174-.997-.174H11c-.686 0-1.295-.577-1.206-1.336.023-.192.05-.39.076-.586.065-.488.13-.97.13-1.328 0-.809-.144-1.15-.288-1.316-.137-.158-.402-.304-1.048-.378C8.357 1.521 8 1.793 8 2.25v.5c0 1.922-.978 3.128-1.933 3.825a5.861 5.861 0 01-1.567.81V13.3zM2.75 6.5a.25.25 0 01.25.25v7.5a.25.25 0 01-.25.25h-1a.25.25 0 01-.25-.25v-7.5a.25.25 0 01.25-.25h1z"></path>
		                      </svg>
		                       like ${l.getLuotLike()}
                    	</c:if>
                      
                    </a>
                    
                   
                  </p>
                </div>
              </div>
              <div> </div>
            </div>
            <form method="post" action="commentController?idanh=${l.getMaAnhChe()}">
			    <div class="mb-3">
			      <label for="pwd">Viết bình luận </label>
			      <input type="text" class="form-control"  placeholder="" name="txtbinhluan">
				      <button type="submit" class="btn btn-success" style="margin-top: 10px;
				    float: right;">Gửi</button>
			    </div>
			    
			    
			    
		  </form>
            <c:forEach var="b" items="${dscomment}">
            	
            	
		            <div id="main" class="style-scope ytd-comment-renderer">
		            	_______________________________________________________________________________<br>
		        		<h4>${b.getTenKhachHang() }: </h4>  ${ b.getBinhLuan()}
			        	<c:if test="${b.getMaKhachHang().equals(tk.getMaKhachHang()) }">
			        	
			        			<form  method="post" action="commentController?idanh=${l.getMaAnhChe()}&xoacom=${b.getCommentId()}">
							  	  	<button type="submit"  style="margin-top: 10px;
				    					">Xoá bình luận</button>
							  	</form>
			        		
			        	</c:if>
		        		
		            
		            </div>
	          
	            
            </c:forEach>
            <div><br><br><br><br><br></div>
            <div></div>
            
          </div>
        </div>
        <div class="col-4">
          <div class="row">
            <div class="col-12">
              <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="#">Chủ đề</a></li>
                  <li class="breadcrumb-item active" aria-current="page">
                    Tin học
                  </li>
                  <li class="breadcrumb-item active" aria-current="page">
                    Tin học Văn Phòng
                  </li>
                </ol>
              </nav>
            </div>
          </div>
          <div class="row">
            <div class="col-12 mb-2">
              <div
                id="carouselExampleIndicators"
                class="carousel slide"
                data-ride="carousel">
                <ol class="carousel-indicators">
                  <li
                    data-target="#carouselExampleIndicators"
                    data-slide-to="0"
                    class="active"></li>
                  <li
                    data-target="#carouselExampleIndicators"
                    data-slide-to="1"></li>
                  <li
                    data-target="#carouselExampleIndicators"
                    data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                  <div class="carousel-item active">
                    <img
                      class="d-block w-100"
                      src="https://source.unsplash.com/random/1600x900"
                      alt="First slide" />
                    <div class="carousel-caption d-none d-md-block">
                      <h5 class="text-auto">
                        carousel-caption d-none d-md-block
                      </h5>
                      <p>...</p>
                    </div>
                  </div>
                  <div class="carousel-item">
                    <img
                      class="d-block w-100"
                      src="https://source.unsplash.com/random/1600x900"
                      alt="Second slide" />
                    <div class="carousel-caption d-none d-md-block">
                      <h5 class="text-auto">
                        carousel-caption d-none d-md-block
                      </h5>
                      <p>...</p>
                    </div>
                  </div>
                  <div class="carousel-item">
                    <img
                      class="d-block w-100"
                      src="https://source.unsplash.com/random/1600x900"
                      alt="Third slide" />
                    <div class="carousel-caption d-none d-md-block">
                      <h5 class="text-auto">
                        carousel-caption d-none d-md-block
                      </h5>
                      <p>...</p>
                    </div>
                  </div>
                </div>
                <a
                  class="carousel-control-prev"
                  href="#carouselExampleIndicators"
                  role="button"
                  data-slide="prev">
                  <span
                    class="carousel-control-prev-icon"
                    aria-hidden="true"></span>
                  <span class="sr-only">Previous</span>
                </a>
                <a
                  class="carousel-control-next"
                  href="#carouselExampleIndicators"
                  role="button"
                  data-slide="next">
                  <span
                    class="carousel-control-next-icon"
                    aria-hidden="true"></span>
                  <span class="sr-only">Next</span>
                </a>
              </div>
            </div>
            <div class="col-12 mb-2">
              <div
                id="carouselExampleIndicators"
                class="carousel slide"
                data-ride="carousel">
                <ol class="carousel-indicators">
                  <li
                    data-target="#carouselExampleIndicators"
                    data-slide-to="0"
                    class="active"></li>
                  <li
                    data-target="#carouselExampleIndicators"
                    data-slide-to="1"></li>
                  <li
                    data-target="#carouselExampleIndicators"
                    data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                  <div class="carousel-item active">
                    <img
                      class="d-block w-100"
                      src="https://source.unsplash.com/random/1600x900"
                      alt="First slide" />
                    <div class="carousel-caption d-none d-md-block">
                      <h5 class="text-auto">
                        carousel-caption d-none d-md-block
                      </h5>
                      <p>...</p>
                    </div>
                  </div>
                  <div class="carousel-item">
                    <img
                      class="d-block w-100"
                      src="https://source.unsplash.com/random/1600x900"
                      alt="Second slide" />
                    <div class="carousel-caption d-none d-md-block">
                      <h5 class="text-auto">
                        carousel-caption d-none d-md-block
                      </h5>
                      <p>...</p>
                    </div>
                  </div>
                  <div class="carousel-item">
                    <img
                      class="d-block w-100"
                      src="https://source.unsplash.com/random/1600x900"
                      alt="Third slide" />
                    <div class="carousel-caption d-none d-md-block">
                      <h5 class="text-auto">
                        carousel-caption d-none d-md-block
                      </h5>
                      <p>...</p>
                    </div>
                  </div>
                </div>
                <a
                  class="carousel-control-prev"
                  href="#carouselExampleIndicators"
                  role="button"
                  data-slide="prev">
                  <span
                    class="carousel-control-prev-icon"
                    aria-hidden="true"></span>
                  <span class="sr-only">Previous</span>
                </a>
                <a
                  class="carousel-control-next"
                  href="#carouselExampleIndicators"
                  role="button"
                  data-slide="next">
                  <span
                    class="carousel-control-next-icon"
                    aria-hidden="true"></span>
                  <span class="sr-only">Next</span>
                </a>
              </div>
            </div>
            <div class="col-12">
              <div
                id="carouselExampleIndicators"
                class="carousel slide"
                data-ride="carousel">
                <ol class="carousel-indicators">
                  <li
                    data-target="#carouselExampleIndicators"
                    data-slide-to="0"
                    class="active"></li>
                  <li
                    data-target="#carouselExampleIndicators"
                    data-slide-to="1"></li>
                  <li
                    data-target="#carouselExampleIndicators"
                    data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                  <div class="carousel-item active">
                    <img
                      class="d-block w-100"
                      src="https://source.unsplash.com/random/1600x900"
                      alt="First slide" />
                  </div>
                  <div class="carousel-item">
                    <img
                      class="d-block w-100"
                      src="https://source.unsplash.com/random/1600x900"
                      alt="Second slide" />
                    <div class="carousel-caption d-none d-md-block">
                      <h5 class="text-auto">
                        carousel-caption d-none d-md-block
                      </h5>
                      <p>...</p>
                    </div>
                  </div>
                  <div class="carousel-item">
                    <img
                      class="d-block w-100"
                      src="https://source.unsplash.com/random/1600x900"
                      alt="Third slide" />
                    <div class="carousel-caption d-none d-md-block">
                      <h5 class="text-auto">
                        carousel-caption d-none d-md-block
                      </h5>
                      <p>...</p>
                    </div>
                  </div>
                </div>
                <a
                  class="carousel-control-prev"
                  href="#carouselExampleIndicators"
                  role="button"
                  data-slide="prev">
                  <span
                    class="carousel-control-prev-icon"
                    aria-hidden="true"></span>
                  <span class="sr-only">Previous</span>
                </a>
                <a
                  class="carousel-control-next"
                  href="#carouselExampleIndicators"
                  role="button"
                  data-slide="next">
                  <span
                    class="carousel-control-next-icon"
                    aria-hidden="true"></span>
                  <span class="sr-only">Next</span>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <script
      src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
      integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
      crossorigin="anonymous"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
      integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
      crossorigin="anonymous"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
      integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
      crossorigin="anonymous"></script>
</body>
</html>