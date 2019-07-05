

--16. SUBSTR �Լ��� ����Ͽ� ������� �Ի��� �⵵�� �Ի��� �޸� ����Ͻÿ�.
select SUBSTR(hiredate,1,5) as "�Ի���"
from emp
;



--17. SUBSTR �Լ��� ����Ͽ� 4���� �Ի��� ����� ����Ͻÿ�.
select *
from emp
where SUBSTR(hiredate,4,2) = 04
;



--18. MOD �Լ��� ����Ͽ� �����ȣ�� ¦���� ����� ����Ͻÿ�.
select *
from emp
where MOD(empno,2)=0
;


--19. �Ի����� �⵵�� 2�ڸ�(YY), ���� ����(MON)�� ǥ���ϰ� ������ ��� (DY)�� �����Ͽ� ����Ͻÿ�.
select TO_CHAR(hiredate, 'YY/MON/DY ') as "�Ի���"
from emp
;


--20. ���� �� ĥ�� �������� ����Ͻÿ�. ���糯¥���� ���� 1�� 1���� �� ����� ����ϰ� TO_DATE �Լ��� ����Ͽ� ������ ���� ��ġ ��Ű�ÿ�.
select trunc(sysdate-TO_DATE('2019/01/01', 'YYYY/MM/DD'))
from dual
;



--21. ������� ��� ����� ����ϵ� ����� ���� ����� ���ؼ��� NULL �� ��� 0���� ����Ͻÿ�.
select nvl(mgr, 0)
from emp
;

--22. DECODE �Լ��� ���޿� ���� �޿��� �λ��ϵ��� �Ͻÿ�. ������ ��ANALIST���� ����� 200, ��SALESMAN���� ����� 180, ��MANAGER���� ����� 150, ��CLERK���� ����� 100�� �λ��Ͻÿ�.
select ename, job, sal, 
        DECODE(job, 
                'ANALYST', sal+200,
                'SALESMAN', sal+180,
                'MANAGER', sal+150,
                'CLERK', sal+100
        ) as upsal
from emp
;

--23. ��� ����� �޿� �ְ��, ������, �Ѿ� �� ��� �޿��� ����Ͻÿ�. ��տ� ���ؼ��� ������ �ݿø��Ͻÿ�.
select max(sal) as "�ְ��", min(sal) as "������", sum(sal) as "�Ѿ�", round(avg(sal)) as "���"
from emp
;



--24. �� ��� ���� �������� �޿� �ְ��, ������, �Ѿ� �� ��� ���� ����Ͻÿ�. ��տ� ���ؼ��� ������ �ݿø� �Ͻÿ�.
select job, max(sal) as "�ְ��", min(sal) as "������", sum(sal) as "�Ѿ�", round(avg(sal)) as "���"
from emp
group by job
;



--25. COUNT(*) �Լ��� �̿��Ͽ� �������� ������ ��� ���� ����Ͻÿ�.
select job, count(*)
from emp
group by job
;




--26. ������ ���� �����Ͻÿ�.
select mgr, count(*)
from emp
group by mgr
;



--27. �޿� �ְ��, �޿� �������� ������ ����Ͻÿ�.
select max(sal) - min(sal) as "����"
from emp
;


select * from emp;
--28. ���޺� ����� ���� �޿��� ����Ͻÿ�. �����ڸ� �� �� ���� ����� ���� �޿��� 2000 �̸��� �׷��� ���ܽ�Ű�� ����� �޿��� ���� ������������ �����Ͽ� ����Ͻÿ�.
select job, min(sal)
from emp
where mgr is not null
group by job
having min(sal) > 2000
order by min(sal) desc
;



--29. �� �μ��� ���� �μ���ȣ, ��� ��, �μ� ���� ��� ����� ��� �޿��� ����Ͻÿ�. ��� �޿��� �Ҽ��� ��° �ڸ��� �ݿø� �Ͻÿ�.
select deptno as "�μ���ȣ", count(*) as "��� ��", trunc(avg(sal),2) as "��� �޿�" 
from emp
group by deptno
;


--30. �� �μ��� ���� �μ���ȣ �̸�, ���� ��, ��� ��, �μ����� ��� ����� ��� �޿��� ����Ͻÿ�. ��� �޿��� ������ �ݿø� �Ͻÿ�. DECODE ���.
select deptno,
        DECODE(deptno, 
                '10', 'ACCOUNTING',
                '20', 'RESEARCH',
                '30', 'SALES',
                '40', 'OPERATIONS'
        ) as dname,
        DECODE(deptno, 
                '10', 'NEW YORK',
                '20', 'DALLAS',
                '30', 'CHICAGO',
                '40', 'BOSTON'
        ) as loc,
        count(*) as "��� ��", 
        round(avg(sal)) as "��ձ޿�"
from emp
group by deptno
;



--31. ������ ǥ���� ���� �ش� ������ ���� �μ� ��ȣ�� �޿� �� �μ� 10, 20, 30�� �޿� �Ѿ��� ���� ����Ͻÿ�. ��Ī�� �� job, dno, �μ� 10, �μ� 20, �μ� 30, �Ѿ����� �����Ͻÿ�. ( hint. Decode, group by )
select job, deptno as dno, 
        DECODE(deptno, '10', sum(sal)) as "�μ� 10",
        DECODE(deptno, '20', sum(sal)) as "�μ� 20",
        DECODE(deptno, '30', sum(sal)) as "�μ� 30",
        sum(sal) as "�Ѿ�"
from emp
group by job, deptno
order by deptno asc
;