-- 2019.07.08

-- �μ����� 2

-- �� �̸��� ���� �ѱݾ��� ���
select custid, (
        select name from customer 
        where orders.custid = customer.custid
        ) as ���̸�, sum(saleprice) as �����Ѿ�
from orders
group by custid
;


-- JOIN ó��
select o.custid, c.name, sum(o.saleprice) as �����ѱݾ�
from orders o join customer c
on o.custid = c.custid
group  by o.custid, c.name
order by o.custid
;


-- �ζ��� ��
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
from (select * from emp order by ename) -- abc ������ row num�� ����� ��
;


-- ��� �ֹ��ݾ� ������ �ֹ��� ���ؼ� �ֹ���ȣ�� �ݾ��� ���
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

-- �� ���� ��� �ֹ��ݾ׺��� ū �ݾ��� �ֹ� ������ ���ؼ� �ֹ���ȣ, ����ȣ, �ݾ��� ���
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


-- ���ѹα��� �����ϴ� ������ �Ǹ��� ������ ���Ǹž��� ���Ͻÿ�.
-- IN ��ø����
select sum(saleprice) as ���Ǹűݾ�
from orders
where custid IN (
                select custid
                from customer
                where address like '%���ѹα�%'
);
-- JOIN
select sum(saleprice) as ���Ǹűݾ�
from orders o join customer c
on o.custid=c.custid and c.address like '%���ѹα�%'
;


-- 3�� ���� �ֹ��� ������ �ְ� �ݾ׺��� �� ��� ������ ������ �ֹ��� �ֹ���ȣ�� �ݾ��� ���̽ÿ�.
-- �ִ� ������ ū �� ã��
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


-- EXISTS �����ڷ� ���ѹα��� �����ϴ� ������ �Ǹ��� ������ �� �Ǹž��� ���Ͻÿ�.
select sum(o.saleprice)
from orders o
where exists (
            select *
            from customer c
            where o.custid=c.custid and c.address like '%���ѹα�%'
);



---------------------------------------------------------------------------------------------
-- DML
---------------------------------------------------------------------------------------------

-- ������ �Է� : INSERT INTO ���̺� �� (�÷� ����Ʈ..) VALUES (�Է� ������ ����Ʈ..)

-- ���̺� ����
drop table dept01;

-- ���̺� ����
create table dept01
as
select * from dept where 1=0
;

desc dept01;

-- ������ �Է�
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

-- null ���� �Է�
-- �Ϲ���/�Ͻ��� ���
-- �÷��� ���� �Է�
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

-- �������� ����
-- : UPDATE ���̺� �̸� SET �÷��̸�=���浥���� , �÷��̸�=���浥����, ...
-- : WHERE �����ϰ����ϴ� ���� ã�� ���� ����

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

-- where ���� �̿��� Ư�� ���� ������ ����
-- �μ���ȣ�� 10���� ����� �μ���ȣ�� 30������ ����
update emp01
set deptno=30
where deptno=10
;
select * from emp01;

-- �޿��� 3000�̻��� ����� �޿��� 10% �λ�
update emp01
set sal=sal*1.1
where sal >= 3000
;

-- 1987�⿡ �Ի��� ����� �Ի����� ���÷� �����սô�.
-- ����� �Ի����� ���÷� ������ �Ŀ� ���̺� ������ ���캾�ô�.
update emp01
set hiredate=sysdate
where substr(hiredate,1,2)='87'
;


-- SCOTT ����� �μ���ȣ�� 20������, ������ MANAGER�� �Ѳ����� �����ϵ��� �սô�.
update emp01
set deptno='20', job='MANAGER'
where ename='SCOTT'
;
select * from emp01;
-- SCOTT ����� �Ի����ڴ� ���÷�, �޿��� 50 ���� Ŀ�̼��� 4000 ���� �����սô�.
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

-- 20�� �μ��� �������� 40�� �μ��� ���������� �����ϱ� ���ؼ� ���� �������� ����� ���ô�.
update dept01
set loc=(                       -- ��Į�� �μ����� : ������/���Ͽ�
        select loc
        from dept01
        where deptno=40
        )
where deptno=20
;
select * from dept01;

-- �μ���ȣ�� 20�� �μ��� �μ���� �������� �μ� ��ȣ�� 40���� �μ��� �����ϰ� ����
update dept01
set (dname, loc) = (
                    select dname, loc
                    from dept
                    where deptno=40
                    )
where deptno=20
;


-- ������ ���� �� DELETE FROM ���̺� �̸� WHERE ����
-- ���ǿ� �ش��ϴ� ���� ����

select * from dept01;
-- ��ü ���� ����
delete from dept01;

drop table dept01;
create table dept01
as
select * from dept;

-- Ư������ �����Ѵ�. WHERE ������ Ư�� ���� ã�� ������ ���
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

-- ȸ�� ���Խ� �����ϴ� IDX ���� ���� sequence ����
create sequence memberinfo_idx_seq;

-- ȸ������
insert into memberinfo (idx, u_id, u_pw, u_name, u_photo, r_egdate) 
values (memberinfo_idx_seq.nextval, 'hhw9797', '1234', '������', 'hhw.jpg','2019/07/08');

insert into memberinfo (idx, u_id, u_pw, u_name, u_photo, r_egdate) 
values (memberinfo_idx_seq.nextval, 'yumi', '1111', '����', 'yumi.jpg','2019/07/08');

insert into memberinfo (idx, u_id, u_pw, u_name, u_photo) 
values (memberinfo_idx_seq.nextval, 'love', '2222', '�������', 'love.jpg');

insert into memberinfo (idx, u_id, u_pw, u_name) 
values (memberinfo_idx_seq.nextval, 'foodlove', '3333', '������');

insert into memberinfo (idx, u_id, u_pw, u_name, u_photo, r_egdate) 
values (memberinfo_idx_seq.nextval, 'snoopy', '4444', '������', '','1995/01/01');



update memberinfo
set r_egdate = '14/09/07' where u_id='yumi';

update memberinfo
set r_egdate='', u_photo='HEART.png'
where u_id='love'
;

delete from memberinfo where idx=4;

delete from memberinfo;

commit; -- �������� ����
ROLLBACK;


-------------------------------------------------------------------------------------
-- VIEW : ����ڿ��� �����ִ� ���� ���̺�
--        Ư�� �÷��� �����ϰų� ������ sql ���� ����ȭ ��Ų��.
-------------------------------------------------------------------------------------

-- VIEW ���� : CREATE VIEW �� �̸� AS ��������
create view emp_view30
as
select empno,ename,deptno 
from emp
where deptno=30
;

select empno, ename, deptno from emp where deptno=30;
select * from emp_view30;


-- �ζ��κ�
-- ��� �߿��� �Ի����� ���� ��� 5��(TOP-5)���� ��� ���� ���ǹ��� �ۼ��� ���ô�.

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
-- SEQUENCE : �ڵ� ���� ����ó�����ִ� ��ü
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