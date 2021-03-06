package com.example.cinek.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Cinek on 06.01.2019.
 */
@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "Order of skladowe punkty is not valid")
public class NotValidOrderInSkladowePunktyException extends RuntimeException {
    public NotValidOrderInSkladowePunktyException(String message) {
        super(message);
    }
}
