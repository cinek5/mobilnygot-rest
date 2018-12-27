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
    private Date dataModyfikacji;


    public TrasaPunktowana(Long id, List<SkladowyPunktTrasy> skladowePunktyTrasy, GrupaGorska grupaGorska, Integer liczbaPunktow, Date dataDodania, Date dataModyfikacji) {
        super(id, skladowePunktyTrasy, grupaGorska);
        this.liczbaPunktow = liczbaPunktow;
        this.dataDodania = dataDodania;
        this.dataModyfikacji = dataModyfikacji;
    }


    @Override
    public int getLiczbaPunktow() {
        return liczbaPunktow;
    }
    public void setLiczbaPunktow(int liczbaPunktow) {
        this.liczbaPunktow = liczbaPunktow;
    }
}
