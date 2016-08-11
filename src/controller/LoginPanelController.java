package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.EmployeeModel;
import model.Model;
import model.ModelImpl;
import model.core.EmployeesImpl;
import model.core.EmployeesModel;
import view.AddEmployeeImpl;
import view.BookshopPanel;
import view.BookshopPanelImpl;
import view.LoginPanel;
import view.LoginPanelImpl;
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
    	if(model.employees().logged(username, password)){
    		System.out.println("Loggato");
    		BookshopPanelImpl bsp = new BookshopPanelImpl();
        	BookshopController bsc = new BookshopController(this.mainView, model);
        	bsc.setView(bsp);
        	mainView.replaceMainPanel(bsp);
    		
    	} else {
    		System.out.println("Non loggato");
    		view.displayMessage("Credenziali errate");
    	}	
	}

	@Override
	public void registerEmployeeClicked() {
		AddEmployeeImpl ae = new AddEmployeeImpl();
		InsertEmployeeController ie = new InsertEmployeeController(model);
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