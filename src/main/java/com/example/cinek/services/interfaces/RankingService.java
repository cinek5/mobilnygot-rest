package com.example.cinek.services.interfaces;

import com.example.cinek.model.DTO.RankList;

import java.util.Date;
import java.util.List;

public interface RankingService
{
    RankList getRank(Long reqId, Date startDate, Date endDate, List<Long> groups);

}
