<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="nav">
	<ul>
		<li><a href="<%= request.getContextPath() %>">홈</a></li>
		<li><a href="<%= request.getContextPath() %>/member/login.jsp">로그인</a></li>
		<li><a href="<%= request.getContextPath() %>/member/memberRegForm.jsp">회원가입</a></li>
		<li><a href="<%= request.getContextPath() %>/member/myPage.jsp">MyPage</a></li>
		<li><a href="<%= request.getContextPath() %>/member/memberlist.jsp">회원리스트</a></li>
		<li><a href="<%= request.getContextPath() %>/member/logout.jsp">LOGOUT</a></li>
	</ul>
</div>