--
-- Structure de la table `notification`
--

CREATE TABLE IF NOT EXISTS `notification` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `commentaire` text NOT NULL,
  `status` varchar(50) NOT NULL,
  `dateCr` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;