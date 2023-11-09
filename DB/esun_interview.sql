-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1
-- 產生時間： 2023-11-09 12:45:09
-- 伺服器版本： 10.4.27-MariaDB
-- PHP 版本： 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `esun_interview`
--

DELIMITER $$
--
-- 程序
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `create_a_like_item` (IN `in_OrderAmount` INT, IN `in_Account` VARCHAR(16) CHARSET big5, IN `in_TotalFee` DECIMAL(18,5), IN `in_TotalAmount` DECIMAL(18,5), IN `in_UserID` VARCHAR(10) CHARSET big5, IN `in_Product_No` BIGINT)   INSERT INTO `likelist` (`OrderAmount`, `Account`, `TotalFee`, `TotalAmount`, `UserId`, `Product_No`) VALUES (in_OrderAmount, in_Account, in_TotalFee, in_TotalAmount, in_UserID, in_Product_No)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_a_like_item` (IN `in_SN` BIGINT)   DELETE FROM `likelist` WHERE `SN`=in_SN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `list_all_of_like_item` ()   SELECT 
l.SN,
l.OrderAmount,
l.TotalFee,
l.TotalAmount,
u.UserID,
u.User_Name,
u.Email,
u.Account,
p.No,
p.Product_Name,
p.Price,
p.Fee_Rate
FROM `likelist` l
INNER JOIN `user` u ON u.UserID = l.UserID
INNER JOIN `product` p ON p.No = l.Product_No
ORDER BY l.SN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `query_a_like_item` (IN `in_SN` BIGINT)   SELECT 
l.SN,
l.OrderAmount,
l.TotalFee,
l.TotalAmount,
u.UserID,
u.User_Name,
u.Email,
u.Account,
p.No,
p.Product_Name,
p.Price,
p.Fee_Rate
FROM `likelist` l
INNER JOIN `user` u ON u.UserID = l.UserID
INNER JOIN `product` p ON p.No = l.Product_No
WHERE l.SN = in_SN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `update_a_like_item` (IN `in_SN` BIGINT, IN `in_OrderAmount` INT, IN `in_Account` VARCHAR(16), IN `in_TotalFee` DECIMAL(18,5), IN `in_TotalAmount` DECIMAL(18,5), IN `in_UserID` VARCHAR(10), IN `in_Product_No` BIGINT)   UPDATE `likelist` SET `OrderAmount`=in_OrderAmount, `Account`=in_Account, `TotalFee`=in_TotalFee, `TotalAmount`=in_TotalAmount, `UserId`=in_UserID, `Product_No`=in_Product_No WHERE `SN` = in_SN$$

DELIMITER ;

-- --------------------------------------------------------

--
-- 資料表結構 `likelist`
--

CREATE TABLE `likelist` (
  `SN` bigint(20) NOT NULL,
  `OrderAmount` int(11) NOT NULL,
  `Account` varchar(16) NOT NULL,
  `TotalFee` decimal(18,5) NOT NULL,
  `TotalAmount` decimal(18,5) NOT NULL,
  `UserID` varchar(10) NOT NULL,
  `Product_No` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- 資料表結構 `product`
--

CREATE TABLE `product` (
  `No` bigint(20) NOT NULL,
  `Product_Name` varchar(255) NOT NULL,
  `Price` decimal(18,5) NOT NULL,
  `Fee_Rate` decimal(18,5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- 資料表結構 `user`
--

CREATE TABLE `user` (
  `UserID` varchar(10) NOT NULL,
  `User_Name` varchar(20) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Account` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `likelist`
--
ALTER TABLE `likelist`
  ADD PRIMARY KEY (`SN`),
  ADD KEY `UserID` (`UserID`),
  ADD KEY `likelist_ibfk_2` (`Product_No`);

--
-- 資料表索引 `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`No`);

--
-- 資料表索引 `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UserID`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `likelist`
--
ALTER TABLE `likelist`
  MODIFY `SN` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `product`
--
ALTER TABLE `product`
  MODIFY `No` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- 已傾印資料表的限制式
--

--
-- 資料表的限制式 `likelist`
--
ALTER TABLE `likelist`
  ADD CONSTRAINT `likelist_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `likelist_ibfk_2` FOREIGN KEY (`Product_No`) REFERENCES `product` (`No`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
