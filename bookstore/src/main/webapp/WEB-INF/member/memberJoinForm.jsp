<%@page import="member.model.Member"%>
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
<script>
	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var addr = ''; // 주소 변수
						var extraAddr = ''; // 참고항목 변수

						//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							addr = data.roadAddress;
						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							addr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
						if (data.userSelectedType === 'R') {
							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							if (extraAddr !== '') {
								extraAddr = ' (' + extraAddr + ')';
							}
							// 조합된 참고항목을 해당 필드에 넣는다.
							document.getElementById("sample6_extraAddress").value = extraAddr;

						} else {
							document.getElementById("sample6_extraAddress").value = '';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample6_postcode').value = data.zonecode;
						document.getElementById("sample6_address").value = addr;
						// 커서를 상세주소 필드로 이동한다.
						document.getElementById("sample6_detailAddress")
								.focus();
					}
				}).open();
	}
</script>
<style type="text/css">
.err {
	color: red;
	font-weight: bold;
	font-size: 9pt;
}
</style>

<%@ include file="./../../book_nav.jsp"%>
<h1 align="center">회원가입</h1>

<form:form action="join.me" method="post" commandName="member">
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-2">
			아이디<input type="text" name="id" value="${member.id }"
				class="form-control">
			<form:errors cssClass="err" path="id" />

		</div>
	</div>

	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-2">
			비밀번호<input type="password" name="password" class="form-control">
			<form:errors cssClass="err" path="password" />

		</div>
	</div>
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-2">
			비밀번호 확인 <input type="password" name="passwordCheck"
				class="form-control">
			<form:errors cssClass="err" path="passwordCheck" />
		</div>
	</div>
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-2">
			이름 <input type="text" name="name" value="${member.name }"
				class="form-control">
			<form:errors cssClass="err" path="name" />
		</div>
	</div>
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-2">
			전화번호 <input type="number" name="phoneNum" value="${member.phoneNum }"
				class="form-control">
			<form:errors cssClass="err" path="phoneNum" />
		</div>
	</div>
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-2">
			이메일 <input type="email" name="email" value="${member.email }"
				class="form-control">
			<form:errors cssClass="err" path="email" />
		</div>
	</div>



	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-1">주소</div>
	</div>
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-1">
			<input type="text" id="sample6_postcode" name="address"
				placeholder="우편번호" value="${fn:split(member.address,',')[0]}"
				class="form-control">
			
		</div>
		<div class="col-md-1">
			<input type="button" onclick="sample6_execDaumPostcode()"
				value="우편번호 찾기" class="btn btn-secondary">
		</div>
	</div>
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-2">
			<input type="text" id="sample6_address" name="address"
				placeholder="주소" size="40"
				value="${fn:split(member.address,',')[1]}" class="form-control">
			<input type="text" id="sample6_detailAddress" name="address"
				placeholder="상세주소" value="${fn:split(member.address,',')[2]}"
				class="form-control"> <input type="text"
				id="sample6_extraAddress" name="address" placeholder="참고항목"
				value="${fn:split(member.address,',')[3]}" class="form-control">
			<form:errors cssClass="err" path="address" />
		</div>
	</div>
	
	<br>
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-1">
			<input type="submit" value="가입" class="btn btn-primary">
		</div>
	</div>


</form:form>
<%@ include file="./../../footer.jsp"%>
<!-- devU01TX0FVVEgyMDIxMDMzMDE3MzEyODExMDk4NzA= -->