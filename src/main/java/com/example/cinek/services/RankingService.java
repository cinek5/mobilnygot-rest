package com.example.cinek.services;

import com.example.cinek.model.grupa.GrupaGorska;
import com.example.cinek.model.uzytkownik.Turysta;

import java.util.Date;
import java.util.List;

public interface RankingService
{
    List<Turysta> getRank(String startDate, String endDate, List<Long> groups);
    int getPositionInList(List<Turysta> list, Long userId);
}
