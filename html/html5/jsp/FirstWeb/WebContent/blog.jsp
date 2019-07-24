<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link href="frame/blogstyle.css" rel="stylesheet" media="screen">

<style>
</style>

</head>
<body>
	<div id="main_wrap">
		<!-- header 시작 -->
		<%@ include file = "frame/header.jsp" %>
		<!-- header 끝 -->
		
		<!--nav 시작 -->
		<%@ include file = "frame/nav.jsp" %>
		<!--nav 끝 -->
		
		<!-- contents 시작 -->
		<div id="contnets">
		    <div id="content">
		        <article>
		            <h1 class="title">스누피</h1>
		            <span class="date">2019.06.05 14:55</span>
		            <img class="img" src="images/snoopy.gif">
		            <p>만화 피너츠의 캐릭터이자 세계에서 가장 유명한 개 캐릭터.</p>
		
		            <p>견종은 비글. 그래서인지 작중에서도 인간이 할 수 있는 일을 강아지의 몸으로 하기도 하는 만능 엔터테이너.</p>
		
		            <p>만화 피너츠의 진 주인공이며, 자신의 주인인 찰리 브라운보다도 더 유명해진 견공. 피너츠라는 만화 자체가 아주아주 처음 연재될 때는 찰리 브라운을 필두로 주변인들과 벌어지는 일들이 내용이었으나, 이제는 피너츠라는 만화 원래 이름보다 스누피라는 이름이 더 많이 알려져 한국 정식발매판에는 왠지 꼬박꼬박 스누피라는 이름으로만 알려졌었다. 그러다 90년대 후반에 원판 직번역본부터 피너츠라는 원래 이름을 쓰기 시작해서 그제서야 한국에 이름이 알려진 케이스로 그만큼 스누피는 피너츠라는 만화의 대명사이자 마스코트격 존재다.</p>
		
		            <p>원래 처음 주인공은 찰리 브라운이었고 따라서 스누피도 4차원 강아지가 아니라 그냥 평범한 비글견(!)이였다. 당연히 연재초반에는 4족보행이었다. 그러다가 가면 갈수록 지능도 생겨나고 대사도 생기더니 급기야는 2족보행까지 했다.</p>
		
		        </article>
		
		        <article>
		            <h1 class="title">찰리브라운</h1>
		            <span class="date">2019.06.05 14:55</span>
		            <img class="img" src="images/char.jpg">
		            <p>피너츠의 영원한 주인공. 만화에서의 공감요소와 재미의 대부분을 담당하고 있다. 일단 자신이 무슨 일을 시작해서 좋게 끝난 적이 거의 없으며 연 날리는 것조차 못한다. 밖에 나가면 아는 친구한테 갈굼당하지, 공감해 주는 사람(?)도 많지는 않는데다가 심지어는 공부도 제대로 못하는 비운의 주인공.</p>
		            <p>80년대 KBS-1TV 더빙판 (어깨동무 찰리 브라운)에서 성우는 송도영, 금성비디오 출시판 성우는 정경애[2] 극장판 스누피: 더 피너츠 무비에서는 아역배우 이종원이 맡았는데 평이 나쁘다. 참고로 이종원은 굿 다이노에서도 주인공 알로 목소리를 맡았는데 거기서도 평이 나빴다.</p>
		
		            <p>동그랗고 대머리같아 보이는 외모[3]에 그리고 검은 지그재그의 줄이 그려진 셔츠를 입고 있다. 그러나 대부분 인기나 유명세, 관련 상품들을 보면 자기 애완동물 스누피에게도 밀린다. 오히려 자기를 주인취급하지 않는 스누피를 어떻게든 잘 돌봐주려 노력하는 수준의 대인배.[4] 작가의 어린 시절을 모티브로 만들어진 캐릭터라고 한다. 후지코 F. 후지오가 자신의 어린 시절을 바탕으로 도라에몽의 안습캐 노진구를 만든 것과도 비슷한 맥락이다. 원본에서의 말버릇은 "Good grief" 등이 있다. 반대로 가장 많이 듣는 말은 "You blockhead!{이 멍청아!}"이다.</p>
		            <p>풀 네임은 찰스 "찰리" 브라운(Charles "Charlie" Brown)이다. 마시는 "찰스"라고 부르며, 페퍼민트 패티는 "척(Chuck)"이라고 부른다.</p>
		
		            
		        </article>
		
		    </div>
		</div>
		<!-- contents 끝 -->
		
		<!--aside 시작 -->
		<%@ include file = "frame/aside.jsp" %>
		<!--aside 끝 -->
		
		<!-- footer 시작 -->
		<%@ include file = "frame/footer.jsp" %>
		<!--footer 끝 -->
	</div>
</body>
</html>