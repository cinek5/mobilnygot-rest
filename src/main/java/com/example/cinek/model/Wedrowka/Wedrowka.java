package com.example.cinek.model.Wedrowka;

import com.example.cinek.model.uzytkownik.Turysta;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Entity
public class Wedrowka
{
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Turysta turysta;
    @Length(max = 50)
    @NotEmpty
    private String nazwaWedrowki;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat
    private Date dataWedrowki;
    private Integer punktyZaWedrowke;
    @OneToMany(mappedBy = "wedrowka",cascade = CascadeType.ALL)
    private List<TrasaSkladowa> trasySkladowe;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Turysta getTurysta()
    {
        return turysta;
    }

    public void setTurysta(Turysta turysta)
    {
        this.turysta = turysta;
    }

    public String getNazwaWedrowki()
    {
        return nazwaWedrowki;
    }

    public void setNazwaWedrowki(String nazwaWedrowki)
    {
        this.nazwaWedrowki = nazwaWedrowki;
    }

    public Date getDataWedrowki()
    {
        return dataWedrowki;
    }

    public void setDataWedrowki(Date dataWedrowki)
    {
        this.dataWedrowki = dataWedrowki;
    }

    public Integer getPunktyZaWedrowke()
    {
        return punktyZaWedrowke;
    }

    public void setPunktyZaWedrowke(Integer punktyZaWedrowke)
    {
        this.punktyZaWedrowke = punktyZaWedrowke;
    }

    public List<TrasaSkladowa> getTrasySkladowe()
    {
        return trasySkladowe;
    }

    public void setTrasySkladowe(List<TrasaSkladowa> trasySkladowe)
    {
        this.trasySkladowe = trasySkladowe;
    }
}
