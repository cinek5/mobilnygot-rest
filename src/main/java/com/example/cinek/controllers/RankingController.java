package com.example.cinek.controllers;

import com.example.cinek.model.DTO.RankList;
import com.example.cinek.services.interfaces.RankingService;
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

    @GetMapping("/wyswietl/{id}/{startDate}/{endDate}")
    @CrossOrigin
    public RankList getRank(@PathVariable("id") Long id, @PathVariable("startDate") String startDate,
                            @PathVariable("endDate") String endDate, @RequestBody List<Long> groups)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date sd = null;
        Date ed = null;
        try
        {
            sd = sdf.parse(startDate);
            ed = sdf.parse(endDate);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return rankingService.getRank(id, sd, ed, groups);
    }
}
