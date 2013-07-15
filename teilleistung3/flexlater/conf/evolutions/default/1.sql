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
  major                     varchar(255),
  duration                  integer,
  max_participant           integer,
  docent_id                 integer,
  constraint pk_exam primary key (exam_id))
;

create table student (
  student_id                integer not null,
  name                      varchar(255),
  first_name                varchar(255),
  major                     varchar(255),
  constraint pk_student primary key (student_id))
;

create sequence docent_seq;

create sequence enrollment_seq;

create sequence exam_seq;

create sequence student_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists docent;

drop table if exists enrollment;

drop table if exists exam;

drop table if exists student;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists docent_seq;

drop sequence if exists enrollment_seq;

drop sequence if exists exam_seq;

drop sequence if exists student_seq;

