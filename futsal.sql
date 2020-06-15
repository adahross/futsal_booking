-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 15, 2020 at 08:23 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `futsal`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `bookingID` int(5) NOT NULL,
  `bookingStat` varchar(10) NOT NULL,
  `courtType` varchar(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `courtName` varchar(20) NOT NULL,
  `courtID` int(5) NOT NULL,
  `payStatus` varchar(10) NOT NULL,
  `book_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`bookingID`, `bookingStat`, `courtType`, `username`, `courtName`, `courtID`, `payStatus`, `book_date`) VALUES
(73, 'pending', 'Court A', 'nsaadah32', 'Normal court', 4, 'pending', '2018-11-28'),
(74, 'pending', 'Court A', 'nsaadah32', 'Outdoor Court', 4, 'pending', '2019-01-01'),
(75, 'pending', 'Court A', 'nsaadah32', 'Outdoor Court', 4, 'pending', '2019-01-01'),
(76, 'approve', 'Court A', 'nsaadah32', 'Outdoor Court', 4, 'approve', '2019-01-04'),
(77, 'rejected', 'Court C', 'afqh', 'Outdoor Court', 6, 'pending', '2019-01-25'),
(78, 'approve', 'Court A', 'afqh', 'Indoor Court', 1, 'approve', '2019-01-10'),
(79, 'approve', 'Court B', 'afqh', 'Outdoor Court', 5, 'approve', '2019-01-11'),
(81, 'approve', 'Court B', 'q', 'Outdoor Court', 5, 'pending', '2019-01-11');

-- --------------------------------------------------------

--
-- Table structure for table `bookingitem`
--

CREATE TABLE `bookingitem` (
  `bookingID` int(5) NOT NULL,
  `bookingStat` varchar(10) NOT NULL,
  `itemType` varchar(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `itemName` varchar(20) NOT NULL,
  `itemID` int(5) NOT NULL,
  `payStatus` varchar(10) NOT NULL,
  `book_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bookingitem`
--

INSERT INTO `bookingitem` (`bookingID`, `bookingStat`, `itemType`, `username`, `itemName`, `itemID`, `payStatus`, `book_date`) VALUES
(7, 'approve', 'Badmiinton', 'nsaadah32', 'Racquet', 1, 'approve', '2018-12-23'),
(8, 'approve', 'Tennis', 'nsaadah32', 'Ball', 2, 'approve', '2018-12-19'),
(9, 'approve', 'Volleyball', 'slm', 'Net', 3, 'approve', '2018-12-28'),
(13, 'pending', 'Futsal', 'nsaadah32', 'Boot', 4, 'pending', '2018-11-28'),
(24, 'pending', 'Ping Pong', 'nsaadah32', 'Bat', 5, 'pending', '2019-01-01');

-- --------------------------------------------------------

--
-- Table structure for table `court`
--

CREATE TABLE `court` (
  `courtID` int(11) NOT NULL,
  `courtType` varchar(15) NOT NULL,
  `courtName` varchar(10) NOT NULL,
  `price` double NOT NULL,
  `image` varchar(150) NOT NULL DEFAULT 'default.png',
  `courtStat` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `court`
--

INSERT INTO `court` (`courtID`, `courtType`, `courtName`, `price`, `image`, `courtStat`) VALUES
(1, 'Indoor Court', 'Court A', 103, 'default.png', 'Active'),
(2, 'Indoor Court', 'Court B', 80, 'default.png', 'Inactive'),
(3, 'Indoor Court', 'Court C', 120, 'default.png', 'Active'),
(4, 'Outdoor Court', 'Court A', 150, 'default.png', 'Active'),
(5, 'Outdoor Court', 'Court B', 111, 'default.png', 'Active'),
(6, 'Outdoor Court', 'Court C', 150, 'default.png', 'Inactive'),
(8, 'Indoor Court', 'Court J', 12, 'default.png', 'Active'),
(9, 'Indoor Court', 'Court P', 12, 'default.png', 'Active'),
(10, 'Indoor Court', 'Court P', 12, 'default.png', 'Inactive');

-- --------------------------------------------------------

--
-- Table structure for table `creditcard`
--

CREATE TABLE `creditcard` (
  `fullname` varchar(30) NOT NULL,
  `cvv` varchar(3) NOT NULL,
  `cardNo` varchar(20) NOT NULL,
  `month` varchar(2) NOT NULL,
  `year` varchar(4) NOT NULL,
  `paymentID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `creditcard`
--

INSERT INTO `creditcard` (`fullname`, `cvv`, `cardNo`, `month`, `year`, `paymentID`) VALUES
('Nur Saadah', '576', '13544576858', '10', '2020', 1),
('asdasf', '637', 'asdaf', '01', '2016', 2),
('afafaf', '645', 'afsfafsa', '01', '2016', 3),
('Adah', '646', '324362473', '05', '2023', 4),
('afqh', '678', '123456789', '01', '2020', 5),
('Nur Saadah ', '853', '24343576351315', '01', '2016', 6),
('adah', '986', '123456789', '04', '2020', 7),
('Nur Saadah', '123', '1234567890', '01', '2023', 8);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `itemID` int(11) NOT NULL,
  `itemType` varchar(15) NOT NULL,
  `itemName` varchar(10) NOT NULL,
  `price` double NOT NULL,
  `itemStat` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`itemID`, `itemType`, `itemName`, `price`, `itemStat`) VALUES
(1, 'Badminton', 'Racquet', 5, 'active'),
(2, 'Tennis', 'Ball', 6, 'active');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `fullname` varchar(50) NOT NULL,
  `username` varchar(10) NOT NULL,
  `phoneNo` varchar(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(10) NOT NULL,
  `usertype` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`fullname`, `username`, `phoneNo`, `email`, `password`, `usertype`) VALUES
('Balqis Athira', 'balqis', '01112152923', 'balqishamezi@utm.my', '1234567890', 0),
('Afiqah Anuar', 'nafiqah237', '0199023149', 'afqhanr@gmail.com', '1234567890', 0),
('Nurul Nazifa', 'nazifa24', '0123456789', 'nazifanshr@gmail.com', '1234567890', 0),
('Nur Saadah', 'nsaadah32', '0199023149', 'nsaadah32@gmail.com', '1234567890', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`bookingID`),
  ADD KEY `courtID` (`courtID`);

--
-- Indexes for table `bookingitem`
--
ALTER TABLE `bookingitem`
  ADD PRIMARY KEY (`bookingID`);

--
-- Indexes for table `court`
--
ALTER TABLE `court`
  ADD PRIMARY KEY (`courtID`);

--
-- Indexes for table `creditcard`
--
ALTER TABLE `creditcard`
  ADD PRIMARY KEY (`paymentID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `bookingID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=82;

--
-- AUTO_INCREMENT for table `bookingitem`
--
ALTER TABLE `bookingitem`
  MODIFY `bookingID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `court`
--
ALTER TABLE `court`
  MODIFY `courtID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `creditcard`
--
ALTER TABLE `creditcard`
  MODIFY `paymentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`courtID`) REFERENCES `court` (`courtID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
