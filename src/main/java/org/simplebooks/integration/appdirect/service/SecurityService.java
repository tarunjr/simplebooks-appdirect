package org.simplebooks.integration.appdirect.service;

import org.springframework.stereotype.Service;

public interface SecurityService {
    public boolean validateAuthorization(String auth);
}
