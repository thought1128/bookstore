<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../book_nav.jsp"%>

    /board/insert.jsp

<form:form commandName="review" action="insert.rv" method="post"  enctype="multipart/form-data">
	<input type="hidden" name="memberNum" value="${sessionScope.loginInfo.memberNum }">
	<input type="hidden" name="name" value="${sessionScope.loginInfo.name }">
	<input type="hidden" name="isbn" value="${product.isbn}">
	
	<table class="table mx-auto" style="width: 700px">
		<tr>
			<td>도서명</td>
			<td>
				<input class="form-control"  type="text" name="title" value="${product.title }" readonly>
			</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${sessionScope.loginInfo.name }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input class="form-control"  type="text" name="subject" value="${review.subject }">
			<form:errors cssClass="err" path="subject"></form:errors>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea class="form-control" name="content">${review.content} </textarea>
				<form:errors cssClass="err" path="content"></form:errors>
			</td>
		</tr>
		<tr>
			<td>이미지</td>
			<td><input type="file" name="upload"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input class="btn btn-secondary"  type="submit" value="submit">
				<input class="btn btn-secondary"  type="reset" value="reset">
			</td>
		</tr>
	</table>
</form:form>