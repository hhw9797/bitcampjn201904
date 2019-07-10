-- 2019.07.08

-- 부속질의 2

-- 고객 이름별 구매 총금액을 출력
select custid, (
        select name from customer 
        where orders.custid = customer.custid
        ) as 고객이름, sum(saleprice) as 구매총액
from orders
group by custid
;


-- JOIN 처리
select o.custid, c.name, sum(o.saleprice) as 구매총금액
from orders o join customer c
on o.custid = c.custid
group  by o.custid, c.name
order by o.custid
;


-- 인라인 뷰
select * from customer where custid <= 2;

select *
from (select * from customer where custid <= 2) c, orders o
where c.custid = o.custid
;


-- row num
select rownum, empno
from emp
order by ename
;
select rownum, empno, ename
from (select * from emp order by ename) -- abc 순으로 row num을 만들어 냄
;


-- 평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 출력
select avg(saleprice)
from orders;
--11800

select orderid, saleprice
from orders
where saleprice <= 11800
;
select orderid, saleprice
from orders
where saleprice <= (
        select avg(saleprice)
        from orders
);

-- 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 주문번호, 고객번호, 금액을 출력
select avg(saleprice)
from orders
;
select orderid, custid, saleprice
from orders od
where saleprice > (
                    select avg(saleprice)
                    from orders so
                    where od.custid=so.custid
);


-- 대한민국에 거주하는 고객에게 판매한 도서의 총판매액을 구하시오.
-- IN 중첩질의
select sum(saleprice) as 총판매금액
from orders
where custid IN (
                select custid
                from customer
                where address like '%대한민국%'
);
-- JOIN
select sum(saleprice) as 총판매금액
from orders o join customer c
on o.custid=c.custid and c.address like '%대한민국%'
;


-- 3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한 주문의 주문번호와 금액을 보이시오.
-- 최대 값보다 큰 값 찾기
select orderid, saleprice
from orders
where saleprice > all (
                    select saleprice
                    from orders
                    where custid=3
);

select orderid, saleprice
from orders
where saleprice > (
                    select max(saleprice)
                    from orders
                    where custid=3
);


-- EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.
select sum(o.saleprice)
from orders o
where exists (
            select *
            from customer c
            where o.custid=c.custid and c.address like '%대한민국%'
);



---------------------------------------------------------------------------------------------
-- DML
---------------------------------------------------------------------------------------------

-- 데이터 입력 : INSERT INTO 테이블 명 (컬럼 리스트..) VALUES (입력 데이터 리스트..)

-- 테이블 삭제
drop table dept01;

-- 테이블 생성
create table dept01
as
select * from dept where 1=0
;

desc dept01;

-- 데이터 입력
insert into dept01 
(deptno, dname, loc) 
values 
(10, 'accounting', 'newyork')
;
select * from dept01;

desc dept01;
insert into dept01
values (20, 'research', 'dallas')
;
select * from dept01;

-- null 값의 입력
-- 암묵적/암시적 방법
-- 컬럼을 빼고 입력
insert into dept01
(deptno, dname)
values (30, 'sales')
;
select * from dept01;

insert into dept01
values (40, 'operations', null)
;
select * from dept01;

insert into dept01
values (50, '', null)
;
select * from dept01;

insert into dept01
select * from dept
;

-- 데이터의 수정
-- : UPDATE 테이블 이름 SET 컬럼이름=변경데이터 , 컬럼이름=변경데이터, ...
-- : WHERE 변경하고자하는 행을 찾기 위한 조건

drop table emp01;
create table emp01
as
select * from emp;

desc emp01;
select * from emp01;

update emp01
set deptno=30
;
update emp01
set sal= sal * 1.1
;
update emp01
set hiredate= sysdate
;

-- where 절을 이용한 특정 행의 데이터 변경
-- 부서번호가 10번인 사원의 부서번호를 30번으로 수정
update emp01
set deptno=30
where deptno=10
;
select * from emp01;

-- 급여가 3000이상인 사원만 급여를 10% 인상
update emp01
set sal=sal*1.1
where sal >= 3000
;

-- 1987년에 입사한 사원의 입사일이 오늘로 수정합시다.
-- 사원의 입사일을 오늘로 수정한 후에 테이블 내용을 살펴봅시다.
update emp01
set hiredate=sysdate
where substr(hiredate,1,2)='87'
;


-- SCOTT 사원의 부서번호는 20번으로, 직급은 MANAGER로 한꺼번에 수정하도록 합시다.
update emp01
set deptno='20', job='MANAGER'
where ename='SCOTT'
;
select * from emp01;
-- SCOTT 사원의 입사일자는 오늘로, 급여를 50 으로 커미션을 4000 으로 수정합시다.
update emp01
set hiredate=sysdate, sal=50, comm=4000
where ename='SCOTT'
;


select * from dept01;

drop table dept01;
create table dept01
as
select * from dept
;

-- 20번 부서의 지역명을 40번 부서의 지역명으로 변경하기 위해서 서브 쿼리문을 사용해 봅시다.
update dept01
set loc=(                       -- 스칼라 부속질의 : 단일행/단일열
        select loc
        from dept01
        where deptno=40
        )
where deptno=20
;
select * from dept01;

-- 부서번호가 20인 부서의 부서명과 지역명을 부서 번호가 40번인 부서와 동일하게 변경
update dept01
set (dname, loc) = (
                    select dname, loc
                    from dept
                    where deptno=40
                    )
where deptno=20
;


-- 데이터 삭제 ㅣ DELETE FROM 테이블 이름 WHERE 조건
-- 조건에 해당하는 행을 삭제

select * from dept01;
-- 전체 행을 삭제
delete from dept01;

drop table dept01;
create table dept01
as
select * from dept;

-- 특정행을 삭제한다. WHERE 절에서 특정 행을 찾는 조건을 기술
delete from dept01
where deptno=30
;
select * from dept01;

delete from emp
where ename='HYEWON'
;

-------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------
desc memberinfo;
--IDX      NOT NULL NUMBER(7)    
--U_ID     NOT NULL VARCHAR2(12) 
--U_PW     NOT NULL VARCHAR2(16) 
--U_NAME   NOT NULL VARCHAR2(10) 
--U_PHOTO           VARCHAR2(30) 
--R_EGDATE          DATE         
select * from memberinfo;

-- 회원 가입시 증가하는 IDX 값을 위한 sequence 생성
create sequence memberinfo_idx_seq;

-- 회원가입
insert into memberinfo (idx, u_id, u_pw, u_name, u_photo, r_egdate) 
values (memberinfo_idx_seq.nextval, 'hhw9797', '1234', '한혜원', 'hhw.jpg','2019/07/08');

insert into memberinfo (idx, u_id, u_pw, u_name, u_photo, r_egdate) 
values (memberinfo_idx_seq.nextval, 'yumi', '1111', '유미', 'yumi.jpg','2019/07/08');

insert into memberinfo (idx, u_id, u_pw, u_name, u_photo) 
values (memberinfo_idx_seq.nextval, 'love', '2222', '사랑세포', 'love.jpg');

insert into memberinfo (idx, u_id, u_pw, u_name) 
values (memberinfo_idx_seq.nextval, 'foodlove', '3333', '출출이');

insert into memberinfo (idx, u_id, u_pw, u_name, u_photo, r_egdate) 
values (memberinfo_idx_seq.nextval, 'snoopy', '4444', '스누피', '','1995/01/01');



update memberinfo
set r_egdate = '14/09/07' where u_id='yumi';

update memberinfo
set r_egdate='', u_photo='HEART.png'
where u_id='love'
;

delete from memberinfo where idx=4;

delete from memberinfo;

commit; -- 물리적인 저장
ROLLBACK;


-------------------------------------------------------------------------------------
-- VIEW : 사용자에게 보여주는 가상 테이블
--        특정 컬럼을 제외하거나 복잡한 sql 문을 간소화 시킨다.
-------------------------------------------------------------------------------------

-- VIEW 생성 : CREATE VIEW 뷰 이름 AS 서브쿼리
create view emp_view30
as
select empno,ename,deptno 
from emp
where deptno=30
;

select empno, ename, deptno from emp where deptno=30;
select * from emp_view30;


-- 인라인뷰
-- 사원 중에서 입사일이 빠른 사람 5명(TOP-5)만을 얻어 오는 질의문을 작성해 봅시다.

select rownum, empno, ename, hiredate from emp order by hiredate;

select rownum, empno, ename, hiredate
from (
    select rownum, empno, ename, hiredate from emp order by hiredate
)
where rownum <=5
order by hiredate
;-- LIMIT 0, 5

select * from emp limit 0,5; -- MY SQL

create or replace view emp_view_hd
as
select empno, ename, hiredate from emp order by hiredate
;

select rownum, empno, ename, hiredate
from emp_view_hd
where rownum <=5
order by hiredate
;



-------------------------------------------------------------------------------------
-- SEQUENCE : 자동 숫자 증가처리해주는 객체
-------------------------------------------------------------------------------------
create sequence test_seq
start with 10
increment by 10
;

drop sequence test_seq;

select test_seq.nextval from dual;
select test_seq.currval from dual;

desc dept01;
select * from dept01;

insert into dept01 values (test_seq.nextval, 'DESIGN', 'SEOUL');
delete from dept01;


select * from dept;
select * from emp;

insert into dept values (60, 'Design', 'SEOUL');

delete from dept where deptno=60;

commit;

select * 
from emp e, dept d
where e.deptno = d.deptno;