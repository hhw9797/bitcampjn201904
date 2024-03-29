<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("name01", "requestData");
	session.setAttribute("name01", "sessionData");
	application.setAttribute("name03", "applicationData");
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
	<h3>
	
		request 영역의 name01 : ${name01} <br> <!-- 속성영역은 생략 가능. EL 기본 제공하는 객체가 아니기 때문에 생략되었다고 인식 -->
							   <%= request.getAttribute("name01") %> <br>							  
		session 영역의 name02 : ${sessionScope.name01} <br>
		application 영역의 name03 : ${name03} <br>
		<!-- 표현식, 표현언어 둘 다 출력의 목적 -->
		code 파라미터 : ${param.code} <br>
		code 파라미터 : <%= request.getParameter("code") %> <br>
		
		contextPath: ${pageContext.request.contextPath} <br>
		contextPath: <%= request.getContextPath() %> <br>
		
		<a href="${pageContext.request.contextPath}/member/memberList.jsp">경로1</a>
		<a href="<%= request.getContextPath() %>/member/memberList.jsp">경로2</a>
		
	</h3>
</body>
</html>