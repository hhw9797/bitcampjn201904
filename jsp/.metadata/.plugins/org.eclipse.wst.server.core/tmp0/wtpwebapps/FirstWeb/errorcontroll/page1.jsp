<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="../errorpage/viewErrorPage.jsp" %>
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
	<!-- toLowerCase() : 대문자로 변경해줌 -->
	<!-- name 에 값이 없으면 null값이 들어가는데 null값에 toLowerCase()메서드를 불러오게되면 NullPointerException 오류가 뜬다 500에러 -->
	name 파라미터 값 : <%= request.getParameter("name").toLowerCase() %>
</body>
</html>