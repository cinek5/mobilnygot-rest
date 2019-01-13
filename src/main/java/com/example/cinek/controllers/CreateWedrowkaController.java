package com.example.cinek.controllers;

import com.example.cinek.model.DTO.wedrowka.TrasaPunktowanaLite;
import com.example.cinek.services.interfaces.CreateWedrowkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Cinek on 13.01.2019.
 */
@RestController
public class CreateWedrowkaController {
    @Autowired
    private CreateWedrowkaService createWedrowkaService;

    @GetMapping("/lite/trasa/punktowana/poczatekwpunkcie/{punktId}")
    public List<TrasaPunktowanaLite> getTrasyPktLitesStartingInPoint(@PathVariable Long     punktId)
    {
        return createWedrowkaService.getTrasyPktLiteStartingInPunkt(punktId);
    }
}
