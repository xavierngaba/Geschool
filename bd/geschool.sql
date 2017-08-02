-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 02, 2017 at 10:25 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `geschool`
--

-- --------------------------------------------------------

--
-- Table structure for table `anneescolaire`
--

CREATE TABLE IF NOT EXISTS `anneescolaire` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(25) NOT NULL,
  `Date_debut` date NOT NULL,
  `Date_fin` date NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `anneescolaire`
--

INSERT INTO `anneescolaire` (`Id`, `libelle`, `Date_debut`, `Date_fin`) VALUES
(1, 'SESS20172018', '2017-09-03', '2018-06-29');

-- --------------------------------------------------------

--
-- Table structure for table `classe`
--

CREATE TABLE IF NOT EXISTS `classe` (
  `IdClasse` int(11) NOT NULL AUTO_INCREMENT,
  `Libelle` varchar(25) NOT NULL,
  `Classe_Code` varchar(25) DEFAULT NULL,
  `IdGroupe` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdClasse`),
  KEY `IdGroupe` (`IdGroupe`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `classe`
--

INSERT INTO `classe` (`IdClasse`, `Libelle`, `Classe_Code`, `IdGroupe`) VALUES
(2, 'P1', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `discipline`
--

CREATE TABLE IF NOT EXISTS `discipline` (
  `IdDiscipline` int(11) NOT NULL AUTO_INCREMENT,
  `designation` varchar(25) NOT NULL,
  `IdNiveau` int(11) NOT NULL,
  PRIMARY KEY (`IdDiscipline`),
  KEY `IdNiveau` (`IdNiveau`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `eleve`
--

CREATE TABLE IF NOT EXISTS `eleve` (
  `IdEleve` int(11) NOT NULL AUTO_INCREMENT,
  `matricule` varchar(25) NOT NULL,
  `Nom` varchar(25) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `Date_Naiss` date NOT NULL,
  `adresses` varchar(100) NOT NULL,
  `telephone` varchar(25) NOT NULL,
  `dette` int(11) NOT NULL,
  `status` varchar(50) NOT NULL,
  `quantine` int(11) NOT NULL,
  `nationalite` varchar(50) NOT NULL,
  `sexe` varchar(10) NOT NULL,
  `email` varchar(100) NOT NULL,
  `Date_inscription` date NOT NULL,
  `IdTuteur` int(11) NOT NULL,
  PRIMARY KEY (`IdEleve`),
  KEY `IdTuteur` (`IdTuteur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `facture`
--

CREATE TABLE IF NOT EXISTS `facture` (
  `IdFacture` int(11) NOT NULL AUTO_INCREMENT,
  `Date_Facture` date NOT NULL,
  `Montant_Facture` int(11) NOT NULL,
  `Code_Facture` varchar(100) NOT NULL,
  `IdEleve` int(11) NOT NULL,
  PRIMARY KEY (`IdFacture`),
  KEY `IdEleve` (`IdEleve`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `groupe`
--

CREATE TABLE IF NOT EXISTS `groupe` (
  `IdGroupe` int(11) NOT NULL AUTO_INCREMENT,
  `designation` varchar(25) NOT NULL,
  `group_mensualite` int(11) NOT NULL,
  `group_frais_inscription` int(11) NOT NULL,
  `group_nb_mois` int(11) NOT NULL,
  `group_date_ouverture` date NOT NULL,
  `group_date_fermeture` date NOT NULL,
  `IdNiveau` int(11) NOT NULL,
  PRIMARY KEY (`IdGroupe`),
  KEY `IdNiveau` (`IdNiveau`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `groupe_utilisateur`
--

CREATE TABLE IF NOT EXISTS `groupe_utilisateur` (
  `IdGroupeUtilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `LibelleGroupeUtilisateur` varchar(50) NOT NULL,
  PRIMARY KEY (`IdGroupeUtilisateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `groupe_utilisateur`
--

INSERT INTO `groupe_utilisateur` (`IdGroupeUtilisateur`, `LibelleGroupeUtilisateur`) VALUES
(1, 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `inscrit`
--

CREATE TABLE IF NOT EXISTS `inscrit` (
  `IdInscrit` int(11) NOT NULL AUTO_INCREMENT,
  `IdAnnee` int(11) NOT NULL,
  `IdEleve` int(11) NOT NULL,
  `IdClasse` int(11) NOT NULL,
  PRIMARY KEY (`IdInscrit`),
  KEY `IdEleve` (`IdEleve`),
  KEY `IdClasse` (`IdClasse`),
  KEY `IdAnnee` (`IdAnnee`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `matiere`
--

CREATE TABLE IF NOT EXISTS `matiere` (
  `IdMatiere` int(11) NOT NULL AUTO_INCREMENT,
  `designation` varchar(50) NOT NULL,
  `IdProfesseur` int(11) NOT NULL,
  `Cod_matiere` int(11) NOT NULL,
  PRIMARY KEY (`IdMatiere`),
  KEY `IdProfesseur` (`IdProfesseur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `niveau`
--

CREATE TABLE IF NOT EXISTS `niveau` (
  `IdNiveau` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(25) NOT NULL,
  PRIMARY KEY (`IdNiveau`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `note`
--

CREATE TABLE IF NOT EXISTS `note` (
  `IdNote` int(11) NOT NULL AUTO_INCREMENT,
  `Note` int(11) NOT NULL,
  `Type_Not` varchar(100) NOT NULL,
  `IdMatiere` int(11) NOT NULL,
  `IdInscrit` int(11) NOT NULL,
  PRIMARY KEY (`IdNote`),
  KEY `IdMatiere` (`IdMatiere`),
  KEY `IdInscrit` (`IdInscrit`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `professeur`
--

CREATE TABLE IF NOT EXISTS `professeur` (
  `IdProfesseur` int(11) NOT NULL AUTO_INCREMENT,
  `nom_prenom` varchar(100) NOT NULL,
  `Code_prof` int(11) NOT NULL,
  PRIMARY KEY (`IdProfesseur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `reglement`
--

CREATE TABLE IF NOT EXISTS `reglement` (
  `IdReglement` int(11) NOT NULL AUTO_INCREMENT,
  `Reg_Code` int(11) NOT NULL,
  `Reg_Date` date NOT NULL,
  `Reg_Montant` int(11) NOT NULL,
  `Reg_Type` varchar(100) NOT NULL,
  `Reg_ref` varchar(100) NOT NULL,
  `Reg_Categories` varchar(100) NOT NULL,
  `IdEleves` int(11) NOT NULL,
  PRIMARY KEY (`IdReglement`),
  KEY `IdEleves` (`IdEleves`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `sequence`
--

CREATE TABLE IF NOT EXISTS `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '51');

-- --------------------------------------------------------

--
-- Table structure for table `tuteur`
--

CREATE TABLE IF NOT EXISTS `tuteur` (
  `IdTuteur` int(11) NOT NULL AUTO_INCREMENT,
  `tut_code` varchar(100) NOT NULL,
  `nom_prenom` varchar(100) NOT NULL,
  `telephone` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Adresse` varchar(100) NOT NULL,
  `Relation` varchar(100) NOT NULL,
  `profession` varchar(100) NOT NULL,
  PRIMARY KEY (`IdTuteur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `IdUtilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `nom_prenom` varchar(30) NOT NULL,
  `login` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `date_creation` date NOT NULL,
  `etat` int(2) NOT NULL,
  `groupe_utilisateur` int(11) NOT NULL,
  PRIMARY KEY (`IdUtilisateur`),
  KEY `groupe_utilisateur` (`groupe_utilisateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`IdUtilisateur`, `nom_prenom`, `login`, `password`, `date_creation`, `etat`, `groupe_utilisateur`) VALUES
(1, 'admin', 'admin', 'admin', '2017-08-02', 0, 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `classe_ibfk_1` FOREIGN KEY (`IdGroupe`) REFERENCES `groupe` (`IdGroupe`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `discipline`
--
ALTER TABLE `discipline`
  ADD CONSTRAINT `discipline_ibfk_1` FOREIGN KEY (`IdNiveau`) REFERENCES `niveau` (`IdNiveau`);

--
-- Constraints for table `eleve`
--
ALTER TABLE `eleve`
  ADD CONSTRAINT `eleve_ibfk_1` FOREIGN KEY (`IdTuteur`) REFERENCES `tuteur` (`IdTuteur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `facture_ibfk_1` FOREIGN KEY (`IdEleve`) REFERENCES `eleve` (`IdEleve`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `groupe`
--
ALTER TABLE `groupe`
  ADD CONSTRAINT `groupe_ibfk_1` FOREIGN KEY (`IdNiveau`) REFERENCES `niveau` (`IdNiveau`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `inscrit`
--
ALTER TABLE `inscrit`
  ADD CONSTRAINT `inscrit_ibfk_2` FOREIGN KEY (`IdClasse`) REFERENCES `classe` (`IdClasse`),
  ADD CONSTRAINT `inscrit_ibfk_1` FOREIGN KEY (`IdEleve`) REFERENCES `eleve` (`IdEleve`),
  ADD CONSTRAINT `inscrit_ibfk_3` FOREIGN KEY (`IdAnnee`) REFERENCES `anneescolaire` (`Id`);

--
-- Constraints for table `matiere`
--
ALTER TABLE `matiere`
  ADD CONSTRAINT `matiere_ibfk_1` FOREIGN KEY (`IdProfesseur`) REFERENCES `professeur` (`IdProfesseur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `note_ibfk_2` FOREIGN KEY (`IdInscrit`) REFERENCES `inscrit` (`IdInscrit`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `note_ibfk_1` FOREIGN KEY (`IdMatiere`) REFERENCES `matiere` (`IdMatiere`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `reglement`
--
ALTER TABLE `reglement`
  ADD CONSTRAINT `reglement_ibfk_1` FOREIGN KEY (`IdEleves`) REFERENCES `eleve` (`IdEleve`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`groupe_utilisateur`) REFERENCES `groupe_utilisateur` (`IdGroupeUtilisateur`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
