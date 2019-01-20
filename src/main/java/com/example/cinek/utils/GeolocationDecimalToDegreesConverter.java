package com.example.cinek.utils;

/**
 * This is a class with static methods to help convert between coordinates formats.
 */
public class GeolocationDecimalToDegreesConverter
{
    /**
     * Creates a String with both coordinates dms representation.
     * @param longitude float longitude value
     * @param latitude float latitude value
     * @return returns a formatted String (e.g. 79°58'55"N 21°36'55"E)
     */
    public static String decimalToDMS(float longitude, float latitude)
    {
        String longSign = longitude > 0 ? "N" : "S";
        String latSign = latitude > 0 ? "E" : "W";
        return String.format("%s %s %s %s",
                decimalToDMS(longitude), longSign,
                decimalToDMS(latitude), latSign);
    }

    /**
     * Creates a String with dms coordinate representation.
     * @param coord float coord value
     * @return returns a formatted String (e.g. 79°58'55")
     */
    public static String decimalToDMS(float coord)
    {
        float mod = coord % 1;
        int intPart = (int)coord;
        int degrees = intPart;

        coord = mod * 60;
        mod = coord % 1;
        intPart = (int)coord;
        if (intPart < 0) {
            // Convert number to positive if it's negative.
            intPart *= -1;
        }

        int minutes = intPart;

        coord = mod * 60;
        intPart = (int)coord;
        if (intPart < 0) {
            // Convert number to positive if it's negative.
            intPart *= -1;
        }

        int seconds = intPart;

        return String.format("%s°%s'%s''", degrees, minutes, seconds);
    }

    /**
     * Creates decimal value coordinate from DMS
     *
     * Input: latitude or longitude in the DMS format ( example: W 79° 58' 55.903")
     * Return: latitude or longitude in decimal format
     * @param hemisphereOuMerid one from values {W,E,S,N}
     * @param degrees dms degrees value
     * @param degrees dms minutes value
     * @param degrees dms seconds value
     */
    public static double DmsToDecimal(String hemisphereOuMerid,
                                      double degrees, double minutes, double seconds)
    {
        double signe = 1.0;

        if((hemisphereOuMerid.equals("W")) || (hemisphereOuMerid.equals("S")))
        {
            signe = -1.0;
        }

        double latOrLon = signe * (Math.floor(degrees) + Math.floor(minutes)/60.0 + seconds/3600.0);

        return latOrLon;
    }
}

