package com.example.cinek.model.uzytkownik;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Turysta.class, name = "Turysta"),
        @JsonSubTypes.Type(value = Przodownik.class, name = "Przodownik")
})
@MappedSuperclass
public abstract class Uzytkownik
{
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String imie;
    @NotEmpty
    private String nazwisko;

    public Long getId()
    {
        return id;
    }

    public String getImie()
    {
        return imie;
    }

    public String getNazwisko()
    {
        return nazwisko;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setImie(String imie)
    {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko)
    {
        this.nazwisko = nazwisko;
    }
}
