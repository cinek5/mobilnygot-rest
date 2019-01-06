package com.example.cinek.model.Wedrowka;

import com.example.cinek.model.trasa.Trasa;
import com.example.cinek.model.uzytkownik.Przodownik;

import javax.persistence.*;
import java.util.List;

@Entity
public class TrasaSkladowa
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Przodownik verifyPrzodownik;
    @ManyToOne(cascade = CascadeType.ALL)
    private Trasa trasa;
    @Convert(converter = StatusToIntConverter.class)
    private Status status;
    @OneToMany(mappedBy = "trasaSkladowa")
    private List<Pamiatka> pamiatki;
    @ManyToOne
    private Wedrowka wedrowka;

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

    public Wedrowka getWedrowka()
    {
        return wedrowka;
    }

    public void setWedrowka(Wedrowka wedrowka)
    {
        this.wedrowka = wedrowka;
    }
}
