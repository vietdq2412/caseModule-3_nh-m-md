drop database if exists CaseStudyMD3_QuanLySach;
create database CaseStudyMD3_QuanLySach;

use CaseStudyMD3_QuanLySach;

drop table if exists `role` cascade;
create table role(
                     id int not null auto_increment primary key,
                     name varchar(10) not null
);

drop table if exists `account` cascade;
CREATE TABLE `CaseStudyMD3_QuanLySach`.`account` (
                                          `id` INT NOT NULL AUTO_INCREMENT,
                                          `full_name` NVARCHAR(50) NOT NULL,
                                          `username` NVARCHAR(20) NOT NULL,
                                          `password` NVARCHAR(15) NOT NULL,
                                          `address` NVARCHAR(255),
                                          `email` NVARCHAR(50) NOT NULL,
                                          `phone_number` NVARCHAR(10),
                                          `role_id` INT NOT NULL,
                                          PRIMARY KEY (`id`),
                                          FOREIGN KEY (role_id) REFERENCES role(id)
);

drop table if exists `category` cascade;
CREATE TABLE `CaseStudyMD3_QuanLySach`.`category` (
                                           `id` INT NOT NULL AUTO_INCREMENT,
                                           `name` NVARCHAR(45) NOT NULL,
                                           PRIMARY KEY (`id`));
drop table if exists `order_status` cascade;
CREATE TABLE `CaseStudyMD3_QuanLySach`.`order_status` (
                                               `id` INT NOT NULL AUTO_INCREMENT,
                                               `name` NVARCHAR(45) NOT NULL,
                                               PRIMARY KEY (`id`));
drop table if exists `author` cascade;
CREATE TABLE `CaseStudyMD3_QuanLySach`.`author` (
                                         `id` INT NOT NULL AUTO_INCREMENT,
                                         `name` NVARCHAR(150) NOT NULL,
                                         `date_of_birth` DATE,
                                         `number_of_arts` INT(10),
                                         `nation` NVARCHAR(45),
                                         `image` NVARCHAR(255),
                                         PRIMARY KEY (`id`));
drop table if exists `book` cascade;
CREATE TABLE `CaseStudyMD3_QuanLySach`.`book` (
                                       `id` INT NOT NULL AUTO_INCREMENT,
                                       `title` NVARCHAR(255) NOT NULL ,
                                       `category_id` INT(10),
                                       `author_id` INT(10),
                                       `publish_year` INT(10),
                                       `description` LONGTEXT,
                                       `image` NVARCHAR(255),
                                       `views` INT(10),
                                       `quantity` INT(10),
                                       `price` DOUBLE NOT NULL,
                                       PRIMARY KEY (`id`));
drop table if exists `order` cascade;
CREATE TABLE `CaseStudyMD3_QuanLySach`.`order` (
                                        `id` INT NOT NULL AUTO_INCREMENT,
                                        `create_time` DATE NOT NULL,
                                        `total_price` DOUBLE NOT NULL,
                                        `account_id` INT(10) NOT NULL,
                                        `order_status_id` INT(10) NOT NULL,
                                        PRIMARY KEY (`id`));
drop table if exists `order_detail` cascade;
CREATE TABLE `CaseStudyMD3_QuanLySach`.`order_detail` (
                                               `id` INT(10) NOT NULL AUTO_INCREMENT,
                                               `quantity` INT(10) NOT NULL,
                                               `order_id` INT(10) NOT NULL,
                                               `total_price` DOUBLE NOT NULL,
                                               `book_id` INT(10) NOT NULL,
                                               PRIMARY KEY (`id`));

-- thêm khóa ngoại
ALTER TABLE book ADD CONSTRAINT id FOREIGN KEY (author_id)
    REFERENCES author(id);

ALTER TABLE book ADD CONSTRAINT id_category FOREIGN KEY (category_id)
    REFERENCES category(id);

ALTER TABLE `CaseStudyMD3_QuanLySach`.`order` ADD CONSTRAINT order_orderstatus FOREIGN KEY (order_status_id)
    REFERENCES order_status(id);

ALTER TABLE `CaseStudyMD3_QuanLySach`.`order` ADD CONSTRAINT order_account FOREIGN KEY (account_id)
    REFERENCES account(id);

ALTER TABLE `CaseStudyMD3_QuanLySach`.`order_detail` ADD CONSTRAINT orderdetail_order FOREIGN KEY (order_id)
    REFERENCES `CaseStudyMD3_QuanLySach`.`order`(id);

ALTER TABLE `CaseStudyMD3_QuanLySach`.`order_detail` ADD CONSTRAINT orderdetail_book FOREIGN KEY (book_id)
    REFERENCES `CaseStudyMD3_QuanLySach`.`book`(id);


-- end--------------------
-- Insert data---
-- category---
insert into category(name) values ('non-fiction');
insert into category(name) values ('fiction-books');
insert into category(name) values ('classics');
insert into category(name) values ('children');
insert into category(name) values ('poetry-drama');
insert into category(name) values ('books-into-movies');