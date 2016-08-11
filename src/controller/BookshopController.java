package controller;

import model.Model;
import view.BookshopPanel;
import view.MainView;
import view.ReceiptPanelImpl;
import view.observer.BookshopObserver;

public class BookshopController implements BookshopObserver{
	
	private Model model;
	private MainView maninView;
	private BookshopPanel view;
	
	public BookshopController(MainView mainView, Model model){
		this.maninView = mainView;
		this.model = model;
	}
	
	public void setView(BookshopPanel bp) {
		this.view = bp;
		this.view.attachObserver(this);

	}
	
	@Override
	public double uploadBooks(String title, int ammount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void shopPurchaseItClicked() {
		ReceiptPanelImpl ri = new ReceiptPanelImpl();
		ReceiptPanelController rc = new ReceiptPanelController(model);
		rc.setView(ri);
		maninView.replaceMainPanel(ri);
		//System.out.println("QUALCOSA");
		
		
	}

	@Override
	public int getStocksOfTheShop(String title) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
