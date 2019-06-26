<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- class : 풀네임 사용(경로), scope="page" : default값이라 생략가능하다 --%>
<%-- usrBean에서는 객체를 생성하는것이 목적이 아닌 객체를 찾는것이 목적 만약 객체가 존재한다면 그대로 써도되지만 없다면 생성해야한다. --%>
<jsp:useBean id="userInfo" class="web.UserInfo" scope="page"/>

<%--
	1. 해당 영역(현재 페이지)에 userInfo 이름의 web.UserInfo타입 객체가 잇는지 확인
	2. 객체가 있다면 현재 저장되어 있는 객체를 반환한다.
	3. 없다면 UserInfo ui = new web.UserInfo(); 새로운 객체를 생성해준다.
	3-1. pageContext.setAttribute("userInfo", ui); : pageContext영역에 userInfo이름으로 ui객체를 넣는다.
 --%>
 
<%-- userInfo 객체에 있는 name에 hot이라는 value값을 넣어준다. --%> 
<jsp:setProperty property="name" value="hot" name="userInfo"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<%
		userInfo.setId("cool");
	%>

	<%= userInfo.getId() %><br>
	<%= userInfo.getName() %>
</body>
</html>