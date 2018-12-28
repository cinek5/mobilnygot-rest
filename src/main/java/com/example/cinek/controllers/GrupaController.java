package com.example.cinek.controllers;

import com.example.cinek.model.grupa.GrupaGorska;
import com.example.cinek.repos.StaticDb;
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
    @GetMapping("/grupa")
    public List<GrupaGorska> getAllGrupyGorskie()
    {
        return StaticDb.grupyGorskie;
    }
}
