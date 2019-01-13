package com.example.cinek.model.DTO.wedrowka;


import com.example.cinek.model.trasa.PunktTrasy;

/**
 * Created by Cinek on 13.01.2019.
 */
public class TrasaPunktowanaLite {
    private Long idTrasy;
    private String nazwaTrasy;
    private Integer liczbaPunktow;
    private Float distance;

    private PunktTrasyLite punktPoczatkowy;
    private PunktTrasyLite punktKoncowy;


    public TrasaPunktowanaLite(Long idTrasy, String nazwaTrasy, Integer liczbaPunktow, Float distance, PunktTrasyLite punktPoczatkowy, PunktTrasyLite punktKoncowy) {
        this.idTrasy = idTrasy;
        this.nazwaTrasy = nazwaTrasy;
        this.liczbaPunktow = liczbaPunktow;
        this.distance = distance;
        this.punktPoczatkowy = punktPoczatkowy;
        this.punktKoncowy = punktKoncowy;
    }

    public TrasaPunktowanaLite() {}

    public PunktTrasyLite getPunktPoczatkowy() {
        return punktPoczatkowy;
    }

    public void setPunktPoczatkowy(PunktTrasyLite punktPoczatkowy) {
        this.punktPoczatkowy = punktPoczatkowy;
    }

    public PunktTrasyLite getPunktKoncowy() {
        return punktKoncowy;
    }

    public void setPunktKoncowy(PunktTrasyLite punktKoncowy) {
        this.punktKoncowy = punktKoncowy;
    }

    public Long getIdTrasy() {
        return idTrasy;
    }

    public void setIdTrasy(Long idTrasy) {
        this.idTrasy = idTrasy;
    }

    public String getNazwaTrasy() {
        return nazwaTrasy;
    }

    public void setNazwaTrasy(String nazwaTrasy) {
        this.nazwaTrasy = nazwaTrasy;
    }

    public Integer getLiczbaPunktow() {
        return liczbaPunktow;
    }

    public void setLiczbaPunktow(Integer liczbaPunktow) {
        this.liczbaPunktow = liczbaPunktow;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }


    public static class Builder {
        private Long idTrasy;
        private String nazwaTrasy;
        private Integer liczbaPunktow;
        private Float distance;

        private PunktTrasyLite punktPoczatkowy;
        private PunktTrasyLite punktKoncowy;

        public Builder() {}

        public Builder withIdTrasy(Long idTrasy)
        {
            this.idTrasy = idTrasy;
            return this;
        }

        public Builder withNazwaTrasy(String nazwaTrasy) {
            this.nazwaTrasy = nazwaTrasy;
            return this;
        }

        public Builder withLiczbaPunktow(Integer liczbaPunktow)
        {
            this.liczbaPunktow = liczbaPunktow;
            return this;
        }

        public Builder withDistance(Float distance)
        {
            this.distance = distance;
            return this;
        }
        public Builder withPunktPoczatkowy(PunktTrasyLite punktPoczatkowy)
        {
            this.punktPoczatkowy = punktPoczatkowy;
            return this;
        }

        public Builder withPunktKoncowy(PunktTrasyLite punktKoncowy)
        {
            this.punktKoncowy = punktKoncowy;
            return this;
        }

        public TrasaPunktowanaLite build()
        {
            return new TrasaPunktowanaLite(idTrasy,nazwaTrasy,liczbaPunktow,distance,punktPoczatkowy,punktKoncowy);
        }

    }
}
