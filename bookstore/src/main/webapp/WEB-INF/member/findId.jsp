<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<!-- Bootstrap JS -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap"
	rel="stylesheet">

<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<%@ include file="./../../book_nav.jsp"%>
<h2 align="center"><a href="findId.me" style="color: black; text-decoration: none;">아이디찾기</a>|<a href="findPassword.me" style="color: black; text-decoration: none;">비밀번호 찾기</a></h2>
<form action="findId.me" method="post">
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-2">
			이름 <input type="text" name="name" class="form-control">

		</div>
	</div>
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-2">
			이메일 주소 <input type="email" name="email" class="form-control">


		</div>
	</div><br>
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-2">
			<input type="submit" value="아이디 찾기" class="btn btn-primary">
		</div>
	</div>

</form>

|


<%@ include file="./../../footer.jsp"%>
