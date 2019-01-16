package com.example.cinek.repos;

import com.example.cinek.model.CustomDbObjects.RankEntry;

import java.util.Date;
import java.util.List;

public interface RankRepository
{
    List<RankEntry> getRank(List<Long> groupIds, Date startDate, Date endDate);
    RankEntry getRankEntryWithNoPoints(Long touristId);
}
