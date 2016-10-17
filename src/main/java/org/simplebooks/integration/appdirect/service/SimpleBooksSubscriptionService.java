package org.simplebooks.integration.appdirect.service;

import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionOrderEvent;
import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionChangeEvent;
import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionCancelEvent;
import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionNoticeEvent;

public class SimpleBooksSubscriptionService implements SubscriptionService {
  public EventResponseBase create(SubscriptionOrderEvent event) {
      EventSuccessResponse res = new EventSuccessResponse();
      res.setSucccess(true);
      res.setAccountIdentifier("SMP-" + event.getPayload().getOrder().getEditionCode() + "-" + "123456");
      return res;
  }
  public EventResponseBase change(SubscriptionChangeEvent event) {
    EventResponseBase res = new EventResponseBase();
    res.setSucccess(true);
    return res;
  }
  public EventResponseBase cancel(SubscriptionCancelEvent event) {
    EventResponseBase res = new EventResponseBase();
    res.setSucccess(true);
    return res;
  }
  public EventResponseBase notice(SubscriptionNoticeEvent event) {
    EventResponseBase res = new EventResponseBase();
    res.setSucccess(true);
    return res;
  }
}
