-- Adminer 4.7.7 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP DATABASE IF EXISTS `course`;
CREATE DATABASE `course` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `course`;

DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `title` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `time` varchar(50) NOT NULL,
  KEY `username` (`username`),
  CONSTRAINT `activity_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

TRUNCATE `activity`;

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `authority` varchar(50) NOT NULL,
  KEY `username` (`username`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

TRUNCATE `authorities`;
INSERT INTO `authorities` (`username`, `authority`) VALUES
('admin',	'admin'),
('user',	'user');

DROP TABLE IF EXISTS `course_comment`;
CREATE TABLE `course_comment` (
  `id` int NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `course_id` int NOT NULL,
  `time` varchar(50) NOT NULL,
  `content` text NOT NULL,
  KEY `username` (`username`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `course_comment_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`),
  CONSTRAINT `course_comment_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

TRUNCATE `course_comment`;

DROP TABLE IF EXISTS `course_vote`;
CREATE TABLE `course_vote` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_id` int NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `username` (`username`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `course_vote_ibfk_2` FOREIGN KEY (`username`) REFERENCES `users` (`username`),
  CONSTRAINT `course_vote_ibfk_3` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

TRUNCATE `course_vote`;
INSERT INTO `course_vote` (`id`, `course_id`, `username`) VALUES
(1,	2,	'admin'),
(2,	1,	'admin');

DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `vote` int DEFAULT NULL,
  `dislike` int DEFAULT NULL,
  `introduction` text,
  `teacher_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `courses_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

TRUNCATE `courses`;
INSERT INTO `courses` (`id`, `name`, `vote`, `dislike`, `introduction`, `teacher_id`) VALUES
(1,	'新课程',	1,	0,	'这是一门新课程',	1),
(2,	'测试课程',	1,	0,	'无',	1);

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

TRUNCATE `teacher`;
INSERT INTO `teacher` (`id`, `name`, `gender`, `title`, `introduction`) VALUES
(1,	'新老师',	'男',	'教授',	'无');

DROP TABLE IF EXISTS `teacher_comment`;
CREATE TABLE `teacher_comment` (
  `id` int NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `teacher_id` int NOT NULL,
  `time` varchar(50) NOT NULL,
  `content` text NOT NULL,
  KEY `username` (`username`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `teacher_comment_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`),
  CONSTRAINT `teacher_comment_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

TRUNCATE `teacher_comment`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

TRUNCATE `users`;
INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
('admin',	'$2a$10$vVmNKbV7XKwmEDhxguhMd.sOYrWcmoo4yjvfdxezDO8aNRSmFPL8K',	1),
('user',	'$2a$10$vVmNKbV7XKwmEDhxguhMd.sOYrWcmoo4yjvfdxezDO8aNRSmFPL8K',	1);

-- 2020-09-18 16:30:57
