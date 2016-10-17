package org.simplebooks.integration.appdirect.service;

import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionOrderEvent;
import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionChangeEvent;
import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionCancelEvent;
import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionNoticeEvent;

public interface SubscriptionService {
  public EventResponseBase create(SubscriptionOrderEvent event);
  public EventResponseBase change(SubscriptionChangeEvent event);
  public EventResponseBase cancel(SubscriptionCancelEvent event);
  public EventResponseBase notice(SubscriptionNoticeEvent event);
}
