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
                    
                    
                   
                  </p>
                </div>
              </div>
              <div> </div>
            </div>
            
            <c:forEach var="b" items="${dscomment}">
            	
            	
		            <div id="main" class="style-scope ytd-comment-renderer">
		            	_______________________________________________________________________________<br>
		        		<h4>${b.getTenKhachHang() }: </h4>  ${ b.getBinhLuan()}
			        	
			        	
			        			<form  method="post" action="chitietanhadminController?idanh=${l.getMaAnhChe()}&xoacom=${b.getCommentId()}">
							  	  	<button type="submit"  style="margin-top: 10px;
				    					">Xoá bình luận</button>
							  	</form>
			        		
			        	
		        		
		            
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