package view;

import view.observer.AddEmployeeObserver;

public interface AddEmployeePanel {
	/**
	 * pulitura della schermata di aggiunta di un nuovo dipendente
	 * 
	 **/
	void cleanInterface();

	/**
	 * Attacca l'observer alla view
	 * 
	 * @param observer
	 **/
	void attachObserver(AddEmployeeObserver observer);

	/**
	 * visualizza eventuali messaggi
	 * 
	 * @param message
	 * */
	void displayMessage(String message);
}
