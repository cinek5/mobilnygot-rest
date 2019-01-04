package com.example.cinek.model.trasa;

import com.example.cinek.model.grupa.GrupaGorska;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by Cinek on 27.12.2018.
 */
public class TrasaPunktowana extends Trasa {
    private String nazwa;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataDodania;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataUsuniecia;
    private Long poprzedniaWersjaId;

    public TrasaPunktowana() {}

    public TrasaPunktowana(Long id, String nazwa, List<SkladowyPunktTrasy> skladowePunktyTrasy, GrupaGorska grupaGorska, Integer punktyRegulaminowe, Date dataDodania, Date dataUsuniecia) {
        super(id, skladowePunktyTrasy, grupaGorska, punktyRegulaminowe);
        this.nazwa = nazwa;
        this.dataDodania = dataDodania;
        this.dataUsuniecia = dataUsuniecia;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setDataDodania(Date dataDodania) {
        this.dataDodania = dataDodania;
    }

    public void setDataUsuniecia(Date dataUsuniecia) {
        this.dataUsuniecia = dataUsuniecia;
    }

    public Long getPoprzedniaWersjaId() {
        return poprzedniaWersjaId;
    }

    public void setPoprzedniaWersjaId(Long poprzedniaWersjaId) {
        this.poprzedniaWersjaId = poprzedniaWersjaId;
    }

    @Override
    public int getGetPointsCount() {
        return getPunktyRegulaminowe();
    }

    public Date getDataDodania() {
        return dataDodania;
    }
    public Date getDataUsuniecia() {
        return dataUsuniecia;
    }
}
