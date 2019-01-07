package com.example.cinek.controllers;

import com.example.cinek.exceptions.ExceptionMessages;
import com.example.cinek.exceptions.TrasaAlreadyDeletedException;
import com.example.cinek.exceptions.TrasaNotFoundException;
import com.example.cinek.model.trasa.TrasaPunktowana;
import com.example.cinek.services.interfaces.TrasyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.cinek.Utils.getDateFromString;

/**
 * Created by Cinek on 27.12.2018.
 */
@RestController
@RequestMapping("/trasa")
public class TrasyController {
    @Autowired
    TrasyService trasyService;


    @GetMapping("/punktowana")
    @CrossOrigin
    public List<TrasaPunktowana> getAllTrasyPunktowane()
    {
        return trasyService.getAllTrasyPuntkowane();
    }
    @GetMapping("/punktowana/{id}")
    @CrossOrigin
    public TrasaPunktowana getTrasaPunktowana(@PathVariable("id") long id) {
        TrasaPunktowana trasaPunktowana = trasyService.getTrasaPunktowanaById(id);
        if (trasaPunktowana!=null)
        {
            return trasaPunktowana;
        }
        else
        {
            throw new TrasaNotFoundException(ExceptionMessages.TRASA_NOT_FOUND);
        }
    }
    @PutMapping("/punktowana/{id}")
    @CrossOrigin
    public void updateTrasaPunktowana(@PathVariable("id") long id, @RequestBody TrasaPunktowana trasaPunktowana, @RequestParam String dataUsuniecia) {
        if (trasyService.getTrasaPunktowanaById(id)!=null)
        {
            trasyService.updateTrasaPunktowana(id, trasaPunktowana, getDateFromString(dataUsuniecia));
        }
        else
        {
            throw new TrasaNotFoundException(ExceptionMessages.TRASA_NOT_FOUND);
        }
    }
    @PostMapping("/punktowana")
    @CrossOrigin
    public void createTrasaPunktowana(@RequestBody TrasaPunktowana trasaPunktowana)
    {
        trasyService.insertTrasaPunktowana(trasaPunktowana);
    }
    @DeleteMapping("/punktowana/{id}")
    @CrossOrigin
    public void deleteTrasaPunktowana(@PathVariable("id") long id, @RequestParam String dataUsuniecia) {
        TrasaPunktowana trasaPunktowana = trasyService.getTrasaPunktowanaById(id);
        if (trasaPunktowana==null)
        {
            throw new TrasaNotFoundException(ExceptionMessages.TRASA_NOT_FOUND);
        }
        if (trasaPunktowana.getDataUsuniecia()!=null)
        {
            throw new TrasaAlreadyDeletedException(ExceptionMessages.TRASA_ALREADY_DELETED);
        }
        trasyService.deleteTrasaPunktowana(id, getDateFromString(dataUsuniecia));
    }
}
