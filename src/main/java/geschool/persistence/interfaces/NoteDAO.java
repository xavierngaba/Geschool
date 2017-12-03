package geschool.persistence.interfaces;

import geschool.persistence.model.Note;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author InesG
 */
@Local
public interface NoteDAO {    
    void creerNote(Note note);
    List<Note> rechercherToutesLesNotes();
}
