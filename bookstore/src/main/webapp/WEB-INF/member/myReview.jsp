<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../book_nav.jsp"%>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>



<table>
	<tr>	
		<td>ref</td>
		<td>게시글번호</td>
		<td>상품명</td>
		<td>글쓴이</td>
		<td>제목</td>
		<td>조회수</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>
	<c:forEach var="r" items="${reviewList}">
		<tr>
			<td>${r.ref}</td>
			<td>${r.reviewNum }</td>
			<td>${r.productTitle }</td>
			<td>${r.name }</td>
			<td>
			<c:if test="${r.reLevel>0}">
				<c:forEach begin="1" end="${r.reLevel}">
					<img src="<%=request.getContextPath() %>/resources/images/level.gif">
				</c:forEach>
			</c:if>			
			<a href="read.rv?reviewNum=${r.reviewNum }">${r.subject }</a></td>
			<td>${b.regDate }</td>
			<td><a href="update.rv?reviewNum=${r.reviewNum  }">수정</a></td>
			<td><a href="delete.rv?reviewNum=${r.reviewNum  }">삭제</a></td>
		</tr>
	</c:forEach>
</table>

	${pageInfo.pagingHtml }

