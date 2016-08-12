package view.observer;

public interface NorthPanelObserver {
	/**
	 * cambia lo stato della login a logout e viceversa 
	 * */
	void changeLogStatus();

	/**
	 *ritorna nella home (il pannello di login) 
	 * */
	void buttonHomeClicked();
	/**
	 * effettua la login 
	 * */
	void buttonLoginClicked();
	
	void OpenAddBookClick();
}
