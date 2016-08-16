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
	public void addNewSubcriptionClicked(String name, String surname) {
		subscription = new SubscriptionImpl(name, surname, "Bronze", 0);
		model.subscriptions().addSubscription(subscription);
		System.out.println(model.subscriptions().getSubscriptions());
	}

}
