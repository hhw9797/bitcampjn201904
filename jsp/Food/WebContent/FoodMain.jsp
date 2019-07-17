<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOBBY - 맛집</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>

</style>
</head>
<body>
	
	<h3>맛집 소개</h3>
	<hr>
	<form action="writeReview.jsp" method="post">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>식당번호</td>
				<td><input type="text" name="num"></td>
			</tr>
			<tr>
				<td>평점</td>
				<td><input type="text" name="star"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="100" name="post"></textarea></td>
			</tr>
			<tr>
				<td>사진첨부</td>
				<td><input type="file" name="photo"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록"></td>
			</tr>
		</table>
	</form>
	<hr>
</html>