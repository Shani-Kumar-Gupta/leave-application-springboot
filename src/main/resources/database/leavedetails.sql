/* Database for leave details */

create database leave_details;

/* Query OK, 1 row affected (0.01 sec) */

show databases;

/*
+--------------------+
| Database           |
+--------------------+
| information_schema |
| leave_details      |
| mysql              |
| performance_schema |
| sakila             |
| sys                |
| world              |
+--------------------+
7 rows in set (0.01 sec) */

/*Create user*/

create user 'springuser'@'%' identified by '171999@';

/*Grant access on leave_details database*/

grant all on leave_application.* to 'springuser'@'%';

use leave_application;

/*Create table leavedetails*/
create table leavedetails
(
    id          int auto_increment
        primary key,
    reason      varchar(255) not null,
    startDate   date         not null,
    endDate     date         not null,
    isHalfDay   tinyint(1)   not null,
    leaveType   varchar(20)  not null,
    status      varchar(20)  not null,
    appliedDate date         not null,
    updatedDate date         not null
);

/*insert data into table leavedetails*/

insert into leavedetails (reason, startDate, endDate, isHalfDay, leaveType, status, appliedDate, updatedDate) values ('Urgent Work','2020/08/10','2020/08/15',false,'CL','Applied','2020/07/27','2020/08/16');
insert into leavedetails (reason, startDate, endDate, isHalfDay, leaveType, status, appliedDate, updatedDate) values ('Urgent Work','2020/08/10','2020/08/15',false,'CL','Applied','2020/07/27','2020/08/16');
insert into leavedetails (reason, startDate, endDate, isHalfDay, leaveType, status, appliedDate, updatedDate) values ('Due to sick','2020/07/28','2020/08/30',true,'PL','Approved','2020/07/28','2020/09/01');
insert into leavedetails (reason, startDate, endDate, isHalfDay, leaveType, status, appliedDate, updatedDate) values ('Due to urgent work related to addhar','2020/07/29','2020/08/05',true,'CL','Avaited','2020/07/20','2020/08/06');






