package org.simplebooks.integration.appdirect.controller;

import org.simplebooks.integration.appdirect.service.SubscriptionService;
import org.simplebooks.integration.appdirect.service.SecurityService;
import org.simplebooks.integration.appdirect.service.EventResponseBase;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthCommunicationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class SubscriptionEventHandlerController {
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private SecurityService securityService;


    @RequestMapping("/subscription/create/notification")
    public EventResponseBase create(@RequestParam(value="url", defaultValue="")  String eventUrl,
                         @RequestHeader(value="authorization",required=true) String authorization) {
        securityService.validate(authorization);
        System.out.println(eventUrl);
        System.out.println(authorization);

        System.out.println(getEventInformation(eventUrl));

        return subscriptionService.create(null);
    }
    private String getEventInformation(String eventUrl) {
      String result = null;
      try {
        OAuthConsumer consumer = new DefaultOAuthConsumer("Dummy", "secret");
        URL url = new URL(eventUrl);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        consumer.sign(request);
        request.connect();

        Object res = request.getContent();
        result = res.toString();
      } catch (IOException iox) {
        result = "";
      } catch (OAuthMessageSignerException oamsx ) {
        result = "";
      } catch (OAuthExpectationFailedException oefx) {
        result = "";
      } catch (OAuthCommunicationException ocex) {
        result = "";
      }
      return result;
    }
    /*
    @RequestMapping("/subscription/create/notification")
    public void echo(HttpServletRequest req,  HttpServletResponse res) throws IOException {
        StringBuilder sb = new StringBuilder();

        Enumeration headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String header = (String)headerNames.nextElement();
            sb.append(header);
            sb.append(":");

            Enumeration headers = req.getHeaders(header);
            while(headers.hasMoreElements()) {
                String value = (String)headers.nextElement();
                sb.append(value);
                sb.append(",");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

        res.setStatus(HttpServletResponse.SC_OK);
    }
    */
    @RequestMapping("/subscription/change/notification")
    public String change(@RequestParam(value="url", defaultValue="")  String eventUrl) {
        return subscriptionService.change(null);
    }
    @RequestMapping("/subscription/cancel/notification")
    public String cancel(@RequestParam(value="url", defaultValue="")  String eventUrl) {
        return subscriptionService.cancel(null);
    }
    @RequestMapping("/subscription/notice/notification")
    public String notice(@RequestParam(value="url", defaultValue="")  String eventUrl) {
        return subscriptionService.notice(null);
    }
}
