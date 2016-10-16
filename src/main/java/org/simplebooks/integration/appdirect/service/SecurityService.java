package org.simplebooks.integration.appdirect.service;

import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    public boolean validate(String auth) {
      return true;
    }
}
