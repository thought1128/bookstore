<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
<%@ include file="./../../book_nav.jsp"%>
<%@ include file="./memberTop.jsp"%>
<center>
<h1>주문 상세 정보</h1>
<table class="table table-hover mx-auto" style="width: 700px;">
	<tr>
		<td>제목</td>
		<td>분류</td>
		<td>저자</td>
		<td>출판사</td>
		<td>가격</td>
		<td>수량</td>
		<td>적립 포인트</td>	
	</tr>
	<c:forEach items="${list }" var="oproduct">
	<tr>
		<td><a href="detail.pv?isbn=${oproduct.isbn }">${oproduct.title}</a></td>
		<td>${oproduct.classify}</td>
		<td>${oproduct.writer}</td>
		<td>${oproduct.publisher}</td>
		<td>${oproduct.price}</td>
		<td>${oproduct.oqty}</td>
		<td>${oproduct.point}</td>
	</tr>
	
	
	</c:forEach>

</table>
</center>
<%@ include file="./../../footer.jsp"%>