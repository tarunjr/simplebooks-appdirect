package org.simplebooks.integration.appdirect.model.appdirect;

import org.simplebooks.integration.appdirect.model.appdirect.NoticePayload;
import org.simplebooks.integration.appdirect.model.appdirect.Creator;

public class SubscriptionNoticeEvent extends SubscriptionEventBase {
  private Creator creator;
  public  Creator getCreator(){
    return creator;
  }
  public void setCreator(Creator creator) {
    this.creator = creator;
  }

  private NoticePayload payload;
  public NoticePayload getPayload() {
    return payload;
  }
  public void setPayload(NoticePayload payload) {
    this.payload = payload;
  }


}
