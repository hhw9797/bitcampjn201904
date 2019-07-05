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

-- �μ��� ��� �޿��� 2000 �̻��� �μ��� ���
select deptno, sum(sal), round(avg(sal)), count(*), count(comm), max(sal), min(sal)
from emp
group by deptno
having avg(sal) >= 2000
;

-- �μ��� �ִ�޿��� 2900 �̻��� �μ��� ���
select deptno, sum(sal), round(avg(sal)), count(*), count(comm), max(sal), min(sal)
from emp
group by deptno
having max(sal) >= 2900
;




--------------------------------------------------------------------------------------------
-- JOIN : 2�� �̻��� ���̺� ������ ���δ�. -> ǥ���ϴ� �÷��� �þ��.
--------------------------------------------------------------------------------------------

-- ���̺��� ���δ�. CROSS JOIN
select *
from emp, dept
where emp.deptno = dept.deptno
;

-- �̸��� 'SCOTT'�� ����� �̸��� �μ��̸��� �������
select ename, dname, emp.deptno
from emp, dept
where emp.deptno = dept.deptno and ename='SCOTT'
;

-- �ֹ� ���̺��� ȸ���� �̸���, �ֹ� ������ ����غ���
select o.orderid, c.name
from orders o, customer c
where o.custid = c.custid and name='������'
;

select *
from emp e, dept d
where e.deptno = d.deptno
;

-- customer, book, orders
select *
from orders o, customer c, book b
where o.custid=c.custid and b.bookid=o.bookid
;

-- ������ ���� �ֹ��� å�� �̸��� ���
select b.bookname, b.publisher
from customer c, orders o, book b
where c.custid=o.custid and o.bookid=b.bookid and c.name='������'
;

select *
from salgrade
;

select ename, sal, s.grade
from emp e, salgrade s
where sal between s.losal and s.hisal 
        and ename='SCOTT'
;

select e.ename || '�� �Ŵ����� ' || m.ename || ' �Դϴ�.'
from emp e, emp m
where e.mgr=m.empno(+)
order by m.ename
;

select e.empno, e.ename, e.mgr, m.ename
from emp e, emp m
where e.mgr=m.empno(+)
;

-- ANSI CROSS JOIN
select *
from emp cross join dept
;

select * 
from emp, dept
;

-- ANSI INNER JOIN
select *
from emp inner join dept
on emp.deptno=dept.deptno
;

select *
from emp join dept
on emp.deptno=dept.deptno
;

select *
from emp join dept
USING (deptno)
;

select e.ename, m.ename
from emp e left outer join emp m
on e.mgr = m. empno
;

select *
from customer
;
select distinct(custid)
from orders
;

select *
from orders o, customer c
where o.custid(+)=c.custid
;

select *
from orders o right outer join customer c
on o.custid=c.custid
;