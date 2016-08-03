/**
 * 
 */
package model;

/**
 * @author Rovinelli
 *
 */
public interface Book {
    public String getTitle();
    public String getAuthor();
    public String getLiteraryGenre();
    public int getyearOfPublication();
    public int getQuantity();
    public double getPrice();
    
    public void setTitle(String title);
    public void setAuthor(String author);
    public void setLiteraryGenre(String genre);
    public void setYearOfPublication(int YOP);
    public void setQuantity(int quantity);
    public void setPrice(double price);
    
}
