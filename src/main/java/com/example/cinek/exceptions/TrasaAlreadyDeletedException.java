package com.example.cinek.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Cinek on 29.12.2018.
 */
@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "Trasa had been alread deleted")
public class TrasaAlreadyDeletedException extends RuntimeException {
}