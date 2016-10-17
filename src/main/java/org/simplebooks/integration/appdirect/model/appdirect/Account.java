package org.simplebooks.integration.appdirect.model.appdirect;

/*

"account": {
       "accountIdentifier": "a3f72246-5377-4d92-8bdc-b1b6b450c55c",
       "status": "ACTIVE"
     }
*/

public class Account {
    private String accountIdentifier;
    public String getAccountIdentifier() {
      return accountIdentifier;
    }
    public void setAccountIdentifier(String accountIdentifier) {
      this.accountIdentifier = accountIdentifier;
    }

    private String status;
    public String getStatus() {
      return status;
    }
    public void setStatus(String status) {
      this.status = status;
    }
}
