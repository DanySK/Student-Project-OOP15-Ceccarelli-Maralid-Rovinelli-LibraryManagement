package view;

import view.observer.BookshopObserver;

public interface BookshopPanel {
	/**
	 * metodo per pulire l'elenco dei libri selezionati
	 * */
	void clearSelectedBooks();
	/**
	 * Attacca alla view il BookshopObserver
	 * 
	 * @param observer
	 * */
	void attachObserver (BookshopObserver observer);
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
	

		
}
