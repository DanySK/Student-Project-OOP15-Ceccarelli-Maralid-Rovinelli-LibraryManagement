package view;

import java.awt.List;

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
	 * ritorna una lista con tutti i prezzi degli elementi acquistati (ogni elemento ha il prezzo
	 * base moltiplicato per il numero di copie richiesto)
	 * 
	 * */
	List getAllPrice();
	/**
	 *Permette di ottentere l'elenco di tutti gli elementi acquistati 
	 */	
	List getAllTitle();
}
