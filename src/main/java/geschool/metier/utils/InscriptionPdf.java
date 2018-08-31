/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.utils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import geschool.persistence.interfaces.InscritDAO;
import geschool.persistence.interfaces.SessionDAO;
import geschool.persistence.model.Inscrit;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xavier_ng
 */
public final class InscriptionPdf {
    public void genererPDF(InscritDAO iDAO,SessionDAO aDAO, HttpServletResponse resp){
        Document document = new Document(PageSize.A4);
        Date d = new Date();
        SimpleDateFormat formater1 = new SimpleDateFormat("ddMMyyyy");
        SimpleDateFormat formater2 = new SimpleDateFormat("dd MMMM yyyy HH:mm");
        try {
            resp.setContentType("application/pdf");
            resp.setHeader("Content-Disposition", "inline;filename=liste-"+formater1.format(d)+".pdf");
            PdfWriter.getInstance(document, resp.getOutputStream());
            document.open(); 
            
            Paragraph paragraph = new Paragraph(new Phrase("Liste des élèves inscription en cours",FontFactory.getFont(FontFactory.COURIER, 15, Font.BOLD, BaseColor.BLACK)));
            paragraph.setAlignment(Element.ALIGN_CENTER);
            Chapter chapter = new Chapter(paragraph, 1);
            chapter.setNumberDepth(0);
            
            Section section = chapter.addSection(new Paragraph(""), 5);
            section.setNumberDepth(0);
            
            Paragraph paragraph1 = new Paragraph("");
            Phrase ph = new Phrase("Date : "+formater2.format(d)+"\n",FontFactory.getFont(FontFactory.COURIER, 10, Font.BOLD, BaseColor.BLACK));
            paragraph1.add(ph);
            paragraph1.setAlignment(Element.ALIGN_LEFT);
            section.add(paragraph1);
            
            PdfPTable table = new PdfPTable(4);
            table.addCell("Nom & Prénom");
            table.addCell("Classe");
            table.addCell("Montant versé");
            table.addCell("Reste à payer");
            List<Inscrit> listEleveInscrit = iDAO.rechercherToutesLesElevesInscritPasFiniUneAnnee(aDAO.chercherSessionEnCours().getId());
            for (Inscrit eleveInscrit : listEleveInscrit) {
                table.addCell(eleveInscrit.getIdEleve().getNom()+" "+eleveInscrit.getIdEleve().getPrenom());
                table.addCell(eleveInscrit.getIdClasse().getLibelle());
                table.addCell(""+(eleveInscrit.getIdClasse().getMontant() - eleveInscrit.getIdEleve().getDette())+" frs CFA");
                table.addCell(""+eleveInscrit.getIdEleve().getDette()+" frs CFA");
            }
            
            document.add(chapter);
            document.add(table);
            document.close();
        } catch (DocumentException de) {
            de.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
