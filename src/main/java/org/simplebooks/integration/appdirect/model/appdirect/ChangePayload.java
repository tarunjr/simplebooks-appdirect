package org.simplebooks.integration.appdirect.model.appdirect;

import org.simplebooks.integration.appdirect.model.appdirect.Account;
import org.simplebooks.integration.appdirect.model.appdirect.Order;

/*
"payload": {
     "account": {
       "accountIdentifier": "206123",
       "status": "ACTIVE"
     },
     "order": {
       "editionCode": "DME",
       "pricingDuration": "DAILY",
       "item": {
         "quantity": "0",
         "unit": "GIGABYTE"
       }
     }
   }
*/

public class ChangePayload {
    private Account account;
    public Account getAccount() {
      return account;
    }
    public void setAccount(Account account) {
      this.account = account;
    }

    private Order order;
    public Order getOrder() {
      return order;
    }
    public void setOrder(Order order) {
      this.order = order;
    }
}
