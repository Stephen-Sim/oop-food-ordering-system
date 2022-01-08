-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.33 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for food_ordering_system
DROP DATABASE IF EXISTS `food_ordering_system`;
CREATE DATABASE IF NOT EXISTS `food_ordering_system` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `food_ordering_system`;

-- Dumping structure for table food_ordering_system.foods
DROP TABLE IF EXISTS `foods`;
CREATE TABLE IF NOT EXISTS `foods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `price` decimal(64,2) NOT NULL,
  `food_type` varchar(255) NOT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `foods`
--

INSERT INTO `foods` (`id`, `NAME`, `price`, `food_type`, `stock`) VALUES
(1, 'Nissin Ramen', '7.50', 'food', 2),
(2, 'Dairy Yogurt', '5.50', 'drink', 1),
(3, 'Coca-cola', '2.00', 'drink', 3),
(4, 'Mammie Monster', '5.50', 'food', 2),
(5, 'Pringles', '5.00', 'food', 4);

-- --------------------------------------------------------

-- Data exporting was unselected.

-- Dumping structure for table food_ordering_system.food_order
DROP TABLE IF EXISTS `food_order`;
CREATE TABLE IF NOT EXISTS `food_order` (
  `order_id` int(11) NOT NULL,
  `food_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `total_price` decimal(64,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `food_order`
--

INSERT INTO `food_order` (`order_id`, `food_id`, `quantity`, `total_price`) VALUES
(13, 4, 2, '11.00'),
(13, 1, 2, '15.00'),
(15, 3, 3, '6.00');

-- --------------------------------------------------------

-- Data exporting was unselected.

-- Dumping structure for table food_ordering_system.orders
DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total_price` decimal(64,2) DEFAULT NULL,
  `transaction_time` datetime DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  `STATUS` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `total_price`, `transaction_time`, `customer_id`, `STATUS`) VALUES
(13, '26.00', '2022-01-08 14:08:32', 2, 1),
(14, NULL, NULL, 2, 0),
(15, '6.00', '2022-01-08 14:09:08', 3, 1),
(16, NULL, NULL, 3, 0);

-- --------------------------------------------------------

-- Data exporting was unselected.

-- Dumping structure for table food_ordering_system.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `PASSWORD`) VALUES
(1, 'admin', 'abc12345'),
(2, 'alvin', 'iloveoop'),
(3, 'stephen', '12345678');

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
