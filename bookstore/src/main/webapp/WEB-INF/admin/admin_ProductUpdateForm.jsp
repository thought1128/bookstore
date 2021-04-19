<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../common/common.jsp" %>
<%@ include file="./../../book_nav.jsp"%>
<%@ include file="./adminTop.jsp"%>

<!-- update.prd => ProductUpdateController -->
<!-- WEB-INF/admin_ProductUpdateForm.jsp<br> -->

<br>
<br>

<form:form commandName="product" action="update.prd" method="post" enctype="multipart/form-data">
	<table align="center">
	<tr>
		<td width="120">isbn</td>
		<td width="180">
	<input type="text" name="isbn" value="${product.isbn}" readonly>
	<form:errors cssClass="err" path="isbn" />
	</td>
	</tr>
	
	<tr>
		<td width="120">책제목</td>
		<td width="180">
			<input type="text" name="title" value="${product.title }">
			<form:errors cssClass="err" path="title" />
		</td>
	</tr>
	<tr>
		<td width="120">저자</td>
		<td width="180">
			<input type="text" name="writer" value="${product.writer }">
			<form:errors cssClass="err" path="writer" />
		</td>
	</tr>
	<tr>
		<td width="120">출판사</td>
		<td width="180">
			<input type="text" name="publisher" value="${product.publisher  }">
			<form:errors cssClass="err" path="publisher" />
		</td>
	</tr>
	 <tr>
      <td width="120">출간일</td>
      <td width="180">
         <fmt:parseDate var="parseDate" value="${product.publishedDate}" pattern = "yyyy-MM-dd"/>
         <fmt:formatDate var="fmtDate" value="${parseDate}" pattern = "yyyy-MM-dd"/>
         <input type="date" name="targetDate" value="${fmtDate }">
         <form:errors cssClass="err" path="publishedDate" />
      </td>
   </tr>
	<tr>
		<td width="120">상품가격</td>
		<td width="180">
			<input type="text" name="price" value="${product.price }">
			<form:errors cssClass="err" path="price" />
		</td>
	</tr>
	<tr>
		<td width="120">적립포인트</td>
		<td width="180">
			<input type="text" name="point" value="${product.point }">
			<form:errors cssClass="err" path="point" />
		</td>
	</tr>
	<tr>
		<td width="120">재고수량</td>
		<td width="180">
			<input type="text" name="qty" value="${product.qty}">
			<form:errors cssClass="err" path="qty" />
		</td>
	</tr>
	<tr>
		<td width="120">재고유무</td>
		<td width="180">
			<select name="status">
      	   		<option value="waiting">출간예정</option>
        	 	<option value="sale">판매중</option>
        		 <option value="soldout">절판</option>
			</select>
			<form:errors cssClass="err" path="status" />
		</td>
	</tr>
	<tr>
		<td width="120">책 이미지</td>
		<td width="180">
		<img src="<%=request.getContextPath() %>/resources/book_images/${product.image}" width="100px" height="100px">
		
		<input type="file" name="upload"> 
		<input type="hidden" name="upload2" value="${product.image}">
		<form:errors cssClass="err" path="image" />
	</td>
	</tr>
	<tr>
		<td width="120">분류</td>
		<td width="180">
			<input type="text" name="classify" value="${product.classify}">
			<form:errors cssClass="err" path="classify" />
		</td>
	</tr>
	<tr>
		<td width="120">페이지 노출여부</td>
		<td width="180">
			<input type="radio" name="promotions" value="T" checked>T
			<input type="radio" name="promotions" value="F">F
				<form:errors cssClass="err" path="promotions" />
		
		</td>
	</tr>
	
	<tr>
		<td colspan="2" align="center" width="300">
			<input type="submit" value="수정하기">
		</td>
	</tr>
	</table>
</form:form >
<%@ include file="./../../footer.jsp"%>