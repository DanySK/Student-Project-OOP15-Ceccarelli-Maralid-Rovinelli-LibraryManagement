package view.observer;

public interface BookshopObserver {
	
	/**
	 * metodo per caricare i libri in una lista
	 * 
	 * @param titolo
	 * @param autore
	 * @param annoPublicazione
	 * @param prezzo
	 * @param prezzoTotale
	 * */
	void uploadBooks(String titolo, String autore, String annoPublicazione, double prezzo, double prezzoTotale );
	/**
	 * permette di aprire la view del carrello con i libri scelti
	 * */
	void ShopCartClicked();
}
