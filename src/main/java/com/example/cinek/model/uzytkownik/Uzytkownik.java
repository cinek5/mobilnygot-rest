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
}
