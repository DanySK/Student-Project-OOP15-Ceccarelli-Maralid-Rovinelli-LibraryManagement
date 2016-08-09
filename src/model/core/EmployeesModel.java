package model.core;

import java.util.Map;

import model.EmployeeModel;

public interface EmployeesModel {
    public void updateEmployees(Map<Integer,EmployeeModel> employees);
    public Map<Integer,EmployeeModel> getEmployees();
    public Boolean logged(String username,char[] password);
    public void addNewEmployee(EmployeeModel employee);
}
