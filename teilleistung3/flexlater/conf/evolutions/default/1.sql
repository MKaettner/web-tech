# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table docent (
  docent_id                 integer not null,
  name                      varchar(255),
  first_name                varchar(255),
  chair                     varchar(255),
  constraint pk_docent primary key (docent_id))
;

create table enrollment (
  enrollment_id             integer not null,
  exam_id                   integer,
  student_id                integer,
  constraint pk_enrollment primary key (enrollment_id))
;

create table exam (
  exam_id                   integer not null,
  name                      varchar(255),
  place                     varchar(255),
  date                      varchar(255),
  time                      varchar(255),
  duration                  integer,
  max_participant           integer,
  docent_id                 integer,
  major_id                  integer,
  constraint pk_exam primary key (exam_id))
;

create table major (
  major_id                  integer not null,
  name                      varchar(255),
  constraint pk_major primary key (major_id))
;

create table student (
  student_id                integer not null,
  name                      varchar(255),
  first_name                varchar(255),
  major_id                  integer,
  constraint pk_student primary key (student_id))
;


create table enrollment_exam (
  enrollment_enrollment_id       integer not null,
  exam_exam_id                   integer not null,
  constraint pk_enrollment_exam primary key (enrollment_enrollment_id, exam_exam_id))
;

create table exam_docent (
  exam_exam_id                   integer not null,
  docent_docent_id               integer not null,
  constraint pk_exam_docent primary key (exam_exam_id, docent_docent_id))
;

create table major_student (
  major_major_id                 integer not null,
  student_student_id             integer not null,
  constraint pk_major_student primary key (major_major_id, student_student_id))
;
create sequence docent_seq;

create sequence enrollment_seq;

create sequence exam_seq;

create sequence major_seq;

create sequence student_seq;




alter table enrollment_exam add constraint fk_enrollment_exam_enrollment_01 foreign key (enrollment_enrollment_id) references enrollment (enrollment_id) on delete restrict on update restrict;

alter table enrollment_exam add constraint fk_enrollment_exam_exam_02 foreign key (exam_exam_id) references exam (exam_id) on delete restrict on update restrict;

alter table exam_docent add constraint fk_exam_docent_exam_01 foreign key (exam_exam_id) references exam (exam_id) on delete restrict on update restrict;

alter table exam_docent add constraint fk_exam_docent_docent_02 foreign key (docent_docent_id) references docent (docent_id) on delete restrict on update restrict;

alter table major_student add constraint fk_major_student_major_01 foreign key (major_major_id) references major (major_id) on delete restrict on update restrict;

alter table major_student add constraint fk_major_student_student_02 foreign key (student_student_id) references student (student_id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists docent;

drop table if exists exam_docent;

drop table if exists enrollment;

drop table if exists enrollment_exam;

drop table if exists exam;

drop table if exists major;

drop table if exists major_student;

drop table if exists student;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists docent_seq;

drop sequence if exists enrollment_seq;

drop sequence if exists exam_seq;

drop sequence if exists major_seq;

drop sequence if exists student_seq;

