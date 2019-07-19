<%@page import="sharehobby.exception.food.MessageNotFoundException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="sharehobby.service.food.DeletePostService"%>
<%@page import="sharehobby.service.food.WritePostService"%>
<%@page import="sharehobby.model.food.FoodPostListView"%>
<%@page import="sharehobby.service.food.GetPostListService"%>
<%@page import="sharehobby.model.food.FoodPost"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int messageId = Integer.parseInt(request.getParameter("messageId"));
	String password = request.getParameter("password");
	
	int resultCnt = 0;
	boolean chk = false;
	String msg = "";
	
	// 서비스 객체 생성
	DeletePostService service = DeletePostService.getInstance();
	
	try {
		resultCnt = service.deletePost(messageId);
		chk = true;
	} catch ( SQLException e ){
		msg = e.getMessage();
	} catch ( MessageNotFoundException e ) {
		msg = e.getMessage();
	} 
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOBBY - 맛집 리뷰 작성</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
</style>
</head>
<body>

<!-- nav 시작 -->
	<%@ include file="../frame/nav.jsp"%>
	<!-- nav 끝 -->

	<!-- header 시작 -->
	<%@ include file="../frame/header.jsp"%>
	<!-- header 끝 -->

	<!-- contents 시작 -->
	<h1>
		<%
			if(chk){		
		%>
			<%= resultCnt %> 개의 행이 삭제 되었습니다.
		<%	} else { %>
			<%= msg %>
		<%	} %>
	</h1>
	
	<a href="list.jsp">리스트</a>
	
	<!-- contents 끝 -->


	<!-- footer 시작 -->
	<%@ include file="../frame/footer.jsp"%>
	<!-- footer 끝 -->
	
</body>
</html>




