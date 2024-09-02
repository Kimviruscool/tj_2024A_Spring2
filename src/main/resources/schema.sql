--[1] DB생성
--drop database if exists springpy;
--create database springpy;
--use springpy;

--[2] user table
drop table if exists user;
CREATE TABLE user (
    id int auto_increment,
    name varchar(20),
    age int,
    primary key (id)
);