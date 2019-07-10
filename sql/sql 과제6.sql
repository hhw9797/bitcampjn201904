--1 마당서점의 고객이 요구하는 다음 질문에 대해 SQL 문을 작성하시오.
select * from orders;
select * from customer;
select * from book;
--(5) 박지성이 구매한 도서의 출판사수
select count(b.publisher) as "구매도서 출판사 수"
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid and name='박지성'
;

--(6) 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이
select b.bookname as "도서의 이름", o.saleprice as "가격", (b.price - o.saleprice) as "정가와 판매가격의 차이"
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid  and c.name='박지성'
;
--(7) 박지성이 구매하지 않은 도서의 이름
select b.bookname
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid and c.name!='박지성'
;

--2 마당서점의 운영자와 경영자가 요구하는 다음질문에 대해 SQL 문을 작성하시오.
--(8) 주문하지 않은 고객의 이름(부속질의 사용)
select c.name
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid and c.custid not in (select distinct custid from orders)
;
--(9) 주문금액의 총액과 주문의 평균금액
select sum(saleprice) as "총액", avg(saleprice) as "평균금액"
from orders
;
--(10) 고객의 이름과 고객별 구매액
select c.name as "고객이름", sum(o.saleprice) as "고객별 구매액"
from customer c, orders o
where c.custid=o.custid
group by c.name
;

--(11) 고객의 이름과 고객이 구매한 도서목록
select c.name, b.bookname
from customer c, orders o, book b
where c.custid=o.custid and o.bookid=b.bookid
;
--(12) 도서의 가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문
select *
from order 
;
select max(b.price - o.saleprice)
from book b, orders o
where b.bookid=o.bookid
;

--(13) 도서의 판매액 평균보다 자신의 구매액평균이 더 높은 고객의 이름
select *
from orders o, customer c
where o.custid=c.custid 
group by c.name
having sum(o.saleprice) > all (select avg(price) from book)
;

--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름

4 다음 질의에 대해 DML 문을 작성하시오.
(1) 새로운 도서(‘스포츠세계’, ‘대한미디어’, 10000원)이 마당서점에 입고되었다.
    삽입이 안될 경우 필요한 데이터가 더 있는지 찾아보자.
(2) ‘삼성당’에서 출판한 도서를 삭제해야한다.
(3) ‘이상미디어’에서 출판한 도서를 삭제해야한다. 삭제가 안될경우 원인을 생각해보자.
(4) 출판사 ‘대한미디어’가 ‘대한출판사’로 이름을 바꾸었다.