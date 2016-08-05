package controller;

import java.util.Date;

import view.AddEmployee;
import view.observer.AddEmployeeObserver;
import model.Employee;
import model.IOModel;

public class InsertEmployeeController implements AddEmployeeObserver{

	private IOModel<Employee,Employee> employeeModel;
	private AddEmployee view;
	
	public InsertEmployeeController(IOModel<Employee, Employee> employeeModel) {
		this.employeeModel = employeeModel;
	}
	
	public void setView(AddEmployee ae){
		this.view = ae;
		this.view.attachObserver(this);
	}
	@Override
	public void saveEmployee(String name, String surname, String address, String username, char[] password,
			String email, int telephoneNumber, String taxCode, Date birthDate, Date hireDate) {
		System.out.println("fa qualcosa");
	}

}
