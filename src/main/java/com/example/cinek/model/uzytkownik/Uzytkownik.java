package com.example.cinek.model.uzytkownik;

import com.example.cinek.model.grupa.GrupaGorska;

public abstract class Uzytkownik
{
    private Long id;
    private String imie;
    private String nazwisko;

    public Long getId()
    {
        return id;
    }

    public String getImie()
    {
        return imie;
    }

    public String getNazwisko()
    {
        return nazwisko;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setImie(String imie)
    {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko)
    {
        this.nazwisko = nazwisko;
    }
}
