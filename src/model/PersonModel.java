package model;

public interface PersonModel {
    
    /**metodo per settare il codice fiscale*/ 
    public void setTaxCode(String taxCode);
    
    /**metodo per settare il nome */
    public void setName(String name);
    
    /**metodo per settare il cognome*/
    public void setSurname(String surname);
    
    /**metodo per settare le mail*/
    public void setEmail(String email);
    
    /**metodo per leggere il taxCode*/
    public String getTaxCode();
    
    /**metodo per leggere il cognome*/
    public String getSurname();
    
    /**metodo per leggere il nome*/
    public String getName();
    
    /**metodo per leggerele la mail*/
    public String getEmail();
   
    
}
