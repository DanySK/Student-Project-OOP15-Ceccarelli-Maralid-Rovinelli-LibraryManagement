package controller;

import java.io.Serializable;

import model.EmployeeImpl;
import model.Model;
import view.AddEmployeePanelImpl;
import view.BookshopPanelImpl;
import view.LoginPanel;
import view.MainView;
import view.observer.LoginObserver;

public class LoginPanelController implements LoginObserver,Serializable{
	
	private Model model;
	public MainView mainView; 
	private LoginPanel view;
	

	public LoginPanelController (MainView mainView, Model model) {
		this.mainView = mainView;
		this.model = model;
	}

	public void setView(LoginPanel lp) {
		this.view = lp;
		this.view.attachObserver(this);
		
	}
	
	@Override
	public void loginEmployee(String username, char[] password) {
    	if(model.employees().logged(username, password).equals(true)){
    		System.out.println("Loggato");
    		BookshopPanelImpl bsp = new BookshopPanelImpl();
        	BookshopController bsc = new BookshopController(this.mainView, model);
        	bsc.setView(bsp);
        	mainView.replaceMainPanel(bsp);
        	EmployeeImpl e = (EmployeeImpl) model.employees().employeeLogged(username);
        	mainView.getNorthPanel().displayLoggedEmployee(e.getName(), e.getSurname());
        	/*EmployeeModel e = new EmployeeImpl();
        	e = model.employees().employeeLogged(username);
        e.getClass().asSubclass(PersonModel);*/
        	
    		
    	} else {
    		view.displayMessage("Credenziali errate");
    	}	
	}

	@Override
	public void registerEmployeeClicked() {
		AddEmployeePanelImpl ae = new AddEmployeePanelImpl();
		InsertEmployeeController ie = new InsertEmployeeController(mainView, model);
		ie.setView(ae);
		mainView.replaceMainPanel(ae);
	}

	
	/*public void registerUser() {
		InsertDipendenteController idc = new InsertDipendenteController(model);
		InsertDipendenteView idview = new InsertDipendenteView();
		idc.setView(idview);
		mainView.replaceCentralPanel(idview);

	}*/

}