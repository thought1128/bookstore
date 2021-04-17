<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" href="resources/product/css/product.css"/>
<!-- <script src="resources/product/js/product.js" defer="defer"></script> -->
<!-- productbar -->
<p>
<div class="product__bar">
	<ul class="nav justify-content-center">
		<li class="nav-item">
    		<button class="nav-link btn" onclick="location.href='${currenturi}'" style="font-size: 1.2rem;">전체</button>
  		</li>
		<c:forEach var="classify" items="${classifyList}">
			<li class="nav-item">
				<button type="button" class="nav-link btn" style="font-size: 1.2rem;" onclick="location.href='?whatColumn=classify&keyword=${classify.classify}'">${classify.classify}</button>
  			</li>
		</c:forEach>
	</ul>
</div>
<p>
<!-- product -->
<div class="product__container">
	<div class="row row-cols-1 row-cols-md-2 g-4 d-flex justify-content-center">
	<c:forEach var="product" items="${list}">
		<c:if test="${fn:contains(product.promotions,'T')}">
			<div class="card" style="width: 18rem;">
				<img src="resources/book_images/${product.image}" class="card-img-top" alt="${product.title}">
				<div class="card-body">
					<h5 class="card-title"><a href="detail.pv?isbn=${product.isbn}">${product.title}</a></h5>
					<fmt:parseDate var="parseDate" value="${product.publishedDate}" pattern = "yyyy-MM-dd"/>
					<fmt:formatDate var="fmtDate" value="${parseDate}" pattern = "yyyy-MM-dd"/>
					<p class="card-text">${product.writer}<br>${product.publisher}<br>${fmtDate}</p>
				</div>
			</div>
		</c:if>
	</c:forEach>
	</div>
</div>
<center>${pageInfo.pagingHtml}</center>