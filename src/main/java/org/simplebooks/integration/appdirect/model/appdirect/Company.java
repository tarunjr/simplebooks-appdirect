package org.simplebooks.integration.appdirect.model.appdirect;

/*
"company": {
      "country": "US",
      "name": "tester",
      "phoneNumber": "1-800-333-3333",
      "uuid": "385beb51-51ae-4ffe-8c05-3f35a9f99825",
      "website": "www.testco.com"
    }
*/

public class Company {
    private String country;
    public String getCountry() {
      return country;
    }
    public void setCountry(String country) {
      this.country = country;
    }

    private String name;
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }

    private String phoneNumber;
    public String getPhoneNumber() {
      return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
    }

    private String uuid;
    public String getUuid() {
      return uuid;
    }
    public void setUuid(String uuid) {
      this.uuid = uuid;
    }

    private String website;
    public String getWebsite() {
      return website;
    }
    public void setWebsite(String website) {
      this.website = website;
    }
}
