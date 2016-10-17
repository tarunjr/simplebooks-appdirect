package org.simplebooks.integration.appdirect.web;

import org.simplebooks.integration.appdirect.service.SubscriptionService;
import org.simplebooks.integration.appdirect.service.SecurityService;
import org.simplebooks.integration.appdirect.service.EventResponseBase;
import org.simplebooks.integration.appdirect.service.EventService;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class SubscriptionNotificationController {

    private final SubscriptionService subscriptionService;
    private final EventService eventService;
    private final SecurityService securityService;

    @Autowired
    public SubscriptionNotificationController(SubscriptionService subscriptionService,
                                              EventService eventService,
                                              SecurityService securityService) {
        this.subscriptionService = subscriptionService;;
        this.eventService = eventService;
        this.securityService = securityService;
    }

    @RequestMapping("/subscription/create/notification")
    public ResponseEntity<EventResponseBase> create(
                                              @RequestParam(value="url", defaultValue="")  String eventUrl,
                                              @RequestHeader(value="authorization",defaultValue="") String authorization) {
        isAuthorized(authorization);

        return new ResponseEntity<EventResponseBase>(
                        subscriptionService.create(eventService.getOrderEvent(eventUrl)),
                        HttpStatus.CREATED);
    }

    @RequestMapping("/subscription/change/notification")
    public ResponseEntity<EventResponseBase> change(
                                              @RequestParam(value="url", defaultValue="")  String eventUrl,
                                              @RequestHeader(value="authorization", defaultValue="") String authorization) {
      isAuthorized(authorization);
      return new ResponseEntity<EventResponseBase>(
                            subscriptionService.change(eventService.getChangeEvent(eventUrl)),
                            HttpStatus.OK);

    }

    @RequestMapping("/subscription/cancel/notification")
    public ResponseEntity<EventResponseBase> cancel(
                                              @RequestParam(value="url", defaultValue="")  String eventUrl,
                                              @RequestHeader(value="authorization", defaultValue="") String authorization) {
      isAuthorized(authorization);
      return new ResponseEntity<EventResponseBase>(
                            subscriptionService.cancel(eventService.getCancelEvent(eventUrl)),
                            HttpStatus.OK);
    }

    @RequestMapping("/subscription/notice/notification")
    public ResponseEntity<EventResponseBase> notice(
                                              @RequestParam(value="url", defaultValue="")  String eventUrl,
                                              @RequestHeader(value="authorization", defaultValue="") String authorization) {
      isAuthorized(authorization);
      return new ResponseEntity<EventResponseBase>(
                            subscriptionService.notice(eventService.getNoticeEvent(eventUrl)),
                            HttpStatus.OK);
    }
    private void isAuthorized(String authorization) {
      if (!securityService.validateAuthorization(authorization)) {
          throw new UnAuthorizedException();
      }
    }
}

@ResponseStatus(HttpStatus.UNAUTHORIZED)
class UnAuthorizedException extends RuntimeException {

	public UnAuthorizedException() {
		super("Missing or invalid authorization header in the request");
	}
}
