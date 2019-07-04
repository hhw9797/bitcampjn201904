-- 2019.07.04

-- �׷��Լ�

-- SUM(�÷�) : �׷��� ���� ��ȯ

-- ��� ���̺��� ����� �� �޿�(sal)�� ������ ���غ���
select sum(sal) as "�� �ѱ޿�"
from emp
;

-- 10�� �μ� �Ҽ� �������� �� �޿� �Ѿ��� ���غ���
select sum(sal)
from emp
where deptno = 10
;

-- sum �Լ����� null �� ó����� : null ���� �����Ѵ�.
select sum(comm)
from emp
;
select comm from emp;

-- avg(�÷�) : �׷쿡 ���Ե� ������ ��հ��� ��ȯ
select avg(sal) as "��ü����� ��� ���޿�"
from emp
;
-- �׷��Լ��� ����� �������� �ϳ��� �÷�
select trunc(avg(sal)) as "��ü����� ��� ���޿�"
from emp
;
select trunc(avg(sal)) as "�Ŵ����� ��� ���޿�"
from emp
where job='MANAGER'
;

-- avg �Լ��� �÷��� ���� null �϶� �����ϰ� ó��
select avg(comm)
from emp
;

-- MAX(�÷�) : �ִ� ��ȯ, MIN(�÷�) : �ּڰ� ��ȯ
select max(sal) as "�ִ�޿�", min(sal) as "�ּұ޿�"
from emp
;

-- count(�÷�) : row�� ������ ��ȯ

-- ȸ�翡 �Ҽӵ� ����� ��
select count(*) as "��ü ����� ��"
from emp
;

-- 10�� �μ��� �Ҽӵ� ������ ��
select count(*)
from emp
where deptno = 10
;

-- Ŀ�̼��� �޴� ������ ��
select count(comm)
from emp
;

-- �μ��� ���� ������.
select count(*)
from dept
;
-- ������� �Ҽӵ� �μ��� ��
select count(distinct deptno)
from emp
;

select count(distinct job) as "���� ��"
from emp
;

-- grouop by �÷��̸� : row�� �׷��� �ؼ� ó��, �����Լ�(sum, avg, count..)
-- �÷��̸� -> �׷����� ����
select deptno, sum(sal), round(avg(sal)), count(*), count(comm), max(sal), min(sal)
from emp
group by deptno
;

-- ������ ��ǥ�� ����غ���
select job,count(*) as "������ ��", TO_CHAR(sum(sal), '999,999') as "�޿��� ����", round(avg(sal)) as "�޿��� ���", max(sal) as" �ִ�޿�", min(sal) as "�ּұ޿�"
from emp
group by job
;