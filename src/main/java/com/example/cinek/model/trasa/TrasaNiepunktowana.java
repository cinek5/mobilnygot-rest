package com.example.cinek.model.trasa;

import com.example.cinek.model.grupa.GrupaGorska;

import java.util.List;

/**
 * Created by Cinek on 27.12.2018.
 */
public class TrasaNiepunktowana extends Trasa{
    public TrasaNiepunktowana() {}

    public TrasaNiepunktowana(Long id, List<SkladowyPunktTrasy> skladowePunktyTrasy, GrupaGorska grupaGorska, Integer points) {
        super(id, skladowePunktyTrasy, grupaGorska, points);
    }

    @Override
    public int getGetPointsCount()
    {
        return getPunktyRegulaminowe();
    }
}
