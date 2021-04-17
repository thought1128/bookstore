<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../../book_nav.jsp"%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
/board/list.jsp
<br>

<script>
	window.onload = function(){
		var error = "${msg}";
		if(error !=''){
			alert(error);
		}	
	}
</script>

<hr>

<h1 class="text-center">QNA 게시판</h1>
<br>
<form action="list.br" method="get">
	<div class="input-group mx-auto" style="width: 700px">
		<select class="custom-select" name="whatColumn"
			id="inputGroupSelect02">
			<option value="all">전체검색</option>
			<option value="name" ${param.whatColumn=='name'?'selected':''}>작성자</option>
			<option value="subject" ${param.whatColumn=='subject'?'selected':''}>제목</option>
		</select>
		<div class="input-group-append">
			<input class="form-control" type="text" name="keyword" placeholder="Search" value="${param.whatColumn=='all'?'':param.keyword }">
		</div>
		<div class="input-group-append">
			<input class="btn btn-outline-primary"
				type="submit" value="검색">
		</div>
		<div class="input-group-append mr-auto">
			&nbsp&nbsp&nbsp 
		</div>
		<div class="input-group-append">
			<a class="btn btn-outline-primary" href="insert.br">게시글입력</a>
		</div>
	</div>
</form>

<table class="table mx-auto" style="width: 700px">
	<tr>
		<td>번호</td>
		<td>글쓴이</td>
		<td>제목</td>
		<td>작성일</td>
		<td>조회수</td>
	</tr>
	<c:forEach var="b" items="${boardList}">
		<tr>
			<td>${b.boardNum }</td>
			<td>${b.name }</td>
			<td><c:if test="${b.reLevel>0}">
					<c:forEach begin="1" end="${b.reLevel}">
						<img
							src="<%=request.getContextPath() %>/resources/images/level.gif">
					</c:forEach>
				</c:if> <a href="read.br?boardNum=${b.boardNum }">${b.subject }</a></td>
			<td>
				<fmt:parseDate var="day" value="${b.regDate}" pattern="yyyy-MM-dd" /> 
				<fmt:formatDate value="${day}" pattern="yyyy-MM-dd" />
			</td>
			<td>${b.readCount}</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="5" class="text-center">
		${pageInfo.pagingHtml }
		</td>
	</tr>
</table>

