package com.example.cinek.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Cinek on 29.12.2018.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Trasa with specified id not found")
public class TrasaNotFoundException extends RuntimeException {
    public TrasaNotFoundException(String message) {
        super(message);
    }
}