package controller;

import java.util.Map;

import model.BookImpl;
import model.BookModel;
import model.Model;
import view.MainView;
import view.WarehousePanel;
import view.observer.WarehouseObserver;

public class WarehouseController implements WarehouseObserver{

	private Model model;
	private WarehousePanel view;
	private BookModel book;
	private Map<BookModel, Integer> map;
	public WarehouseController(Model model){
		this.model = model;
	}
	
	public void setView(WarehousePanel wp){
		this.view = wp;
		this.view.attachObserver(this);
	}
	
	@Override
	public void addBooksInBookShopClicked(String title, String author, String literaryGenre, int year, double price,
			int ammount) {
		book = new BookImpl(title, author, literaryGenre, year, price);//Create new book
		model.shop().addNewBookInLibrary(book, ammount);//Add book into library (book shop)
		for ( BookModel b : model.warehouse().getBooks().keySet() ) {
			if(model.warehouse().getBookQuantity(b) == 0 && b.getTitle().equals(book.getTitle()) && b.getAuthor().equals(book.getAuthor())){
				view.displayMessage("Quantità residua esaurita");
			} else {
				if(b.getTitle().equals(book.getTitle()) && b.getAuthor().equals(book.getAuthor()) && b.getyearOfPublication() == book.getyearOfPublication()){
					model.warehouse().replaceQuantity(b, model.warehouse().getBookQuantity(b) - ammount);//Change ammount
					view.displayMessage("Libro aggiunto al negozio");
				}
			}
	    }
	}
	
	@Override
	public Map <BookModel, Integer> getBooksInWarehouse() {
		map= model.warehouse().getBooks();
		return map;
	}
}
