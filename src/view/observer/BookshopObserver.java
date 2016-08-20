package view.observer;

import java.util.Map;

import model.BookModel;

public interface BookshopObserver {
	/**
	 * go to purhcase recap view
	 * 
	 * @param purchaseList
	 */
	void shopPurchaseItClicked(Map<BookModel, Integer> purchaseList);

	/**
	 * return books in shop
	 * 
	 * @return
	 */
	Map<BookModel, Integer> getBookInShop();
}
