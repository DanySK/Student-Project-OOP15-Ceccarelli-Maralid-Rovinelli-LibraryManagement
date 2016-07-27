package controller;

import view.MainView;
import view.ViewObserver;

public class Controller implements ViewObserver{
	//private IModel model;
	private MainView mainView;
	
	/**
	 * Crea un nuovo Controller senza dare alcun parametro come input.
	 * 
	 * @param model
	 *            il model utilizzato per salvare i dati
	 */
	public Controller(/*Tipo Imodel model*/) {
			//this.model = model;
	}

	@Override
	public void exitCommand() {
		// TODO Auto-generated method stub
		
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
		
	};
	
	/**
	 * Imposta al controller la {@link greenKiosk.views.MainViewInterface} view
	 * da osservare.
	 * 
	 * @param v
	 *            La {@link greenKiosk.views.MainViewInterface} da osservare.
	 */
	//SET VIEW

	

}
