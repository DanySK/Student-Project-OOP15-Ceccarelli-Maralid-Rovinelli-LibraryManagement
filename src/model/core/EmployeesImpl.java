package model.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import model.EmployeeImpl;
import model.EmployeeModel;
/**
 * This class represents the list of employees
 * @author mattia.Rovinelli
 *
 */
public class EmployeesImpl implements EmployeesModel{
   
    private Map<Integer, EmployeeModel> employees;
    
    public EmployeesImpl(){
    	employees = new HashMap<Integer,EmployeeModel>();
    }
    
    public void updateEmployees(Map<Integer,EmployeeModel> employees){
        this.employees = employees;
    }
    public Map<Integer,EmployeeModel> getEmployees(){
        return this.employees;
    }
    public Boolean logged(String username,char[] password){
    	boolean exist = false;
    	for(Integer i : employees.keySet()){
    		if(employees.get(i).getUsername().equals(username) && String.valueOf(employees.get(i).getPassword()).equals(password)){
    			exist = true;
    		}
    	}
    	return exist;
       /* boolean exist = false;
        Iterator<Integer> it = employees.keySet().iterator(); 
        while(it.hasNext()){
        	it.next();
            Iterator<Entry<Integer,EmployeeModel>> it = employees.entrySet().iterator(); 
              Map.Entry<Integer, EmployeeModel> current =(Map.Entry<Integer, EmployeeModel>) it.next();
            if(current.getValue().getUsername().equals(username) &&current.getValue().getPassword().equals(password) )
            if(employees.get(it).getUsername().equals(username) && String.valueOf(employees.get(it).getPassword()).equals(password) )
                exist = true;
            
        }
        return exist;*/
    	 /*boolean exist = false;
         System.out.println(employees.get(0).getUsername());
         System.out.println(employees.get(0).getPassword());
         Iterator<Entry<Integer, EmployeeModel>> it = employees.entrySet().iterator(); 
         while(it.hasNext()){
         	Map.Entry<Integer, EmployeeModel> pair = (Entry<Integer, EmployeeModel>) it.next();
         	System.out.println(pair);
          	String str = String.valueOf(password);
              if(pair.getValue().getUsername().equals(username) && String.valueOf(pair.getValue().getPassword()).toString().equals(str))
                  exist = true;
          }
          return exist;*/
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
