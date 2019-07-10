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
	
	<h1>사원 등록</h1>
	<hr>
	<form action="insertEmp.jsp" method="post">
		사원번호 <input type="text" name="empno" required> <br>
		사원이름 <input type="text" name="ename" required> <br>
		사원직무 <input type="text" name="job" > <br>
		부서번호 <input type="text" name="deptno" > <br>
		<input type="submit" value="등록">
	</form>
</body>
</html>