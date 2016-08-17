package view;
/**
 * @author Ceccarelli
 * */
import javax.swing.JPanel;

import view.observer.ViewObserver;


public interface MainView {
	/**
	 * Permette di visualizzare una finestra con un messaggio preso in input
	 * 
	 * @param message
	 * */
	void showMessage(String message);
	
	/**
	 * Permette di sostituire il pannello principale della GUI con quello passato in input
	 * 
	 * @param panel
	 * */
	void replaceMainPanel (JPanel panel);
	/**
	 * Ritorna il pannello superiore
	 * 
	 * @return 
	 * */
	NorthPanel getNorthPanel();
	/**
	 * Attach an observer of the view
	 * 
	 * @param observer
	 */
	void attachObserver(ViewObserver observer);
	
}
