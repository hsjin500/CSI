select * from students

--drop table students

create table students (
student_id varchar(12) not null,
pw varchar(15) not null,
student_name varchar(30) not null,
phone_number varchar(30),
student_email varchar(50) not null,
signup_date date,
constraint student_id_pk primary key(student_id)
)

insert into students VALUES ('14', '123', 'È«¼ºÁø', '01046085062', 'imsun0101@naver.com',sysdate)
