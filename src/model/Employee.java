package model;

import java.util.Date;

public interface Employee {
 
    public Date getDateOfBirth();
    public Date getHireDate();
    public String getAddress();
    public String getUsername();
    public String getPassword();
    
    public void setDateOfBirth(Date date);
    public void setHireDate(Date hireDate);
    public void setAddress(String address);
    public void setUsername(String username);
    public void setPassword(String password);
}
