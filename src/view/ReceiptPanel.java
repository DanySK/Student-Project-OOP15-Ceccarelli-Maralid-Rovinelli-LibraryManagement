package view;

import view.observer.RecepitObserver;

public interface ReceiptPanel {
	/**
	 * set per l'observer del RecepitImpl
	 * 
	 * @param observer
	 * */
	void attachObserver(RecepitObserver observer);
	
	void setRecepit();
	
	void displayMessage(String message);
}
