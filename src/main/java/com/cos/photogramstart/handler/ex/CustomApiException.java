package com.cos.photogramstart.handler.ex;

import java.util.Map;

public class CustomApiException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private Map<String, String> erropMap;

    public CustomApiException(String message){
        super(message);
    }

    public CustomApiException(String message, Map<String, String> erropMap){
        super(message);
        this.erropMap = erropMap;
    }

    public Map<String, String> getErropMap() {
        return erropMap;
    }
}
