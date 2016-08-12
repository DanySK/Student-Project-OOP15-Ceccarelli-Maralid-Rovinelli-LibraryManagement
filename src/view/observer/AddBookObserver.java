package view.observer;

public interface AddBookObserver {
	/**
	 * Permette di aggiungere un nuovo libri e la sua quantità
	 * nel magazzino 
	 * 
	 */
	void addBook();
	
	void backToWharehouseClicked();
}
