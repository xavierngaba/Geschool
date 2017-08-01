/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ines.G
 */
public final class ConvertDateYear {
    public static List<Date> DateTransform (String DateList)throws ParseException{
        List<Date> dateListe = new ArrayList<Date>();
        String dateStr = DateList;
         String[] dateList = dateStr.split("-");
        SimpleDateFormat formater = new SimpleDateFormat("MM/dd/yyyy");
        
        dateListe.add(formater.parse(dateList[0]));
        dateListe.add(formater.parse(dateList[1]));
        return dateListe;
    }
   
   public static List<Integer> YearTransform (List<Date> DateList)throws ParseException{
        List<Integer> YearListe = new ArrayList<Integer>();
        SimpleDateFormat formaterYear = new SimpleDateFormat("yyyy");
        
        YearListe.add(Integer.parseInt(formaterYear.format(DateList.get(0))));
        YearListe.add(Integer.parseInt(formaterYear.format(DateList.get(1))));
        return YearListe;
    }
}
