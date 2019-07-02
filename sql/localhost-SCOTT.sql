-- 2019.07.02

-- ���̺��� �÷����� �����μӼ��� Ȯ��
-- ������ �Է� ��, ������ ���� ��
DESC dept;

-- �����͸� �˻��ϴ� ���
-- select {�÷� �̸�, ...} from ���̺� �̸�
select * from dept;
select deptno from dept;
select dname from dept;
select dname, loc, deptno from dept;

-- emp ���̺� Ȯ��
desc emp;
-- ��ü �÷� ���
select * from emp;

-- ����� ��ȣ, �̸��� ����Ʈ
select empno, ename from emp;

-- �÷��� ��Ģ����
select sal from emp;
select sal + comm from emp; -- null�� ������ ��� -> null
select sal, sal + 100 from emp;
select sal, sal - 100 from emp;
select ename, sal, sal * 12 from emp;
select sal, sal/5 from emp;

-- nvl �Լ� : Ư�� �÷��� �����Ͱ� null�� ��� Ư�� �����ͷ� ġȯ���ִ� �Լ�
-- nvl(�÷��̸�, ġȯ��)
select ename, sal, comm, sal*12+comm from emp;
select ename, sal, comm, sal*12+comm as ySall, nvl(comm,0), sal*12+nvl(comm,0) as ySal from emp;

-- �÷��� ���ڿ��� �����ϴ� ��� ���, sql���� ���ڿ� ǥ���� ' ' �� ���´�.
select ename ||' is a '|| job as str from emp;

-- distinct : �÷������� �ߺ��Ǵ� ���� �����ϰ� �ϳ��� �����͸� ������ش�.
select distinct deptno from emp;

-- select �� ������ : select �÷���.. from ���̺�� where ���ǽ�(true/false);
-- where �� ������ ���� ã�´�.
select dname
from dept
where deptno = 10
;

select empno, ename, job
from emp
where deptno = 10
;

-- ���� ���� ��� ���� ����ǥ�� ǥ��, ��ҹ��� ����!!!!!!!!!!!!!
select empno, JoB
from emp
where ename='SCOTT'
;

-- ��¥ �˻� : ��¥ �����͸� '' �� �����ش�.
SELECT ENAME, HIREDATE
FROM emp
WHERE HIREDATE >= '81/12/03'
;

-- �� ���� : AND, OR, NOT
select *
from emp
where deptno = 30 and job = 'MANAGER'
;
select *
from emp
where deptno = 10 or deptno = 20
;
select *
from emp
where not deptno = 30
;

-- BETWEEN A AND B ������ : A �̻� B ������ ���� ����
select *
from emp
--where sal between 2000 and 3000
where sal > 2000 and sal < 3000
;
-- ���� ������ ��¥ ���굵 �����ϴ�.
select *
from emp
where hiredate between '1987/01/01' and '1987/12/31'
;

-- IN ������ : or ������ ���� �� ���
select *
from emp
--where comm in(300,500,1400)
where comm=300 or comm=500 or comm=1400
;