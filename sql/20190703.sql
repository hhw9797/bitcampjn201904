-- 2019.07.03

--LIKE : 문자 패턴검색 연산자 키워드
-- 컬러명 LIKE 패턴
-- 패턴 : % _

--% 패턴을 이용
-- 사원 테이블에서 'S'로 시작하는 사원의 이름을 검색하자
select ename
from emp
where ename like 'S%'
;
-- 'S'로 끝나는 이름을 가진 사원 검색
select ename
from emp
where ename like '%S'
;
-- 사원의 이름에 'S'를 포함하는 이름을 가진 사원 검색
select ename
from emp
where ename like '%S%'
;

-- _연산자는 자리(위치) 고정을 의미 : 해당 자리에는 어떠한 값이 와도 상관없다.
-- _A% : 앞자리 문자는 어떠한 문자여도 무관, 두번째 문자는 반드시 A인 패턴
-- _A_ : 세자리 문자 중 두번째 문자는 반드리 A인 패턴
-- 사원의 이름중에 두번째 문자에 'A'를 포함하는 이름의 사원
select *
from emp
where ename like '__A%'
;

-- 사원의 이름 중 'A' 를 포함하지 않는 사원들을 검색
select *
from emp
where ename not like '%A%'
;


-- 컬럼의 데이터 값이 null 값 여부를 확인
-- is null -> 값이 null일 때 true, is not null -> 값이 null이 아닐 때 true

-- 커미션을 받지 않는 사원
select *
from emp
where comm is null or comm = 0
;
-- 커미션을 받는 사원
select *
from emp
where not ( comm is null or comm = 0 )
;
select *
from emp
where comm is not null or comm > 0
;


-- 결과 테이블의 로우(행) 정렬
-- order by 컬럼명 [asc]/desc, 컬럼명 [asc]/desc

-- 급여가 작은 사원부터 급여가 많은 사원 순으로 정렬
select *
from emp
order by sal --asc
;

-- 급여가 많은 사원부터 급여가 작은 사원 순으로 정렬
select *
from emp
order by sal desc
;

-- 최근 입사한 사원 순으로 사원의 리스트 출력
select *
from emp
order by hiredate desc
;

-- 급여 기준으로 급여가 많은 사람 순으로 정렬, 급여가 같은 사원의 경우 이름 순으로 정렬
select ename, sal
from emp
order by sal desc, ename asc
;


----------------------------------------------------------------------------------
--함수
----------------------------------------------------------------------------------

-- TO_CHAR
-- DATE -> STR
select sysdate as 날짜, TO_CHAR(sysdate, 'YYYY.MM.DD. HH24:MI:SS') as 변환날짜
from dual
;

select hiredate, TO_CHAR(hiredate,'YYYY.MM.DD') as "date"
from emp
;

-- NUMBER > STR : TO_CHAR(숫자타입, '패턴')
select TO_CHAR(10000, 'L999,999')
from dual
;
select sal, TO_CHAR(sal, 'L999,999') as "월 급여", TO_CHAR(sal*12+nvl(comm,0), 'L999,999') as 연봉
from emp
;

-- TO_DATE(원본, 'YYYYMMDD') -> date
select ename, hiredate, TO_DATE('19810220', 'YYYYMMDD')
from emp
where hiredate = TO_DATE(19810220, 'YYYYMMDD')
;

select sysdate, TO_DATE('1997/09/07', 'YYYY/MM/DD'), sysdate-TO_DATE('1997/09/07', 'YYYY/MM/DD'),
trunc(sysdate-TO_DATE('1997/09/07', 'YYYY/MM/DD'))
from dual
;

-- DECODE 함수 : switch case 형식과 유사
select ename, deptno, 
        DECODE(deptno, 
                    10, 'ACOUNTING',
                    20, 'RESEARCH',
                    30, 'SALES',
                    40, 'OPERATION') as DNAME
from emp
;

select ename, job, sal, 
        DECODE(job, 
                'ANALYST', sal*1.05,
                'SALESMAN', sal*1.1,
                'MANAGER', sal*1.15,
                'CLERK', sal*1.2
        ) as upsal
from emp
;

select DISTINCT job from emp;

select ename, deptno,

        case 
            when deptno=10 then 'ACOUNTING'
            when deptno=20 then 'RESEARCH'
            when deptno=30 then 'SALES'
            when deptno=40 then 'OPERATION'
            else 'no NAME'
        end as DNAME
from emp
;