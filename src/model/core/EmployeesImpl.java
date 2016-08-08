package model.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.EmployeeModel;

public class EmployeesImpl implements EmployeesModel{
   
    private Map<Integer,EmployeeModel> employees = new HashMap<Integer,EmployeeModel>();
    
    public void updateEmployees(Map<Integer,EmployeeModel> employees){
        this.employees = employees;
    }
    public Map<Integer,EmployeeModel> getEmployees(){
        return this.employees;
    }
    public Boolean logged(String username,String password){
        boolean exist = false;
        Iterator<Integer> it = employees.keySet().iterator(); 
        while(it.hasNext()){
            if(employees.get(it.next()).getUsername().equals(username) &&employees.get(it.next()).getPassword().equals(password) )
                exist = true;
        }
        return exist;
    }
}
