--
-- Structure de la table `typereglement`
--

CREATE TABLE IF NOT EXISTS `typereglement` (
  `idTypeReglement` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idTypeReglement`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Contenu de la table `typereglement`
--

INSERT INTO `typereglement` (`idTypeReglement`, `libelle`) VALUES
(1, 'Mensuel'),
(2, 'Trimestriel'),
(3, 'Annuel');

ALTER TABLE `reglement` CHANGE `Reg_Type` `Reg_Type` INT(11) NOT NULL;
ALTER TABLE `reglement` ADD INDEX(`Reg_Type`);
ALTER TABLE `reglement` ADD FOREIGN KEY (`Reg_Type`) REFERENCES `geschool`.`typereglement`(`idTypeReglement`) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE `reglement` CHANGE `Reg_ref` `Reg_ref` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL, CHANGE `Reg_Categories` `Reg_Categories` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;
ALTER TABLE `reglement` CHANGE `Reg_Code` `Reg_Code` VARCHAR(11) NOT NULL;
ALTER TABLE `eleve` CHANGE `Nom` `Nom` VARCHAR(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL, CHANGE `Prenom` `Prenom` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL;
ALTER TABLE `tuteur` CHANGE `nom_prenom` `nom_prenom` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL, CHANGE `Adresse` `Adresse` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL, CHANGE `Relation` `Relation` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL, CHANGE `profession` `profession` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL;
