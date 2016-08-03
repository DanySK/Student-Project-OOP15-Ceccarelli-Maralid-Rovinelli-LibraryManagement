package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeImpl extends AbstractPerson implements Employee ,Serializable {
  
    

    private static final long serialVersionUID = 1L;
    private SimpleDateFormat dateOfBirth ;
    private SimpleDateFormat hireDate;
    private String address;
    private String username;
    private String password;
    
  
    public EmployeeImpl(String taxCode, String name, String surname, String email, SimpleDateFormat dateOfBirth,SimpleDateFormat hireDate,String address ,String username,String password) {
        super(taxCode, name, surname, email);
      
       this.dateOfBirth = dateOfBirth;
       this.hireDate = hireDate;
       this.address = address;
       this.username = username;
       this.password = password;
      ;
        
    }
  
    public SimpleDateFormat getDateOfBirth() {
       return dateOfBirth;
    }
   
    public SimpleDateFormat getHireDate() {
       return hireDate;
    }
   
    public String getAddress() {
       return address;
    }

  
    public String getUsername() {
        // TODO Auto-generated method stub
        return username;
    }

    
    public String getPassword() {
        return password;
    }

   
    public void setDateOfBirth(SimpleDateFormat date) {
      this.dateOfBirth = date;

    }

  
    public void setHireDate(SimpleDateFormat hireDate) {
       this.hireDate = hireDate;
}

 
    public void setAddress(String address) {
       this.address = address;

       
    }
   
    public void setUsername(String username) {
        this.username = username;
    }

    
    public void setPassword(String password) {
     this.password = password;
    }

 }
