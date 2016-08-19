package view;

import view.observer.WarehouseObserver;

public interface WarehousePanel {
	/**
	 * Set for the WarehousePnaleImpl observer
	 * 
	 * @param observer
	 */
	void attachObserver(WarehouseObserver observer);

	/**
	 * Cleans all textField in the panel
	 */
	void clearPanel();

	/**
	 * The method used to display a message
	 * 
	 * @param message
	 */
	void displayMessage(String message);
	/**
	 *Load the list of books
	 *
	 */
	void setAllBooks();
	
	//void clearSelectedBooks();

}
