package org.simplebooks.integration.appdirect.model.appdirect;

import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionEventBase;
import org.simplebooks.integration.appdirect.model.appdirect.OrderPayload;
import org.simplebooks.integration.appdirect.model.appdirect.Creator;

public class SubscriptionOrderEvent extends SubscriptionEventBase {
    private Creator creator;
    public  Creator getCreator(){
      return creator;
    }
    public void setCreator(Creator creator) {
      this.creator = creator;
    }

    private OrderPayload payload;
    public OrderPayload getPayload() {
      return payload;
    }
    public void setPayload(OrderPayload payload) {
      this.payload = payload;
    }
}
