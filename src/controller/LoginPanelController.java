package controller;

import model.Employee;
import model.IOModel;
import model.Model;
import view.BookshopPanel;
import view.BookshopPanelImpl;
import view.LoginPanel;
import view.MainView;
import view.observer.LoginObserver;

public class LoginPanelController implements LoginObserver{
	
	private IOModel model;
	private MainView mainView; 
	private LoginPanel view;
	
	/**
	 * Crea un nuovo LoginPanelConrtoller
	 * 
	 * @param mainView
	 *            la view da usare per cambiare il
	 *            display del pannello corrente
	 * @param model
	 *            il model da utilizzare
	 *            per salvare i dati
	 * @return 
	 */
	public LoginPanelController (MainView mainView, IOModel<Employee, Employee> model) {
		this.mainView = mainView;
		this.model = model;
	}

	public void setView(LoginPanel lp) {
		this.view = lp;
		this.view.attachObserver(this);
		
	}
	
	@Override
	public void loginEmployee(String username, String password) {
		/*if(model(username) && em.getPassword().equals(password)){
			System.out.println("loggato");
		} else {
			System.out.println("credenziali errate");
		}*/
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

	@Override
	public void regiterEmployee() {
		// TODO Auto-generated method stub
		
	}
	
	/*public void registerUser() {
		InsertDipendenteController idc = new InsertDipendenteController(model);
		InsertDipendenteView idview = new InsertDipendenteView();
		idc.setView(idview);
		mainView.replaceCentralPanel(idview);

	}*/

}