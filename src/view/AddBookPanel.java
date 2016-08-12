package view;

import view.observer.AddBookObserver;

public interface AddBookPanel {
	/**
	 * Permette di visualizzare un messaggio in una label
	 * 
	 * 
	 */
	void displayMessage(String message);
	
	/**
	 * Attacca l'AddBookObserver alla view
	 * 
	 */
	void attachObserver(AddBookObserver observer);
	
	/**
	 * Pulisce tutti i campi all'interno della view
	 * 
	 * 
	 */
	void clearView();
	
	double setTotalPrice(int ammount, double price);
}
