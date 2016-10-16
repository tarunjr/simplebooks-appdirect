package org.simplebooks.integration.appdirect.service;

import org.simplebooks.integration.appdirect.model.Event;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
  public EventResponseBase create(Event event) {
      EventSuccessResponse res = new EventSuccessResponse();
      res.setSucccess(true);
      res.setAccountIdentifier("12345");
      return res;
  }
  public String change(Event event) {
      return "CHANGED";
  }
  public String cancel(Event event) {
      return "CANCEL";
  }
  public String notice(Event event) {
      return "NOTICE";
  }
}
