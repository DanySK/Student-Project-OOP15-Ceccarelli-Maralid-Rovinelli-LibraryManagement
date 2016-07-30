package view;
import view.observer.LoginObserver;

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
}
