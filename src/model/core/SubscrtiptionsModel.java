package model.core;


import java.util.Map;

import model.SubscriptionModel;

public interface SubscrtiptionsModel {
    /**
     * this method updates the map of subscriptions
     * 
     * @param subscriptions
     */
    public void updateSubscriptions(Map<Integer,SubscriptionModel> subscriptions);
    /**
     * this method add in the map a new subscription
     * 
     * @param subscription
     */
    public void addSubscription(SubscriptionModel subscription);
    /**
     * this method return the map of subscriptions
     * @return map of subscription
     */
    public Map<Integer,SubscriptionModel> getSubscriptions();
}
