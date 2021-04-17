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



<%@ include file="./../../book_nav.jsp"%>
<%@ include file="./memberTop.jsp"%>
<h1 align="center">회원 탈퇴</h1>
<form action="deleteMember.me" method="post">
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-2">
			<input type="password" name="password" class="form-control" placeholder="비밀번호를 입력해 주세요">
		</div>
	</div>
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-1">
			<input type="submit" value="탈퇴" class="btn btn-primary">
		</div>
	</div>
	
</form>
<%@ include file="./../../footer.jsp"%>