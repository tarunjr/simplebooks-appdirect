package org.simplebooks.integration.appdirect.service;

import org.simplebooks.integration.appdirect.service.EventService;
import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionEvent;
import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionChangeEvent;
import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionNoticeEvent;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthCommunicationException;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.lang.StringBuilder;


public class AppdirectEventService  implements EventService {

    @Value("${consumerkey}")
    private String consumerKey;
    @Value("${consumersecret}")
    private String consumerSecret;

    public SubscriptionEvent getOrderEvent(String eventUrl) {
        String eventJson = getEventJson(eventUrl);

        ObjectMapper mapper = new ObjectMapper();
        SubscriptionEvent result = null;
        try {
          result = mapper.readValue(eventJson, SubscriptionEvent.class);
          System.out.println(result.getPayload().getCompany().getUuid());
          System.out.println(result.getPayload().getOrder().getEditionCode());
        } catch(IOException iox) {
          iox.printStackTrace();
          result = null;
        }
        return result;
    }
    public SubscriptionChangeEvent getChangeEvent(String eventUrl) {
        String eventJson = getEventJson(eventUrl);

        ObjectMapper mapper = new ObjectMapper();
        SubscriptionChangeEvent result = null;
        try {
          result = mapper.readValue(eventJson, SubscriptionChangeEvent.class);
          System.out.println(result.getPayload().getAccount().getAccountIdentifier());
          System.out.println(result.getPayload().getOrder().getEditionCode());
        } catch(IOException iox) {
          iox.printStackTrace();
          result = null;
        }
        return result;
    }
    public SubscriptionEvent getCancelEvent(String eventUrl) {
        String eventJson = getEventJson(eventUrl);
        System.out.println("getCancelEvent");
        ObjectMapper mapper = new ObjectMapper();
        SubscriptionEvent result = null;
        try {
          result = mapper.readValue(eventJson, SubscriptionEvent.class);
          System.out.println(result);
          System.out.println(result.getPayload().getAccount().getAccountIdentifier());
        } catch(IOException iox) {
          iox.printStackTrace();
          result = null;
        }
        return result;
    }
    public SubscriptionNoticeEvent getNoticeEvent(String eventUrl) {
        String eventJson = getEventJson(eventUrl);

        ObjectMapper mapper = new ObjectMapper();
        SubscriptionNoticeEvent result = null;
        try {
          result = mapper.readValue(eventJson, SubscriptionNoticeEvent.class);
          System.out.println(result.getPayload().getAccount().getAccountIdentifier());
          System.out.println(result.getPayload().getNotice().getType());
        } catch(IOException iox) {
          iox.printStackTrace();
          result = null;
        }
        return result;
    }

    // TODO : Check if we can use RestTemplate insted of HttpURLConnection
    private String getEventJson(String eventUrl) {
      StringBuilder result = new StringBuilder();
      try {
        System.out.println(consumerKey + ":" + consumerSecret);
        OAuthConsumer consumer = new DefaultOAuthConsumer(consumerKey, consumerSecret);
        URL url = new URL(eventUrl);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestProperty("Accept", "application/json");
        request.setRequestProperty("Accept-Language", "en");
        request.setRequestProperty("Accept-Charset", "utf-8");
        consumer.sign(request);
        request.connect();

        InputStream in = (InputStream)request.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while((line = reader.readLine()) != null) {
          result.append(line);
        }
        //System.out.println(result.toString());
      } catch (IOException iox) {
        result.append("IOException");
      } catch (OAuthMessageSignerException oamsx ) {
        result.append("OAuthMessageSignerException");
      } catch (OAuthExpectationFailedException oefx) {
        result.append("OAuthExpectationFailedException");
      } catch (OAuthCommunicationException ocex) {
        result.append("OAuthCommunicationException");
      }
      return result.toString();
    }
}
