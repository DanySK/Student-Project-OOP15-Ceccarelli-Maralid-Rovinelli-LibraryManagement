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
	@Override
	public void loginEmployee(String username, char[] password) {
		BookshopPanelImpl bsp = new BookshopPanelImpl();
    	BookshopController bsc = new BookshopController(this.mainView, model);
    	bsc.setView(bsp);
    	mainView.replaceMainPanel(bsp);
    	if(model.getEmployees().logged(username, password)){
    		System.out.println("Loggato");
    		
    	} else {
    		System.out.println("Non loggato");
    	}
    	//EmployeesModel employees = new EmployeesImpl();
    	//this.mainView.getNorthPanel().diaplayLoggedEmployee(entryMap.getValue().getName(), entryMap.getValue().getSurname());
	    /*Iterator iterator;
		try {
			iterator = employeeModel.readFile("prova.dat").entrySet().iterator();
			Map.Entry<Integer,EmployeeModel> entryMap = null;
			while(iterator.hasNext()){
				entryMap =(Map.Entry<Integer,EmployeeModel>) iterator.next();
			    //System.out.println("key: "+mentry.getKey()+" value: "+mentry.getValue().getUsername() + " pass:"+mentry.getValue().getPassword());  
		    }
			if(entryMap.getValue().getUsername().equals(username) && entryMap.getValue().getPassword().equals(String.valueOf(password)))
		    {
		    	System.out.println("Riuscito");
		    	BookshopPanel bsp = new BookshopPanelImpl();
		    	//Va implementato il controller della prima schermata da aprire (ancora da fare)
		    } else {
		    	System.out.println("Non riuscito");
		    }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	    
		
		/*Map<Integer,Employee> employeeMap = new HashMap<>();
		
		
		Date prova = new Date(1993,12,13);
		Employee em = new EmployeeImpl("12","Erik","Maraldi","prova@email", prova, prova, "sadasdasd", "asdasd", "asdasd");
		Map<Integer,Employee> m = new HashMap<Integer,Employee>();
		m.put(0,em);
		m.put(1,em);
		employeeModel.writeFile("prova.dat", employeeMap);
		try {
			
			employeeModel.search(employeeMap, field)
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(employeeMap);
		*/
		// TODO Auto-generated method stub
		/*System.out.println("Ciao");
			Date prova = new Date(1993,12,13);
			Employee em = new EmployeeImpl("12","Erik","Maraldi","prova@email", prova, prova, "sadasdasd", "asdasd", "aaa");
			m.put(0,em);
			m.put(1, em);
			employeeModel.writeFile("prova.dat", m);
			try {
				Iterator iterator =  model.readFile("prova.ser").entrySet().iterator();
			    
				while(iterator.hasNext()){
				    Map.Entry<Integer,Employee> mentry =(Map.Entry<Integer,Employee>) iterator.next();
				    System.out.println("key: "+mentry.getKey()+" value: "+mentry.getValue().getUsername());  
			    }
			   
			    Map <Integer, Employee> employee = new HashMap<>();
				try {
					employee = employeeModel.readFile("prova.dat");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(employee.get(0).getUsername().toString());
				System.out.println(employee.get(1).getAddress().toString());
	*/
		
	}

	@Override
	public void registerEmployeeClicked() {
		System.out.println("qualcosa");
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