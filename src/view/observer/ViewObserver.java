package view.observer;

public interface ViewObserver {
	/**
	 * Metodo per chiudere l'applicazione
	 */
	void exitCommand();

	/**
	 * Metodo che permette il savataggio dei dati
	 */
	void saveData();
	
	/**
	 * Metodo che permette il savataggio dei dati
	 * 
	 * @param path
	 *            Percorso in cui salvare il model
	 */
	void saveData(String path);
	/**
	 * Metodo che permette di salvare i dati
	 */
	
	void dataLoad();

	/**
	 * Metodo che permette di salvare i dati
	 * 
	 * @param path
	 *            Percorso da cui caricare il model
	 */
	void dataLoad(String path);
	/**
	 * 
	 */
	void warehouseClicked();

	/**
	 * 
	 * 
	 */
	void addBooksClicked();

	/**
	 * 
	 * 
	 */
	void bookShopClicked();

	/**
	 * 
	 * 
	 */
	void addEmployeeClicked();

	/**
	 * 
	 * 
	 */
	void addSubscriptionClicked();
	

	
}
