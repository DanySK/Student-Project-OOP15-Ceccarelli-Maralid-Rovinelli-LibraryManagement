package controller;

import view.MainView;

public interface Controller {
	/**
	 * Imposta al controller la view da osservare.
	 * 
	 * @param v
	 *            La view da osservare.
	 */
	void setView(MainView v);
	/**
	 * Imposta il pannello di login
	 */
	void createLoginPanel();
}
