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
<%@ include file="./../admin/adminTop.jsp"%>

		
			<h1 align="center">멤버 리스트</h1>
		
	<form action="memberList.me" method="post">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-1">
				<select name="whatColumn" class="form-select" style="width: 80px">
					<option value="all">전체 검색
					<option value="id">아이디
					<option value="name">이름
				</select>
			</div>
			<div class="col-md-2">
				<input type="text" name="keyword" class="form-control">
			</div>
			<div class="col-md-1">
				<input type="submit" value="검색" class="btn btn-primary">
			</div>
		</div>


	</form>
	<table class="table table-hover table-bordered mx-auto" style="width: 1100px;">
		<tr>
			<th><span>멤버 번호</span></th>
			<th><span>ID</span></th>
			<th><span>이름</span></th>
			<th><span>전화번호</span></th>
			<th><span>이메일 주소</span></th>
			<th><span>주소</span></th>
			<th><span>포인트</span></th>
		</tr>
		<c:forEach items="${memberLists }" var="member">
			<tr>
				<th>${member.memberNum }</th>
				<th><a href="detail.me?memberNum=${member.memberNum }">${member.id }</a>
					<!-- detail.me=> MemberDetailViewController --></th>
				<th>${member.name }</th>
				<th>${member.phoneNum }</th>
				<th>${member.email }</th>
				<th>${member.address }</th>
				<th>${member.point }</th>

			</tr>
		</c:forEach>
	</table>


<center>
	 ${pageInfo.pagingHtml }
</center>
<%@ include file="./../../footer.jsp"%>