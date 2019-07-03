-- 2019.07.03

--LIKE : ���� ���ϰ˻� ������ Ű����
-- �÷��� LIKE ����
-- ���� : % _

--% ������ �̿�
-- ��� ���̺��� 'S'�� �����ϴ� ����� �̸��� �˻�����
select ename
from emp
where ename like 'S%'
;
-- 'S'�� ������ �̸��� ���� ��� �˻�
select ename
from emp
where ename like '%S'
;
-- ����� �̸��� 'S'�� �����ϴ� �̸��� ���� ��� �˻�
select ename
from emp
where ename like '%S%'
;

-- _�����ڴ� �ڸ�(��ġ) ������ �ǹ� : �ش� �ڸ����� ��� ���� �͵� �������.
-- _A% : ���ڸ� ���ڴ� ��� ���ڿ��� ����, �ι�° ���ڴ� �ݵ�� A�� ����
-- _A_ : ���ڸ� ���� �� �ι�° ���ڴ� �ݵ帮 A�� ����
-- ����� �̸��߿� �ι�° ���ڿ� 'A'�� �����ϴ� �̸��� ���
select *
from emp
where ename like '__A%'
;

-- ����� �̸� �� 'A' �� �������� �ʴ� ������� �˻�
select *
from emp
where ename not like '%A%'
;


-- �÷��� ������ ���� null �� ���θ� Ȯ��
-- is null -> ���� null�� �� true, is not null -> ���� null�� �ƴ� �� true

-- Ŀ�̼��� ���� �ʴ� ���
select *
from emp
where comm is null or comm = 0
;
-- Ŀ�̼��� �޴� ���
select *
from emp
where not ( comm is null or comm = 0 )
;
select *
from emp
where comm is not null or comm > 0
;


-- ��� ���̺��� �ο�(��) ����
-- order by �÷��� [asc]/desc, �÷��� [asc]/desc

-- �޿��� ���� ������� �޿��� ���� ��� ������ ����
select *
from emp
order by sal --asc
;

-- �޿��� ���� ������� �޿��� ���� ��� ������ ����
select *
from emp
order by sal desc
;

-- �ֱ� �Ի��� ��� ������ ����� ����Ʈ ���
select *
from emp
order by hiredate desc
;

-- �޿� �������� �޿��� ���� ��� ������ ����, �޿��� ���� ����� ��� �̸� ������ ����
select ename, sal
from emp
order by sal desc, ename asc
;


----------------------------------------------------------------------------------
--�Լ�
----------------------------------------------------------------------------------

-- TO_CHAR
-- DATE -> STR
select sysdate as ��¥, TO_CHAR(sysdate, 'YYYY.MM.DD. HH24:MI:SS') as ��ȯ��¥
from dual
;

select hiredate, TO_CHAR(hiredate,'YYYY.MM.DD') as "date"
from emp
;

-- NUMBER > STR : TO_CHAR(����Ÿ��, '����')
select TO_CHAR(10000, 'L999,999')
from dual
;
select sal, TO_CHAR(sal, 'L999,999') as "�� �޿�", TO_CHAR(sal*12+nvl(comm,0), 'L999,999') as ����
from emp
;

-- TO_DATE(����, 'YYYYMMDD') -> date
select ename, hiredate, TO_DATE('19810220', 'YYYYMMDD')
from emp
where hiredate = TO_DATE(19810220, 'YYYYMMDD')
;

select sysdate, TO_DATE('1997/09/07', 'YYYY/MM/DD'), sysdate-TO_DATE('1997/09/07', 'YYYY/MM/DD'),
trunc(sysdate-TO_DATE('1997/09/07', 'YYYY/MM/DD'))
from dual
;

-- DECODE �Լ� : switch case ���İ� ����
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