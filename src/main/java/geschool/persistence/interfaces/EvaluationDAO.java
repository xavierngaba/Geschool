/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.interfaces;

import geschool.persistence.model.Evaluation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author IGNES
 */
@Local
public interface EvaluationDAO {
    void creerEvaluation(Evaluation c);
    void modifierEvaluation(Evaluation c);
    List<Evaluation> rechercherToutesLesEvaluation();
    Evaluation rechercherEvaluationParId (Integer id);
    Evaluation rechercherEvaluationParLibelleCours(String l);
    Long verifEvaluationExist(String l);
//    Integer rechercherLeNombreCoursEvaluation(Integer id);
}   