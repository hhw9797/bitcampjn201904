<%@page import="foodPost.service.WritePostService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="foodpost" class="foodPost.model.FoodPost" />
<jsp:setProperty property="*" name="foodpost" />
<%
	//객체생성
	WritePostService service = WritePostService.getInstance();
	int cnt = service.write(foodpost);
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
	<h1>
		<%= cnt>0 ? "맛집 게시판에 새 게시글을 남겼습니다." : "게시글이 정상적으로 등록되지 않았습니다." %>
	</h1>
	<a href="list.jsp">목록보기</a>
</body>
</html>