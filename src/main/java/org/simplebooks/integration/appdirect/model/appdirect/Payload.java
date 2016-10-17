package org.simplebooks.integration.appdirect.model.appdirect;

import org.simplebooks.integration.appdirect.model.appdirect.Account;
import org.simplebooks.integration.appdirect.model.appdirect.Configuration;
import org.simplebooks.integration.appdirect.model.appdirect.Order;
import org.simplebooks.integration.appdirect.model.appdirect.Notice;

public class Payload{

  private String user;
  public String getUser() {
    return user;
  }
  public void setUser(String user) {
    this.user = user;
  }

  private Company company;
  public Company getCompany() {
    return company;
  }
  public void setCompany(Company company) {
    this.company = company;
  }
  private Account account;
  public Account getAccount() {
    return account;
  }
  public void setAccount(Account account) {
    this.account = account;
  }
  private String addonInstance;
  public String getAddonInstance() {
    return addonInstance;
  }
  public void setAddonInstance(String addonInstance) {
    this.addonInstance = addonInstance;
  }

  private String addonBinding;
  public String getAddonBinding() {
    return addonBinding;
  }
  public void setAddonBinding(String addonBinding) {
    this.addonBinding = addonBinding;
  }
  private Order order;
  public Order getOrder() {
    return order;
  }
  public void setOrder(Order order) {
    this.order = order;
  }
  private Notice notice;
  public Notice getNotice() {
    return notice;
  }
  public void setNotice(Notice notice) {
    this.notice = notice;
  }
  private Configuration configuration;
  public Configuration getConfiguration() {
    return configuration;
  }
}
