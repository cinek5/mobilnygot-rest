package com.example.cinek.utils;

import com.example.cinek.model.trasa.PunktTrasy;

import static java.lang.Math.round;

/**
 * Created by Cinek on 13.01.2019.
 */
public class DistanceCalcultor {

    public static float calculateDistanceInKm(PunktTrasy punktTrasy1, PunktTrasy punktTrasy2) {
        float Rk = 6373; // mean radius of the earth (km) at 39 degrees from the equator

        float t1 = punktTrasy1.getSzerokoscGeograficzna();
        float n1 = punktTrasy1.getWysokoscGeograficzna();
        float t2 = punktTrasy2.getSzerokoscGeograficzna();
        float n2 = punktTrasy2.getWysokoscGeograficzna();

        // convert coordinates to radians
        float lat1 = degToRad(t1);
        float lon1 = degToRad(n1);
        float lat2 = degToRad(t2);
        float lon2 = degToRad(n2);

        // find the differences between the coordinates
        float dlat = lat2 - lat1;
        float dlon = lon2 - lon1;

        // here's the heavy lifting
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)); // great circle distance in radians
        double dk = c * Rk; // great circle distance in km

        // round the results down to the nearest 1/1000

        // display the result
        return (float)dk;
    }

    private static float degToRad(float deg) {
        float rad = (float) (deg * Math.PI / 180);
        return rad;
    }
}
