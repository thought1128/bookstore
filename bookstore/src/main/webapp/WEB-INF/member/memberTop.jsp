<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<nav class="navbar  navbar-expand navbar-light"
	style="background-color: #e3f2fd;">
	<div align="center" class="collapse navbar-collapse"
		id="navbarNavAltMarkup">
		<div class="navbar-nav">
			<a class="nav-link active" href="main.pv">사용자홈</a>
			<!-- 사용자홈으로-->
			<a class="nav-link active" href="myPage.me">마이페이지</a>
			<a class="nav-link active" href="updateMemberInfo.me">회원정보 수정</a>
			<a class="nav-link active" href="deleteMember.me">회원탈퇴</a>
			<a class="nav-link active" href="cancelOrderList.me">취소/반품/교환/환불 내역</a>
			<a class="nav-link active" href="list.br?whatColumn=name&keyword=${sessionScope.loginInfo.name }">내가 쓴 글</a>
			<a class="nav-link active" href="list.rv?whatColumn=memberNum&keyword=${sessionScope.loginInfo.memberNum}">나의 리뷰2</a>
			
		</div>
	</div>
</nav>

    