package com.example.cinek.model.Wedrowka;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Pamiatka
{
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    @ManyToOne
    private TrasaSkladowa trasaSkladowa;
    @NotNull
    private Boolean czyDokumentujaca;
    @NotNull
    private Boolean czyPubliczna;
    //@NotEmpty
    @Column(columnDefinition="BLOB")
    private byte [] zdjecie;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public TrasaSkladowa getTrasaSkladowa()
    {
        return trasaSkladowa;
    }

    public void setTrasaSkladowa(TrasaSkladowa trasaSkladowa)
    {
        this.trasaSkladowa = trasaSkladowa;
    }

    public Boolean getCzyDokumentujaca()
    {
        return czyDokumentujaca;
    }

    public void setCzyDokumentujaca(Boolean czyDokumentujaca)
    {
        this.czyDokumentujaca = czyDokumentujaca;
    }

    public Boolean getCzyPubliczna()
    {
        return czyPubliczna;
    }

    public void setCzyPubliczna(Boolean czyPubliczna)
    {
        this.czyPubliczna = czyPubliczna;
    }

    public byte[] getZdjecie()
    {
        return zdjecie;
    }

    public void setZdjecie(byte[] zdjecie)
    {
        this.zdjecie = zdjecie;
    }
}
