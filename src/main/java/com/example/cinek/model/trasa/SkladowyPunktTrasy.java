package com.example.cinek.model.trasa;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * Created by Cinek on 27.12.2018.
 */
@Entity
public class SkladowyPunktTrasy implements Serializable
{
    @Id
    @OneToOne(fetch= FetchType.EAGER)
    private PunktTrasy punktTrasy;
    @Id
    @ManyToOne
    private Trasa trasa;
    @NotEmpty
    private int kolejnoscPunktu;

    public SkladowyPunktTrasy() {}

    public SkladowyPunktTrasy(PunktTrasy punktTrasy, int kolejnoscPunktu) {
        this.punktTrasy = punktTrasy;
        this.kolejnoscPunktu = kolejnoscPunktu;
    }

    public PunktTrasy getPunktTrasy() {
        return punktTrasy;
    }

    public void setPunktTrasy(PunktTrasy punktTrasy) {
        this.punktTrasy = punktTrasy;
    }

    public int getKolejnoscPunktu() {
        return kolejnoscPunktu;
    }

    public void setKolejnoscPunktu(int kolejnoscPunktu) {
        this.kolejnoscPunktu = kolejnoscPunktu;
    }

    public Trasa getTrasa()
    {
        return trasa;
    }

    public void setTrasa(Trasa trasa)
    {
        this.trasa = trasa;
    }
}
