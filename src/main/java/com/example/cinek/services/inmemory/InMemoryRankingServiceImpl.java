package com.example.cinek.services.inmemory;

import com.example.cinek.model.DTO.RankList;
import com.example.cinek.model.uzytkownik.Turysta;
import com.example.cinek.repos.StaticDb;
import com.example.cinek.services.interfaces.RankingService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InMemoryRankingServiceImpl implements RankingService
{
    @Override
    public RankList getRank(Long id, String startDate, String endDate, List<Long> groups)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date sd, ed;
        try
        {
            sd = sdf.parse(startDate);
            ed = sdf.parse(endDate);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

        List<Turysta> tmpList = new ArrayList<>(StaticDb.turysci);
        /*for(Turysta t : tmpList)
        {
            int points = 0;
            for(Wedrowka w : t.getWedrowki())
            {
                if(w.getDataWedrowki().after(sd) && w.getDataWedrowki().before(ed))
                {
                    for(TrasaSkladowaLite ts : w.getTrasySkladowe())
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
            rankList.getNames().add(tmpList.get(i).getImie() + " " + tmpList.get(i).getNazwisko().substring(0, 1) + ".");
            rankList.getPoints().add(tmpList.get(i).getZgromadzonePunkty());
        }
        rankList.setReqTouristPosition(getPositionInList(tmpList, id));
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
