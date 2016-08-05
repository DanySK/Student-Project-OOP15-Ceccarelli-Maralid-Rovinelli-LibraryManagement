package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.Employee;
import model.EmployeeImpl;
import model.IOModel;
import model.Model;
import view.BookshopPanel;
import view.BookshopPanelImpl;
import view.LoginPanel;
import view.MainView;
import view.observer.LoginObserver;

public class LoginPanelController implements LoginObserver,Serializable{
	
	private IOModel<Employee, Employee> modelemployee;
	public MainView mainView; 
	private LoginPanel view;

	public LoginPanelController (MainView mainView, IOModel<Employee, Employee> model) {
		this.mainView = mainView;
		this.modelemployee = model;
	}

	public void setView(LoginPanel lp) {
		this.view = lp;
		this.view.attachObserver(this);
		
	}
	
	/*@Override
	public void loginEmployee(String username, String password){
		System.out.println("prova");
		/*try {
			Employee em = (Employee) model.search( model.readFile("prova.txt"), "Prova");
			System.out.println(em.getUsername());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(model(username) && em.getPassword().equals(password)){
			System.out.printn("loggato");
		} else {
			System.out.println("credenziali errate");
		}
	}*/
	
	@Override
	public void loginEmployee(String username, char[] password) {
		// TODO Auto-generated method stub
		System.out.println("Ciao");
			Date prova = new Date(1993,12,13);
			Employee em = new EmployeeImpl("12","Erik","Maraldi","prova@email", prova, prova, "sadasdasd", "asdasd", "asdasd");
			Map<Integer,Employee> m = new HashMap<Integer,Employee>();
			m.put(0,em);
			modelemployee.writeFile("prova.dat", m);
			try {
			/*	Iterator iterator =  model.readFile("prova.ser").entrySet().iterator();
			    
				while(iterator.hasNext()){
				    Map.Entry<Integer,Employee> mentry =(Map.Entry<Integer,Employee>) iterator.next();
				    System.out.println("key: "+mentry.getKey()+" value: "+mentry.getValue().getUsername());  
			    }*/
			   
			    Map <Integer, Employee> employee = new HashMap<>();
				employee = modelemployee.readFile("prova.dat");
				
				System.out.println(employee.get(0).getUsername().toString());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
	}

	@Override
	public void regiterEmployee() {
		// TODO Auto-generated method stub
		
	}
	
	
	/*public void doLoginUtente(String username, String password) {
		try {
			Dipendente dip = model.getDipendente(username);
			if (dip.getPassword().equals(password)) {
				model.setUser(dip);
				OrdineView ov = new OrdineView(model.getOrdine(Calendar
						.getInstance()));
				OrdineController oc = new OrdineController(this.mainView, model);
				oc.setView(ov);
				CentralView cview = new CentralView(ov);
				CentralViewController cvc = new CentralViewController(mainView,
						model);
				cvc.setView(cview);
				mainView.replaceCentralPanel(cview);
				this.mainView.getLeftPanel()
						.displayUser(model.getUser().getNome(),
								model.getUser().getCognome());
				mainView.getLeftPanel().setUserLogged();
			} else {
				this.view.displayMsg("Password errata");
			}
		} catch (UserNotFoundException ex) {
			view.displayMsg("L'utente non esiste");
		}

	}*/


	
	/*public void registerUser() {
		InsertDipendenteController idc = new InsertDipendenteController(model);
		InsertDipendenteView idview = new InsertDipendenteView();
		idc.setView(idview);
		mainView.replaceCentralPanel(idview);

	}*/

}