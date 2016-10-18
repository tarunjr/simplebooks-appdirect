package org.simplebooks.integration.appdirect.service;

import org.simplebooks.integration.appdirect.service.EventService;
import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionEvent;
import org.simplebooks.integration.appdirect.Application;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthCommunicationException;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.lang.StringBuilder;


public class AppdirectEventService  implements EventService {
    private static final Logger log = LoggerFactory.getLogger(AppdirectEventService.class);

    private final SecurityService securityService;
    @Autowired
    public AppdirectEventService(SecurityService securityService) {
        this.securityService = securityService;
    }
    public SubscriptionEvent getEvent(String eventUrl) {
        String eventJson = getEventJson(eventUrl);
        SubscriptionEvent result = null;

        try {
          ObjectMapper mapper = new ObjectMapper();
          result = mapper.readValue(eventJson, SubscriptionEvent.class);
        } catch(IOException iox) {
          log.error("Failed to parse event json", iox);
          result = null;
        }
        return result;
    }

    private String getEventJson(String eventUrl) {
      StringBuilder result = new StringBuilder();
      try {
        log.info(eventUrl);
        HttpURLConnection request= securityService.getSignedURLConnection(eventUrl);
        if (request == null) {
          result.append("{}");
          return result.toString();
        }
        request.setRequestProperty("Accept", "application/json");
        request.setRequestProperty("Accept-Language", "en");
        request.setRequestProperty("Accept-Charset", "utf-8");
        request.connect();

        InputStream in = (InputStream)request.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while((line = reader.readLine()) != null) {
          result.append(line);
        }
        log.info(result.toString());
      } catch (IOException iox) {
        log.error("Failed to get event json", iox);
        result.append("{}");
      }
      return result.toString();
    }
}
