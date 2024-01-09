-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 09, 2024 at 01:03 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `greenmart`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `custID` int(11) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(1000) DEFAULT NULL,
  `contactNo` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`custID`, `password`, `name`, `email`, `address`, `contactNo`) VALUES
(1, '1234', 'Ashen Dulsanka', 'ashendul@gmail.com', 'No.3 Samagi Mawatha, Depanama, Pannipitiya', 778494082),
(2, 'dul1234', 'Dulsanka Abeysekara', 'abey@gmail.com', 'No.12 Pannipitiya', 882299330),
(3, 'abey1234', 'Abey Dul', 'dul@gmail.com', 'No.34 Depanama', 993884471),
(6, 'test', 'test', 'test@gmail.com', 'test', 299383),
(7, '1234', 'Suhas ', 'suhas@gmail.com', 'No.45 Polwatta', 778822991),
(8, '123', 'Ashen Abeysekara', 'ashendul@gmail.com', 'No.3 Samagi Mawatha, Depanama, Pannipitiya', 778494028),
(9, 'test', 'test', 'test@yahoo.com', 'test', 112293493),
(10, 'test', 'test', 'test@test', 'test', 123),
(11, 'test', 'test', 'test@1', 'test', 1234),
(12, 'te', 'test', 'test@test', 'test', 119283345),
(13, '1234', 'Ashen Abeysekara', 'dulabeyse@gmail.com', 'No.3 Samagi Mawatha', 726356763);

-- --------------------------------------------------------

--
-- Table structure for table `feedbacks`
--

CREATE TABLE `feedbacks` (
  `feedbackID` int(11) NOT NULL,
  `custID` int(11) NOT NULL,
  `feedbackText` varchar(5000) NOT NULL,
  `feedbackDate` varchar(450) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `feedbacks`
--

INSERT INTO `feedbacks` (`feedbackID`, `custID`, `feedbackText`, `feedbackDate`) VALUES
(1, 1, 'nice website', '2024-01-09'),
(2, 13, 'test', '2024-01-09'),
(3, 1, 'asd', '2024-01-09');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `orderID` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `custID` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `orderDate` varchar(450) NOT NULL,
  `orderAmount` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`orderID`, `productID`, `custID`, `quantity`, `orderDate`, `orderAmount`) VALUES
(1, 1, 1, 2, '2024-01-09', '0.00'),
(2, 3, 1, 1, '2024-01-09', '0.00'),
(3, 3, 1, 1, '2024-01-09', '0.00'),
(4, 5, 1, 1, '2024-01-09', '0.00'),
(5, 2, 1, 2, '2024-01-09', '1.45'),
(6, 3, 1, 1, '2024-01-09', '1.25'),
(7, 2, 1, 2, '2024-01-09', '2.90'),
(8, 3, 1, 3, '2024-01-09', '3.75'),
(9, 3, 13, 2, '2024-01-09', '2.50'),
(10, 2, 13, 4, '2024-01-09', '5.80'),
(11, 11, 13, 3, '2024-01-09', '29.85'),
(12, 2, 1, 1, '2024-01-09', '1.45'),
(13, 1, 1, 2, '2024-01-09', '3.30'),
(14, 6, 1, 2, '2024-01-09', '2.30'),
(15, 2, 1, 1, '2024-01-09', '1.45');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `productID` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `price` double(10,2) NOT NULL,
  `quantity` int(11) NOT NULL,
  `image` varchar(5000) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`productID`, `name`, `price`, `quantity`, `image`, `size`) VALUES
(1, 'Apple', 1.65, 25, 'https://i.imgur.com/vUJ2JKU.png', '100g'),
(2, 'Chili', 1.45, 25, 'https://i.imgur.com/rFhSMZN.png', '100g'),
(3, 'Onion', 1.25, 47, 'https://i.imgur.com/sGLggWL.jpg', '100g'),
(4, 'Potato', 1.15, 37, 'https://i.imgur.com/WFjH6ui.png', '100g'),
(5, 'Garlic', 0.95, 39, 'https://i.imgur.com/XVLuy2J.png', '100g'),
(6, 'Tomato', 1.15, 30, 'https://i.imgur.com/8l5hDhS.png', '100g'),
(7, 'Panda Baby Cream', 3.05, 19, 'https://www.nbc.lk/storage/uploads/image/1_61af42354631f.png/medium/1_61af42354631f.png', '200ml'),
(8, 'Johnsons Baby Shampoo', 3.55, 12, 'https://static.beautytocare.com/cdn-cgi/image/width=1600,height=1600,f=auto/media/catalog/product//j/o/johnson-s-baby-shampoo-with-dispenser-750ml.jpg', '750ml'),
(9, 'Marvel Baby Wet Wipes', 3.82, 24, 'https://www.kidzcare.lk/sites/default/files/field/product/FrontAngle_1024x1024%402x.jpg', '80pcs'),
(10, 'Nivea Men Face Cream', 12.35, 14, 'https://static.beautytocare.com/cdn-cgi/image/width=1600,height=1600,f=auto/media/catalog/product//n/i/nivea-men-protect-care-24h-moisturizing-face-cream-75ml.jpg', '75ml'),
(11, 'Beard Oil Original', 9.95, 20, 'https://i0.wp.com/thebeardarmour.com/wp-content/uploads/2020/05/original_front-scaled.jpg?fit=2560%2C2560&ssl=1', '15ml'),
(12, 'Vaseline Lip Balm', 24.99, 19, 'https://www.ubuy.com.lk/productimg/?image=aHR0cHM6Ly9pNS53YWxtYXJ0aW1hZ2VzLmNvbS9zZW8vVmFzZWxpbmUtTGlwLVRoZXJhcHktVGludGVkLUxpcC1CYWxtLU1pbmktUm9zeS0wLTI1LW96XzZmY2VkMzZlLTU0NTktNDQ5Zi05MzkwLWYyMzljMzc5YmQ2YV8xLjc1Mjc2MTk5ZGZhODg3N2I0ZDE4OGYwMzIwMjk5MTNmLmpwZWc.jpg', '7g'),
(13, 'Maped Pencils', 9.99, 12, 'https://premiumstationers.lk/cdn/shop/products/01-20.jpg?v=1630773779', '12pcs'),
(14, 'Pilot FriXion Pen', 2.99, 24, 'https://www.thefullstop.lk/wp-content/uploads/2022/08/Cl-Frixion-Black.jpg', '1pcs'),
(15, 'Maped Sticky Notes', 2.79, 16, 'https://www.thefullstop.lk/wp-content/uploads/2022/07/760010-2.jpg', '100 sheets');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`custID`);

--
-- Indexes for table `feedbacks`
--
ALTER TABLE `feedbacks`
  ADD PRIMARY KEY (`feedbackID`),
  ADD KEY `custID` (`custID`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`orderID`),
  ADD KEY `productID` (`productID`),
  ADD KEY `custID` (`custID`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`productID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `custID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `feedbacks`
--
ALTER TABLE `feedbacks`
  MODIFY `feedbackID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `orderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `productID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `feedbacks`
--
ALTER TABLE `feedbacks`
  ADD CONSTRAINT `feedbacks_ibfk_1` FOREIGN KEY (`custID`) REFERENCES `customers` (`custID`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`productID`) REFERENCES `products` (`productID`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`custID`) REFERENCES `customers` (`custID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
