package geschool.persistence.impl;

import geschool.persistence.interfaces.NoteDAO;
import geschool.persistence.model.Note;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author msgomis
 */
@Stateless
public class NoteDAOImpl implements NoteDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void creerNote(Note f) {
        if (f != null) {
            em.persist(f);
        }
    }

    @Override
    public List<Note> rechercherToutesLesNotes() {
        return em.createNamedQuery("Note.findAll").getResultList();
    }


}
