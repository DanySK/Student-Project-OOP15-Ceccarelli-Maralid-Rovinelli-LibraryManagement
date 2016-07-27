package model;

import java.io.Serializable;

public abstract class AbstractPerson implements Serializable ,AbstractPersonInterface {

    
    private static final long serialVersionUID = 1L;
    protected String taxCode;
    protected String name;
    protected String surname;
    protected String email;
    /**costruttore astrato della classe persona */
    public AbstractPerson(String taxCode,String name,String surname ,String email){
        this.taxCode = taxCode;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    /**metodo per leggere il codice fiscale*/
    public String getTaxCode(){
        return taxCode;     
    }
    /**metodo per settare il cf*/
    public void setTaxCode(String taxCode){
        this.taxCode = taxCode;
    }
    /**metodo per leggere il nome di una persona*/
    public String getName(){
        return name;
    }
    /**metodo per leggere il nome*/
    public void setName(String name){
        this.name = name;
    }
    /**metodo per leggere il cognome*/
    public String getSurname(){
        return surname;
    }
    /**metodo per leggere il soprannome*/
    public void setSurname(String surname){
        this.surname = surname;
    }
    /**metodo per leggere la mail*/
    public String getEmail(){
        return email;
    }
   /**metodo per settare la mail*/
    public void setEmail(String email){
        this.email = email;
    }

}
