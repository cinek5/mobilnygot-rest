package com.example.cinek.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Cinek on 06.01.2019.
 */
@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "Trasa with specified name already exists")
public class DuplicateNazwaTrasyException extends RuntimeException {
    public DuplicateNazwaTrasyException(String message) {
        super(message);
    }
}
