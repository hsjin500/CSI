select * from clients

--drop table clients

create table clients (
client_id varchar2(12) not null,
client_pw varchar2(15) not null,
client_name varchar2(30) not null,
phone_number varchar2(30) not null,
client_email varchar2(50) not null,
signup_date date,
guard varchar2(3),
manager varchar2(7),
constraint client_id_pk primary key(client_id)
)

insert into clients VALUES ('hsjin500', 'hsjin500', 'È«¼ºÁø', '01011112222', 'imsun0101@naver.com',sysdate)
