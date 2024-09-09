--[1] DB생성
--drop database if exists springpy;
--create database springpy;
--use springpy;

--[2] user
use account;
drop table if exists accounts;
CREATE TABLE accounts (
    id int auto_increment,
    tmi varchar(20),
    price int,
    timer datetime default now(),
    primary key (id)
);
