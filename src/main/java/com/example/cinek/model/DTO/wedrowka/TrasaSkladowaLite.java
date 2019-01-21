package com.example.cinek.model.DTO.wedrowka;

public class TrasaSkladowaLite {
    private TrasaPunktowanaLite trasaPunktowanaLite;
    private int kolejnosc;


    public TrasaSkladowaLite(TrasaPunktowanaLite trasaPunktowanaLite, int kolejnosc) {
        this.trasaPunktowanaLite = trasaPunktowanaLite;
        this.kolejnosc = kolejnosc;
    }
    public TrasaSkladowaLite() {}

    public TrasaPunktowanaLite getTrasaPunktowanaLite() {
        return trasaPunktowanaLite;
    }

    public void setTrasaPunktowanaLite(TrasaPunktowanaLite trasaPunktowanaLite) {
        this.trasaPunktowanaLite = trasaPunktowanaLite;
    }

    public int getKolejnosc() {
        return kolejnosc;
    }

    public void setKolejnosc(int kolejnosc) {
        this.kolejnosc = kolejnosc;
    }
}
