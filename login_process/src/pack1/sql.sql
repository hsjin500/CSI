select * from clients

drop table request
drop table temp
drop table location
drop table mia


---------����� ���̺� ���� --------
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
-------����----
insert into clients VALUES ('csi1234', 'csi1234', 'ȫ����', '01011112222', 'imsun0101@naver.com', null, '0', null )
insert into clients VALUES ('csi12345', 'csi1234', '�����', '01011112222', 'imsun0101@naver.com', '920000-1500000', '�ϱ�', null )
insert into clients values ('admin','csi1234','������','0100000000','admin@naver.com','800000-1322112','������','admin')
insert into location values ('���� �����','����','�ּ�')
insert into location values ('�ϱ� �����','�ϱ�','�ּ�')
insert into location values ('���걸 �����','���걸','�ּ�')
insert into location values ('���� �����','����','�ּ�')
insert into location values ('���� �����','����','�ּ�')
insert into location values ('�Ϲ���','0','�ּ�')
insert into location values ('������','������','�ּ�')
insert into mia values ('hsjin500', '������','���� 7�� 20��', '7��1��', '�̸��� ��̾� �̰� ���̴� 4���̰� �Ӹ��� �ܹ��̿��� ��Ź�帳�ϴ�...','����',sysdate)
temp_id varchar2(12) not null,
ss_number varchar2(30) not null,
guard varchar2(10),
history varchar2(2),
constraint temp_id_fk foreign key(temp_id) references clients(client_id))
---------location ���̺� ����------

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
-------------������ ����
alter table temp modify(guard varchar2(10))