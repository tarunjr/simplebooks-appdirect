package org.simplebooks.integration.appdirect.model.appdirect;

import org.simplebooks.integration.appdirect.model.appdirect.Account;

/*
"payload": {
     "account": {
       "accountIdentifier": "9d6fca98-aa94-462b-85fa-118804ad3fe3",
       "status": "ACTIVE"
     }
   }
*/

public class CancelPayload {
    private Account account;
    public Account getAccount() {
      return account;
    }
    public void setAccount(Account account) {
      this.account = account;
    }
}
