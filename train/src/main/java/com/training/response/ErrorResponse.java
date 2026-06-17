package com.training.response;

public class ErrorResponse {
    private int code;
    private String message;

    public int getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }

    public void setCode(int Code){
        this.code = Code;
    }

    public void setMessage(String Message){
        this.message = Message;
    }
}
