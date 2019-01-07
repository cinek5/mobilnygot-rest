package com.example.cinek.exceptionhandlers;

import com.example.cinek.exceptions.DuplicateNazwaTrasyException;
import com.example.cinek.exceptions.NotValidOrderInSkladowePunktyException;
import com.example.cinek.exceptions.TrasaAlreadyDeletedException;
import com.example.cinek.exceptions.TrasaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Cinek on 07.01.2019.
 */
@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler({DuplicateNazwaTrasyException.class, NotValidOrderInSkladowePunktyException.class, TrasaAlreadyDeletedException.class, TrasaNotFoundException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception ex) {
        ErrorResponse response = new ErrorResponse(ex.getMessage());
        return response;
    }
}
