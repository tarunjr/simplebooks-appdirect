package org.simplebooks.integration.appdirect.model.appdirect;

import org.simplebooks.integration.appdirect.model.appdirect.CancelPayload;
import org.simplebooks.integration.appdirect.model.appdirect.Creator;

public class SubscriptionCancelEvent extends SubscriptionEventBase {
  private Creator creator;
  public  Creator getCreator(){
    return creator;
  }
  public void setCreator(Creator creator) {
    this.creator = creator;
  }

  private CancelPayload payload;
  public CancelPayload getPayload() {
    return payload;
  }
  public void setPayload(CancelPayload payload) {
    this.payload = payload;
  }
}
