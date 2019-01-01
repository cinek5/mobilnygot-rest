package com.example.cinek.controllers;

import com.example.cinek.model.grupa.GrupaGorska;
import com.example.cinek.model.trasa.TrasaPunktowana;
import com.example.cinek.model.uzytkownik.Turysta;
import com.example.cinek.services.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController
{
    @Autowired
    RankingService rankingService;

    @GetMapping("/show")
    @CrossOrigin
    public List<Turysta> getRank(@RequestBody Date startDate, @RequestBody Date endDate, @RequestBody List<GrupaGorska> groups)
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
