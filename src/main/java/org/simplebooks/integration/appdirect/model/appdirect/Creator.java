package org.simplebooks.integration.appdirect.model.appdirect;
/*
"creator": {
      "address": {
        "city": "San Jose",
        "country": "US",
        "firstName": "Test",
        "fullName": "Test User",
        "lastName": "User",
        "state": "CA",
        "street1": "1 Main St",
        "zip": "95131"
      },
      "email": "testuser@testco.com",
      "firstName": "Test",
      "language": "en",
      "lastName": "User",
      "locale": "en_US",
      "openId": "https://www.acme.com/openid/id/7f59aad1-85cd-4c04-b35b-906ee53acc71",
      "uuid": "7f59aad1-85cd-4c04-b35b-906ee53acc71"
    }

*/
public class Creator {
    private Address address;
    public Address getAddress() {
      return address;
    }
    public void setAddress(Address address) {
      this.address = address;
    }

    private String email;
    public String getEmail() {
      return email;
    }
    public void setEmail(String email) {
      this.email = email;
    }

    private String firstName;
    public String getFirstName() {
      return firstName;
    }
    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    private String language;
    public String getLanguage() {
      return language;
    }
    public void setLanguage(String language) {
      this.language = language;
    }

    private String lastName;
    public String getLastName() {
      return lastName;
    }
    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    private String locale;
    public String getLocale() {
      return locale;
    }
    public void setLocale(String locale) {
      this.locale = locale;
    }

    private String openId;
    public String getOpenId() {
      return openId;
    }
    public void setOpenId(String openId) {
      this.openId = openId;
    }

    private String uuid;
    public String getUuid() {
      return uuid;
    }
    public void setUuid(String uuid) {
      this.uuid = uuid;
    }
}
