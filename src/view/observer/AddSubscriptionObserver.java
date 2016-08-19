package view.observer;

import java.util.Map;

import model.SubscriptionModel;

public interface AddSubscriptionObserver {
	
	/**
	 *With this method can be save a new subcription 
	 * 
	 * @param name
	 * @param surname
	 */	
	void addNewSubcriptionClicked(String name, String surname);
	/**
	 * 
	 * 
	 */
	Map <Integer, SubscriptionModel> getAllSubscriptions ();
}
