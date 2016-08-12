package view.observer;

public interface AddBookObserver {
	/**
	 * Permette di aggiungere un nuovo libri e la sua quantità nel magazzino
	 * 
	 */
	void addBookClicked(String title, String author, String literaryGenre, int year, double price, int ammount);

	void backToWharehouseClicked();
}
