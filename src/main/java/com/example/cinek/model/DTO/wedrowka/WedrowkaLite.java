package com.example.cinek.model.DTO.wedrowka;


import java.util.ArrayList;
import java.util.List;

public class WedrowkaLite {
    private String nazwa;
    private List<TrasaSkladowaLite> trasySkladowe;


    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<TrasaSkladowaLite> getTrasySkladowe() {
        return trasySkladowe;
    }

    public void setTrasySkladowe(List<TrasaSkladowaLite> trasySkladowe) {
        this.trasySkladowe = trasySkladowe;
    }


    public float calcDistanceSum()
    {
        float sum = 0;
        for (TrasaSkladowaLite trasaSkladowaLite : trasySkladowe)
        {
            sum += trasaSkladowaLite.getTrasaPunktowanaLite().getDistance();
        }
        return sum;
    }
    public int calcPtsSum()
    {
        int sum = 0;
        for (TrasaSkladowaLite trasaSkladowaLite : trasySkladowe)
        {
            sum += trasaSkladowaLite.getTrasaPunktowanaLite().getLiczbaPunktow();
        }
        return sum;
    }
    private void addTrasaSkladowa(TrasaSkladowaLite trasaSkladowaLite)
    {
        this.trasySkladowe.add(trasaSkladowaLite);
    }
    public void addTrasa(TrasaPunktowanaLite trasaPunktowanaLite)
    {
        TrasaSkladowaLite trasaSkladowaLite = new TrasaSkladowaLite(trasaPunktowanaLite, this.trasySkladowe.size());
        addTrasaSkladowa(trasaSkladowaLite);
    }

}
