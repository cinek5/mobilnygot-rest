package com.example.cinek.utils;

public class GeolocationDecimalToDegreesConverter{
    // Input a double latitude or longitude in the decimal format
    // e.g. -79.982195
    public static String decimalToDMS(float longitude, float latitude)
    {
        String longSign = longitude > 0 ? "N" : "S";
        String latSign = latitude > 0 ? "E" : "W";
        return String.format("%s %s %s %s",
                decimalToDMS(longitude), longSign,
                decimalToDMS(latitude), latSign);
    }

    public static String decimalToDMS(float coord) {
        // gets the modulus the coordinate divided by one (MOD1).
        // in other words gets all the numbers after the decimal point.
        // e.g. mod := -79.982195 % 1 == 0.982195
        //
        // next get the integer part of the coord. On other words the whole number part.
        // e.g. intPart := -79

        float mod = coord % 1;
        int intPart = (int)coord;

        //set degrees to the value of intPart
        //e.g. degrees := "-79"

        int degrees = intPart;

        // next times the MOD1 of degrees by 60 so we can find the integer part for minutes.
        // get the MOD1 of the new coord to find the numbers after the decimal point.
        // e.g. coord :=  0.982195 * 60 == 58.9317
        //	mod   := 58.9317 % 1    == 0.9317
        //
        // next get the value of the integer part of the coord.
        // e.g. intPart := 58

        coord = mod * 60;
        mod = coord % 1;
        intPart = (int)coord;
        if (intPart < 0) {
            // Convert number to positive if it's negative.
            intPart *= -1;
        }

        // set minutes to the value of intPart.
        // e.g. minutes = "58"
        int minutes = intPart;

        //do the same again for minutes
        //e.g. coord := 0.9317 * 60 == 55.902
        //e.g. intPart := 55
        coord = mod * 60;
        intPart = (int)coord;
        if (intPart < 0) {
            // Convert number to positive if it's negative.
            intPart *= -1;
        }

        // set seconds to the value of intPart.
        // e.g. seconds = "55"
        int seconds = intPart;

        // I used this format for android but you can change it
        // to return in whatever format you like
        // e.g. output = "-79/1,58/1,56/1"
        //Standard output of D°M′S″
        //output = degrees + "°" + minutes + "'" + seconds + "\"";
        return String.format("%s°%s'%s''", degrees, minutes, seconds);
    }

    /*
     * Conversion DMS to decimal
     *
     * Input: latitude or longitude in the DMS format ( example: W 79° 58' 55.903")
     * Return: latitude or longitude in decimal format
     * hemisphereOUmeridien => {W,E,S,N}
     *
     */
    public static double DMSToDecimal(String hemisphereOuMeridien,
                                      double degrees, double minutes, double seconds)
    {
        double signe = 1.0;

        if((hemisphereOuMeridien.equals("W")) || (hemisphereOuMeridien.equals("S")))
        {
            signe = -1.0;
        }

        double latOrLon = signe * (Math.floor(degrees) + Math.floor(minutes)/60.0 + seconds/3600.0);

        return latOrLon;
    }
}

