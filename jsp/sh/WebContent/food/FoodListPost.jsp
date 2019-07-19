<%@page import="sharehobby.service.food.GetPostListService"%>
<%@page import="sharehobby.model.food.FoodPostListView"%>
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
<title>HOBBY - 맛집 :: 리뷰</title>
<link href="/sh/css/default_css.css" rel="stylesheet" type="text/css">
<style type="text/css">

#topForm {
	text-align: right;
}

#list {
	text-align: center;
}
</style>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	function writePost(){
	    location.href="FoodWritePost.jsp";
	}
</script>


</head>
<body>

	<!-- nav 시작 -->
	<%@ include file="../frame/nav.jsp"%>
	<!-- nav 끝 -->

	<!-- header 시작 -->
	<%@ include file="../frame/header.jsp"%>
	<!-- header 끝 -->

	<!-- contents 시작 -->
	<div id="wrap">

		<!-- 글목록 위 부분-->
		<br>
		<div id="topForm">
			
				<input type="button" value="글쓰기" onclick="writePost()">
			
		</div>

		<!-- 게시글 목록 부분 -->
		<br>
		
		<%
			if(viewData.isEmpty()) {
		%>
		<h3>등록된 메시지가 없습니다.</h3>
		<%
			}else {
		
			for (FoodPost foodpost : viewData.getPostList()) {
			
			%>
		<div>
			<table id="list" width="800" border="3" align="center">
				<tr heigh="30">
					<td>글번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일</td>
					<td>수정 | 삭제</td>
				</tr>
				
					<tr>
						<td><%=foodpost.getBf_num() %></td>
						<td><a href="#"><%=foodpost.getBf_title() %></a></td>
						<td><a href="#"> <%=foodpost.getU_num() %> </a></td>
						<td><%=foodpost.getBf_time() %></td>
						<td><a href="FoodUpdatePost.jsp?bf_num=<%=foodpost.getBf_num()%>">수정하기</a> | 
						<a href="FoodDeletePost.jsp?bf_num=<%=foodpost.getBf_num()%>">삭제하기</a> <br>
					</tr>
				
			</table>
			
		</div>
		<% 
			}
			}
		//[1] [2] [3]
		for(int i=1; i<=viewData.getPageTotalCount(); i++){
		%>
		<ahref="boardmain.jsp?page=<%=i%>">[<%=i%>]</a>
		​
		<%
		}
			%>
	</div>
	

	
	<!-- contents 끝 -->


	<!-- footer 시작 -->
	<%@ include file="../frame/footer.jsp"%>
	<!-- footer 끝 -->

</body>

</html>


