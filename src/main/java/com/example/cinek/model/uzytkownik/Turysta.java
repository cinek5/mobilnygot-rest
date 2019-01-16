package com.example.cinek.model.uzytkownik;

import com.example.cinek.model.Wedrowka.Wedrowka;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
public class Turysta extends Uzytkownik
{
    @NotNull
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

    @Override
    public int hashCode()
    {
        return Objects.hashCode(this);
    }
}
