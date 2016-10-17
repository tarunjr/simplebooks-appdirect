package org.simplebooks.integration.appdirect.model.appdirect;

import org.simplebooks.integration.appdirect.model.appdirect.Company;
import org.simplebooks.integration.appdirect.model.appdirect.Order;


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
}
