<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../../book_nav.jsp"%>
<title>index.jsp</title>

	<!-- Carousel -->
	<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
  		<div class="carousel-indicators">
    		<button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    		<button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    		<button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
  		</div>
 		<div class="carousel-inner">
    		<div class="carousel-item active" style="max-height: 450px;">
      		<img src="resources/main/img/main_home03.png" class="d-block w-100" alt="" style="background-size: center/cover no-repeat;">
      			<div class="carousel-caption d-none d-md-block">
        			<h5>중앙문고</h5>
        			<p>환영합니다</p>
      			</div>
    		</div>
    		<div class="carousel-item" style="max-height: 450px;">
				<img src="resources/main/img/main_home02.png" class="d-block w-100" alt="">
      			<div class="carousel-caption d-none d-md-block">
        			<h5>중앙문고</h5>
        			<p>환영합니다</p>
      			</div>
   	 		</div>
    		<div class="carousel-item" style="max-height: 450px;">
      			<img src="resources/main/img/main_home01.png" class="d-block w-100" alt="">
     			<div class="carousel-caption d-none d-md-block">
       				<h5>중앙문고</h5>
        			<p>환영합니다</p>
	      		</div>
    		</div>
  		</div>
 		<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    		<span class="carousel-control-prev-icon" aria-hidden="true"></span>
    		<span class="visually-hidden">Previous</span>
  		</button>
  		<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    		<span class="carousel-control-next-icon" aria-hidden="true"></span>
    		<span class="visually-hidden">Next</span>
  		</button>
	</div>
	
	<!-- product-->
	<%@ include file="product_list.jsp"%>

	<!-- footer -->
	<%@ include file="./../../footer.jsp"%>