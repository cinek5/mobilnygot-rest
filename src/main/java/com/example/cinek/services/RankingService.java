package com.example.cinek.services;

import com.example.cinek.model.grupa.GrupaGorska;
import com.example.cinek.model.uzytkownik.Turysta;

import java.util.Date;
import java.util.List;

public interface RankingService
{
    List<Turysta> getRank(Date startDate, Date endDate, List<GrupaGorska> groups);
    int getPositionInList(List<Turysta> list, Long userId);
}
