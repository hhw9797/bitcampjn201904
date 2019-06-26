<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	CookieBox cBox = new CookieBox(request);

	String chId = cBox.getValue("saveID");
	
 	if(chId == null){
 		chId="";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
</style>
</head>
<body>

	<h1>로그인</h1>
	<hr>
	<form action="login.jsp" method="post">
		아이디 <input type="text" name="id" value=<%= chId %>> <br> 
		비밀번호 <input type="password" name="pw"> <br> 
		아이디 저장 <input type="checkbox" name="idSave"> <br>
		<input type="submit" value="로그인"> <br>
	</form>

	<br>
	<a href="loginCheck.jsp">loginCheck</a>
</body>
</html>