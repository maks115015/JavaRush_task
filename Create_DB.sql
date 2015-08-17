CREATE DATABASE `test`;  
use test;

CREATE TABLE `user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(24) NOT NULL,
  `age` INT(11) NOT NULL,
  `isAdmin` BIT(1) NOT NULL,
  `createdDate` TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;  

INSERT INTO `user` (`id`, `name`, `age`, `isAdmin`) VALUES
(31, 'maks', '22',0),
(32, 'макс', '44', 1), 
(33, 'дима', '11', 1), 
(34, 'юра', '6', 1),
(35, 'дима', '3', 0), 
(36, 'витя', '54', 0),   
(37, 'вася', '32', 0), 
(38, 'ваня', '21', 0), 
(39, 'сергей', '46', 0), 
 (40, 'женя', '67', 0),  
 (11, 'влад', '33', 1),  
 (12, 'олег', '31', 0),  
 (13, 'andrew', '12', 0),  
 (14, 'tom', '16', 1),  
 (15, 'leo', '46', 0),
 (16, 'antonio', '75', 0),  
 (17, 'оля', '33', 0),  
 (18, 'юля', '8', 0),
 (19, 'stev', '53', 0),  
 (20, 'john', '29', 0),  
 (21, 'vincent', '55', 0), 
 (22, 'денис', '28', 0);  