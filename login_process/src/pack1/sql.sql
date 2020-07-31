select * from clients

drop table request
drop table temp
drop table location
drop table mia


---------사용자 테이블 생성 --------
create table clients (
client_id varchar2(12) not null,
client_pw varchar2(15) not null,
client_name varchar2(30) not null,
phone_number varchar2(30) not null,
client_email varchar2(50) not null,
ss_number varchar2(30),
guard varchar2(10),
manager varchar2(7),
constraint client_id_pk primary key(client_id)
)


delete from clients where client_id = 'admin'
-------삽입----
insert into clients VALUES ('csi1234', 'csi1234', '홍성진', '01011112222', 'imsun0101@naver.com', null, '0', null )
insert into clients VALUES ('csi12345', 'csi1234', '방범대', '01011112222', 'imsun0101@naver.com', '920000-1500000', '북구', null )
insert into clients values ('admin','csi1234','관리자','0100000000','admin@naver.com','800000-1322112','관리자','admin')
insert into location values ('동구 방범대','동구','주소')
insert into location values ('북구 방범대','북구','주소')
insert into location values ('광산구 방범대','광산구','주소')
insert into location values ('서구 방범대','서구','주소')
insert into location values ('남구 방범대','남구','주소')
insert into location values ('일반인','0','주소')
insert into location values ('관리자','관리자','주소')
insert into mia values ('hsjin500', '봉선동','오후 7시 20분', '7월1일', '이름은 김미아 이고 나이는 4살이고 머리는 단발이에요 부탁드립니다...','없음',sysdate)
temp_id varchar2(12) not null,
ss_number varchar2(30) not null,
guard varchar2(10),
history varchar2(2),
constraint temp_id_fk foreign key(temp_id) references clients(client_id))
---------location 테이블 생성------

create table location (
b_name varchar2(20),
b_gu varchar2(10),
b_address varchar2(100)
)
--------------
create table request (
req_id varchar2(12) ,
req_location varchar2(100) not null,
req_time varchar2(50) not null,
req_date varchar2(50) not null,
req_ask varchar2(500),
upload_date date,
req_condition varchar2(10),
constraint req_id_fk foreign key(req_id) references clients(client_id)
)
-----------
create table mia(
mia_id varchar2 (12) not null,
mia_location varchar2(100) not null,
mia_time varchar2(50) not null,
mia_date varchar2(15) not null,
mia_info varchar2(500) not null,
mia_photo varchar2(1000),
upload_date date,
mia_condition varchar2(10),
constraint mia_id_fk foreign key(mia_id) references clients(client_id)
)
-------------사이즈 수정
alter table temp modify(guard varchar2(10))