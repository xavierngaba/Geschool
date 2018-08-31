

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`IdUtilisateur`, `nom_prenom`, `login`, `password`, `date_creation`, `etat`, `groupe_utilisateur`) VALUES
(1, 'admin', 'admin', 'admin', '2017-08-02', 0, 1),
(2, 'gnali ines', 'Ines', 'Ines', '2018-07-11', 0, 2),
(3, 'Gilles Camo', 'gilles', 'gilles', '2018-07-11', 1, 3);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`groupe_utilisateur`) REFERENCES `groupe_utilisateur` (`IdGroupeUtilisateur`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
