--drop user hr2 cascade;

create user hr2 identified by hr2 default tablespace users;

grant connect, resource to hr2;


create table hr2.workers(
    user_id number(2),
    user_name varchar2(10),
    reg_date date);
    
    
alter table hr2.workers
    add constraint user_userid_pk primary key(user_id);

commit;