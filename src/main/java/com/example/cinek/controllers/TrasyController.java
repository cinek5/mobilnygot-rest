package com.example.cinek.controllers;

import com.example.cinek.model.trasa.Trasa;
import com.example.cinek.model.trasa.TrasaPunktowana;
import com.example.cinek.repos.StaticDb;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Cinek on 27.12.2018.
 */
@RestController
public class TrasyController {

    @GetMapping("/trasa/punktowana")
    public List<TrasaPunktowana> getAllTrasyPunktowane()
    {
        return StaticDb.trasyPunktowane;
    }
}
