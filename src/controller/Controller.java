package controller;

import model.Model;
import model.StreamImpl;
import model.StreamModel;
import view.LoginPanelImpl;
import view.MainView;
import view.NorthPanel;
import view.NorthPanelImpl;
import view.observer.NorthPanelObserver;
import view.observer.ViewObserver;

import java.io.IOException;
import java.util.Map;

import model.EmployeeImpl;
import model.EmployeeModel;

public class Controller implements NorthPanelObserver, ViewObserver{
	private Model model;
	private MainView mainView;
	StreamModel<Integer, EmployeeModel> sm = new StreamImpl<Integer, EmployeeModel>();;
	
	/**
	 * Crea un nuovo Controller senza dare alcun parametro come input.
	 * 
	 * @param model
	 *            il model utilizzato per salvare i dati
	 */
	public Controller(Model model) {
			this.model = model;
	}


	public void setView(MainView mainView) {
		this.mainView = mainView;
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
		sm.writeFile("Employee.txt", model.getEmployees().getEmployees());
	}

	@Override
	public void saveData(String path) {
		// TODO Auto-generated method stub
		System.out.println("Siamo qui");
		
	}

	@Override
	public void dataLoad() {
		// TODO Auto-generated method stub
		try {
			Map<Integer, EmployeeModel> mappa = sm.readFile("Employee.txt");
			System.out.println(mappa.get(0).getUsername());
			model.getEmployees().updateEmployees(mappa);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void dataLoad(String path) {
		// TODO Auto-generated method stub
		
	}


}
