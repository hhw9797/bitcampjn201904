<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- scope="session" : session영역에 데이터 저장 다른 페이지에서 데이터를 공유하기위해서는 scope도 맞춰야한다. --%>
<jsp:useBean id="userData" class="web.UserInfo" scope="session" />
<%-- userInfo에 있는 모든 변수들을 가져와(*을사용해서 모든변수를 선택) userData에 저장 --%>
<jsp:setProperty property="*" name="userData"/>
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
<h1>
	<%= userData %>
</h1>
<jsp:forward page="viewMember.jsp"/>
</body>
</html>