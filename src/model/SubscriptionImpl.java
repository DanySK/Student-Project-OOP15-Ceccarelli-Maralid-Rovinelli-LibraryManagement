package model;

import java.io.Serializable;

/**
 * This class represents a subscription.
 * The subscription is made when a customer wants to subscribe to receive discounts at the checkout.
 * @author Mattia.Rovinelli
 *
 */
public class SubscriptionImpl implements SubscriptionModel, Serializable {

    private static final long serialVersionUID = 1L; 
    private String name;
    private String surname;
    private String type;
    private int books ;
    
    public SubscriptionImpl(String name,String surname,String type,int books){
       this.name = name;
       this.surname = surname;
       this.type = type;
       this.books = books;
    }
    
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
    public void addBook(int book) {
       this.books += book;
       }
}
