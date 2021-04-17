<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../../book_nav.jsp"%>


<title>product_detail.jsp</title>
<p></p>
<fmt:parseDate var="parseDate" value="${product.publishedDate}" pattern="yyyy-MM-dd"/>
<fmt:formatDate var="fmtDate" value="${parseDate}" pattern="yyyy년 MM월 dd일"/>
<div class="container">
<div class="card mb-3 mx-auto" style="max-width: 700px;" >
  <div class="row g-0">
    <div class="col-md-4">
      <img src="resources/book_images/${product.image}" alt="${product.title}" style="max-width: 100%; max-height: 100%;">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">${product.title}</h5>
        <hr>
        <p class="card-text">
        	제목 : ${product.writer}<br>
        	저자 : ${product.publisher}<br>
        	출간일 : ${fmtDate}<br>
        	가격 : <fmt:formatNumber value="${product.price}" pattern="###,###"/>원<br>
        	적립 포인트 : <fmt:formatNumber value="${product.point}" pattern="###,###"/>P<br>
        	재고 : <fmt:formatNumber value="${product.qty}" pattern="###,###"/>권<br>
        	<c:if test="${product.status == 'waiting'}">준비중<br></c:if>
        	<form action="add.mall" method="post">
	 			<input type="hidden" name="isbn" value="${product.isbn}">
				<input type="hidden" name="reCount" value="n">
	        	<input type="hidden" name="qty" value="${product.qty}">	
	        	<div class="input-group" style="width: 200px">
			       	<input class="form-control"type="number" name="oqty" value="1" maxlength="2">
			       	<input class="btn btn-secondary" type="submit" value="장바구니">
	        	</div>
        	</form>
        </p>
      </div>
    </div>
  </div>
</div>
<p></p>

<form action="detail.pv" method="get">
<input type="hidden" name="isbn" value="${product.isbn }">
	<div class="input-group mx-auto" style="max-width: 700px;" >
		<select class="custom-select" name="whatColumn"
			id="inputGroupSelect02">
			<option value="">전체검색</option>
			<option value="name" ${param.whatColumn=='name'?'selected':''}>작성자</option>
			<option value="subject" ${param.whatColumn=='subject'?'selected':''}>제목</option>
		</select>
		&nbsp;
		<div class="input-group-append">
			<input class="form-control" type="text" name="keyword" value="${param.whatColumn!=''?param.keyword:''}" placeholder="Search">
		</div>
		&nbsp;
		<div class="input-group-append">
			<input class="btn btn-outline-primary" type="submit" value="검색">
		</div>
		<div class="input-group-append mr-auto">
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;
		</div>
		<div class="input-group-append">
			<a class="btn btn-outline-primary" href="insert.rv?isbn=${product.isbn}">리뷰하기</a>
		</div>
	</div>
</form>

<table class="table mx-auto" style="max-width: 700px;" >
	<tr>	
		<td>번호</td>
		<td>글쓴이</td>
		<td>제목</td>
		<td>작성일</td>
		<td>조회수</td>
	</tr>
	<c:if test="${fn:length(reviewList)==0}">
		<tr>
			<td colspan="5">
				리뷰가 없습니다. 첫 번째 리뷰를 남겨주세요.
			</td>
		</tr>
	</c:if>
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
			<td>${r.readCount}</td>
		</tr>
	</c:forEach>

</table>
<center>${pageInfo.pagingHtml}</center>
</div>
<p></p>
<%@ include file="./../../footer.jsp"%>