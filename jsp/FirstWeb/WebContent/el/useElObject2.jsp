<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	<h3>
	
		request 영역의 name01 : ${requestScope.name01} <br> <!-- el에서의 null 은 출력하지 않음 -->
							   <%= request.getAttribute("name01") %> <br> <!-- null 값은 null 출력 -->		  
		session 영역의 name02 : ${sessionScope.name02} <br>
		application 영역의 name03 : ${applicationScope.name03}
	</h3>
</body>
</html>