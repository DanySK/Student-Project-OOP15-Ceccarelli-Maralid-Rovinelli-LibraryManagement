package view;

import view.observer.BookshopObserver;

public interface BookshopPanel {
	/**
	 * metodo per pulire l'elenco dei libri selezionati
	 * */
	void clearSelectedBooks();
	/**
	 * attacca alla view il BookshopObserver
	 * 
	 * @param observer
	 */
	void attachObserver (BookshopObserver observer);
	/**
	 * the method used to display a message
	 * 
	 * @param message
	 */
	void displayMessage(String message);
	/**
	 *load the list of books
	 *
	 */
	void setAllBooks();
	/**
	 * this method check if the user can move the book by the jtable tblAllBooks 
	 * to tblSelectedBooks and do this job
	 * 
	 */
	void moveBooks();

		
}
