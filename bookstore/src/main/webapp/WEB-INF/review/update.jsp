<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../book_nav.jsp"%>
    
    /review/update.jsp

<form:form commandName="review" action="update.rv" method="post" enctype="multipart/form-data">
	<input type="hidden" name="memberNum" value="${sessionScope.loginInfo.memberNum }">
	<input type="hidden" name="name" value="${sessionScope.loginInfo.name }">
	<input type="hidden" name="reviewNum" value="${review.reviewNum }">
	<input type="hidden" name="isbn" value="${review.isbn }" >
	
	<table class="table mx-auto" style="width: 700px">
		<tr>
			<td>대상 상품명</td>
			<td>
				<input type="text"class="form-control"  name="title" value="${review.title }" readonly>
			</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${sessionScope.loginInfo.name }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" class="form-control" name="subject" value="${review.subject }">
				<form:errors cssClass="err" path="subject"></form:errors>
			</td>
		</tr>
		<tr>
			<td>기존이미지</td>
			<td>
			
				<img class="mr-3" src="<%=request.getContextPath() %>/resources/reviewImage/${review.image }" width="100px" height="100px">
				<input type="hidden"  name="upload2" value="${review.image }">
			</td>
		</tr>		
		<tr>
			<td>이미지 변경</td>
			<td><input type="file" class="form-control" name="upload"></td>
		</tr>

		<tr>
			<td colspan="2">
				<textarea class="form-control" name="content">${review.content }</textarea>
				<form:errors cssClass="err" path="content"></form:errors>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" class="btn btn-secondary" value="submit">
				<input type="reset" class="btn btn-secondary" value="reset">
			</td>
		</tr>
		
	</table>
</form:form>