-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Servidor: sql11.freesqldatabase.com
-- Tiempo de generación: 04-06-2021 a las 08:02:44
-- Versión del servidor: 5.5.62-0ubuntu0.14.04.1
-- Versión de PHP: 7.0.33-0ubuntu0.16.04.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sql11415013`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `MESSAGE`
--

CREATE TABLE `MESSAGE` (
  `UID1` int(11) NOT NULL,
  `UID2` int(11) NOT NULL,
  `MESSAGE` varchar(256) NOT NULL,
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
  `MESSAGE` varchar(256) NOT NULL,
  `DATE` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `POST`
--

INSERT INTO `POST` (`PID`, `USERID`, `TITLE`, `MESSAGE`, `DATE`) VALUES
(1, 1, '', 'Test message', '2021-05-19'),
(2, 20, 'a', 'a', '2021-05-31'),
(8, 20, 'aa', 'aa', '2021-05-31'),
(9, 20, 'aa', 'aaaas', '2021-05-31'),
(10, 20, 'aaaaaaaaa', 'Body', '2021-05-31'),
(11, 20, 'asdfsadfsa', 'asdfasdfads', '2021-05-31'),
(12, 20, 'ESto es un test de un texto muy largo', 'Espero que te guste wapo hehehehehehehehehheheeh', '2021-06-03'),
(13, 20, 'HEHEHEHEHEHEHEHEHEHEHEHEHEHE', 'HEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHE', '2021-06-03'),
(14, 20, 'a', 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', '2021-06-03'),
(15, 20, 'this is new', 'hello', '2021-06-03'),
(16, 20, 'eeee', 'aaa', '2021-06-03'),
(17, 24, 'Hola', 'prueba para presentacion ', '2021-06-04');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `USER`
--

CREATE TABLE `USER` (
  `UID` int(11) NOT NULL,
  `USERNAME` varchar(32) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `PASSWORD` varchar(256) NOT NULL,
  `NAME` varchar(32) NOT NULL,
  `SURNAME` varchar(32) NOT NULL,
  `IMGURL` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `USER`
--

INSERT INTO `USER` (`UID`, `USERNAME`, `EMAIL`, `PASSWORD`, `NAME`, `SURNAME`, `IMGURL`) VALUES
(20, 'test', 'test', '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'test', 'test', 'https://www.antiagingya.com/es/wp-ontent/uploads/2015/01/img-default-autores.jpg'),
(21, 'root', 'root@root', '4813494d137e1631bba301d5acab6e7bb7aa74ce1185d456565ef51d737677b2', 'root', 'root', 'https://www.antiagingya.com/es/wp-content/uploads/2015/01/img-default-autores.jpg'),
(24, 'prova', 'prova@example.com', '6258a5e0eb772911d4f92be5b5db0e14511edbe01d1d0ddd1d5a2cb9db9a56ba', 'alex', 'sanchez', 'https://wonder-day.com/wp-content/uploads/2020/10/wonder-day-among-us-21.png'),
(26, 'test2', 'test2@gmail.com', '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'pol', 'kun', 'https://wonder-day.com/wp-content/uploads/2020/10/wonder-day-among-us-21.png');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `MESSAGE`
--
ALTER TABLE `MESSAGE`
  ADD PRIMARY KEY (`DATE`),
  ADD KEY `UID1` (`UID1`),
  ADD KEY `UID2` (`UID2`);

--
-- Indices de la tabla `POST`
--
ALTER TABLE `POST`
  ADD PRIMARY KEY (`PID`);

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
  MODIFY `PID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT de la tabla `USER`
--
ALTER TABLE `USER`
  MODIFY `UID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
