package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public interface IOModel {
    /** datogli il file restituisce il contenuto del file suddiviso per righe
     * @throws IOException */
   public Map<Integer,ArrayList<String>> readFile(String path) throws IOException;
}
