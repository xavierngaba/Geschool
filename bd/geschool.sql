-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 01 Août 2017 à 22:35
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
-- Structure de la table `anneescolaire`
--

CREATE TABLE IF NOT EXISTS `anneescolaire` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(25) NOT NULL,
  `Date_debut` date NOT NULL,
  `Date_fin` date NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE IF NOT EXISTS `classe` (
  `IdClasse` int(11) NOT NULL AUTO_INCREMENT,
  `Libelle` varchar(25) NOT NULL,
  `Classe_Code` varchar(25) NOT NULL,
  `IdGroupe` int(11) NOT NULL,
  PRIMARY KEY (`IdClasse`),
  KEY `IdGroupe` (`IdGroupe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `discipline`
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
-- Structure de la table `eleve`
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
-- Structure de la table `facture`
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
-- Structure de la table `groupe`
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
-- Structure de la table `groupe_utilisateur`
--

CREATE TABLE IF NOT EXISTS `groupe_utilisateur` (
  `IdGroupeUtilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `LibelleGroupeUtilisateur` varchar(50) NOT NULL,
  PRIMARY KEY (`IdGroupeUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `inscrit`
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
-- Structure de la table `matiere`
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
-- Structure de la table `niveau`
--

CREATE TABLE IF NOT EXISTS `niveau` (
  `IdNiveau` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(25) NOT NULL,
  PRIMARY KEY (`IdNiveau`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `note`
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
-- Structure de la table `professeur`
--

CREATE TABLE IF NOT EXISTS `professeur` (
  `IdProfesseur` int(11) NOT NULL AUTO_INCREMENT,
  `nom_prenom` varchar(100) NOT NULL,
  `Code_prof` int(11) NOT NULL,
  PRIMARY KEY (`IdProfesseur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `reglement`
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
-- Structure de la table `tuteur`
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
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `IdUtilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `nom_prenom` int(11) NOT NULL,
  `login` int(11) NOT NULL,
  `password` int(11) NOT NULL,
  `date_creation` int(11) NOT NULL,
  `etat` int(11) NOT NULL,
  `groupe_utilisateur` int(11) NOT NULL,
  PRIMARY KEY (`IdUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `classe_ibfk_1` FOREIGN KEY (`IdGroupe`) REFERENCES `groupe` (`IdGroupe`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `discipline`
--
ALTER TABLE `discipline`
  ADD CONSTRAINT `discipline_ibfk_1` FOREIGN KEY (`IdNiveau`) REFERENCES `niveau` (`IdNiveau`);

--
-- Contraintes pour la table `eleve`
--
ALTER TABLE `eleve`
  ADD CONSTRAINT `eleve_ibfk_1` FOREIGN KEY (`IdTuteur`) REFERENCES `tuteur` (`IdTuteur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `facture_ibfk_1` FOREIGN KEY (`IdEleve`) REFERENCES `eleve` (`IdEleve`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD CONSTRAINT `groupe_ibfk_1` FOREIGN KEY (`IdNiveau`) REFERENCES `niveau` (`IdNiveau`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `inscrit`
--
ALTER TABLE `inscrit`
  ADD CONSTRAINT `inscrit_ibfk_2` FOREIGN KEY (`IdClasse`) REFERENCES `classe` (`IdClasse`),
  ADD CONSTRAINT `inscrit_ibfk_1` FOREIGN KEY (`IdEleve`) REFERENCES `eleve` (`IdEleve`),
  ADD CONSTRAINT `inscrit_ibfk_3` FOREIGN KEY (`IdAnnee`) REFERENCES `anneescolaire` (`Id`);

--
-- Contraintes pour la table `matiere`
--
ALTER TABLE `matiere`
  ADD CONSTRAINT `matiere_ibfk_1` FOREIGN KEY (`IdProfesseur`) REFERENCES `professeur` (`IdProfesseur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `note_ibfk_2` FOREIGN KEY (`IdInscrit`) REFERENCES `inscrit` (`IdInscrit`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `note_ibfk_1` FOREIGN KEY (`IdMatiere`) REFERENCES `matiere` (`IdMatiere`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reglement`
--
ALTER TABLE `reglement`
  ADD CONSTRAINT `reglement_ibfk_1` FOREIGN KEY (`IdEleves`) REFERENCES `eleve` (`IdEleve`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
