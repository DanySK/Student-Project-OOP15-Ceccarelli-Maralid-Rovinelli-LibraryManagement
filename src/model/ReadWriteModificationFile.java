package model;

import java.util.ArrayList;

public interface ReadWriteModificationFile {
    /** datogli il file restituisce il contenuto del file suddiviso per righe*/
   public ArrayList<String> readLineFile(String file);
   
  
}
