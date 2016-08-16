package controller;

import model.Model;
import view.MainView;
import view.WarehousePanel;
import view.observer.WarehouseObserver;

public class WarehouseController implements WarehouseObserver{

	private Model model;
	private MainView mainView;
	private WarehousePanel view;
	
	public WarehouseController(MainView mainView, Model model){
		this.mainView = mainView;
		this.model = model;
	}
	
	public void setView(WarehousePanel wp){
		this.view = wp;
		this.view.attachObserver(this);
		
	}
	@Override
	public void addBooksInBookShopClicked(int ammount) {
		// TODO Auto-generated method stub
		
	}

}
