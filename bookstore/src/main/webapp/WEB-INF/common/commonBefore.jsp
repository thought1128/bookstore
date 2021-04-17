<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!-- font -->
<script src="https://kit.fontawesome.com/7bd2081d90.js" crossorigin="anonymous"></script>
<style>
	table, td{
		border : 1px solid black
	} 
	.err{
		font-size: 9pt;
		color: red;
		font-weight: bold;
	}
	
</style>

<script>
	window.onload = function(){
		var error = "${msg}";
		if(error !=''){
			alert(error);
		}	
	}
</script>    

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap');
html,body {
	font-family: 'Noto Sans KR', sans-serif !important;
 	margin: 0;
}
</style>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="view.pv">중앙문고(${sessionScope.loginInfo.id})</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<c:if test="${sessionScope.loginInfo == null }">
						<li class="nav-item">		
							<a class="nav-link active" aria-current="page" href="login.me">로그인</a>
						</li>
					</c:if>
					
					<c:if test="${sessionScope.loginInfo != null }">
						<li class="nav-item">
							<a class="nav-link active" aria-current="page" href="login.me">회원정보(${sessionScope.loginInfo.id})</a>
						</li>
						<li class="nav-item">								
							<a class="nav-link active" aria-current="page" href="logout.me">로그아웃</a>
						</li>
					</c:if>					
					<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="list.br">QNA게시판</a>
					</li>
					<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="view.pv">상품목록</a>
					</li>
					<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="list.mall">장바구니</a>
					</li>
<%-- 					<c:forEach var="classify" items="${classifyList}">
						<li class="nav-item">
							<a class="nav-link active" aria-current="page" href="#">${classify.classify}</a>
						</li>
					</c:forEach>			
 --%>					
				</ul>
				<form class="d-flex">
					<input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>