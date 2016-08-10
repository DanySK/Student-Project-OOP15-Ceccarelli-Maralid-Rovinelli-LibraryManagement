package model.core;

import java.util.HashMap;
import java.util.Map;

import model.SubscriptionModel;

public class SubscriptionsImpl implements SubscrtiptionsModel {
    
   Map<Integer,SubscriptionModel> subscriptions = new HashMap<Integer,SubscriptionModel>();
    
    public void updateSubscriptions(Map<Integer,SubscriptionModel> subscriptions){
        this.subscriptions = subscriptions;
    }
    
    public void addSubscription(SubscriptionModel subscription){
      
        int s = this.subscriptions.size();
        this.subscriptions.put(s, subscription);
        
    }
    
    public Map<Integer,SubscriptionModel> getSubscriptions(){
        return this.subscriptions;
    }
}
