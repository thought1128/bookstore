<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./../common/common.jsp"%>
<%@ include file="./../../book_nav.jsp"%>
<%@ include file="./adminTop.jsp"%>

<script type="text/javascript">
	function insert() {
		location.href = 'input.prd';
	}

</script>
<center>
<form method="get" action="list.prd">
	<select name="whatColumn">
		<option value="total">전체</option>
		<option value="title">제목</option>
		<option value="status">재고유무</option>
		<option value="classify">분류</option>
		<option value="promotions">노출</option>
	</select>
	<input type="text" name="keyword"> <input type="submit" value="검색">
</form>
</center>
	<table border="1"  align="center" class='table table-bordered'>
		<tr>
			<td colspan="13" align="right"><input type="button" value="추가하기"
				onclick="insert()"></td>
		</tr>
		<tr>

			<th><span>책제목</span></th>
			<th><span>ISBN</span></th>
			<th><span>저자</span></th>
			<th><span>출판사</span></th>
			<th><span>출간일</span></th>
			<th><span>가격</span></th>
			<th><span>적립포인트</span></th>
			<th><span>재고수량</span></th>
			<th><span>재고유무</span></th>
			<th><span>이미지</span></th>
			<th><span>분류</span></th>
			<th><span>노출여부</span></th>
			<th><span> 수정|삭제 </span></th>
		</tr>
		<c:forEach items="${list }" var="product">
			<tr>
				<th align="center">${product.title }</th>
				<th align="center">${product.isbn }</th>
				<th align="center">${product.writer }</th>
				<th align="center">${product.publisher  }</th>
				<th align="center">
				<fmt:parseDate var="day" value="${product.publishedDate}" pattern="yyyy-MM-dd" /> 
            <fmt:formatDate value="${day}" pattern="yyyy-MM-dd" />
            </th>
				<th align="center">${product.price   }</th>
				<th align="center">${product.point  }</th>
				<th align="center">${product.qty  }</th>
				<th align="center">${product.status   }</th>
				<th align="center">${product.image   }</th>
				<th align="center">${product.classify   }</th>
				<th align="center">${product.promotions    }</th>
				<th align="center">
				<a href="update.prd?isbn=${product.isbn }&pageNumber=${pageInfo.pageNumber}&pageSize=${pageInfo.pageSize}">수정</a>
				<a href="delete.prd?isbn=${product.isbn }&pageNumber=${pageInfo.pageNumber}">삭제</a></th>
				
			</tr>
		</c:forEach>
	</table>
<center><div id="paging">${pageInfo.pagingHtml }</div></center>
<%@ include file="./../../footer.jsp"%>