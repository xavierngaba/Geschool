-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Dim 03 Décembre 2017 à 20:44
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `geschool`
--

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

CREATE TABLE IF NOT EXISTS `note` (
  `IdNote` int(11) NOT NULL AUTO_INCREMENT,
  `Note` int(11) NOT NULL,
  `IdTypeNote` int(11) NOT NULL,
  `IdMatiereClasse` int(11) NOT NULL,
  `IdEleve` int(11) NOT NULL,
  PRIMARY KEY (`IdNote`),
  KEY `IdMatiere` (`IdMatiereClasse`),
  KEY `IdInscrit` (`IdEleve`),
  KEY `IdEleve` (`IdEleve`),
  KEY `IdTypeNote` (`IdTypeNote`),
  KEY `IdTypeNote_2` (`IdTypeNote`),
  KEY `IdTypeNote_3` (`IdTypeNote`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `note_ibfk_3` FOREIGN KEY (`IdTypeNote`) REFERENCES `typenote` (`IdTypeNote`),
  ADD CONSTRAINT `note_ibfk_1` FOREIGN KEY (`IdMatiereClasse`) REFERENCES `matiereclasse` (`IdMClasse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `note_ibfk_2` FOREIGN KEY (`IdEleve`) REFERENCES `eleve` (`IdEleve`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
