package org.simplebooks.integration.appdirect.model.appdirect;

import org.simplebooks.integration.appdirect.model.appdirect.Payload;
import org.simplebooks.integration.appdirect.model.appdirect.Creator;
import org.simplebooks.integration.appdirect.model.appdirect.Marketplace;


import java.util.List;

public class SubscriptionEvent {
  //type property
  private String type;
  public String getType(){
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  // Marketplace property
  private Marketplace marketplace;
  public  Marketplace getMarketplace(){
    return marketplace;
  }
  public void setMarketplace(Marketplace marketplace) {
    this.marketplace = marketplace;
  }
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

  private Payload payload;
  public Payload getPayload() {
    return payload;
  }
  public void setPayload(Payload payload) {
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
