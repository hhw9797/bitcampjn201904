<%@page import="foodPost.model.FoodPostListView"%>
<%@page import="foodPost.model.FoodPost"%>
<%@page import="foodPost.service.GetPostListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pageNumberstr = request.getParameter("page");
	
	//페이지 숫자
	int pageNumber = 1;
	
	if(pageNumberstr != null) {
		pageNumber = Integer.parseInt(pageNumberstr);
	}
	
	//핵심 처리할 서비스 객체
	GetPostListService service = GetPostListService.getInstance();
	
	//응답 데이터의 결과
	FoodPostListView viewData =service.getPostList(pageNumber);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOBBY - 맛집</title>
<style>
	div {
		border: 2px solid #333;
		margin: 5px 0px;
		width: 300px;
	}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>

	<h3>식당 리뷰 작성</h3>
	<hr>
	<form action="writeReview.jsp" method="post">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bf_title"></td>
			</tr>
			<tr>
				<td>식당번호</td>
				<td><input type="text" name="hf_num"></td>
			</tr>
			<tr>
				<td>평점</td>
				<td><input type="text" name="bf_star"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="100" name="bf_cont"></textarea></td>
			</tr>
			<tr>
				<td>사진첨부</td>
				<td><input type="file" name="bf_photo"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록"></td>
			</tr>
			<!-- <tr>
				<td>게시글번호</td>
				<td><input type="text" name="bf_num"></td>
			</tr>
			<tr>
				<td>회원번호</td>
				<td><input type="text" name="u_num"></td>
			</tr>
			<tr>
				<td>작성시간</td>
				<td><input type="text" name="bf_time"></td>
			</tr> -->
		</table>
	</form>
	<hr>

 	<%-- <%
		if(viewData.isEmpty()){
			%>
			<h3>등록된 메시지가 없습니다.</h3>
			<%
		} else {
			
			for( FoodPost foodpost : viewData.getPostList()){
			
			%>
				<div>
					게시글 번호 : <%= foodpost.getBf_num() %> <br>
					손님 이름 : <%= foodpost.getU_num() %><br>
					게시글 : <%= foodpost.getBf_cont() %> <br>
					<a href="confirmDeletion.jsp?postId=<%= foodpost.getBf_num() %>">삭제하기</a>
				</div>		
			<%
			}
		}
	//[1],[2],[3] 페이지 번호
	for(int i=1; i <= viewData.getPageTotalCount(); i++) {
		%>
			<a href="list.jsp?page=<%=i%>"> [ <%= i %> ] </a>
		<%
	}
	%> --%>

</body>
</html>