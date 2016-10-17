package org.simplebooks.integration.appdirect.model.appdirect;

import org.simplebooks.integration.appdirect.model.appdirect.Company;
import org.simplebooks.integration.appdirect.model.appdirect.Order;
import org.simplebooks.integration.appdirect.model.appdirect.Configuration;


/*
"payload": {
    "company": {
      "country": "US",
      "name": "tester",
      "phoneNumber": "1-800-333-3333",
      "uuid": "385beb51-51ae-4ffe-8c05-3f35a9f99825",
      "website": "www.testco.com"
    },
    "order": {
      "editionCode": "Standard",
      "pricingDuration": "MONTHLY",
      "item": {
        "quantity": "4",
        "unit": "USER"
      }
    }
  }
*/

public class OrderPayload {
  private Company company;
  public Company getCompany() {
    return company;
  }
  public void setCompany(Company company) {
    this.company = company;
  }

  private Order order;
  public Order getOrder() {
    return order;
  }
  public void setOrder(Order order) {
    this.order = order;
  }
  private String notice;
  public String getNotice() {
    return notice;
  }
  public void setNotice(String notice) {
    this.notice = notice;
  }
  private Configuration configuration;
  public Configuration getConfiguration() {
    return configuration;
  }
  public void setConfiguration(Configuration configuration) {
    this.configuration = configuration;
  }
  private String account;
  public String getAccount() {
    return account;
  }
  public void setAccount(String account) {
    this.account = account;
  }

  private String addonInstance;
  public String getAddonInstance() {
    return addonInstance;
  }
  public void setAddonInstance(String addonInstance) {
    this.addonInstance = addonInstance;
  }

  private String addonBinding;
  public String getAddonBinding() {
    return addonBinding;
  }
  public void setAddonBinding(String addonBinding) {
    this.addonBinding = addonBinding;
  }

  private String user;
  public String getUser() {
    return user;
  }
  public void setUser(String user) {
    this.user = user;
  }

}
