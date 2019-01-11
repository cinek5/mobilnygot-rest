package com.example.cinek.exceptions;

/**
 * Created by Cinek on 11.01.2019.
 */
public class TrasaNotEnoughPunktyException extends  RuntimeException{
    public TrasaNotEnoughPunktyException(String msg)
    {
        super(msg);
    }
}
