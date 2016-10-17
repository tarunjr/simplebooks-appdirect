package org.simplebooks.integration.appdirect.model.appdirect;

import org.simplebooks.integration.appdirect.model.appdirect.Item;
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

    private Item item;
    public Item getItem() {
      return item;
    }
    public void setItem(Item item) {
      this.item = item;
    }
}
