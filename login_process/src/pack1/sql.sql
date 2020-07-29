select * from clients

drop table clients
---------사용자 테이블 생성 --------
create table clients (
client_id varchar2(12) not null,
client_pw varchar2(15) not null,
client_name varchar2(30) not null,
phone_number varchar2(30) not null,
client_email varchar2(50) not null,
signup_date date,
id_number varchar2(15),
guard varchar(3),
constraint client_id_pk primary key(client_id)
)
-------삽입----
insert into clients VALUES ('csi1234', 'csi1234', '홍성진', '01011112222', 'imsun0101@naver.com', sysdate, null, null )
insert into clients VALUES ('csi12345', 'csi12345', '방범대', '01011112222', 'imsun0101@naver.com', sysdate, null, '1' )
-----------Temp 테이블 생성 ----------
create table temp(
temp_id varchar2(12) not null,
id_number varchar2(15) not null,
constraint temp_pk primary key(temp_id),
constraint temp_fk foreign key(temp_id) references clients(client_id)
)
---------
