-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 01 mai 2022 à 11:51
-- Version du serveur :  10.4.18-MariaDB
-- Version de PHP : 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `puissance4`
--

-- --------------------------------------------------------

--
-- Structure de la table `cpu`
--

CREATE TABLE `cpu` (
  `ID` int(5) NOT NULL,
  `DESCRIPTION` varchar(20) DEFAULT NULL,
  `DEPTH` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cpu`
--

INSERT INTO `cpu` (`ID`, `DESCRIPTION`, `DEPTH`) VALUES
(4, 'Hard', 4),
(6, 'ok', 8);

-- --------------------------------------------------------

--
-- Structure de la table `game`
--

CREATE TABLE `game` (
  `ID` int(20) NOT NULL,
  `PLAYER_1` int(10) DEFAULT NULL,
  `PLAYER_2` int(10) DEFAULT NULL,
  `CPU` int(5) DEFAULT NULL,
  `GRID_SIZE_row` int(8) DEFAULT NULL,
  `GRID_SIZE_col` int(10) DEFAULT NULL,
  `RESULT` int(2) DEFAULT NULL,
  `DATETIME_START` time DEFAULT NULL,
  `DURATION` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `player`
--

CREATE TABLE `player` (
  `ID` int(10) NOT NULL,
  `USERNAME` varchar(15) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `PERMISSION` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `player`
--

INSERT INTO `player` (`ID`, `USERNAME`, `EMAIL`, `PASSWORD`, `PERMISSION`) VALUES
(1, 'oakajf', 'lad@yahhoo.fr', '123456', 2);

-- --------------------------------------------------------

--
-- Structure de la table `turn`
--

CREATE TABLE `turn` (
  `GAME_ID` int(20) NOT NULL,
  `TURN` int(80) NOT NULL,
  `PLAYER_ID` int(10) DEFAULT NULL,
  `X` int(10) DEFAULT NULL,
  `Y` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `cpu`
--
ALTER TABLE `cpu`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Fk_Game_player1` (`PLAYER_1`),
  ADD KEY `Fk_Game_player2` (`PLAYER_2`),
  ADD KEY `Fk_Game_cpu` (`CPU`);

--
-- Index pour la table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `turn`
--
ALTER TABLE `turn`
  ADD PRIMARY KEY (`GAME_ID`,`TURN`),
  ADD KEY `FK_Turn1` (`PLAYER_ID`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `game`
--
ALTER TABLE `game`
  ADD CONSTRAINT `Fk_Game_cpu` FOREIGN KEY (`CPU`) REFERENCES `cpu` (`ID`),
  ADD CONSTRAINT `Fk_Game_player1` FOREIGN KEY (`PLAYER_1`) REFERENCES `player` (`ID`),
  ADD CONSTRAINT `Fk_Game_player2` FOREIGN KEY (`PLAYER_2`) REFERENCES `player` (`ID`);

--
-- Contraintes pour la table `turn`
--
ALTER TABLE `turn`
  ADD CONSTRAINT `FK_Turn` FOREIGN KEY (`GAME_ID`) REFERENCES `game` (`ID`),
  ADD CONSTRAINT `FK_Turn1` FOREIGN KEY (`PLAYER_ID`) REFERENCES `player` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
