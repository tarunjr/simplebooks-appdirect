package org.simplebooks.integration.appdirect.service;

import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionEvent;

public interface EventService {
    public SubscriptionEvent getEvent(String eventUrl);
}
