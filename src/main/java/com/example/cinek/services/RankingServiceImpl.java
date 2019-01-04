package com.example.cinek.services;

import com.example.cinek.model.Wedrowka.TrasaSkladowa;
import com.example.cinek.model.Wedrowka.Wedrowka;
import com.example.cinek.model.trasa.Status;
import com.example.cinek.model.uzytkownik.Turysta;
import com.example.cinek.repos.StaticDb;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class RankingServiceImpl implements RankingService
{
    @Override
    public List<Turysta> getRank(String startDate, String endDate, List<Long> groups)
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
        for(Turysta t : tmpList)
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
        }

        tmpList.sort(new Comparator<Turysta>()
        {
            @Override
            public int compare(Turysta o1, Turysta o2)
            {
                return o2.getZgromadzonePunkty().compareTo(o1.getZgromadzonePunkty());
            }
        });
        return tmpList;
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
