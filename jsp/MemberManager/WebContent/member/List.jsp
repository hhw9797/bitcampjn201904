
<%@page import="member.MemberInfo"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Enumeration<String> e = application.getAttributeNames(); // eterator 의 이전버전 반복시킬 수 있음.
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
	
	<%
		while(e.hasMoreElements()){
			
			String name = e.nextElement();
			
			Object obj = application.getAttribute(name);
			
			if(obj instanceof MemberInfo ){
				out.println(name + ":" + obj + "<br>");
			}
		}
	%>
	
</body>
</html>