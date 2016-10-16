package org.simplebooks.integration.appdirect.service;

public class EventSuccessResponse extends EventResponseBase {
    private String accountIdentifier;
    public String getAccountIdentifier() {
      return accountIdentifier;
    }
    public void setAccountIdentifier(String accountIdentifier){
      this.accountIdentifier = accountIdentifier;
    }
}
