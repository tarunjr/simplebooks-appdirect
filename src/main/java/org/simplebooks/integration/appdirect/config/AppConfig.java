package org.simplebooks.integration.appdirect.config;

import org.simplebooks.integration.appdirect.service.SubscriptionService;
import org.simplebooks.integration.appdirect.service.SecurityService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public SubscriptionService subscriptionService() {
        return new SubscriptionService();
    }
    @Bean
    public SecurityService securityService() {
        return new SecurityService();
    }
}
