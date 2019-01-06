package com.example.cinek.controllers;

import com.example.cinek.model.DTO.RankList;
import com.example.cinek.model.uzytkownik.Turysta;
import com.example.cinek.services.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController
{
    @Autowired
    RankingService rankingService;

    @GetMapping("/wyswietl/{id}/{startDate}/{endDate}")
    @CrossOrigin
    public RankList getRank(@PathVariable("id") Long id, @PathVariable("startDate") String startDate,
                            @PathVariable("endDate") String endDate, @RequestBody List<Long> groups)
    {
        return rankingService.getRank(id, startDate, endDate, groups);
    }
}
