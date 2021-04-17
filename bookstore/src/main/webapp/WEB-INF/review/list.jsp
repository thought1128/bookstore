<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../book_nav.jsp"%>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>



<br><h3 class="text-center">내가 쓴 리뷰</h3><br>

<table class="table mx-auto" style="max-width: 400px;" >
	<tr>	
		<td>번호</td>
		<td>글쓴이</td>
		<td>제목</td>
		<td>조회수</td>
	</tr>
	<c:forEach var="r" items="${reviewList}">
		<tr>
			<td>${r.reviewNum }</td>
			<td>${r.name }</td>
			<td>
			<c:if test="${r.reLevel>0}">
				<c:forEach begin="1" end="${r.reLevel}">
					<img src="<%=request.getContextPath() %>/resources/images/level.gif">
				</c:forEach>
			</c:if>			
			<a href="read.rv?reviewNum=${r.reviewNum }">${r.subject }</a></td>
			<td>
				<fmt:parseDate var="day" value="${r.regDate}" pattern="yyyy-MM-dd" /> 
				<fmt:formatDate value="${day}" pattern="yyyy-MM-dd" />							
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td class="text-center" colspan="6"> ${pageInfo.pagingHtml } </td>
	</tr>
</table>

	

