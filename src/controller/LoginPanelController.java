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
		EmployeeImpl e;
    	if(model.employees().logged(username, password).equals(true)){
    		mainView.getNorthPanel().changeLogStatus(true);
        	mainView.changeLogStatus(true);
    		BookshopPanelImpl bsp = new BookshopPanelImpl();
        	BookshopController bsc = new BookshopController(this.mainView, model);
        	bsc.setView(bsp);
        	mainView.replaceMainPanel(bsp);
        	e = (EmployeeImpl) model.employees().employeeLogged(username);
        	mainView.getNorthPanel().displayLoggedEmployee(e.getName(), e.getSurname());
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

	//It's true if someone is logged
	@Override
	public boolean loginFlag() {
		return true;
	}
}