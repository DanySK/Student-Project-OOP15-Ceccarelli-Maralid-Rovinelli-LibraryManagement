package model.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.EmployeeImpl;
import model.EmployeeModel;
/**
 * This class represents the list of employees
 * @author mattia.Rovinelli
 *
 */
public class EmployeesImpl implements EmployeesModel{
   
    private Map<Integer,EmployeeModel> employees = new HashMap<Integer,EmployeeModel>();
    
    public void updateEmployees(Map<Integer,EmployeeModel> employees){
        this.employees = employees;
    }
    public Map<Integer,EmployeeModel> getEmployees(){
        return this.employees;
    }
    public Boolean logged(String username,char[] password){
        boolean exist = false;
        Iterator<Integer> it = employees.keySet().iterator(); 
        while(it.hasNext()){
            /* Iterator<Entry<Integer,EmployeeModel>> it = employees.entrySet().iterator(); 
            Map.Entry<Integer, EmployeeModel> current = it.next();
            if(current.getValue().getUsername().equals(username) &&current.getValue().getPassword().equals(password) )*/
            if(employees.get(it.next()).getUsername().equals(username) &&employees.get(it.next()).getPassword().equals(password) )
                exist = true;
        }
        return exist;
    }
    public void addNewEmployee(EmployeeModel employee){
        int c = this.employees.size();
        this.employees.put(c, employee);
    }
    @Override
    public EmployeeModel employeeLogged(String username) {
        Iterator<Integer> it = employees.keySet().iterator(); 
        EmployeeModel e = new EmployeeImpl();
        while(it.hasNext()){
            if(employees.get(it.next()).getUsername().equals(username)){
              e = employees.get(it.next());  
            }
        }
        return e;
    }
}
