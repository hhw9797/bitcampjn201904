<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME::Share Hobby!</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link href="/sh/css/default_css.css" rel="stylesheet" type="text/css">
<style></style>

</head>
<body>

	<!-- nav 시작 -->
	<%@ include file="../frame/nav.jsp"%>
	<!-- nav 끝 -->

	<!-- header 시작 -->
	<%@ include file="../frame/header.jsp"%>
	<!-- header 끝 -->
	<div>
		<h1>맛집 소개</h1>
		<hr>
		<h3>식당이름</h3>
		<a href="FoodWritePost.jsp">맛집 리뷰하기</a> | <a href="FoodListPost">맛집 리뷰글 보기</a>
		<hr>
	</div>


	<!-- contents 시작 -->

	<!-- contents 끝 -->


	<!-- footer 시작 -->
	<%@ include file="../frame/footer.jsp"%>
	<!-- footer 끝 -->
</body>
</html>
