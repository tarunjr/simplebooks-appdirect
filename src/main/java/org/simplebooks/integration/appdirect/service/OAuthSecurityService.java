package org.simplebooks.integration.appdirect.service;

import org.simplebooks.integration.appdirect.service.SecurityService;

public class OAuthSecurityService implements SecurityService {
    public boolean validateAuthorization(String auth) {
      if (auth.length() == 0)
        return false;
      return true;
    }
}
