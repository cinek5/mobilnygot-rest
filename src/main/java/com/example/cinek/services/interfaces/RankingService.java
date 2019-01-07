package com.example.cinek.services.interfaces;

import com.example.cinek.model.DTO.RankList;
import com.example.cinek.model.uzytkownik.Turysta;

import java.util.List;

public interface RankingService
{
    RankList getRank(Long id, String startDate, String endDate, List<Long> groups);
}
