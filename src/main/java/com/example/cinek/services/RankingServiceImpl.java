package com.example.cinek.services;

import com.example.cinek.model.Wedrowka.TrasaSkladowa;
import com.example.cinek.model.Wedrowka.Wedrowka;
import com.example.cinek.model.grupa.GrupaGorska;
import com.example.cinek.model.trasa.Status;
import com.example.cinek.model.uzytkownik.Turysta;
import com.example.cinek.repos.StaticDb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class RankingServiceImpl implements RankingService
{
    @Override
    public List<Turysta> getRank(Date startDate, Date endDate, List<GrupaGorska> groups)
    {
        List<Turysta> tmpList = new ArrayList<>(StaticDb.turysci);
        for(Turysta t : tmpList)
        {
            int points = 0;
            for(Wedrowka w : t.getWedrowki())
            {
                if(w.getDataWedrowki().after(startDate) && w.getDataWedrowki().before(endDate))
                {
                    for(TrasaSkladowa ts : w.getTrasySkladowe())
                    {
                        if(ts.getStatus().equals(Status.potwierdzona))
                        {
                            if(groups.contains(ts.getTrasa().getGrupaGorska()))
                            {
                                points += ts.getTrasa().getLiczbaPunktow();
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
