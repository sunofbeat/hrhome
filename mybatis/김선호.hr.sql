-- using user 'system'
-- mybatis�� ���õ� ����, ��Ű��,��ü���� �ѹ��� ���ش�.
drop user mybatis cascade;

--����] mybatis/mybatis user�� ������.
create user hr2 identified by hr2 default tablespace users;
grant connect, resource to hr2;


create table hr2.users(
    worker_id number(2),
    worker_name varchar2(10),
    reg_date date);
    
    
alter table hr2.users
    add constraint worker_workerid_pk primary key(worker_id);
   
 insert into workers values
    
    
commit;
insert into workers values(1, 'sun',  to_date('2025/12/21'));
rollback;
-- sqlplus�� �̿��� ����
-- 1. cmd���� �ش� dir�� �̵�
-- 2. sqlplus -s (����/��й�ȣ) < (��������.sql) �Է�