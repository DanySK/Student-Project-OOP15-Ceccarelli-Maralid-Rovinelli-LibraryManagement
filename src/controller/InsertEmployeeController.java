package controller;

import java.util.Date;

import view.AddEmployee;
import view.observer.AddEmployeeObserver;
import model.Model;
import model.StreamImpl;
import model.EmployeeImpl;
import model.EmployeeModel;

public class InsertEmployeeController implements AddEmployeeObserver{

	private Model model;
	private AddEmployee view;
	private EmployeeModel employee;
	
	public InsertEmployeeController(Model model) {
		this.model = model;
	}
	
	public void setView(AddEmployee ae){
		this.view = ae;
		this.view.attachObserver(this);
	}
	@Override
	public void saveEmployee(String name, String surname, String address, String username, char[] password,
			String email, int telephoneNumber, String taxCode, Date birthDate, Date hireDate) {
		
		employee = new EmployeeImpl(taxCode, name, surname, email, birthDate, hireDate, address, username, password);
		model.getEmployees().addNewEmployee(employee);
		//StreamImpl<EmployeeImpl, EmployeeImpl> sm = new StreamImpl<EmployeeImpl, EmployeeImpl> ();

		//view.displayMessage("Registrazione avvenuta con successo");
		/*} catch (DuplicatedCodeException e) {
			view.displayMsg("Questo Dipendente è già registrato");
		} catch (DuplicatedUsernameException e) {
			view.displayMsg("Questo username è già utilizzato");
		}
	}*/
	}
}
