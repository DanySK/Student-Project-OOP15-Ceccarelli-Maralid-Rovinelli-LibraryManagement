package model;

import java.io.IOException;
import java.util.Map;

public interface StreamModel<T,X> {
    /**metodo di lettura di un file
     * resituisce una mappa numerata con all'interno l'apposita classe
     * basta passargli il file di destinazione
     * @param path
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Map<X,T> readFile(String path) throws IOException, ClassNotFoundException;
    /** metodo per scrivere in un file dato il file e la classe che si vuole scrivere nel file
     *
     * @param path
     * @param o
     */
    public void writeFile(String path,T o);
    /**metodo di ricerca di un dato tramite una mappa e il datoda ricercare
     * 
     * @param genericMap
     * @param field
     * @return
     */
    public Object search(Map<Integer,T> genericMap,String field);
    /** metodo per gestire lo user corrente*/
  
}
