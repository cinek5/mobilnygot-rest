package com.example.cinek.services.impl;

import com.example.cinek.model.CustomDbObjects.RankEntry;
import com.example.cinek.model.DTO.RankList;
import com.example.cinek.repos.RankRepository;
import com.example.cinek.services.interfaces.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class RankingServiceImpl implements RankingService
{
    @Autowired
    private RankRepository rankRepository;

    @Override
    public RankList getRank(Long id, Date startDate, Date endDate, List<Long> groups)
    {
        RankList rankList = null;
        try
        {
            List<RankEntry> queryResults = rankRepository.getRank(groups, startDate, endDate);
            rankList = new RankList(queryResults.size() + 1);

            boolean reqFound = false;
            int currentPosition = 1;
            int currentRankPosition = 1;
            Integer lastPoints = -1;
            for(RankEntry re : queryResults)
            {
                if(re.getId().equals(id))
                {
                    reqFound = true;
                    rankList.setReqTouristIndex(currentPosition-1);
                }

                if(!lastPoints.equals(re.getPoints()))
                {
                    currentRankPosition = currentPosition;
                    lastPoints = re.getPoints();
                }
                rankList.addEntry(currentRankPosition, re.getName(), re.getPoints());
                currentPosition++;
            }

            if(!reqFound)
            {
                RankEntry reqEntry = rankRepository.getRankEntryWithNoPoints(id);
                rankList.addEntry(currentPosition, reqEntry.getName(), reqEntry.getPoints());
                rankList.setReqTouristIndex(currentPosition-1);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return rankList;
    }
}
