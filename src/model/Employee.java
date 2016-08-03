package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public interface Employee {
    
 
    /** metodo per leggere la data di nascita*/
    public SimpleDateFormat getDateOfBirth();
    
    /**metodo per leggere la data di assunzione*/
    public SimpleDateFormat getHireDate();
    
    /**metodo per leggere la via*/
    public String getAddress();
    
    /**metodo che restituisce lo username*/
    public String getUsername();
    
    /**metodo che restituisce la password*/
    public String getPassword();
    
   /**metodo per settare la data di nascita */
    public void setDateOfBirth(SimpleDateFormat date);
    
    /**metodo per settare la data di assunzione*/
    public void setHireDate(SimpleDateFormat hireDate);
   
    /**metodo per settare il suo indirizzo*/
    public void setAddress(String address);
    
    /**metodo per settare lo username*/
    public void setUsername(String username);
    
    /**metodo per settare la password*/
    public void setPassword(String password);
    

}
