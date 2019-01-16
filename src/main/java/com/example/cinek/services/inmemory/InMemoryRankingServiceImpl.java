package com.example.cinek.services.inmemory;

import com.example.cinek.model.DTO.RankList;
import com.example.cinek.model.uzytkownik.Turysta;
import com.example.cinek.repos.StaticDb;
import com.example.cinek.services.interfaces.RankingService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InMemoryRankingServiceImpl implements RankingService
{
    @Override
    public RankList getRank(Long id, Date startDate, Date endDate, List<Long> groups)
    {
        List<Turysta> tmpList = new ArrayList<>(StaticDb.turysci);
        /*for(Turysta t : tmpList)
        {
            int points = 0;
            for(Wedrowka w : t.getWedrowki())
            {
                if(w.getDataWedrowki().after(sd) && w.getDataWedrowki().before(ed))
                {
                    for(TrasaSkladowa ts : w.getTrasySkladowe())
                    {
                        if(ts.getStatus().equals(Status.potwierdzona))
                        {
                            if(groups.contains(ts.getTrasa().getGrupaGorska().getId()))
                            {
                                points += ts.getTrasa().getPunktyRegulaminowe();
                            }
                        }
                    }
                }
            }
            t.setZgromadzonePunkty(points);
        }*/

        tmpList.sort((o1, o2) -> o2.getZgromadzonePunkty().compareTo(o1.getZgromadzonePunkty()));

        RankList rankList = new RankList(tmpList.size());
        for(int i = 0; i < tmpList.size(); i++)
        {
            //rankList.getNames().add(tmpList.get(i).getImie() + " " + tmpList.get(i).getNazwisko().substring(0, 1) + ".");
            //rankList.getPoints().add(tmpList.get(i).getZgromadzonePunkty());
        }
        rankList.setReqTouristIndex(getPositionInList(tmpList, id));
        return rankList;
    }

    private int getPositionInList(List<Turysta> list, Long userId)
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
