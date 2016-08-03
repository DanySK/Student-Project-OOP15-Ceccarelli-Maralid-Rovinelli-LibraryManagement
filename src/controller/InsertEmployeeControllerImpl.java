package controller;

import model.Employee;
import model.EmployeeImpl;

public class InsertEmployeeControllerImpl implements InsertEmployeeController{
	private Employee em;
	//private model modelcorrispondente
	//private InsertDipendenteInterface
	
	public InsertEmployeeControllerImpl(Model model) {
		em = new EmployeeImpl();
		this.model = model;
	}
	
	@Override
	public void setView() {
		// TODO Auto-generated method stub
		
	}

}
