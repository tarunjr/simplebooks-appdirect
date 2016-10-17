package org.simplebooks.integration.appdirect.model.appdirect;

/*
"item": {
          "quantity": "4",
          "unit": "USER"
        }
*/

public class Item {
    private String quantity;
    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
      this.quantity = quantity;
    }

    private String unit;
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
      this.unit = unit;
    }
}
