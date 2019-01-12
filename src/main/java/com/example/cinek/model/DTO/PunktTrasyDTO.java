package com.example.cinek.model.DTO;

import com.example.cinek.model.trasa.PunktTrasy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cinek on 12.01.2019.
 */
public class PunktTrasyDTO {
    private Long punktId;
    private String nazwaPunktu;
    private String nazwaGrupy;

    public PunktTrasyDTO(Long punktId, String nazwaPunktu, String nazwaGrupy) {
        this.punktId = punktId;
        this.nazwaPunktu = nazwaPunktu;
        this.nazwaGrupy = nazwaGrupy;
    }

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

    public  static PunktTrasyDTO createFromPunktTrasy(PunktTrasy punktTrasy)
    {
        return new PunktTrasyDTO(punktTrasy.getId(), punktTrasy.getNazwaPunktu(), punktTrasy.getGrupaGorska().getNazwaGrupy());
    }
    public static List<PunktTrasyDTO> createFromPunktTrasy(List<PunktTrasy> punktyTrasy)
    {
        List<PunktTrasyDTO> result = new ArrayList<>();
        punktyTrasy.forEach(punktTrasy -> result.add(createFromPunktTrasy(punktTrasy)));
        return result;
    }
}
