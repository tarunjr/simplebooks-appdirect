package org.simplebooks.integration.appdirect;

import org.simplebooks.integration.appdirect.service.SubscriptionService;
import org.simplebooks.integration.appdirect.service.SecurityService;
import org.simplebooks.integration.appdirect.service.EventService;
import org.simplebooks.integration.appdirect.service.SimpleBooksSubscriptionService;
import org.simplebooks.integration.appdirect.service.AppdirectEventService;
import org.simplebooks.integration.appdirect.service.OAuthSecurityService;
import org.springframework.boot.test.TestRestTemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration
public class TestConfig {
    
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
}
