package com.example.cinek.controllers;

import com.example.cinek.model.grupa.GrupaGorska;
import com.example.cinek.repos.StaticDb;
import com.example.cinek.services.interfaces.GrupyGorskieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Cinek on 27.12.2018.
 */
@RestController
@CrossOrigin
public class GrupaController {

    @Autowired
    private GrupyGorskieService grupyGorskieService;

    @GetMapping("/grupa")
    public List<GrupaGorska> getAllGrupyGorskie()
    {
        return grupyGorskieService.getAllGrupyGorskie();
    }
}
