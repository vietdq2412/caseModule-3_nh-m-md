create database CaseStudyMD3_QuanLySach;

use CaseStudyMD3_QuanLySach;

create table role(
                     id int not null auto_increment primary key,
                     name varchar(10) not null
);

CREATE TABLE `CaseStudyMD3_QuanLySach`.`account` (
                                          `id` INT NOT NULL AUTO_INCREMENT,
                                          `fullname` NVARCHAR(50) NOT NULL,
                                          `username` VARCHAR(20) NOT NULL,
                                          `password` VARCHAR(15) NOT NULL,
                                          `address` VARCHAR(255) NOT NULL,
                                          `email` VARCHAR(50) NOT NULL,
                                          `phone_number` VARCHAR(10) NOT NULL,
                                          `role_id` INT NOT NULL,
                                          PRIMARY KEY (`id`),
                                          FOREIGN KEY (role_id) REFERENCES role(id)
);


CREATE TABLE `CaseStudyMD3_QuanLySach`.`category` (
                                           `id` INT NOT NULL AUTO_INCREMENT,
                                           `name` NVARCHAR(45) NOT NULL,
                                           PRIMARY KEY (`id`));

CREATE TABLE `CaseStudyMD3_QuanLySach`.`order_status` (
                                               `id` INT NOT NULL AUTO_INCREMENT,
                                               `name` NVARCHAR(45) NOT NULL,
                                               PRIMARY KEY (`id`));

CREATE TABLE `CaseStudyMD3_QuanLySach`.`author` (
                                         `id` INT NOT NULL AUTO_INCREMENT,
                                         `name` NVARCHAR(30) NOT NULL,
                                         `date_of_birth` DATE NOT NULL,
                                         `number_of_arts` INT(10) NOT NULL,
                                         `nation` VARCHAR(45) NOT NULL,
                                         `image` VARCHAR(255) NOT NULL,
                                         PRIMARY KEY (`id`));

CREATE TABLE `CaseStudyMD3_QuanLySach`.`book` (
                                       `id` INT NOT NULL AUTO_INCREMENT,
                                       `title` NVARCHAR(45) NOT NULL,
                                       `column` INT(10) NOT NULL,
                                       `category_id` INT(10) NOT NULL,
                                       `author_id` INT(10) NOT NULL,
                                       `publish_year` INT(10) NOT NULL,
                                       `description` LONGTEXT NOT NULL,
                                       `image` VARCHAR(255) NOT NULL,
                                       `view` INT(10) NOT NULL,
                                       `quantity` INT(10) NOT NULL,
                                       `price` DOUBLE NOT NULL,
                                       PRIMARY KEY (`id`));

CREATE TABLE `CaseStudyMD3_QuanLySach`.`order` (
                                        `id` INT NOT NULL AUTO_INCREMENT,
                                        `create_time` DATE NOT NULL,
                                        `total_price` DOUBLE NOT NULL,
                                        `account_id` INT(10) NOT NULL,
                                        `order_status_id` INT(10) NOT NULL,
                                        PRIMARY KEY (`id`));

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
