package model;
import java.util.Date;


public interface EmployeeModel {
    
 
    /** metodo per leggere la data di nascita*/
    public Date getDateOfBirth();
    
    /**metodo per leggere la data di assunzione*/
    public Date getHireDate();
    
    /**metodo per leggere la via*/
    public String getAddress();
    
    /**metodo che restituisce lo username*/
    public String getUsername();
    
    /**metodo che restituisce la password*/
    public String getPassword();
    
   /**metodo per settare la data di nascita */
    public void setDateOfBirth(Date date);
    
    /**metodo per settare la data di assunzione*/
    public void setHireDate(Date hireDate);
   
    /**metodo per settare il suo indirizzo*/
    public void setAddress(String address);
    
    /**metodo per settare lo username*/
    public void setUsername(String username);
    
    /**metodo per settare la password*/
    public void setPassword(String password);
    

}