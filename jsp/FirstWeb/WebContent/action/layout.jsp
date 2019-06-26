<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

String ctgy = request.getParameter("ctgy");

	//값이 안들어있다면 1로 설정
	if(ctgy == null){
		ctgy = "1";
	}
	
	//초기화값 2로 설정
	ctgy="2";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		margin: 0;
		padding: 0;
	}
	
	#main_wrap {
		border : 1px solid #ddd;
		width : 800px;
		padding : 10px;
		margin: 10px auto;
	}
	
	#wrap {
		overflow: hidden;
	}
	
	#wrap>div {
		float: left;
		padding: 10px;
	}
	
	#menu {
		width: 15%;
		background-color: orange;
		font-weight: bold;
		height: 200px;
	}
	
	#aside {
		width: 80%;
	}
	
	#footer {
		border: 1px solid #ddd;
		height: 50px;
	}
	
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<div id="main_wrap">
		<div id="header">
			<h1>title</h1>
		</div>
		<div id="wrap">
			<div id="menu">
				<jsp:include page="menu.jsp">
					<jsp:param value='<%= ctgy %>' name="ctgy"/>
				</jsp:include>
			</div>
			<div id="aside">
				contents
			</div>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>