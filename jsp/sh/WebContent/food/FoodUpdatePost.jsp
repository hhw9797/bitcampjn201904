<%@page import="sharehobby.service.food.WritePostService"%>
<%@page import="sharehobby.model.food.FoodPostListView"%>
<%@page import="sharehobby.service.food.GetPostListService"%>
<%@page import="sharehobby.model.food.FoodPost"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String pageNumberstr = request.getParameter("page");
	int pageNumber = 1;

	if (pageNumberstr != null) {
		pageNumber = Integer.parseInt(pageNumberstr);
	}

	// 핵심 처리할 서비스 객체
	GetPostListService service = GetPostListService.getInstance();
	// 응답 데이터의 결과
	FoodPostListView viewData = service.getPostListView(pageNumber);
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
	<a href="CreateBoard.jsp">리뷰 작성</a>
	<hr>
	<br>
	<%
		if (viewData.isEmpty()) {
	%>
	<h3>등록된 메시지가 없습니다.</h3>
	<%
		} else {

			for (FoodPost foodpost : viewData.getPostList()) {
	%>
	<div>
		<br> 리뷰 번호 : <%=foodpost.getBf_num()%><br>
		리뷰 제목 : <%=foodpost.getBf_title()%><br> 
		리뷰 내용 : <%=foodpost.getBf_cont()%><br>
		평점 :<%=foodpost.getBf_star()%><br>
		<a href="FoodUpdateReview.jsp?pk=<%=foodpost.getBf_title()%>">수정하기</a> | 
		<a href="FoodDeleteReview.jsp?pk=<%=foodpost.getBf_title()%>">삭제하기</a> <br>

	</div>

	<%
		}
		}

		// [1] [2] [3]
		for (int i = 1; i <= viewData.getPageTotalCount(); i++) {
	%>
	<a href="FoodMain.jsp?page=<%=i%>">[<%=i%>]
	</a>

	<%
		}
	%>
</body>
</html>