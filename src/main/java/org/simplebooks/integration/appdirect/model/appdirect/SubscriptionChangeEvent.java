package org.simplebooks.integration.appdirect.model.appdirect;

import org.simplebooks.integration.appdirect.model.appdirect.ChangePayload;
import org.simplebooks.integration.appdirect.model.appdirect.Creator;

public class SubscriptionChangeEvent extends SubscriptionEventBase {
  private Creator creator;
  public  Creator getCreator(){
    return creator;
  }
  public void setCreator(Creator creator) {
    this.creator = creator;
  }
  private ChangePayload payload;
  public ChangePayload getPayload() {
    return payload;
  }
  public void setPayload(ChangePayload payload) {
    this.payload = payload;
  }
}
