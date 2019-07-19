<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:setProperty property="*" name="member" />
<%	
	Connection conn = null;
	PreparedStatement pstmt = null;
	int resultCnt = 0;
	
	try{
		// 데이터베이스 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		
		String sql = "insert into emp (empno,ename,job,deptno) values (?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, member.getEmpno());
		pstmt.setString(2, member.getEname());
		pstmt.setString(3, member.getJob());
		pstmt.setInt(4, member.getDeptno());
		
		resultCnt = pstmt.executeUpdate();
	} catch(ClassNotFoundException ce) {
		
	} catch(SQLException se){
		
	} finally {
		if(conn!=null){
			try{
				conn.close();
			} catch(SQLException e) {
				
			}
		}
		
		if(pstmt!=null){
			try{
				pstmt.close();
			} catch(SQLException e){
				
			}
		}
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>

</style>
</head>
<body>
	<h1>사원 정보 등록</h1>
	<hr>
	<h3> <%= resultCnt %>명의 사원의 정보가 등록되었습니다.</h3>
		<a href="empList.jsp">EMP LIST</a>
	
</body>
</html>