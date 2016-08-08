/**
 * 
 */
package model;

/**
 * @author Rovinelli
 *
 */
public interface BookModel {
    /**metodo per ricevere il nome del libro*/
    public String getTitle();
    /**metodo per ricevere un autore in stringa*/
    public String getAuthor();
    /**metodo per riceve il genere del libro in string*/
    public String getLiteraryGenre();
    /**ritorna l'hanno di pubblicazione del libro*/
    public int getyearOfPublication();
    /**ritora il prezzo del libro*/
    public double getPrice();
    
    public void setTitle(String title);
    public void setAuthor(String author);
    public void setLiteraryGenre(String genre);
    public void setYearOfPublication(int YOP);
    public void setPrice(double price);
    
}
