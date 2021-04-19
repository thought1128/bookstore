<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="./../../book_nav.jsp"%>
    
<title>/review/read.jsp</title>
<p></p>

<table class="table mx-auto" style="width: 700px">

	<tr>
		<td colspan="2" style="text-align: center">
			<c:if test="${fn:length(review.image)>0 }" >
				<img src="<%=request.getContextPath() %>/resources/reviewImage/${review.image }" style="max-width:600px">
			</c:if>
			<c:if test="${fn:length(review.image)==0 }">
				등록한 사진이 없습니다.
			</c:if>
			
		</td>		
	</tr>
	<tr>
		<td>제목</td>
		<td>${review.subject}</td>
	</tr>
	<tr>
		<td>리뷰 대상</td>
		<td>${review.title}</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${review.name}</td>
	</tr>
	<tr>
		<td>작성일</td>
		<td>${review.regDate}</td>
	</tr>
	<tr>
		<td>조회수</td>
		<td>${review.readCount}</td>
	</tr>
	<tr>
		<td colspan="2">${review.content}</td>
	</tr>
	<tr>
		<td colspan="2">
			<a class="btn btn-secondary" href="reply.rv?reviewNum=${review.reviewNum }">답글</a>		
			<c:if test="${sessionScope.loginInfo.memberNum==review.memberNum}">
				<a class="btn btn-secondary" href="update.rv?reviewNum=${review.reviewNum}">수정</a>
				<a class="btn btn-secondary" href="delete.rv?reviewNum=${review.reviewNum }">삭제</a>				
				<a class="btn btn-secondary" href="detail.pv?isbn=${review.isbn }">상품</a>
			</c:if>
			<c:if test="${sessionScope.loginInfo.id=='admin'}">
				<a class="btn btn-secondary" href="delete.rv?reviewNum=${review.reviewNum }">관리자권한삭제</a>							
			</c:if>
		</td>
	</tr>
</table>
<p></p>
<%@ include file="./../../footer.jsp"%>
