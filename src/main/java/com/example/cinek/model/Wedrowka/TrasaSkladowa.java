package com.example.cinek.model.Wedrowka;

import com.example.cinek.model.trasa.Status;
import com.example.cinek.model.trasa.Trasa;
import com.example.cinek.model.uzytkownik.Przodownik;

import java.util.List;

public class TrasaSkladowa
{
    private Long id;
    private Przodownik verifyPrzodownik;
    private Trasa trasa;
    private Status status;
    private List<Pamiatka> pamiatki;

    public Long getId()
    {
        return id;
    }

    public Przodownik getVerifyPrzodownik()
    {
        return verifyPrzodownik;
    }

    public Trasa getTrasa()
    {
        return trasa;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setVerifyPrzodownik(Przodownik verifyPrzodownik)
    {
        this.verifyPrzodownik = verifyPrzodownik;
    }

    public void setTrasa(Trasa trasa)
    {
        this.trasa = trasa;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj)
    {
        return getId().equals(((TrasaSkladowa) obj).getId());
    }

    public List<Pamiatka> getPamiatki()
    {
        return pamiatki;
    }

    public void setPamiatki(List<Pamiatka> pamiatki)
    {
        this.pamiatki = pamiatki;
    }
}
