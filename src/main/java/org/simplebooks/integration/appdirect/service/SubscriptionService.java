package org.simplebooks.integration.appdirect.service;

import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionEvent;
import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionChangeEvent;
import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionNoticeEvent;

public interface SubscriptionService {
  public EventResponseBase create(SubscriptionEvent event);
  public EventResponseBase change(SubscriptionChangeEvent event);
  public EventResponseBase cancel(SubscriptionEvent event);
  public EventResponseBase notice(SubscriptionNoticeEvent event);
}
