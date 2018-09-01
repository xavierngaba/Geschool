-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 01 sep. 2018 à 00:21
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `geschool`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `IdCours` int(11) NOT NULL AUTO_INCREMENT,
  `Designation` varchar(30) NOT NULL,
  `IdClasse` int(11) NOT NULL,
  `IdProfesseur` int(11) NOT NULL,
  `IdMatiere` int(11) NOT NULL,
  PRIMARY KEY (`IdCours`),
  KEY `IdProfesseur` (`IdProfesseur`,`IdMatiere`),
  KEY `Cours_Fk1` (`IdClasse`),
  KEY `Cours_Fk2` (`IdMatiere`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`IdCours`, `Designation`, `IdClasse`, `IdProfesseur`, `IdMatiere`) VALUES
(1, 'E1', 2, 1, 3);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `cours`
--
ALTER TABLE `cours`
  ADD CONSTRAINT `Cours_Fk1` FOREIGN KEY (`IdClasse`) REFERENCES `classe` (`IdClasse`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Cours_Fk2` FOREIGN KEY (`IdMatiere`) REFERENCES `matiere` (`IdMatiere`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Cours_Fk3` FOREIGN KEY (`IdProfesseur`) REFERENCES `professeur` (`IdProfesseur`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
