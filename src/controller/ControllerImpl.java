package controller;

import model.Employee;
import model.IOModel;
import model.Model;
import view.LoginPanelImpl;
import view.MainView;
import view.NorthPanel;
import view.NorthPanelImpl;
import view.observer.NorthPanelObserver;
import view.observer.ViewObserver;

public class ControllerImpl implements Controller, NorthPanelObserver, ViewObserver{
	private IOModel model;
	private MainView mainView;
	
	/**
	 * Crea un nuovo Controller senza dare alcun parametro come input.
	 * 
	 * @param model
	 *            il model utilizzato per salvare i dati
	 */
	public ControllerImpl(IOModel<Employee, Employee> model) {
			this.model = model;
	}

	@Override
	public void setView(MainView v) {
		this.mainView = v;
		this.mainView.attachObserver(this);
		NorthPanelImpl northpanel = (NorthPanelImpl) this.mainView.getNorthPanel();
		northpanel.setObserver(this);
	}
	
	@Override
	public void createLoginPanel() {
		LoginPanelImpl lp = new LoginPanelImpl();
		LoginPanelController lpc = new LoginPanelControllerImpl(this.mainView, model);
		lpc.setView(lp);
		this.mainView.replaceMainPanel(lp);
	}
	
	@Override
	public void changeLogStatus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttomHomeClicked() {
		// TODO Auto-generated method stub
		
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
