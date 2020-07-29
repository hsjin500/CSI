select * from clients

drop table clients

create table clients (
client_id varchar(12) not null,
client_pw varchar(15) not null,
client_name varchar(30) not null,
phone_number varchar(30) not null,
client_email varchar(50) not null,
signup_date date,
guard varchar(3),
manager varchar(7),
constraint client_id_pk primary key(client_id)
)

insert into clients VALUES ('csi1234', 'csi1234', 'È«¼ºÁø', '01011112222', 'imsun0101@naver.com', sysdate, null, null )
