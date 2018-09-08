-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2018 at 03:08 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `battleship_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `matchstats1`
--

CREATE TABLE `matchstats1` (
  `mid` decimal(3,0) NOT NULL,
  `pid1` varchar(15) DEFAULT NULL,
  `pid2` varchar(15) DEFAULT NULL,
  `winnerid` varchar(15) DEFAULT NULL,
  `ships_destroyed_pid1` decimal(1,0) DEFAULT NULL,
  `ships_destoryed_pid2` decimal(1,0) DEFAULT NULL,
  `time_played` varchar(5) DEFAULT NULL,
  `date_played` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matchstats1`
--

INSERT INTO `matchstats1` (`mid`, `pid1`, `pid2`, `winnerid`, `ships_destroyed_pid1`, `ships_destoryed_pid2`, `time_played`, `date_played`) VALUES
('101', 'Kunjal4', '#computer', NULL, NULL, NULL, NULL, '2018-04-10 08:07:44'),
('102', 'Kunjal4', '#computer', '#computer', '1', NULL, '00:31', '2018-04-10 08:17:40'),
('103', 'Kunjal4', '#computer', '#computer', '0', '0', '00:03', '2018-04-10 08:19:56'),
('104', 'Kunjal4', '#computer', '#computer', '3', '0', '00:50', '2018-04-15 14:16:52'),
('105', 'Kunjal4', '#computer', '#computer', '0', '0', '00:05', '2018-04-15 14:28:10'),
('106', 'Kunjal4', '#computer', NULL, NULL, NULL, NULL, '2018-04-15 14:29:39'),
('107', 'Kunjal4', '#computer', NULL, NULL, NULL, NULL, '2018-04-15 14:30:31'),
('108', 'Kunjal4', '#computer', '#computer', '4', '0', '01:08', '2018-04-15 14:44:23'),
('109', 'Kunjal4', '#computer', '#computer', '1', '0', '00:36', '2018-04-15 14:50:40'),
('110', 'Kunjal4', '#computer', '#computer', '1', '0', '00:18', '2018-04-15 14:53:41'),
('111', 'Kunjal4', '#computer', '#computer', '1', '0', '00:15', '2018-04-15 14:55:18'),
('112', 'Kunjal4', '#computer', '#computer', '0', '0', '00:04', '2018-04-15 15:11:54'),
('113', 'Kunjal4', '#computer', '#computer', '2', '0', '03:00', '2018-04-15 15:15:56'),
('114', 'Kunjal4', '#computer', '#computer', '2', '0', '02:47', '2018-05-01 10:59:53'),
('115', 'Kunjal4', '#computer', '#computer', '1', '0', '00:41', '2018-05-02 11:53:53'),
('116', 'Kunjal4', '#computer', '#computer', '1', '0', '00:37', '2018-05-02 11:55:44'),
('117', 'Kunjal4', '#computer', '#computer', '1', '0', '02:04', '2018-05-02 12:43:48'),
('118', 'Kunjal4', '#computer', '#computer', '1', '0', '02:07', '2018-05-02 12:49:47');

-- --------------------------------------------------------

--
-- Table structure for table `player1`
--

CREATE TABLE `player1` (
  `pid` varchar(15) NOT NULL,
  `email` varchar(254) DEFAULT NULL,
  `pwrd` varchar(20) DEFAULT NULL,
  `wins` decimal(3,0) DEFAULT NULL,
  `loses` decimal(3,0) DEFAULT NULL,
  `own_ships_destroyed` decimal(3,0) DEFAULT NULL,
  `opp_ships_destroyed` decimal(3,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `player1`
--

INSERT INTO `player1` (`pid`, `email`, `pwrd`, `wins`, `loses`, `own_ships_destroyed`, `opp_ships_destroyed`) VALUES
('#computer', 'test@battleship.com', '#computer', '0', '0', '0', '0'),
('bugs', 'bugs@hotmail.com', 'Buggie123*O', '1', '2', '13', '8'),
('Kunjal4', 'kunjalspanchal@gmail.com', 'Kunjal4', '2', '0', '3', '10'),
('popeye', 'k@f.com', 'Popeye123*', '0', '0', '0', '0'),
('qwerty', 'abc@gmail.com', 'Possibility123*', '0', '0', '0', '0');

-- --------------------------------------------------------

--
-- Table structure for table `playership1`
--

CREATE TABLE `playership1` (
  `mid` decimal(3,0) NOT NULL,
  `pid` varchar(15) NOT NULL,
  `shipid` decimal(2,0) NOT NULL,
  `noOfHits` decimal(1,0) DEFAULT NULL,
  `startX` int(1) DEFAULT NULL,
  `startY` int(1) DEFAULT NULL,
  `endX` int(1) DEFAULT NULL,
  `endY` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `playership1`
--

INSERT INTO `playership1` (`mid`, `pid`, `shipid`, `noOfHits`, `startX`, `startY`, `endX`, `endY`) VALUES
('112', 'Kunjal4', '1', '0', NULL, NULL, NULL, NULL),
('112', 'Kunjal4', '2', '0', NULL, NULL, NULL, NULL),
('112', 'Kunjal4', '3', '0', NULL, NULL, NULL, NULL),
('112', 'Kunjal4', '4', '0', NULL, NULL, NULL, NULL),
('112', 'Kunjal4', '5', '0', NULL, NULL, NULL, NULL),
('113', 'Kunjal4', '1', '5', NULL, NULL, NULL, NULL),
('113', 'Kunjal4', '2', '4', NULL, NULL, NULL, NULL),
('113', 'Kunjal4', '3', '2', NULL, NULL, NULL, NULL),
('113', 'Kunjal4', '4', '1', NULL, NULL, NULL, NULL),
('113', 'Kunjal4', '5', '1', NULL, NULL, NULL, NULL),
('114', 'Kunjal4', '1', '5', NULL, NULL, NULL, NULL),
('114', 'Kunjal4', '2', '0', NULL, NULL, NULL, NULL),
('114', 'Kunjal4', '3', '0', NULL, NULL, NULL, NULL),
('114', 'Kunjal4', '4', '3', NULL, NULL, NULL, NULL),
('114', 'Kunjal4', '5', '0', NULL, NULL, NULL, NULL),
('115', 'Kunjal4', '1', '5', NULL, NULL, NULL, NULL),
('115', 'Kunjal4', '2', '0', NULL, NULL, NULL, NULL),
('115', 'Kunjal4', '3', '0', NULL, NULL, NULL, NULL),
('115', 'Kunjal4', '4', '0', NULL, NULL, NULL, NULL),
('115', 'Kunjal4', '5', '0', NULL, NULL, NULL, NULL),
('116', 'Kunjal4', '1', '0', NULL, NULL, NULL, NULL),
('116', 'Kunjal4', '2', '0', NULL, NULL, NULL, NULL),
('116', 'Kunjal4', '3', '0', NULL, NULL, NULL, NULL),
('116', 'Kunjal4', '4', '0', NULL, NULL, NULL, NULL),
('116', 'Kunjal4', '5', '0', NULL, NULL, NULL, NULL),
('117', 'Kunjal4', '1', '0', NULL, NULL, NULL, NULL),
('117', 'Kunjal4', '2', '0', NULL, NULL, NULL, NULL),
('117', 'Kunjal4', '3', '0', NULL, NULL, NULL, NULL),
('117', 'Kunjal4', '4', '0', NULL, NULL, NULL, NULL),
('117', 'Kunjal4', '5', '2', NULL, NULL, NULL, NULL),
('118', 'Kunjal4', '1', '0', NULL, NULL, NULL, NULL),
('118', 'Kunjal4', '2', '0', NULL, NULL, NULL, NULL),
('118', 'Kunjal4', '3', '0', NULL, NULL, NULL, NULL),
('118', 'Kunjal4', '4', '0', NULL, NULL, NULL, NULL),
('118', 'Kunjal4', '5', '0', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `ship1`
--

CREATE TABLE `ship1` (
  `shipid` decimal(2,0) NOT NULL,
  `shipName` varchar(15) NOT NULL,
  `shipLength` decimal(1,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ship1`
--

INSERT INTO `ship1` (`shipid`, `shipName`, `shipLength`) VALUES
('1', 'carrier', '5'),
('2', 'battleship', '4'),
('3', 'cruiser', '4'),
('4', 'yacht', '3'),
('5', 'smallboat', '2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `matchstats1`
--
ALTER TABLE `matchstats1`
  ADD PRIMARY KEY (`mid`),
  ADD KEY `fk_pid1` (`pid1`),
  ADD KEY `fk_pid2` (`pid2`);

--
-- Indexes for table `player1`
--
ALTER TABLE `player1`
  ADD PRIMARY KEY (`pid`),
  ADD UNIQUE KEY `u_email` (`email`);

--
-- Indexes for table `playership1`
--
ALTER TABLE `playership1`
  ADD PRIMARY KEY (`mid`,`pid`,`shipid`),
  ADD KEY `fk_pid` (`pid`),
  ADD KEY `fk_shipid` (`shipid`);

--
-- Indexes for table `ship1`
--
ALTER TABLE `ship1`
  ADD PRIMARY KEY (`shipid`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `matchstats1`
--
ALTER TABLE `matchstats1`
  ADD CONSTRAINT `fk_pid1` FOREIGN KEY (`pid1`) REFERENCES `player1` (`pid`),
  ADD CONSTRAINT `fk_pid2` FOREIGN KEY (`pid2`) REFERENCES `player1` (`pid`);

--
-- Constraints for table `playership1`
--
ALTER TABLE `playership1`
  ADD CONSTRAINT `fk_mid` FOREIGN KEY (`mid`) REFERENCES `matchstats1` (`mid`),
  ADD CONSTRAINT `fk_pid` FOREIGN KEY (`pid`) REFERENCES `player1` (`pid`),
  ADD CONSTRAINT `fk_shipid` FOREIGN KEY (`shipid`) REFERENCES `ship1` (`shipid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
