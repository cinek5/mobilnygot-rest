package com.example.cinek.model.trasa;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

/**
 * Created by Cinek on 27.12.2018.
 */
@Entity
public class PunktTrasy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Length(max = 40)
    private String nazwaPunktu;
    @NotEmpty
    private Integer wysokosc;
    @NotEmpty
    private Integer wysokoscGeograficzna;
    @NotEmpty
    private Integer szerokoscGeograficzna;

    public PunktTrasy(){}

    public PunktTrasy(Long id, String nazwaPunktu, Integer wysokosc, Integer wysokoscGeograficzna, Integer szerokoscGeograficzna) {
        this.id = id;
        this.nazwaPunktu = nazwaPunktu;
        this.wysokosc = wysokosc;
        this.wysokoscGeograficzna = wysokoscGeograficzna;
        this.szerokoscGeograficzna = szerokoscGeograficzna;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwaPunktu() {
        return nazwaPunktu;
    }

    public void setNazwaPunktu(String nazwaPunktu) {
        this.nazwaPunktu = nazwaPunktu;
    }

    public Integer getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(Integer wysokosc) {
        this.wysokosc = wysokosc;
    }

    public Integer getWysokoscGeograficzna() {
        return wysokoscGeograficzna;
    }

    public void setWysokoscGeograficzna(Integer wysokoscGeograficzna) {
        this.wysokoscGeograficzna = wysokoscGeograficzna;
    }

    public Integer getSzerokoscGeograficzna() {
        return szerokoscGeograficzna;
    }

    public void setSzerokoscGeograficzna(Integer szerokoscGeograficzna) {
        this.szerokoscGeograficzna = szerokoscGeograficzna;
    }

    @Override
    public boolean equals(Object obj)
    {
        return id.equals(((PunktTrasy)obj).id);
    }
}
