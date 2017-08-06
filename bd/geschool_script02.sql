-- US1.4 - Modification de la table eleve en tenant compte des champs vides
ALTER TABLE `eleve` CHANGE `adresses` `adresses` VARCHAR(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL, 
                    CHANGE `telephone` `telephone` VARCHAR(25) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL, 
                    CHANGE `dette` `dette` INT(11) NULL, CHANGE `quantine` `quantine` INT(11) NULL, 
                    CHANGE `email` `email` VARCHAR(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL;

-- Modification de la table tuteur
ALTER TABLE `tuteur` CHANGE `Email` `Email` VARCHAR(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL, 
                     CHANGE `profession` `profession` VARCHAR(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL;