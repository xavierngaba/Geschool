/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author inesG
 */
public enum TypeReglementEnum {
    Mensuel("1","Mensuel"),
    Trimestriel("2","Trimestriel"),
    Annuel("3","Annuel");
    
    private final String id;
    private final String libelle;
    
    TypeReglementEnum(String id, String libelle){
        this.id = id;
        this.libelle = libelle;
    }

    public String getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }
    
    public static List<TypeReglementEnum> ToutesLesTypeDeReglement(){
        List<TypeReglementEnum> l = new ArrayList<TypeReglementEnum>();
        l.add(Mensuel);
        l.add(Trimestriel);
        l.add(Annuel);
        return l;
    }
    
    public static Integer rechercheIdTypeReglement(String libelle){
        Integer id = null;
        
        for (TypeReglementEnum t : values()) {
            if(libelle.equals(t.Mensuel.getLibelle())){
               id = Integer.parseInt(t.Mensuel.getId());
            }else if(libelle.equals(t.Trimestriel.getLibelle())){
                id = Integer.parseInt(t.Trimestriel.getId());
            }else if(libelle.equals(t.Annuel.getLibelle())){
                id = Integer.parseInt(t.Annuel.getId());
            }
        }
        return id;
    }
    
    public static TypeReglementEnum rechercheTypeReglement(String libelle){
        TypeReglementEnum id = null;
        for (TypeReglementEnum t : values()) {
            if(libelle.equals(t.Mensuel.getLibelle())){
               id = t.Mensuel;
            }else if(libelle.equals(t.Trimestriel.getLibelle())){
                id = t.Trimestriel;
            }else if(libelle.equals(t.Annuel.getLibelle())){
                id = t.Annuel;
            }
        }
        return id;
    }
}

