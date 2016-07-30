package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public interface ReadWriteModificationFile {
    /** datogli il file restituisce il contenuto del file suddiviso per righe
     * @throws IOException */
   public Map<Integer,ArrayList<String>> readLineFile(String path) throws IOException;
   
  
}
