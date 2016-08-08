package model.core;

import java.util.Map;

import model.EmployeeModel;

public interface EmployeesModel {
    public void updateEmployees(Map<Integer,EmployeeModel> employees);
    public Boolean logged(String username,String password);
}
