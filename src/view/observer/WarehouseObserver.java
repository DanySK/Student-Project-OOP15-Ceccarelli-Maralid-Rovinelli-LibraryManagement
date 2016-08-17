package view.observer;

import java.util.Map;

import model.BookModel;

public interface WarehouseObserver {
	/**
	 * It allows you to add new books in warehouse
	 * 
	 */
	void addBooksInBookShopClicked(String title, String author, int year, double price, int ammount);
	/**
	 * 
	 * 
	 * 
	 */
	Map <BookModel, Integer> getBooksInWarehouse();
	
}
