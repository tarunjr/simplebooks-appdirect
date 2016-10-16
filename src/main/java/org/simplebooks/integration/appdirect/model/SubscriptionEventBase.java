package org.simplebooks.integration.appdirect.model;

public class SubscriptionEventBase {
    //type property
    private String type;
    public String getType(){
      return type;
    }
    public void setType(String type) {
      this.type = type;
    }

    // Marketplace property
    private Marketplace marketplace;
    public  Marketplace getMarketplace(){
      return marketplace;
    }
    public void setMarketplace(Marketplace marketplace) {
      this.marketplace = marketplace;
    }
    //Creator property
    private Creator creator;
    public  Creator getCreator(){
      return creator;
    }
    public void setCreator(Creator creator) {
      this.creator = creator;
    }
}
/*
{
    "type": "SUBSCRIPTION_ORDER",
    "marketplace": {
      "baseUrl": "https://www.acme.com",
      "partner": "APPDIRECT"
    },
    "creator": {
      "address": {
        "firstName": "Sample",
        "fullName": "Sample Tester",
        "lastName": "Tester"
      },
      "email": "sampletester@testco.com",
      "firstName": "Sample",
      "language": "en",
      "lastName": "Tester",
      "locale": "en_US",
      "openId": "https://www.acme.com/openid/id/211aa367-f53b-4606-8887-80a381e0ef69",
      "uuid": "211aa369-f53b-4606-8887-80a361e0ef66"
    },
    "payload": {
      "company": {
        "country": "US",
        "name": "Sample Testing co.",
        "uuid": "bd58b532-323b-4627-a828-57729489b27b",
        "website": "www.testerco.com"
      },
      "order": {
        "editionCode": "FREE",
        "pricingDuration": "MONTHLY"
      }
    }
}
*/
