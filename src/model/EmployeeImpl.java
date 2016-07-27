package model;

import java.io.Serializable;
import java.util.Date;

public class EmployeeImpl extends AbstractPerson implements Employee ,Serializable{
  
   

    private static final long serialVersionUID = 1L;
    private Date dateOfBirth ;
    private Date hireDate;
    private String address;
    private String username;
    private String password;
    
  
    public EmployeeImpl(String taxCode, String name, String surname, String email, Date dateOfBirth, Date hireDate,String address ,String username,String password) {
        super(taxCode, name, surname, email);
        this.dateOfBirth = dateOfBirth;
        this.hireDate = hireDate;
        this.address = address;
        this.username = username;
        this.password = password;
    }
    /** metodo per leggere la data di nascita*/
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    /**metodo per leggere la data di assunzione*/
    public Date getHireDate() {
       return hireDate;
    }
    /**metodo per leggere la via*/
    public String getAddress() {
       return address;
    }

    /**metodo che restituisce lo username*/
    public String getUsername() {
        // TODO Auto-generated method stub
        return username;
    }

    /**metodo che restituisce la password*/
    public String getPassword() {
        return password;
    }

    /**metodo per settare la data di nascita*/
    public void setDateOfBirth(Date date) {
      this.dateOfBirth = date;

    }

    /**metodo per settare la data di assunzione*/
    public void setHireDate(Date hireDate) {
       this.hireDate = hireDate;

    }

    /**metodo per settare il suo indirizzo*/
    public void setAddress(String address) {
       this.address = address;

    }

    /**metodo per settare lo username*/
    public void setUsername(String username) {
        this.username = username;

    }

    /**metodo per settare la password*/
    public void setPassword(String password) {
     this.password = password;
    }

}
