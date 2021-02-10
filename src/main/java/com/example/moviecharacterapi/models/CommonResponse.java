package com.example.moviecharacterapi.models;

import org.springframework.http.HttpStatus;

public class CommonResponse {
    public Object data;
    public String message;
    public String error;
    public HttpStatus status;
}

