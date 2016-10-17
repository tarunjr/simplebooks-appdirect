package org.simplebooks.integration.appdirect.model.appdirect;

import org.simplebooks.integration.appdirect.model.appdirect.SubscriptionEventBase;
import org.simplebooks.integration.appdirect.model.appdirect.OrderPayload;
import org.simplebooks.integration.appdirect.model.appdirect.Creator;

import java.util.List;

public class SubscriptionOrderEvent extends SubscriptionEventBase {


    private String applicationUuid;
    public String getApplicationUuid() {
      return applicationUuid;
    }
    public void setApplicationUuid(String applicationUuid) {
      this.applicationUuid = applicationUuid;
    }
    private String flag;
    public String getFlat() {
      return flag;
    }
    public void setFlag(String flag) {
      this.flag = flag;
    }

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
    private String returnUrl;
    public String getReturnUrl() {
      return returnUrl;
    }
    public void setReturnUrl(String returnUrl) {
      this.returnUrl = returnUrl;
    }
    private List<String> links;
    public List<String> getLinks() {
      return links;
    }
    public void setLinks(List<String> links) {
      this.links = links;
    }

}
