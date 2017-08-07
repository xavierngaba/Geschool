/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.interfaces;

import geschool.persistence.model.Inscrit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author xavier_ng
 */
@Local
public interface InscritDAO {
    void creerUneInscription(Inscrit i);
    void modifierUneInscription(Inscrit i);
    Inscrit rechercherInscritAvecId(Integer idInscrit);
    List<Inscrit> rechercherToutesLesInscriptions();
    List<Inscrit> rechercherToutesLesElevesInscritsDansUneClasseUneAnnee(Integer idClasse,Integer idAnnee);
    List<Inscrit> rechercherToutesLesElevesInscritsPourUneAnnee(Integer idAnnee);
    List<Inscrit> rechercherToutesLesInscriptionsEleve(Integer idEleve);
}
