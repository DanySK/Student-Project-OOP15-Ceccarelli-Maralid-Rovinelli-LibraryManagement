package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public interface IOModel {
    /** datogli il file restituisce il contenuto del file suddiviso per righe
     * @throws IOException */
   public Map<Integer,ArrayList<String>> readFile(String path) throws IOException;
   /**scrittura di un nuovo dato,dato il path da scrivere e il/i dati da scrivere
    * il primo paragrafo è il nome del file.txt
    * il secondo è l'ArrayList<String> che contiene le cose da scrivere.
    * @param pathWrite
    * @param line
    */
   public void writeNewLine(String pathWrite,ArrayList<String> line);
   /**restituisce una Map che contiente i valori corrispondenti alla ricerca 
    * mappa in cui effettuare una ricerca
    * colonna del dato da ricercare
    * valore da ricercare*/
   public Map<Integer,ArrayList<String>> searchInFile(Map<Integer,ArrayList<String>> completeList,Integer idSearch,String nameSearch);
}
