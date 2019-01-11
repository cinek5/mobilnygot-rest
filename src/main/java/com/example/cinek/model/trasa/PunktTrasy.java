package com.example.cinek.model.trasa;

import com.example.cinek.model.grupa.GrupaGorska;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by Cinek on 27.12.2018.
 */
@Entity
public class PunktTrasy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Length(max = 50)
    private String nazwaPunktu;
    @NotNull
    private Integer wysokosc;
    @NotNull
    private Float wysokoscGeograficzna;
    @NotNull
    private Float szerokoscGeograficzna;
    @OneToOne
    @NotNull
    private GrupaGorska grupaGorska;

    public PunktTrasy(){}

    public PunktTrasy(Long id, String nazwaPunktu, Integer wysokosc, Float wysokoscGeograficzna, Float szerokoscGeograficzna) {
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

    public Float getWysokoscGeograficzna() {
        return wysokoscGeograficzna;
    }

    public void setWysokoscGeograficzna(Float wysokoscGeograficzna) {
        this.wysokoscGeograficzna = wysokoscGeograficzna;
    }

    public Float getSzerokoscGeograficzna() {
        return szerokoscGeograficzna;
    }

    public void setSzerokoscGeograficzna(Float szerokoscGeograficzna) {
        this.szerokoscGeograficzna = szerokoscGeograficzna;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nazwaPunktu.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PunktTrasy)) return false;

        PunktTrasy that = (PunktTrasy) o;

        if (!id.equals(that.id)) return false;
        return nazwaPunktu.equals(that.nazwaPunktu);
    }

    public GrupaGorska getGrupaGorska()
    {
        return grupaGorska;
    }

    public void setGrupaGorska(GrupaGorska grupaGorska)
    {
        this.grupaGorska = grupaGorska;
    }
}
