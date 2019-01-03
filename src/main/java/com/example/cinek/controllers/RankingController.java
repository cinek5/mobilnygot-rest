package com.example.cinek.controllers;

import com.example.cinek.model.grupa.GrupaGorska;
import com.example.cinek.model.trasa.TrasaPunktowana;
import com.example.cinek.model.uzytkownik.Turysta;
import com.example.cinek.repos.StaticDb;
import com.example.cinek.services.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController
{
    @Autowired
    RankingService rankingService;

    @GetMapping("/wyswietl/{startDate}/{endDate}")
    @CrossOrigin
    public List<Turysta> getRank(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate, @RequestBody List<Long> groups)
    {
        return rankingService.getRank(startDate, endDate, groups);
    }

    @GetMapping("/myPosition")
    @CrossOrigin
    public Integer getPosition(List<Turysta> list, Long userId)
    {
        return rankingService.getPositionInList(list, userId);
    }
}
