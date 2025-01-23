drop user appuser1;
drop database product_service;
drop schema product_service

create database product_service;

CREATE USER 'app_user1'@'%' IDENTIFIED BY 'helloworld';
GRANT ALL PRIVILEGES ON product_service.* TO 'app_user1'@'%' WITH GRANT OPTION;






