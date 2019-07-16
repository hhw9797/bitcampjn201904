<%@page import="guestbook.exception.InvalidMessagePasswordException"%>
<%@page import="guestbook.exception.MessageNotFoundException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="guestbook.service.DeleteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	int messageId = Integer.parseInt(request.getParameter("messageId"));
	String password = request.getParameter("password"); 
	
	//성공여부 cnt
	int resultCnt = 0;
	//성공여부
	boolean chk = false;
	//예외가 발생했을때 띄울 메세지
	String msg = "";
	
	//서비스 객체 생성
	DeleteMessageService service = DeleteMessageService.getInstance();
	
	try {
		resultCnt = service.deleteMessage(messageId, password);
		chk=true;
	} catch (SQLException e) {
		msg = e.getMessage();
	} catch (MessageNotFoundException e) {
		msg = e.getMessage();
	} catch (InvalidMessagePasswordException e) {
		msg = e.getMessage();
	}
	

%>
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
		<%
			//정상적인 처리
			if(chk) {
			
		%>
			<%= resultCnt %>개의 행이 삭제되었습니다.
		<%
			} else {
		%>
			<%= msg %>
		<%
			}
		%>
	</h1>
	<a href="list.jsp">리스트</a>
</body>
</html>