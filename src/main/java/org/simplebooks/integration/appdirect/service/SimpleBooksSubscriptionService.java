package org.simplebooks.integration.appdirect.service;

import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionEvent;

public class SimpleBooksSubscriptionService implements SubscriptionService {
  public EventResponseBase create(SubscriptionEvent event) {
      EventSuccessResponse res = new EventSuccessResponse();
      res.setSucccess(true);
      res.setAccountIdentifier("SMP-" + event.getPayload().getOrder().getEditionCode() + "-" + "123456");
      return res;
  }
  public EventResponseBase change(SubscriptionEvent event) {
    EventResponseBase res = new EventResponseBase();
    res.setSucccess(true);
    return res;
  }
  public EventResponseBase cancel(SubscriptionEvent event) {
    EventResponseBase res = new EventResponseBase();
    res.setSucccess(true);
    return res;
  }
  public EventResponseBase notice(SubscriptionEvent event) {
    EventResponseBase res = new EventResponseBase();
    res.setSucccess(true);
    return res;
  }
}
