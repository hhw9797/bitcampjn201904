<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="nav">

	<ul>
		<li><a href="../home">홈</a></li>
		<li><a href="<c:url value="/member/memberReg" />">회원가입</a></li>
		<li><a href="<c:url value="/member/memberLogin" />">로그인</a></li>
		<li><a href="<c:url value="/member/myPage" />">마이페이지</a></li>
		<li><a href="<c:url value="/member/guestbook" />">방명록</a></li>
		<li><a href="<c:url value="/member/logout" />">로그아웃</a></li>
	</ul>
	
</div>