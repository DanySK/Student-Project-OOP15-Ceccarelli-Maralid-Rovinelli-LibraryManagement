package model;

public class SubscriptionImpl implements SubscriptionModel {

    private static final long serialVersionUID = 1L; 
    private String name;
    private String surname;
    private String type;
    private int books;
   
    @Override
    public Long getId() {
        return SubscriptionImpl.serialVersionUID ;
    }
    @Override
    public String getName() {
       return this.name;
    }
    @Override
    public String getSurname() {
        return this.surname;
    }
    @Override
    public String getType() {
        return this.type;
    }
    @Override
    public int getBook() {
        return this.books;
    }

   
    @Override
    public void setName(String name) {
        this.name = name;
        
    }
    @Override
    public void setSurname(String surname) {
        this.surname = surname;
        
    }
    @Override
    public void setType(String type) {
        this.type = type;
        
    }
    @Override
    public void setBook(int book) {
       this.books = book;
       }
}
