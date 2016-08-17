package controller;

import model.BookImpl;
import model.BookModel;
import model.Model;
import view.AddBookPanel;
import view.MainView;
import view.WarehousePanelImpl;
import view.observer.AddBookObserver;

public class InsertBookController implements AddBookObserver{
	
	private Model model;
	private MainView mainView;
	private AddBookPanel view;
	private BookModel book;
	
	
	public InsertBookController(MainView mainView, Model model) {
		this.mainView = mainView;
		this.model = model;
	}
	
	public void setView(AddBookPanel ab){
		this.view = ab;
		this.view.attachObserver(this); 
	}

	@Override
	public void addBookClicked(String title, String author, String literaryGenre, int year, double price, int ammount) {
		book = new BookImpl(title, author, literaryGenre, year, price);//Create new book
		model.warehouse().addNewBookInLibrary(book, ammount);//Add book into warehouse
		System.out.println("SASDASDASDA" + model.warehouse().getBookQuantity(book));
	}
	
	@Override
	public void backToWharehouseClicked() {
		WarehousePanelImpl wp = new WarehousePanelImpl();
		WarehouseController wc = new WarehouseController(model);
		wc.setView(wp);
		mainView.replaceMainPanel(wp);
	}
}
