package com.example.cinek.model.trasa;

/**
 * Created by Cinek on 27.12.2018.
 */
public class PunktTrasy {
    private Long id;
    private String nazwaPunktu;
    private Integer wysokosc;
    private Float wysokoscGeograficzna;
    private Float szerokoscGeograficzna;

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
    public boolean equals(Object obj)
    {
        return id.equals(((PunktTrasy)obj).id);
    }
}
