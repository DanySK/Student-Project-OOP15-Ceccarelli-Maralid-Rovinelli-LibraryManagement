package view.observer;

import java.util.Map;

import model.BookModel;

public interface WarehouseObserver {
	/**
	 * It allows you to add new books in warehouse
	 * 
	 */
	void addBooksInBookShopClicked(String title, String author, String literaryGenre, int year, double price,
			int amount);

	/**
	 *This method returns a list of all the books in the wharehouse
	 * 
	 * @return
	 */
	Map<BookModel, Integer> getBooksInWarehouse();
}
