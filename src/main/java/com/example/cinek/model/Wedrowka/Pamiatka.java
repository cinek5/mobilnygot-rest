package com.example.cinek.model.Wedrowka;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Pamiatka
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @ManyToOne
    private TrasaSkladowa trasaSkladowa;
    @NotEmpty
    private Boolean czyDokumentujaca;
    @NotEmpty
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
}
