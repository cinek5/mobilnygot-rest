package com.example.cinek.exceptionhandlers;

/**
 * Created by Cinek on 07.01.2019.
 */
public class ErrorResponse {
    private String error;
    public ErrorResponse(String errorMsg)
    {
        this.error = errorMsg;
    }
    public String getError()
    {
        return error;
    }
}
