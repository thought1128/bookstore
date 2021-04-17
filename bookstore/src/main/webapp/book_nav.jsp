<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/common/common.jsp"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<i class="fas fa-book"></i>&nbsp;<a class="navbar-brand" href="<%=request.getContextPath()+"/main.pv"%>">중앙문고</a>
		<button class="navbar-toggler" type="button"
			data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
					<a class="nav-link active" aria-current="page" href="view.pv">책 목록</a>
				</li>				
				<li class="nav-item">
					<a class="nav-link active" aria-current="page" href="list.br">QNA게시판</a>
				</li>
				<li class="nav-item">
					<a class="nav-link active" aria-current="page" href="list.mall">장바구니</a>
				</li>					
			</ul>
			<form class="d-flex me-auto" style="margin-top: 1.25rem;" method="get" action="search.pv">
				<select name="whatColumn">
					<option value="">전체</option>
					<option value="title">제목</option>
					<option value="writer">저자</option>
					<option value="publisher">출판사</option>
					<option value="classify">분류</option>
				</select>
				<input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="search">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
			<c:if test="${sessionScope.loginInfo == null }">
				<!-- <form class="d-flex" style="margin-top: 1.25rem;" method="post" action="login.me">
					<input class="form-control me-2" type="text" placeholder="id" aria-label="id" name="id">
					<input class="form-control me-2" type="password" placeholder="password" aria-label="password" name="password">
					<button class="btn btn-outline-success" type="submit">LogIn</button>
				</form> -->
				<a href="login.me" class="btn btn-outline-success">로그인</a>
				<a href="join.me" class="btn btn-outline-success">회원가입</a>
			</c:if>
			<c:if test="${sessionScope.loginInfo != null }">
				<a class="nav-link active" aria-current="page" href="login.me">반갑습니다! ${sessionScope.loginInfo.id}님</a>
				<button class="btn btn-outline-success" type="button" onclick="location.href='logout.me'">LogOut</button>
			</c:if>	
		</div>
	</div>
</nav>