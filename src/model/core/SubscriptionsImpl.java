package model.core;

import java.util.ArrayList;
import java.util.List;

import model.SubscriptionModel;

public class SubscriptionsImpl implements SubscrtiptionsModel {
    
    List<SubscriptionModel > subscriptions = new ArrayList<SubscriptionModel>();
    
    public void updateSubscriptions(List<SubscriptionModel> subscriptions){
        this.subscriptions = subscriptions;
    }
    
    public void addSubscription(SubscriptionModel subscription){
        subscriptions.add(subscription);
        }
    
    public List<SubscriptionModel> getSubscriptions(){
        return this.subscriptions;
    }
}
