<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="sub.jspf" %>
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
		<!-- include를 통해 sub.jspf에서 코드를 가져와서 정의해놓은 dataFolder를 출력할 수 있다. -->
		폴더 경로 : <%= dataFolder %>
	</h1>
</body>
</html>