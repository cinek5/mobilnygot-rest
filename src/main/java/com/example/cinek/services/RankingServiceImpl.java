package com.example.cinek.services;

import com.example.cinek.model.uzytkownik.Turysta;
import com.example.cinek.repos.StaticDb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RankingServiceImpl implements RankingService
{
    @Override
    public List<Turysta> getRank()
    {
        List<Turysta> retList = new ArrayList<>(StaticDb.turysci);
        retList.sort(new Comparator<Turysta>()
        {
            @Override
            public int compare(Turysta o1, Turysta o2)
            {
                return o2.getZgromadzonePunkty().compareTo(o1.getZgromadzonePunkty());
            }
        });
        return retList;
    }

    @Override
    public int getPositionInList(List<Turysta> list, Long userId)
    {
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getId().equals(userId))
            {
                return i;
            }
        }
        return -1;
    }
}
