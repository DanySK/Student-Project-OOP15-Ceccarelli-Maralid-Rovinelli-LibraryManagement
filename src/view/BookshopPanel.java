package view;

import view.observer.BookshopObserver;

public interface BookshopPanel {
	/**
	 * metodo per pulire la lista che contine tutti i libri in negozio
	 * */
	void clearBooksList();
	/**
	 * metodo per pulire la lista dei libri selezionati
	 * */
	void clearSelectedBookList();
	/**
	 * metodo per pulire tutte le liste
	 * */
	void clearAll();
	/**
	 * Attacca alla view il BookshopObserver
	 * 
	 * @param observer
	 * */
	void attachObserver (BookshopObserver observer);
	
	// promemoria bisogna aggiungere un metodo per riempire la prima lista
}
