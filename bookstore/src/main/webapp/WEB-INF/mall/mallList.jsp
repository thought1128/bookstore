<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../book_nav.jsp"%>

<title>mall\mallList.jsp</title>
<p></p>
<h2 align="center">주문 내역</h2>
<table class="table mx-auto" style="max-width: 900px;">
	<tr>
		<th colspan="8" align="center">
			주문자 : ${sessionScope.loginInfo.id }
		</th>
	</tr>
	<tr>
		<th>상품 번호 </th>
		<th>상품명 </th>
		<th>주문 수량 </th>
		<th>가격</th>
		<th>포인트 </th>
		<th>총가격</th>
		<th>총포인트</th>
		<th>삭제</th>
	</tr>
	<c:forEach items="${sessionScope.shoplists }" var="shInfo">
		<tr>
			<th >${shInfo.isbn}</th>
			<th ><a href="detail.pv?isbn=${shInfo.isbn}">${shInfo.title }</a></th>
			<th> 
			<form action="add.mall" method="post">
				<input type="hidden" name="isbn" value="${shInfo.isbn}">
				<input type="hidden" name="reCount" value="y">
				<div class="input-group mb-3">
				  <input type="number" class="form-control" aria-describedby="button-addon2" name="oqty" value="${shInfo.oqty}" style="max-width: 80px" min="1">
				  <div class="input-group-append">
				    <button class="btn btn-outline-secondary" type="submit" id="button-addon2">변경</button>
				  </div>
				</div>
			</form>
			</th>
			<th >${shInfo.price }</th>
			<th >${shInfo.point }</th>
			<th >${shInfo.price * shInfo.oqty }</th>
			<th >${shInfo.point * shInfo.oqty}</th>
			<th ><a href="remove.mall?isbn=${shInfo.isbn}">삭제</a></th>
		</tr>		
	</c:forEach>
	<tr>
		<th colspan="8" align="center">
			총금액 : ${totalAmount} &nbsp&nbsp&nbsp
			총포인트 : ${totalPoint}
		</th>
	</tr>
	
</table>

<div class="mx-auto" style="max-width: 900px">
	<form method="post" action="calculate.mall">
	  <div class="form-group">
	    <label for="inputName">이름</label>
	    <input type="text" class="form-control" id="inputName" name="name" value="${sessionScope.loginInfo.name}">
	 </div>
	 <div class="form-group">
	   <label for="inputPhone">전화번호</label>
	   <input type="number" class="form-control" id="inputPhone" name="phoneNum" value="${sessionScope.loginInfo.phoneNum}">
	 </div>
	 <div class="form-group">
	   <label for="inputAddress">주소</label>
	   <input type="text" class="form-control" id="inputAddress" name="address" value="${sessionScope.loginInfo.address}">
	  </div>
	  <div class="form-group" align="center">
	  	<br>
	    <button type="submit" class="btn btn-secondary">주문하기</button>
	 		</div>
	</form>
</div>
<p></p>
<%@ include file="./../../footer.jsp"%>

