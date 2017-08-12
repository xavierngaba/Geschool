-- US1.4 - Ajoout d'une nouvelle colonne dans la table anneescolaire pour pouvoir récupérer l'année scolaire en cours
ALTER TABLE `anneescolaire` ADD `actif` INT NULL AFTER `Date_fin`;