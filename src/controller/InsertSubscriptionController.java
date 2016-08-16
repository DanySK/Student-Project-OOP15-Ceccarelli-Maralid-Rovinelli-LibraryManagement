package controller;

import model.Model;
import model.SubscriptionImpl;
import model.SubscriptionModel;
import view.AddSubscriptionPanel;
import view.observer.AddSubscriptionObserver;

public class InsertSubscriptionController implements AddSubscriptionObserver{
	
	private Model model;
	private AddSubscriptionPanel view;
	private SubscriptionModel subscription;
	
	public InsertSubscriptionController(Model model){
		this.model = model;
	}
	
	public void setView(AddSubscriptionPanel sp){
		this.view = sp;
		this.view.attachObserver(this);
	}

	@Override
	public void addNewSubcriptionClicked(String name, String surname, String literaryGenre) {
		subscription = new SubscriptionImpl(name, surname, literaryGenre, 0);
		System.out.println(subscription.getName());
	}

}
