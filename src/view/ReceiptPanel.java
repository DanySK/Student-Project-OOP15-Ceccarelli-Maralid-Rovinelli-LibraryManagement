package view;

import view.observer.RecepitObserver;

public interface ReceiptPanel {
	/**
	 * carica i valori in una lista nell view
	 * 
	 * */
	void WriteList();
	//prova per commit
	/**
	 * set per l'observer del RecepitImpl
	 * 
	 * @param observer
	 * */
	void attachObserver(RecepitObserver observer);
}
