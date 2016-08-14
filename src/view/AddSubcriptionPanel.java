package view;

import view.observer.AddSubscriptionObserver;

public interface AddSubcriptionPanel {
	/**
	 * set for the WarehousePnaleImpl observer
	 * 
	 * @param observer
	 * */
	void attachObserver(AddSubscriptionObserver observer);
	/**
	 * Cleans all textField in the panel 
	 * */
	void clearPanel();
	
}
