package controller;

import model.EmployeeModel;
import model.StreamImpl;
import model.StreamModel;
import view.LoginPanel;
import view.LoginPanelImpl;
import view.MainView;
import view.NorthPanel;
import view.NorthPanelImpl;
import view.observer.NorthPanelObserver;
import view.observer.ViewObserver;

public class Controller implements NorthPanelObserver, ViewObserver{
	private StreamImpl<EmployeeModel, EmployeeModel> model;
	private MainView mainView;
	
	/**
	 * Crea un nuovo Controller senza dare alcun parametro come input.
	 * 
	 * @param model
	 *            il model utilizzato per salvare i dati
	 */
	public Controller(StreamImpl<EmployeeModel, EmployeeModel> model) {
			this.model = model;
	}


	public void setView(MainView v) {
		this.mainView = v;
		this.mainView.attachObserver(this);
		NorthPanel northpanel = (NorthPanelImpl) this.mainView.getNorthPanel();
		northpanel.attachObserver(this);
	}
	
	/*public void createLoginPanel() {
		LoginPanelImpl lp = new LoginPanelImpl();
		LoginPanelController lpc = new LoginPanelController(this.mainView, model);
		lpc.setView(lp);
		this.mainView.replaceMainPanel(lp);
	}*/
	
	@Override
	public void changeLogStatus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonHomeClicked() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void buttonLoginClicked() {
		LoginPanelImpl lp = new LoginPanelImpl();
		LoginPanelController lpc = new LoginPanelController(this.mainView, model);
		lpc.setView(lp);
		this.mainView.replaceMainPanel(lp);
	}

	@Override
	public void exitCommand() {
		System.exit(0);
	}

	@Override
	public void saveData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveData(String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dataLoad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dataLoad(String path) {
		// TODO Auto-generated method stub
		
	}


}
