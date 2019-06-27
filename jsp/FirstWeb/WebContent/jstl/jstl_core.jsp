<%@page import="java.util.List"%>
<%@page import="web.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	List<Member> list = new ArrayList<Member>();

	list.add(new Member("홍길동11", "hong-11", "000-0000-0000"));
	list.add(new Member("홍길동12", "hong-12", null));
	list.add(new Member("홍길동13", "hong-13", "000-0000-0000"));
	list.add(new Member("홍길동14", "hong-14", "000-0000-0000"));
	list.add(new Member("홍길동15", "hong-15", "000-0000-0000"));
	list.add(new Member("홍길동16", "hong-16", null));
	list.add(new Member("홍길동17", "hong-17", null));
	list.add(new Member("홍길동18", "hong-18", "000-0000-0000"));
	list.add(new Member("홍길동19", "hong-19", "000-0000-0000"));
	list.add(new Member("홍길동10", "hong-10", "000-0000-0000"));
	
	application.setAttribute("members", list);
	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
	span.nopnum {
		color : red;
	}

</style>
</head>
<body>

	<h3>
		${param.code}
		<c:out value="${param.code}" escapeXml="false"> 
			<span style="color:red">b</span>
		</c:out>
	</h3>
	<hr>
	<table>
		<tr>
			<td>이름</td>
			<td>아이디</td>
			<td>전화번호</td>
		</tr>
		<c:forEach items="${members}" var="member">
		<tr>
			<td>${member.name}</td>
			<td>${member.id}</td>
			<td>
				
				<c:out value="${member.pNum}" escapeXml="false">
					<span class="nopnum">전화번호 없음</span>
				</c:out>
				
			</td>
		</tr>
		</c:forEach>
		
	</table>

</body>
</html>