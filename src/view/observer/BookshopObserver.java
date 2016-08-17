package view.observer;

import java.util.Map;

import model.BookModel;

public interface BookshopObserver {
	/**
	 * permette di aprire la view del carrello con i libri scelti
	 * */
	void shopPurchaseItClicked();
	/**
	 * 
	 * 
	 * */
	Map <BookModel, Integer> getBookInShop ();
	
}
