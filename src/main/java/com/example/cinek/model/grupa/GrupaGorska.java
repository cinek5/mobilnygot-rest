package com.example.cinek.model.grupa;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Created by Cinek on 27.12.2018.
 */
@Entity
public class GrupaGorska {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Column(unique = true)
    @Length(max = 50)
    private String nazwaGrupy;

    public GrupaGorska(){}

    public GrupaGorska(Long id, String nazwaGrupy) {
        this.id = id;
        this.nazwaGrupy = nazwaGrupy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwaGrupy() {
        return nazwaGrupy;
    }

    public void setNazwaGrupy(String nazwaGrupy) {
        this.nazwaGrupy = nazwaGrupy;
    }

    @Override
    public boolean equals(Object obj)
    {
        return id.equals(((GrupaGorska)obj).id);
    }
}
