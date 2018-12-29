package com.example.cinek.model.trasa;

import com.example.cinek.model.grupa.GrupaGorska;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by Cinek on 27.12.2018.
 */
public class TrasaPunktowana extends Trasa {
    private Integer liczbaPunktow;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dataDodania;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dataUsuniecia;
    private Long poprzedniaWersjaId;


    public TrasaPunktowana(Long id, List<SkladowyPunktTrasy> skladowePunktyTrasy, GrupaGorska grupaGorska, Integer liczbaPunktow, Date dataDodania, Date dataUsuniecia) {
        super(id, skladowePunktyTrasy, grupaGorska);
        this.liczbaPunktow = liczbaPunktow;
        this.dataDodania = dataDodania;
        this.dataUsuniecia = dataUsuniecia;
    }

    public void setLiczbaPunktow(Integer liczbaPunktow) {
        this.liczbaPunktow = liczbaPunktow;
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
    public int getLiczbaPunktow() {
        return liczbaPunktow;
    }
    public Date getDataDodania() {
        return dataDodania;
    }
    public Date getDataUsuniecia() {
        return dataUsuniecia;
    }
    public void setLiczbaPunktow(int liczbaPunktow) {
        this.liczbaPunktow = liczbaPunktow;
    }

}
