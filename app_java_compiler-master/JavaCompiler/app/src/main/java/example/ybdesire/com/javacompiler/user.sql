-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- 主機: 127.0.0.1
-- 產生時間： 2018 年 11 月 14 日 19:16
-- 伺服器版本: 10.1.36-MariaDB
-- PHP 版本： 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `user`
--

-- --------------------------------------------------------

--
-- 資料表結構 `animals`
--

CREATE TABLE `animals` (
  `id` mediumint(9) NOT NULL,
  `name` char(30) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 資料表的匯出資料 `animals`
--

INSERT INTO `animals` (`id`, `name`) VALUES
(1, 'dog'),
(2, 'cat'),
(3, 'penguin'),
(4, 'lax'),
(5, 'whale'),
(6, 'ostrich');

-- --------------------------------------------------------

--
-- 資料表結構 `fyp`
--

CREATE TABLE `fyp` (
  `id` mediumint(9) NOT NULL,
  `Tutorial` char(30) COLLATE utf8_bin NOT NULL,
  `note` char(255) COLLATE utf8_bin NOT NULL,
  `excise` char(255) COLLATE utf8_bin NOT NULL,
  `tips` char(255) COLLATE utf8_bin NOT NULL,
  `ans` char(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 資料表的匯出資料 `fyp`
--

INSERT INTO `fyp` (`id`, `Tutorial`, `note`, `excise`, `tips`, `ans`) VALUES
(1, 'Print', 'Declare a class with name A.\r\nDeclare the main method public static void main(String args[]){\r\nNow Type the System.out.println(\"Hello World\"); which displays the text Hello World.', 'now try to print the \"hello is me\" in the output', 'you may change the world between println(\"//you world here//\");', 'hello is me'),
(2, 'Basic Syntax', 'test2', '', '', ''),
(3, 'Object and Classes', 'test3', '', '', ''),
(4, 'Constructors', 'tes4', '', '', ''),
(5, 'Basic Datatypes', 'tes5', '', '', ''),
(6, 'Variable Types', 'test6', '', '', '');

-- --------------------------------------------------------

--
-- 資料表結構 `user`
--

CREATE TABLE `user` (
  `id` int(255) DEFAULT NULL,
  `account` varchar(255) COLLATE utf8_bin NOT NULL,
  `pwd` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 資料表的匯出資料 `user`
--

INSERT INTO `user` (`id`, `account`, `pwd`) VALUES
(1, 'meme', 'afd'),
(0, 'qrjk', 'helloworld');

--
-- 已匯出資料表的索引
--

--
-- 資料表索引 `animals`
--
ALTER TABLE `animals`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `fyp`
--
ALTER TABLE `fyp`
  ADD PRIMARY KEY (`id`);

--
-- 在匯出的資料表使用 AUTO_INCREMENT
--

--
-- 使用資料表 AUTO_INCREMENT `animals`
--
ALTER TABLE `animals`
  MODIFY `id` mediumint(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- 使用資料表 AUTO_INCREMENT `fyp`
--
ALTER TABLE `fyp`
  MODIFY `id` mediumint(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
