package org.simplebooks.integration.appdirect.model.appdirect;
/*
"marketplace": {
      "baseUrl": "https://www.acme.com",
      "partner": "APPDIRECT"
    }
*/
public class Marketplace {
  private String baseUrl;
  public String getBaseUrl() {
    return baseUrl;
  }
  public void setBaseUrl(String baseUrl){
    this.baseUrl = baseUrl;
  }

  private String partner;
  public String getPartner() {
    return partner;
  }
  public void setPartner(String partner){
    this.partner = partner;
  }
}
