package view;
import view.observer.LoginObserver;
/**
 * @author Ceccarelli
 * */
public interface LoginPanel {

	/**
	 * metodo per pulire le textfield nel login
	 * */
	void clearLogin();
	/**
	 * Attacca alla view il LoginObserver
	 * 
	 * @param observer
	 * */
	void attachObserver (LoginObserver observer);
	
	/**
	 * Permette divisualizzare un dato messaggio in una label predefinita
	 * 
	 * @param message
	 */void displayMessage(String message);
}
