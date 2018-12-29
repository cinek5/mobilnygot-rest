package com.example.cinek.controllers;

import com.example.cinek.exceptions.TrasaNotFoundException;
import com.example.cinek.model.trasa.Trasa;
import com.example.cinek.model.trasa.TrasaPunktowana;
import com.example.cinek.repos.StaticDb;
import com.example.cinek.services.TrasyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            throw new TrasaNotFoundException();
        }
    }
    @PutMapping("/punktowana/{id}")
    public void updateTrasaPunktowana(@PathVariable("id") long id, @RequestBody TrasaPunktowana trasaPunktowana) {
        if (trasyService.getTrasaPunktowanaById(id)!=null)
        {
            trasyService.updateTrasaPunktowana(id, trasaPunktowana);
        }
        else
        {
            throw new TrasaNotFoundException();
        }
    }
    @PostMapping("/punktowana")
    public void createTrasaPunktowana(@RequestBody TrasaPunktowana trasaPunktowana)
    {
        trasyService.insertTrasaPunktowana(trasaPunktowana);
    }
    @DeleteMapping("/punktowana/{id}")
    public void deleteTrasaPunktowana(@PathVariable("id") long id) {
        if (trasyService.getTrasaPunktowanaById(id)!=null)
        {
            trasyService.deleteTrasaPunktowana(id);
        }
        else
        {
            throw new TrasaNotFoundException();
        }
    }
}
