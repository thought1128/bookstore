<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../book_nav.jsp"%>
    
    /board/read.jsp
    
<table class="table mx-auto" style="width: 700px">
	<tr>
		<td>제목</td>
		<td>${board.subject}</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${board.name}</td>
	</tr>
	<tr>
		<td>작성일</td>
		<td>${board.regDate}</td>
	</tr>
	<tr>
		<td>조회수</td>
		<td>${board.readCount}</td>
	</tr>
	<tr>
		<td colspan="2">${board.content}</td>
	</tr>
	<tr>
		<td colspan="2">

		<a class="btn btn-secondary" href="reply.br?boardNum=${board.boardNum }">답글</a>
		<c:if test="${sessionScope.loginInfo.memberNum==board.memberNum}">
			<a class="btn btn-secondary" href="update.br?boardNum=${board.boardNum }">수정</a>
			<a class="btn btn-secondary" href="delete.br?boardNum=${board.boardNum }">삭제</a>
		</c:if>
		<c:if test="${sessionScope.loginInfo.id=='admin'}">
			<a class="btn btn-secondary" href="delete.br?boardNum=${board.boardNum }">관리자권한삭제</a>
		</c:if>
		
		</td>
	</tr>
</table>
