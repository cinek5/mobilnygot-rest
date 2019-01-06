package com.example.cinek.model.uzytkownik;

import com.example.cinek.model.grupa.GrupaGorska;

import javax.persistence.*;
import java.util.List;

@Entity
public class Przodownik extends Uzytkownik
{
    @JoinTable(
            name = "uprawnienia_przodownikow",
            joinColumns = { @JoinColumn(name = "przodownik_id") },
            inverseJoinColumns = { @JoinColumn(name = "GrupaGorska_id") }
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<GrupaGorska> authorizedGrupy;

    public List<GrupaGorska> getAuthorizedGrupy()
    {
        return authorizedGrupy;
    }

    @Override
    public boolean equals(Object obj)
    {
        return getId().equals(((Przodownik)obj).getId());
    }

    public void setAuthorizedGrupy(List<GrupaGorska> authorizedGrupy)
    {
        this.authorizedGrupy = authorizedGrupy;
    }
}
