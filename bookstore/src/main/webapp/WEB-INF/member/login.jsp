<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%@ include file="./../../book_nav.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function join() {
		location.href = "join.me"
	}
	function findId() {
		location.href = "findId.me"
	}
	function findPassword() {
		location.href = "findPassword.me"
	}
</script>
</head>
<body>
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-5"><h1>로그인</h1></div>
	</div>
	<form action="login.me" method="post">
		<div class="row">
			<div class="col-md-2 mx-auto">ID<input type="text" name="id" class="form-control"></div>
		</div>
		<div class="row">
		<div class="col-md-5"></div>
			<div class="col-md-2">Password  <input type="password" name="password" class="form-control">
			
      </div>
		</div>
		<br><div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-5">
			<input type="submit" value="로그인" class="btn btn-primary"> 
			<input type="button" value="회원가입" onclick="join()" class="btn btn-secondary"> 
			<input type="button" value="아이디 찾기" onclick="findId()" class="btn btn-secondary"> 
			<input type="button" value="비밀번호 찾기" onclick="findPassword()" class="btn btn-secondary"></div>
			
		</div>
	</form>

</body>

<%@ include file="./../../footer.jsp"%>