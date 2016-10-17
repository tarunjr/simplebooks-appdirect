package org.simplebooks.integration.appdirect;

import org.simplebooks.integration.appdirect.service.SubscriptionService;
import org.simplebooks.integration.appdirect.service.SecurityService;
import org.simplebooks.integration.appdirect.service.EventService;
import org.simplebooks.integration.appdirect.service.SimpleBooksSubscriptionService;
import org.simplebooks.integration.appdirect.service.AppdirectEventService;
import org.simplebooks.integration.appdirect.service.OAuthSecurityService;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
  @Bean
  public SubscriptionService subscriptionService() {
      return new SimpleBooksSubscriptionService();
  }
  @Bean
  public SecurityService securityService() {
      return new OAuthSecurityService();
  }
  @Bean
  public EventService eventService(){
      return new AppdirectEventService();
  }
  public static void main(String[] args) {
      SpringApplication.run(Application.class,args);
  }
}
