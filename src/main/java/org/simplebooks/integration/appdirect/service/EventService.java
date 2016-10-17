package org.simplebooks.integration.appdirect.service;

import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionOrderEvent;
import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionChangeEvent;
import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionCancelEvent;
import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionNoticeEvent;

public interface EventService {
    public SubscriptionOrderEvent getOrderEvent(String eventUrl);
    public SubscriptionChangeEvent getChangeEvent(String eventUrl);
    public SubscriptionCancelEvent getCancelEvent(String eventUrl);
    public SubscriptionNoticeEvent getNoticeEvent(String eventUrl);
}
