package view.observer;

import java.util.Map;

import model.BookModel;

public interface WarehouseObserver {
	/**
	 * It allows you to add new books in warehouse
	 * 
	 */
	void addBooksInBookShopClicked(int ammount);//aggiungere l'oggetto a cui si riferisce
	/**
	 * 
	 * 
	 * 
	 */
	Map <BookModel, Integer> getBooksInWarehouse();
	
}
