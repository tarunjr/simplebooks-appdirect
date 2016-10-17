package org.simplebooks.integration.appdirect.service;

import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionEvent;

public interface SubscriptionService {
  public EventResponseBase create(SubscriptionEvent event);
  public EventResponseBase change(SubscriptionEvent event);
  public EventResponseBase cancel(SubscriptionEvent event);
  public EventResponseBase notice(SubscriptionEvent event);
}
