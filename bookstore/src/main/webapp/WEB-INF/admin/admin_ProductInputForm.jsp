<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="./../common/common.jsp"%>
<%@ include file="./../../book_nav.jsp"%>
<%@ include file="./adminTop.jsp"%>
<!-- admin_ProductInputForm<br> -->
<br>
<br>
<center>
<form:form commandName="product" action="input.prd" method="post"
	enctype="multipart/form-data" name="myform">
	<table class="table"  align="center">
	<tr>
			<td>ISBN</td>
			<td><input type="text" name="isbn " value="${product.isbn  }">
				<form:errors cssClass="err" path="isbn" /></td>
		</tr>
	
	
		<tr>
			<td>책 제목</td>
			<td><input type="text" name="title " value="${product.title  }">
				<form:errors cssClass="err" path="title" /></td>
		</tr>
		
		<tr>
			<td>저자</td>
			<td><input type="text" name="writer " value=" ${product.writer  }">
				<form:errors cssClass="err" path="writer" /></td>
		</tr>

		<tr>
			<td>출판사</td>
			<td><input type="text" name="publisher " value="${product.publisher  }">
				<form:errors cssClass="err" path="publisher" /></td>
		</tr>
		<tr>
	
			<td>출간일</td>
			<td><input type="date" name="targetDate"
			value="<fmt:parseDate var="parseDate" value="${product.publishedDate}" pattern = "yyyy-MM-dd"/>
			<fmt:formatDate var="fmtDate" value="${parseDate}" pattern = "yyyy-MM-dd"/>">
				<form:errors cssClass="err" path="publishedDate" /></td>
		</tr>
		
		<tr>
			<td>상품가격</td>
			<td><input type="text" name="price" <c:if test="${product.price == null}">value="0"</c:if><c:if test="${product.price != null}">value="${product.price}"</c:if>>원 
				<form:errors cssClass="err" path="price" /></td>
		</tr>
		<tr>
			<td>적립포인트</td>
			<td><input type="text" name="point" <c:if test="${product.point == null}">value="0"</c:if><c:if test="${product.point != null}">value="${product.point}"</c:if>>
				<form:errors cssClass="err" path="point" /></td>
		</tr>
		
		
		<tr>
			<td>재고수량</td>
			<td><input type="text" name="qty" <c:if test="${product.qty == null}">value="0"</c:if><c:if test="${product.qty != null}">value="${product.qty}"</c:if>>
				<form:errors cssClass="err" path="qty" /></td>
		</tr>
		
		<tr>
			<td>재고유무</td>
			<td>
			 <select name="status" class="form-select form-select-sm" aria-label=".form-select-sm example">
      	   		<option value="waiting">출간예정</option>
        	 	<option value="sale">판매중</option>
        		 <option value="soldout">절판</option>
			</select>
			</td>
		</tr>
		
		<tr>
			<td>상품이미지</td>
			<td><input type="file" name="upload" value=" ${product.image }">
				<form:errors cssClass="err" path="image" /></td>
		</tr>
		
		<tr>
			<td>분류</td>
			<td><input type="text" name="classify" value=" ${product.classify}">
				<form:errors cssClass="err" path="classify" /></td>
		</tr>
			<tr>
			<td>노출여부</td>
			<td><input type="radio" name="promotions" value="T">T
			<input type="radio" name="promotions" value="F">F
				<form:errors cssClass="err" path="promotions" /></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center"><input type="submit" value="상품등록">
				<input type="reset" value="취소"></td>
		</tr>
	</table>
</form:form>
<center>
<%@ include file="./../../footer.jsp"%>