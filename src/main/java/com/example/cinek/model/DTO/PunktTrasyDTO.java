package com.example.cinek.model.DTO;

/**
 * Created by Cinek on 12.01.2019.
 */
public class PunkTrasyDTO {
    private Long punktId;
    private String nazwaPunktu;
    private String nazwaGrupy;

    public Long getPunktId() {
        return punktId;
    }

    public void setPunktId(Long punktId) {
        this.punktId = punktId;
    }

    public String getNazwaPunktu() {
        return nazwaPunktu;
    }

    public void setNazwaPunktu(String nazwaPunktu) {
        this.nazwaPunktu = nazwaPunktu;
    }

    public String getNazwaGrupy() {
        return nazwaGrupy;
    }

    public void setNazwaGrupy(String nazwaGrupy) {
        this.nazwaGrupy = nazwaGrupy;
    }
}
