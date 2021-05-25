-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 25-05-2021 a las 11:11:24
-- Versión del servidor: 10.3.29-MariaDB-0ubuntu0.20.04.1
-- Versión de PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `reConnectDB`
--
CREATE DATABASE IF NOT EXISTS `reConnectDB` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `reConnectDB`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `MESSAGE`
--

CREATE TABLE `MESSAGE` (
  `UID1` int(11) NOT NULL,
  `UID2` int(11) NOT NULL,
  `MESSAGE` varchar(370) NOT NULL,
  `DATE` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `POST`
--

CREATE TABLE `POST` (
  `PID` int(11) NOT NULL,
  `USERID` int(11) NOT NULL,
  `TITLE` varchar(58) NOT NULL,
  `MESSAGE` varchar(370) NOT NULL,
  `DATE` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `USER`
--

CREATE TABLE `USER` (
  `UID` int(11) NOT NULL,
  `USERNAME` varchar(32) NOT NULL,
  `EMAIL` varchar(256) NOT NULL,
  `PASSWORD` varchar(256) NOT NULL,
  `NAME` varchar(32) NOT NULL,
  `SURNAME` varchar(32) NOT NULL,
  `IMGURL` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `USER`
--

INSERT INTO `USER` (`UID`, `USERNAME`, `EMAIL`, `PASSWORD`, `NAME`, `SURNAME`, `IMGURL`) VALUES
(1, 'test', 'test@test.com', '9390298f3fb0c5b160498935d79cb139aef28e1c47358b4bbba61862b9c26e59', 'a', 'a', 'https://www.antiagingya.com/es/wp-content/uploads/2015/01/img-default-autores.jpg');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `MESSAGE`
--
ALTER TABLE `MESSAGE`
  ADD KEY `UID1` (`UID1`),
  ADD KEY `UID2` (`UID2`);

--
-- Indices de la tabla `POST`
--
ALTER TABLE `POST`
  ADD PRIMARY KEY (`PID`),
  ADD KEY `USERID` (`USERID`);

--
-- Indices de la tabla `USER`
--
ALTER TABLE `USER`
  ADD PRIMARY KEY (`UID`),
  ADD UNIQUE KEY `UID` (`UID`),
  ADD UNIQUE KEY `USERNAME` (`USERNAME`),
  ADD UNIQUE KEY `EMAIL` (`EMAIL`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `POST`
--
ALTER TABLE `POST`
  MODIFY `PID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `USER`
--
ALTER TABLE `USER`
  MODIFY `UID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
