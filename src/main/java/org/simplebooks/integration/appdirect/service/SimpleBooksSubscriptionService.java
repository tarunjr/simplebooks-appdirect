package org.simplebooks.integration.appdirect.service;

import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionEvent;
import org.simplebooks.integration.appdirect.service.SubscriptionAccount;
import org.simplebooks.integration.appdirect.Application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleBooksSubscriptionService implements SubscriptionService {
  private static final Logger log = LoggerFactory.getLogger(SimpleBooksSubscriptionService.class);

  @Value("${server.simplebooks.service.accounts.server}")
  private String serviceUrl;

  @Value("${server.simplebooks.service.accounts.resource}")
  private String resource;

  public EventResponseBase create(SubscriptionEvent event) {
     SubscriptionAccount sa = convert( event);
     if(sa == null)
        return getErrorResponse("Bad request");

      String uri = getResourceUri(null);
      RestTemplate restTemplate = new RestTemplate();
      SubscriptionAccount created = restTemplate.postForObject(uri, sa, SubscriptionAccount.class);

      EventSuccessResponse res = getSuccessResponse();;
      res.setAccountIdentifier(created.getAccountIdentifier());
      return res;
  }
  public EventResponseBase change(SubscriptionEvent event) {
    if (!isValidAccount(event)) {
      return getErrorResponse("Missing or invalid accoutn identifier");
    }
    SubscriptionAccount sa = convert( event);
    if(sa == null)
      return getErrorResponse("Bad request");

    String uri = getResourceUri(event);
    RestTemplate restTemplate = new RestTemplate();
    try {
      restTemplate.put(uri, sa);
    } catch (RestClientException rcex) {
      return getErrorResponse("Problem in account account");
    }
    return getSuccessResponse();
  }
  public EventResponseBase cancel(SubscriptionEvent event) {
    if (!isValidAccount(event)) {
      return getErrorResponse("Missing or invalid account identifier");
    }

    String uri = getResourceUri(event);
    RestTemplate restTemplate = new RestTemplate();
    try {
      restTemplate.delete(uri);
    } catch (RestClientException rcex) {
        return getErrorResponse("Problem in cancelling account");
    }
    return getSuccessResponse();
  }
  public EventResponseBase notice(SubscriptionEvent event) {
    if (!isValidAccount(event)) {
      return getErrorResponse("Missing or invalid account identifier");
    }
    SubscriptionAccount sa = convert( event);
    if(sa == null)
      return getErrorResponse("Bad request");

    String uri = getResourceUri(event);
    RestTemplate restTemplate = new RestTemplate();
    try {
      restTemplate.put(uri, sa);
    } catch (RestClientException rcex) {
        return getErrorResponse("Problem in updating notice");
    }
    return getSuccessResponse();
  }

  private SubscriptionAccount convert(SubscriptionEvent event) {
      // Basic validation check
      if (event.getPayload() == null &&
          event.getPayload().getAccount() == null &&
          event.getPayload().getOrder() == null) {
          return null;
      }

      SubscriptionAccount sa = new SubscriptionAccount();
      if (event.getPayload().getAccount() != null) {
        sa.setStatus(event.getPayload().getAccount().getStatus());
        sa.setParentAccountIdentifier(event.getPayload().getAccount().getParentAccountIdentifier());
      }
      if (event.getPayload().getOrder() != null) {
        sa.setEditionCode(event.getPayload().getOrder().getEditionCode());
        if( event.getPayload().getOrder().getItems() != null &&
            event.getPayload().getOrder().getItems().size() > 0) {
              sa.setQuantity(event.getPayload().getOrder().getItems().get(0).getQuantity());
              sa.setUnit(event.getPayload().getOrder().getItems().get(0).getUnit());
        }
      }
      if (event.getPayload().getNotice() != null) {
          sa.setNotice(event.getPayload().getNotice().getType());
      }
      return sa;
  }
  private String getResourceUri(SubscriptionEvent event) {
      StringBuilder sb = new StringBuilder();
      sb.append(serviceUrl);
      sb.append(resource);
      if(event != null)
        sb.append(event.getPayload().getAccount().getAccountIdentifier());

      return sb.toString();
  }
  private boolean isValidAccount(SubscriptionEvent event) {
      if (event.getPayload() != null &&
          event.getPayload().getAccount() != null &&
          event.getPayload().getAccount().getAccountIdentifier() != null) {
            long dbId = Long.parseLong(event.getPayload().getAccount().getAccountIdentifier());
            return true;
      }
      return false;
  }
  private EventErrorResponse getErrorResponse(String message) {
    EventErrorResponse res = new EventErrorResponse();
    res.setSucccess(false);
    res.setMessage(message);
    log.debug(message);
    return res;
  }
  private EventSuccessResponse getSuccessResponse() {
    EventSuccessResponse res = new EventSuccessResponse();
    res.setSucccess(true);
    return res;
  }
}
