package com.example.cinek.model.uzytkownik;

import com.example.cinek.model.Wedrowka.Wedrowka;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Turysta extends Uzytkownik
{
    @NotEmpty
    private Integer zgromadzonePunkty;
    @OneToMany(mappedBy = "turysta", cascade = CascadeType.ALL)
    private List<Wedrowka> wedrowki;

    public Integer getZgromadzonePunkty()
    {
        return zgromadzonePunkty;
    }

    public void setZgromadzonePunkty(Integer zgromadzonePunkty)
    {
        this.zgromadzonePunkty = zgromadzonePunkty;
    }

    public List<Wedrowka> getWedrowki()
    {
        return wedrowki;
    }
    @Override
    public boolean equals(Object obj)
    {
        return getId().equals(((Turysta)obj).getId());
    }


    public void setWedrowki(List<Wedrowka> wedrowki)
    {
        this.wedrowki = wedrowki;
    }
}
