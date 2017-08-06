/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.interfaces;

import geschool.persistence.model.Eleve;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author xavier_ng
 */
@Local
public interface EleveDAO {
    void creerEleve(Eleve e);
    void modifEleve(Eleve e);
    List<Eleve> rechercherTousLesEleves();
    Eleve rechercherUnEleveAvecId(Integer idEleve);
    Eleve rechercherUnEleveAvecMatricule(String matricule);
    Eleve rechercherUnEleveAvecNomEtPrenom(String nom,String prenom);
    Integer rechercherLeNombreTotalEleve();
}
