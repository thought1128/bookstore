<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../book_nav.jsp"%>
    
    /board/reply.jsp

<form:form commandName="board" action="reply.br" method="post" >
	<input type="hidden" name="memberNum" value="${sessionScope.loginInfo.memberNum }">
	<input type="hidden" name="name" value="${sessionScope.loginInfo.name }">
	<input type="hidden" name="targetBoardNum" value="${target.boardNum }">
	<input type="hidden" name="ref" value="${target.ref }">
	<input type="hidden" name="reLevel" value="${target.reLevel+1}">
	<input type="hidden" name="reStep" value="${target.reStep+1}">

	<table class="table mx-auto" style="width: 700px">
		<tr>
			<td>작성자</td>
			<td>${sessionScope.loginInfo.name }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input class="form-control" type="text" name="subject" value="${board.subject }">
			<form:errors cssClass="err" path="subject"></form:errors>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<textarea class="form-control" name="content" placeholder="${target.subject}에 대한 답변을 달아주세요.">${board.content }</textarea>
				<form:errors cssClass="err" path="content"></form:errors>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input class="btn btn-secondary"  type="submit" value="submit">
				<input  class="btn btn-secondary" type="reset" value="reset">
			</td>
		</tr>
	</table>
</form:form>