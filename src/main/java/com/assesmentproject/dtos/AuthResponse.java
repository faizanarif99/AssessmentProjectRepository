package com.assesmentproject.dtos;

public class AuthResponse {
    private String token;
    private String code;
    private String message;

    public AuthResponse(String code,String message, String token ) {
        this.code = code;
        this.message = message;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getCode() {
        return code;
    }

    public void setCode( String code ) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage( String message ) {
        this.message = message;
    }
}
