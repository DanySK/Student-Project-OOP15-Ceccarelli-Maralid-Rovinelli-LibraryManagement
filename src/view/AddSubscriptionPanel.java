package view;

import view.observer.AddSubscriptionObserver;

public interface AddSubscriptionPanel {
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
	
	void setAllSubscriptions();
	
}
