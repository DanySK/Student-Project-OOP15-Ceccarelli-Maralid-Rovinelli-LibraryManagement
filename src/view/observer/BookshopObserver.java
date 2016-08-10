package view.observer;

public interface BookshopObserver {
	
	/**
	 * metodo per caricare i libri in una lista
	 * 
	 * @param title
	 * @param ammount
	 * @return 
	 * */
	double uploadBooks(String title, int ammount);
	/**
	 * permette di aprire la view del carrello con i libri scelti
	 * */
	void ShopCartClicked();
	/**
	 *metodo per ottenere la quantità di libri rimanenti in negozio
	 *
	 * @param title
	 * return BokStock
	 **/
	int getStocksOfTheShop(String title);
	
}
