-- using user 'system'
-- mybatis에 관련된 유저, 스키마,객체등을 한번에 없앤다.
drop user mybatis cascade;

--과제] mybatis/mybatis user를 만들어라.
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
-- sqlplus를 이용한 사용법
-- 1. cmd에서 해당 dir로 이동
-- 2. sqlplus -s (유저/비밀번호) < (실행파일.sql) 입력