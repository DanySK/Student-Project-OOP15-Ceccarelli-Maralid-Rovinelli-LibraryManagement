package model;

import java.io.Serializable;
import java.util.Date;

public class EmployeeImpl extends AbstractPerson implements Employee ,Serializable{
  
    public EmployeeImpl(String taxCode, String name, String surname, String email) {
        super(taxCode, name, surname, email);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;
    private Date dateOfBirth ;
    private Date hireDate;
    private String address;
    private String username;
    private String password;
   
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getHireDate() {
       return hireDate;
    }

    public String getAddress() {
       return address;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setDateOfBirth(Date date) {
      this.dateOfBirth = date;

    }

    @Override
    public void setHireDate(Date hireDate) {
       this.hireDate = hireDate;

    }

    @Override
    public void setAddress(String address) {
       this.address = address;

    }

    @Override
    public void setUsername(String username) {
        this.username = username;

    }

    @Override
    public void setPassword(String password) {
     this.password = password;
    }

}
