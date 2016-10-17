package org.simplebooks.integration.appdirect.service;

import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionEvent;
import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionChangeEvent;
import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionNoticeEvent;

public interface EventService {
    public SubscriptionEvent getOrderEvent(String eventUrl);
    public SubscriptionChangeEvent getChangeEvent(String eventUrl);
    public SubscriptionEvent getCancelEvent(String eventUrl);
    public SubscriptionNoticeEvent getNoticeEvent(String eventUrl);
}
