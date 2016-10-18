package org.simplebooks.integration.appdirect;

import org.simplebooks.integration.appdirect.service.SubscriptionService;
import org.simplebooks.integration.appdirect.service.SecurityService;
import org.simplebooks.integration.appdirect.service.EventService;
import org.simplebooks.integration.appdirect.service.SimpleBooksSubscriptionService;
import org.simplebooks.integration.appdirect.service.AppdirectEventService;
import org.simplebooks.integration.appdirect.service.OAuthSecurityService;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
public class Application {
  private static final Logger log = LoggerFactory.getLogger(Application.class);

  @Value("${appdirect.oauth.consumerkey}")
  private String consumerKey;
  @Value("${appdirect.oauth.consumersecret}")
  private String consumerSecret;

  @Bean
  public SubscriptionService subscriptionService() {
      return new SimpleBooksSubscriptionService();
  }
  @Bean
  public SecurityService securityService() {
      return new OAuthSecurityService(consumerKey, consumerSecret);
  }
  @Bean
  public EventService eventService(SecurityService securityService){
      return new AppdirectEventService(securityService);
  }
  
  public static void main(String[] args) {
      SpringApplication.run(Application.class,args);
  }
}
