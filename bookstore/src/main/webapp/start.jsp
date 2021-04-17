<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
start.jsp<br>
<%
	session.setAttribute("destination", "redirect:/myPage.me");
%>

<a href="login.me">로그인</a><br><br>
<a href="join.me">회원가입</a><br><br>
