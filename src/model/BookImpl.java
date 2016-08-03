package model;

public class BookImpl implements Book {

    private String title;
    private String author;
    private String literaryGenre;
    private int yearOfPublication;
    private int quantity;
    private double price;
    
    public BookImpl(){
        
    }
 public BookImpl(String title,String author,String literaryGenre,int yearOfPublication,int quantity,double price){
        this.title = title;
        this.author = author;
        this.literaryGenre = literaryGenre;
        this.yearOfPublication = yearOfPublication;
        this.quantity = quantity;
        this.price = price;
        
    }
@Override
public String getTitle() {
       return this.title;
}
@Override
public String getAuthor() {
    return this.author;
}
@Override
public String getLiteraryGenre() {
    return this.literaryGenre;
}
@Override
public int getyearOfPublication() {
   return this.yearOfPublication;
}
@Override
public int getQuantity() {
  return this.quantity;
}
@Override
public void setTitle(String title) {
    this.title = title;
    
}
@Override
public void setAuthor(String author) {
  this.author = author;
    
}
@Override
public void setLiteraryGenre(String genre) {
   this.literaryGenre =genre;
    
}
@Override
public void setYearOfPublication(int YOP) {
    this.yearOfPublication = YOP;
    
}
@Override
public void setQuantity(int quantity) {
   this.quantity = quantity;
    
}
@Override
public double getPrice() {
  return this.price;
}
@Override
public void setPrice(double price) {
  this.price = price;
}
    
}
