CREATE USER 'appuser1'@'localhost' IDENTIFIED BY 'XXX';
drop user appuser1;

drop database product_service;
create database product_service;
create user appuser1
grant all privileges on product_service to appuser1;

drop schema product_service



