package com.example.cinek.model.trasa;

import com.example.cinek.model.grupa.GrupaGorska;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.List;

/**
 * Created by Cinek on 27.12.2018.
 */
@Entity
@DiscriminatorValue("N")
public class TrasaNiepunktowana extends Trasa {
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
