-- 2019.07.05

-- 서브쿼리

-- SCOTT 사원이 소속된 -> 서브쿼리
-- 부서 이름을 출력 -> 메인 쿼리
select *
from dept
where deptno = (
                select deptno
                from emp
                where ename='SCOTT'
                )
;
select deptno
from emp
where ename='SCOTT'
;

-- 사원들중 평균 급여보다 많은 급여를 받는 사원의 이름과 급여를 출력해보자
select ename, sal
from emp
where sal > (
            select round(avg(sal))
            from emp
            )
;

-- 급여가 3000 이상인 사원의 소속 부서
-- 해당 부서에 근무하는 사원의 리스트
select ename
from emp
where deptno in ( -- 20, 10, 20
                select deptno
                from emp
                where sal >= 3000
                )
;



select ename, sal
from emp
where sal > all(
                select sal
                from emp
                where deptno=30
                )
;

select ename, sal
from emp
where sal > any(
                select sal
                from emp
                where deptno=30
                )
;

-- 인라인 뷰 : from 절 뒤에 서브쿼리가 위치
select empno, ename
from (
        select  empno, ename, job, hiredate
        from emp
     )
;

select ename, deptno, (
                select dname 
                from dept 
                where dept.deptno=emp.deptno
                )
from emp
;

--------------------------------------------------
-- DDL
--------------------------------------------------

-- CREATE TABLE : 테이블 생성 ( 데이터 저장 규칙을 정의 )
-- 컬럼 이름, 저장 데이터의 타입, 저장 데이터 사이즈, 제약조건
-- null 유무 확인
-- 중복 여부 확인 (unique)
-- 기본값
-- 체크
-- 기본키
-- 외래키

-- CREATE TABLE : 컬럼을 직접 설정
create table emp01 ( -- 테이블 이름은 emp01 로 만든다.
    empno number(4), -- 컬럼이름이 empno인 저장공간을 만든다. 숫자타입, 4자리
    ename varchar2(20), -- 컬럼 이름이 ename, 가변문자타입, 20자리
    sal number(7,2) -- 컬럼 이름이 sal, 숫자타입, 7자리, 7자리 중 뒤 2자리는 소수표현
)
;

-- CREATE TABLE : 서브 쿼리를 이용하는 방법
create table emp02
AS
select * from emp
;

desc emp02; -- 제약조건은 복사되지 않음

create table emp03
as
select empno, ename, job, hiredate from emp
;

desc emp03;

create table emp04
as
select * from emp where deptno=20
;
select * from emp04;

create table emp05
as
select * from emp where 1=2
;
select * from emp05;

-- MEMBERINFO 테이블 생성
-- 대리키 : idx                        - 기본키
-- 아이디 : 6~12 자리 문자열            - not null, unique
-- 이름 : 10자리 문자열                 - not null
-- 사진경로(파일이름) : 30자리 문자열     - not null
-- 가입날짜 : 날짜타입
create table memberinfo (             -- default sysdate
    u_id varchar2(12),
    u_pw varchar2(16),
    u_name varchar2(20),
    u_photo varchar2(30),
    r_egdate date
);

drop table memberinfo;

-- 테이블의 구조를 수정하는 명령 : ALTER TABLE
-- 컬럼의 추가, 컬럼의 수정, 컬럼의 삭제

desc emp01;

-- alter table 테이블이름 add 컬럼이름
alter table emp01
add (job VARCHAR2(9));

-- alter table 테이블이름 modify (컬럼정의)
alter table emp01
modify (job varchar2(30));

-- alter table 테이블이름 drop 컬럼이름
alter table emp01
drop (job);

select * from emp02;
truncate table emp02;

rename emp02 to test;
desc emp02;
select * from emp02;
desc test;

-- 제약 조건 적용
create table emp06 (
    empno number(4) not null,
    ename varchar2(20),
    sal number(7,2)
    )
;
desc emp06;    

--INSERT INTO 테이블 이름 (컬럼리스트) VALUES (값, 값, 값...)
insert into emp06 (empno, ename) values (null, null); -- empno에 not null 지정해줬기 때문에 오류발생
insert into emp06 (empno, ename) values (2011, null); -- ename과 sal에 null값 출력
select * from emp06;

insert into emp06 (empno, ename) values (2011, 'king');
insert into emp06 (empno, ename) values (2012, 'king');
insert into emp06 (empno, ename, sal) values (2012, 'king', 4000);

drop table emp06;
create table emp06 (
    empno number(4) primary key,
    ename varchar2(20) not null,
    sal number(7,2) default 1000, -- sal 값을 따로 지정하지 않으면 null. default 값 지정하면 1000이 출력됨
    grade number(1) check (grade between 1 and 5),
    gender char(1) check (gender in ('M','W')),
    deptno number(2),
    foreign key (deptno) REFERENCES dept(deptno)
    )
;
desc emp06;
insert into emp06 values (1000, 'king', null, 5, 'M',30);
insert into emp06 values (1001, 'king', null, 5, 'M',40);
select * from emp06;


create table emp07 (
    empno number(4) constraint emp07_empno_nn not null,
    ename varchar2(10) constraint emp07_ename_nn not null,
    job varchar2(9),
    deptno number(2),
    constraint emp07_empno_pk primary key (empno),
    constraint emp07_job_uk unique (job),
    constraint emp07_deptno_fk foreign key (deptno) references dept(deptno)
    );
    
-- MEMBERINFO 테이블 생성
-- 대리키 : idx                        - 기본키
-- 아이디 : 6~12 자리 문자열            - not null, unique
-- 비밀번호 : 8~16자리 문자열           - not null
-- 이름 : 10자리 문자열                 - not null
-- 사진경로(파일이름) : 30자리 문자열     
-- 가입날짜 : 날짜타입
create table memberinfo (             -- default sysdate
    idx number(7),
    u_id varchar2(12) constraint memberinfo_u_id_nn not null,
    u_pw varchar2(16) constraint memberinfo_u_pw_nn not null,
    u_name varchar2(10) constraint memberinfo_u_name_nn not null,
    u_photo varchar2(30),
    r_egdate date default sysdate,
    constraint memberinfo_idx_pk primary key (idx),
    constraint memberinfo_u_id_uk unique (u_id)
);

