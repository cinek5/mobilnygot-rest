package com.example.cinek.controllers;

import com.example.cinek.model.DTO.wedrowka.PunktTrasyLite;
import com.example.cinek.model.trasa.PunktTrasy;
import com.example.cinek.services.interfaces.PunktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Cinek on 27.12.2018.
 */
@RestController
@CrossOrigin
public class PunktController {
    @Autowired
    private PunktService punktService;

    @GetMapping("/punkt")
    public List<PunktTrasy> getAllPunkty() {
        return punktService.getAllPunktyTrasy();
    }

    @PostMapping("/punkt")
    public void addPunkt(@RequestBody PunktTrasy punktTrasy) {
        punktService.insertPunktTrasy(punktTrasy);
    }

    @GetMapping("/punkt/wgrupie")
    public List<PunktTrasy> getPunktyInGrupa(@RequestParam String grupa) {
        return punktService.getPunktyTrasyByGrupaGorska(grupa);
    }

    @GetMapping("/lite/punkt/poczatkowy/wgrupie")
    public List<PunktTrasyLite> getPunktPoczatkowyInGrupaDTO(@RequestParam String grupa)
    {
        return PunktTrasyLite.createFromPunktTrasy(punktService.getPoczatkowePunktyTrasyByGrupaGorska(grupa));
    }

    @GetMapping("/punkt/poczatkowy/wgrupie")
    public List<PunktTrasy> getPunktyPoczatkoweInGrupa(@RequestParam String grupa) {
        return punktService.getPoczatkowePunktyTrasyByGrupaGorska(grupa);
    }


}
