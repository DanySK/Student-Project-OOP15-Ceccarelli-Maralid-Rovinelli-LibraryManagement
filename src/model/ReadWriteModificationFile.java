package model;

import java.util.ArrayList;
import java.util.Map;

public interface ReadWriteModificationFile {
    /** datogli il file restituisce il contenuto del file suddiviso per righe*/
   public Map<Integer,ArrayList<String>> readLineFile(String path);
   
  
}
