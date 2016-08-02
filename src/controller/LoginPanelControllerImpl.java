package controller;

import view.LoginPanel;
import view.MainView;
import view.observer.LoginObserver;

public class LoginPanelControllerImpl implements LoginPanelController,LoginObserver{
	
	//private nomeImodel model;
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
	 */
	/*public LoginPanelController (MainViewInterface mainView, nomeImodel model) {
		this.mainView = mainView;
		this.model = model;
	}*/
	

	@Override
	public void setView(LoginPanel lp) {
		this.view = lp;
		this.view.attachObserver(this);
		
	}
	
	@Override
	public void loginEmployee(String username, String password) {
		
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

}