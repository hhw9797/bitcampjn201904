--1 ���缭���� ���� �䱸�ϴ� ���� ������ ���� SQL ���� �ۼ��Ͻÿ�.
select * from orders;
select * from customer;
select * from book;
--(5) �������� ������ ������ ���ǻ��
select count(b.publisher) as "���ŵ��� ���ǻ� ��"
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid and name='������'
;

--(6) �������� ������ ������ �̸�, ����, ������ �ǸŰ����� ����
select b.bookname as "������ �̸�", o.saleprice as "����", (b.price - o.saleprice) as "������ �ǸŰ����� ����"
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid  and c.name='������'
;
--(7) �������� �������� ���� ������ �̸�
select b.bookname
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid and c.name!='������'
;

--2 ���缭���� ��ڿ� �濵�ڰ� �䱸�ϴ� ���������� ���� SQL ���� �ۼ��Ͻÿ�.
--(8) �ֹ����� ���� ���� �̸�(�μ����� ���)
select c.name
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid and c.custid not in (select distinct custid from orders)
;
--(9) �ֹ��ݾ��� �Ѿװ� �ֹ��� ��ձݾ�
select sum(saleprice) as "�Ѿ�", avg(saleprice) as "��ձݾ�"
from orders
;
--(10) ���� �̸��� ���� ���ž�
select c.name as "���̸�", sum(o.saleprice) as "���� ���ž�"
from customer c, orders o
where c.custid=o.custid
group by c.name
;

--(11) ���� �̸��� ���� ������ �������
select c.name, b.bookname
from customer c, orders o, book b
where c.custid=o.custid and o.bookid=b.bookid
;
--(12) ������ ����(Book ���̺�)�� �ǸŰ���(Orders ���̺�)�� ���̰� ���� ���� �ֹ�
select *
from order 
;
select max(b.price - o.saleprice)
from book b, orders o
where b.bookid=o.bookid
;

--(13) ������ �Ǹž� ��պ��� �ڽ��� ���ž������ �� ���� ���� �̸�
select *
from orders o, customer c
where o.custid=c.custid 
group by c.name
having sum(o.saleprice) > all (select avg(price) from book)
;

--3. ���缭������ ������ ��ȭ�� ������ ���� SQL ���� �ۼ��Ͻÿ�.
(1) �������� ������ ������ ���ǻ�� ���� ���ǻ翡�� ������ ������ ���� �̸�
(2) �� �� �̻��� ���� �ٸ� ���ǻ翡�� ������ ������ ���� �̸�

4 ���� ���ǿ� ���� DML ���� �ۼ��Ͻÿ�.
(1) ���ο� ����(�����������衯, �����ѹ̵�, 10000��)�� ���缭���� �԰�Ǿ���.
    ������ �ȵ� ��� �ʿ��� �����Ͱ� �� �ִ��� ã�ƺ���.
(2) ���Ｚ�硯���� ������ ������ �����ؾ��Ѵ�.
(3) ���̻�̵����� ������ ������ �����ؾ��Ѵ�. ������ �ȵɰ�� ������ �����غ���.
(4) ���ǻ� �����ѹ̵��� ���������ǻ硯�� �̸��� �ٲپ���.