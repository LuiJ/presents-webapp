create database presents;
use presents;

CREATE TABLE IF NOT EXISTS `present` (
    `id` int(10) NOT NULL AUTO_INCREMENT,
	`type` varchar(512) DEFAULT NULL,
    `name` varchar(512) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `candy` (
    `id` int(10) NOT NULL AUTO_INCREMENT,
	`present_id` int(10) DEFAULT NULL,
	`type` varchar(512) DEFAULT NULL,
    `name` varchar(512) DEFAULT NULL,
    `weight` double DEFAULT NULL,
	`price` double DEFAULT NULL,
	`taste_type` varchar(512) DEFAULT NULL,
	`choco_type` varchar(512) DEFAULT NULL,
	`filling_type` varchar(512) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `present_id` (`present_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

ALTER TABLE `candy`
  ADD CONSTRAINT `candy_ibfk_1` FOREIGN KEY (`present_id`) REFERENCES `present` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

INSERT INTO `present` (`id`, `type`, `name`) VALUES
(1, 'Present', 'New Year'),
(2, 'Present', 'Birthday'),
(3, 'Present', 'Marriage');

INSERT INTO `candy` (`id`, `present_id`, `type`, `name`, `weight`, `price`, `taste_type`, `choco_type`, `filling_type`) VALUES
(1, 1, 'LollipopCandy', 'Aeroflotskaya', 1.5, 7.4, 'Cocacola', NULL, NULL),
(2, 1, 'LollipopCandyWithFilling', 'CupaCups', 4.4, 2.8, 'Cake', NULL, 'Gum'),
(3, 1, 'ChocolateCandy', 'Alenka', 2.5, 3.4, NULL, 'Milk', NULL),
(4, 1, 'ChocolateCandyWithFilling', 'Gryliazh', 6.5, 3.9, NULL, 'Dark', 'Waffles');
  
  

