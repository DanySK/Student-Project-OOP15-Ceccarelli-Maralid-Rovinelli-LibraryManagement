/**
 * @author Ceccarelli
 * */
package view;

import view.observer.NorthPanelObserver;

public interface NorthPanel {
	/**
	 * controlla eventuali login e ne imposta l'identita
	 * */
	void checkEmployeeLogin();
	/**
	 * controlla eventuali logout e ne disconnette il soggetto
	 * */
	void checkEmployeeLogout();
	/**
	 * set per l'observer del northPanel
	 * 
	 * @param observer
	 * */
	void attachObserver(NorthPanelObserver observer);
	/**
	 * Pulisce tutte le stringhe presenti nel panel
	 * */
	void clearPanel();
	/**
	 * Permette di visualizzare il nome ed il cognome del dipendete 
	 * che ha effettuato la login
	 * 
	 * @param nome
	 * @param cognome
	 * */
	void displayLoggedEmployee(String nome, String cognome);
}
