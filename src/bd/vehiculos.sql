-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-07-2025 a las 01:03:47
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `vehiculos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_usuario`
--

CREATE TABLE `tb_usuario` (
  `id_usuario` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `contraseña` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tb_usuario`
--

INSERT INTO `tb_usuario` (`id_usuario`, `usuario`, `contraseña`) VALUES
(1, 'asd', 'asd'),
(2, 'asd', 'asd'),
(3, 'juan', '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_vehiculo`
--

CREATE TABLE `tb_vehiculo` (
  `id_vehiculo` int(11) NOT NULL,
  `placa` varchar(15) NOT NULL,
  `propietario` varchar(100) NOT NULL,
  `tipo_vehiculo` varchar(50) NOT NULL,
  `hora_entrada` datetime NOT NULL,
  `hora_salida` datetime DEFAULT NULL,
  `valor_pagado` decimal(10,2) DEFAULT 0.00,
  `estado` varchar(20) DEFAULT 'activo',
  `id_usuario` int(11) DEFAULT NULL,
  `tipo_cliente` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tb_vehiculo`
--

INSERT INTO `tb_vehiculo` (`id_vehiculo`, `placa`, `propietario`, `tipo_vehiculo`, `hora_entrada`, `hora_salida`, `valor_pagado`, `estado`, `id_usuario`, `tipo_cliente`) VALUES
(1, 'asdf12', 'jaime', 'Automovil', '2025-07-06 19:46:59', '2025-07-06 19:47:24', 0.00, 'EGRESADO', 1, 'RECURRENTE'),
(2, 'RYU548', 'Remi', 'Motocicleta', '2025-07-06 20:21:58', '2025-07-06 20:22:42', 0.00, 'EGRESADO', 3, 'NINGUNO'),
(3, 'asdasd', 'asdasd', 'Automovil', '2025-07-06 20:34:51', '2025-07-08 17:08:56', 22.50, 'EGRESADO', 1, 'NINGUNO'),
(4, 'KGH-123', 'Lupe', 'Automovil', '2025-07-06 20:37:04', '2025-07-07 16:49:56', 10.00, 'EGRESADO', 1, 'NINGUNO'),
(5, 'HJK-143', 'Lujan', 'Motocicleta', '2025-07-06 22:10:44', NULL, 0.00, 'INGRESADO', 1, 'NINGUNO'),
(6, 'ASD-567', 'Jira', 'Motocicleta', '2025-07-06 22:18:22', NULL, 0.00, 'INGRESADO', 1, 'NINGUNO'),
(7, 'RTY-465', 'Qebin', 'Automovil', '2025-07-06 22:19:48', NULL, 0.00, 'INGRESADO', 1, 'NINGUNO'),
(8, 'ASD-754', 'Julio', 'Automovil', '2025-07-07 17:18:59', NULL, 0.00, 'INGRESADO', 1, 'NINGUNO'),
(9, 'GFD-485', 'Perez', 'Automovil', '2025-07-08 16:39:39', NULL, 0.00, 'INGRESADO', 1, 'NINGUNO'),
(13, 'JHG-421', 'Cristian', 'Motocicleta', '2025-07-08 17:43:47', NULL, 0.00, 'INGRESADO', 1, 'NINGUNO'),
(14, 'ERT-154', 'Tius', 'Motocicleta', '2025-07-08 18:02:31', NULL, 0.00, 'INGRESADO', 1, 'Discapacitado');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tb_usuario`
--
ALTER TABLE `tb_usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Indices de la tabla `tb_vehiculo`
--
ALTER TABLE `tb_vehiculo`
  ADD PRIMARY KEY (`id_vehiculo`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tb_usuario`
--
ALTER TABLE `tb_usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tb_vehiculo`
--
ALTER TABLE `tb_vehiculo`
  MODIFY `id_vehiculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tb_vehiculo`
--
ALTER TABLE `tb_vehiculo`
  ADD CONSTRAINT `tb_vehiculo_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuario` (`id_usuario`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
