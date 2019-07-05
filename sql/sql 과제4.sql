--32. EQUI ������ ����Ͽ� SCOTT ����� �μ���ȣ�� �μ� �̸��� ����Ͻÿ�.
select d.deptno as "�μ���ȣ", d.dname as "�μ��̸�"
from emp e, dept d
where e.deptno=d.deptno and ename='SCOTT'
;

--33. INNER JOIN�� ON �����ڸ� ����Ͽ� ��� �̸��� �Բ� �� ����� �Ҽӵ� �μ��̸��� ���� ���� ����Ͻÿ�.
select e.ename as "����̸�", d.dname as "�μ��̸�", d.loc as "���� ��"
from emp e inner join dept d
on e.deptno=d.deptno
;

--36. ���ΰ� WildCARD�� ����Ͽ� �̸��� ��A���� ���Ե� ��� ����� �̸��� �μ����� ����Ͻÿ�.
select e.ename as "����̸�", d.dname as "�μ���"
from emp e, dept d
where e.deptno=d.deptno and e.ename like '%A%'
;

--37. JOIN�� �̿��Ͽ� NEW YORK�� �ٹ��ϴ� ��� ����� �̸�, ����, �μ���ȣ �� �μ����� ����Ͻÿ�.
select e.ename as "����̸�", e.job as "����", e.deptno as "�μ���ȣ", d.dname as "�μ���"
from emp e join dept d
on e.deptno=d.deptno and d.loc='NEW YORK'
;

--38. SELF JOIN�� ����Ͽ� ����� �̸� �� �����ȣ, ������ �̸��� ����Ͻÿ�.
select ename.ename as "����̸�", ename.empno as "�����ȣ", mname.ename as "������ �̸�"
from emp ename, emp mname
where ename.mgr=mname.empno
;

--39. OUTER JOIN, SELF JOIN�� ����Ͽ� �����ڰ� ���� ����� �����Ͽ� �����ȣ�� �������� �������� �����Ͽ� ����Ͻÿ�.
select *
from emp ename, emp mname
where ename.mgr=mname.empno(+)
order by mname.empno desc
;

--40. SELF JOIN�� ����Ͽ� ������ ����� �̸�, �μ���ȣ, ������ ����� ������ �μ����� �ٹ��ϴ� ����� ����Ͻÿ�. ( SCOTT )
select e.ename "�����ѻ���̸�", e.deptno "�μ���ȣ", m.ename "����̸�"
from emp e, emp m
where e.deptno = m.deptno and e.ename = 'SCOTT'
;
 
--41. SELF JOIN�� ����Ͽ� WARD ������� �ʰ� �Ի��� ����� �̸��� �Ի����� ����Ͻÿ�.
select m.ename "����̸�", m.hiredate "�Ի���"
from emp e, emp m
where e.hiredate < m.hiredate and e.ename = 'WARD'
;
 
--42. SELF JOIN �� ����Ͽ� �����ں��� ���� �Ի��� ��� ����� �̸� �� �Ի����� �������� �̸� �� �Ի��ϰ� �Բ� ����Ͻÿ�.
select m.ename "����̸�" , m.hiredate "��� �Ի���", e.ename "�������̸�", e.hiredate "������ �Ի���"
from emp e, emp m
where e.empno = m.mgr and e.hiredate > m.hiredate
;