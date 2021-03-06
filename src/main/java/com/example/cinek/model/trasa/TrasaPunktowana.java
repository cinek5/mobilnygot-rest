package com.example.cinek.model.trasa;

import com.example.cinek.model.grupa.GrupaGorska;
import com.example.cinek.validators.hibernate.annotations.DateBeforeOtherDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by Cinek on 27.12.2018.
 */
@Entity
@DiscriminatorValue("P")
@DateBeforeOtherDate(date="dataDodania", otherDate="dataUsuniecia")
public class TrasaPunktowana extends Trasa {
    @Length(max = 70)
    @NotNull
    @Column(unique=true)
    private String nazwa;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat
    @NotNull
    private Date dataDodania;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat
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
