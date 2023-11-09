DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `create_a_like_item`(IN `in_OrderAmount` INT, IN `in_Account` VARCHAR(16) CHARSET big5, IN `in_TotalFee` DECIMAL(18,5), IN `in_TotalAmount` DECIMAL(18,5), IN `in_UserID` VARCHAR(10) CHARSET big5, IN `in_Product_No` BIGINT)
INSERT INTO `likelist` (`OrderAmount`, `Account`, `TotalFee`, `TotalAmount`, `UserId`, `Product_No`) VALUES (in_OrderAmount, in_Account, in_TotalFee, in_TotalAmount, in_UserID, in_Product_No)$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_a_like_item`(IN `in_SN` BIGINT)
DELETE FROM `likelist` WHERE `SN`=in_SN$$
    DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `query_a_like_item`(IN `in_SN` BIGINT)
SELECT
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
    DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_a_like_item`(IN `in_SN` BIGINT, IN `in_OrderAmount` INT, IN `in_Account` VARCHAR(16), IN `in_TotalFee` DECIMAL(18,5), IN `in_TotalAmount` DECIMAL(18,5), IN `in_UserID` VARCHAR(10), IN `in_Product_No` BIGINT)
UPDATE `likelist` SET `OrderAmount`=in_OrderAmount, `Account`=in_Account, `TotalFee`=in_TotalFee, `TotalAmount`=in_TotalAmount, `UserId`=in_UserID, `Product_No`=in_Product_No WHERE `SN` = in_SN$$
    DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `list_all_of_like_item`()
SELECT
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
    DELIMITER ;
