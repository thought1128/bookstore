<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../book_nav.jsp"%>
    
    /board/reply.jsp

<form:form commandName="review" action="reply.rv" method="post" enctype="multipart/form-data">
	<input type="hidden" name="memberNum" value="${sessionScope.loginInfo.memberNum }">
	<input type="hidden" name="name" value="${sessionScope.loginInfo.name }">
	<input type="hidden" name="targetReviewNum" value="${target.reviewNum }">
	<input type="hidden" name="isbn" value="${target.isbn }">
	<input type="hidden" name="ref" value="${target.ref }">
	<input type="hidden" name="reLevel" value="${target.reLevel+1}">
	<input type="hidden" name="reStep" value="${target.reStep+1}">
	
	<table class="table mx-auto" style="width: 700px">
		<tr>
			<td>작성자</td>
			<td>${sessionScope.loginInfo.name }</td>
		</tr>	
		<tr>
			<td>대상 상품명</td>
			<td>
				<input type="text" class="form-control" name="title" value="${target.title }" readonly>
			</td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" class="form-control"  name="subject" value="${review.subject }">
				<form:errors cssClass="err" path="subject"></form:errors>
			</td>
		</tr>
		<tr>
			<td>이미지</td>
			<td><input type="file" class="form-control"  name="upload"></td>
		</tr>
		<tr>
			<td colspan="2">
			<textarea class="form-control" name="content" placeholder="${target.subject}에 대한 답변을 달아주세요.">${review.content }</textarea>
				<form:errors cssClass="err" path="content"></form:errors>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" class="btn btn-secondary"  value="submit">
				<input type="reset" class="btn btn-secondary"  value="reset">
			</td>
		</tr>
	</table>
</form:form>