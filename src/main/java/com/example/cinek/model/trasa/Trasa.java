package com.example.cinek.model.trasa;

import com.example.cinek.model.grupa.GrupaGorska;

import java.util.List;

/**
 * Created by Cinek on 27.12.2018.
 */
public abstract class Trasa {
    private Long id;
    private List<SkladowyPunktTrasy> skladowePunktyTrasy;
    private GrupaGorska grupaGorska;


    public Trasa(Long id, List<SkladowyPunktTrasy> skladowePunktyTrasy, GrupaGorska grupaGorska) {
        this.id = id;
        this.skladowePunktyTrasy = skladowePunktyTrasy;
        this.grupaGorska = grupaGorska;
    }

    public abstract int getLiczbaPunktow();

    public List<SkladowyPunktTrasy> getSkladowePunktyTrasy() {
        return skladowePunktyTrasy;
    }

    public void setSkladowePunktyTrasy(List<SkladowyPunktTrasy> skladowePunktyTrasy) {
        this.skladowePunktyTrasy = skladowePunktyTrasy;
    }

    public GrupaGorska getGrupaGorska() {
        return grupaGorska;
    }

    public void setGrupaGorska(GrupaGorska grupaGorska) {
        this.grupaGorska = grupaGorska;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj)
    {
        return id.equals(((Trasa)obj).id);
    }
}
