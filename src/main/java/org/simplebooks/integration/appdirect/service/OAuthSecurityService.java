package org.simplebooks.integration.appdirect.service;

import org.simplebooks.integration.appdirect.service.SecurityService;
import org.simplebooks.integration.appdirect.Application;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthCommunicationException;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class OAuthSecurityService implements SecurityService {
    private static final Logger log = LoggerFactory.getLogger(OAuthSecurityService.class);

    private final String consumerKey;
    private final String consumerSecret;

    public OAuthSecurityService(String consumerKey, String consumerSecret) {
      this.consumerKey = consumerKey;
      this.consumerSecret = consumerSecret;
    }
    public boolean validateAuthorization(String auth) {
      if (auth == null || auth.length() == 0) {
        log.debug("validateAuthorization failed");
        return false;
      }
      return true;
    }
    public HttpURLConnection getSignedURLConnection(String toSignUrl) {
      HttpURLConnection request = null;
      try {
        OAuthConsumer consumer = new DefaultOAuthConsumer(consumerKey, consumerSecret);
        URL url = new URL(toSignUrl);
        request = (HttpURLConnection) url.openConnection();
        consumer.sign(request);
      } catch(OAuthException oex) {
          log.error("Oauth error", oex);
          return null;
      } catch (IOException iox) {
          log.error("Netowork IO error",iox);
          return null;
      }
      return request;
    }
}
