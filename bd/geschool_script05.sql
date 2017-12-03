ALTER TABLE `classe` ADD `Montant` INT NOT NULL AFTER `Libelle`;
ALTER TABLE `eleve` CHANGE `nationalite` `nationalite` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL;