package org.simplebooks.integration.appdirect;

import org.simplebooks.integration.appdirect.service.SubscriptionService;
import org.simplebooks.integration.appdirect.service.SecurityService;
import org.simplebooks.integration.appdirect.service.EventService;
import org.simplebooks.integration.appdirect.service.SimpleBooksSubscriptionService;
import org.simplebooks.integration.appdirect.service.AppdirectEventService;
import org.simplebooks.integration.appdirect.service.OAuthSecurityService;
import org.springframework.boot.test.TestRestTemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration
public class TestConfig {
    @Value("${appdirect.oauth.consumerkey}")
    private String consumerKey;
    @Value("${appdirect.oauth.consumersecret}")
    private String consumerSecret;

    @Bean
    public SecurityService securityService() {
        return new OAuthSecurityService(consumerKey, consumerSecret);
    }

    @Bean
    public SubscriptionService subscriptionService() {
        return new SimpleBooksSubscriptionService();
    }

    @Bean
    public EventService eventService(SecurityService securityService){
        return new AppdirectEventService(securityService);
    }
}
