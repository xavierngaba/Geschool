INSERT INTO `groupeutilisateur`(`idGroupeUtilisateur`, `libelleGroupeUtilisateur`) VALUES (1,'admin');
INSERT INTO `utilisateur`(`idUtilisateur`, `nomUtilisateur`, `login`, `password`, `dateCreation`, `etatConnexion`, `GroupeUtilisateur_idGroupeUtilisateur`) 
				  VALUES (1,'admin','admin','admin',NOW(),0,1)
--
-- Table structure for table `sequence`
--

CREATE TABLE IF NOT EXISTS `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '1');