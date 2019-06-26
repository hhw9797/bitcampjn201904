<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- 이 JSP가 에러뜰때 사용되는 페이지라고 지정 --%>
<%@ page isErrorPage="true"%>

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
		[500에러] 요청하신 처리내용 중에 오류가 발생했습니다.<br>빠른 시간안에 해결하겠습니다.
	</h1>
	<%-- 이 루트의 기본 메인페이지로 이동 --%>
	<a href="<%= request.getContextPath() %>">홈으로 이동</a>

	<p>
		에러 타입:
		<%= exception.getClass().getName() %>
		<br> 에러 메시지: <b><%= exception.getMessage() %></b>
</body>
</html>
<!--
	만약 에러 페이지의 길이가 513 바이트보다 작다면,인터넷 익스플로러는 이 페이지가 출력하는 에러 페이지를 출력하지 않고 자체적으로 제공하는 'HTTP 오류 메시지' 화면을 출력할 것이다. 
	만약 에러 페이지의 길이가 513 바이트보다 작은데 에러 페이지의 내용이 인터넷 익스플로러에서도 올바르게 출력되길 원한다면, 응답 결과에 이 주석과 같은 내용을 포함시켜서 에러 페이지의
	길이가 513 바이트 이상이 되도록 해 주어야 한다. 참고로 이 주석은 456바이트이다.
-->