package com.example.cinek.model.trasa;

import com.example.cinek.model.grupa.GrupaGorska;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

/**
 * Created by Cinek on 27.12.2018.
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TrasaPunktowana.class, name = "TrasaPunktowana"),
        @JsonSubTypes.Type(value = TrasaNiepunktowana.class, name = "TrasaNiepunktowana")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typ_trasy")
public abstract class Trasa {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER,mappedBy = "trasa")
    private List<SkladowyPunktTrasy> skladowePunktyTrasy;
    @OneToOne
    @NotNull
    private GrupaGorska grupaGorska;
    @NotNull
    private Integer punktyRegulaminowe;


    public Trasa(){}

    public Trasa(Long id, List<SkladowyPunktTrasy> skladowePunktyTrasy, GrupaGorska grupaGorska, Integer punktyRegulaminowe) {
        this.id = id;
        this.skladowePunktyTrasy = skladowePunktyTrasy;
        this.grupaGorska = grupaGorska;
        this.punktyRegulaminowe = punktyRegulaminowe;
    }

    public abstract int getGetPointsCount();

    public List<SkladowyPunktTrasy> getSkladowePunktyTrasy() {
        return skladowePunktyTrasy;
    }

    public void setSkladowePunktyTrasy(List<SkladowyPunktTrasy> skladowePunktyTrasy) {
        this.skladowePunktyTrasy = skladowePunktyTrasy;
    }

    public GrupaGorska getGrupaGorska() {
        return grupaGorska;
    }

    public void setGrupaGorska(GrupaGorska grupaGorska) {
        this.grupaGorska = grupaGorska;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj)
    {
        return id.equals(((Trasa)obj).id);
    }

    public void setPunktyRegulaminowe(Integer punktyRegulaminowe)
    {
        this.punktyRegulaminowe = punktyRegulaminowe;
    }

    public Integer getPunktyRegulaminowe()
    {
        return punktyRegulaminowe;
    }
}
