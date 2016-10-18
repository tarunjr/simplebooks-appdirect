package org.simplebooks.integration.appdirect.service;

import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;

public interface SecurityService {
    public boolean validateAuthorization(String auth);
    public HttpURLConnection getSignedURLConnection(String Url);
}
