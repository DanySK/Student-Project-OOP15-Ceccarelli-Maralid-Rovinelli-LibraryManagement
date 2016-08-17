package controller;

import model.BookImpl;
import model.BookModel;
import model.Model;
import view.AddBookPanel;
import view.observer.AddBookObserver;

public class InsertBookController implements AddBookObserver{
	
	private Model model;
	private AddBookPanel view;
	private BookModel book;
	
	
	public InsertBookController(Model model) {
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
	}
	
	@Override
	public void backToWharehouseClicked() {
		// TODO Auto-generated method stub
		
	}
}
