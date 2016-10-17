package org.simplebooks.integration.appdirect.model.appdirect;

import org.simplebooks.integration.appdirect.model.appdirect.Item;
import java.util.List;
/*
"order": {
      "editionCode": "Standard",
      "pricingDuration": "MONTHLY",
      "item": {
        "quantity": "4",
        "unit": "USER"
      }
    }
*/

public class Order {
    private String editionCode;
    public String getEditionCode() {
      return editionCode;
    }
    public void setEditionCode(String editionCode) {
      this.editionCode = editionCode;
    }
    private String pricingDuration;
    public String getPricingDuration() {
      return pricingDuration;
    }
    public void setPricingDuration(String pricingDuration) {
      this.pricingDuration = pricingDuration;
    }

    private List<Item> items;
    public List<Item> getItems() {
      return items;
    }
    public void setItem(List<Item> items) {
      this.items = items;
    }

    private String addonOfferingCode;
    public String getAddonOfferingCode() {
      return addonOfferingCode;
    }
    public void setAddonOfferingCode(String addonOfferingCode) {
      this.addonOfferingCode = addonOfferingCode;
    }
}
