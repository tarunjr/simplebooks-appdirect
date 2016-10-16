package org.simplebooks.integration.appdirect.service;

public class EventErrorResponse extends EventResponseBase {
    private String errorCode;
    public String getErrorCode() {
      return errorCode;
    }
    public void setErrorCode(String errorCode){
      this.errorCode = errorCode;
    }

    private String message;
    public String getMessage() {
      return message;
    }
    public void setMessage(String message){
      this.message = message;
    }
}
