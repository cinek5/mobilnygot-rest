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
     * @throws IllegalArgumentException for longitude > 90 or latitude > 90
     */
    public static String decimalToDMS(float longitude, float latitude)
    {
        if(Math.abs(longitude) > 90)
            throw new IllegalArgumentException(String.format("Invalid value for longitude: %f", longitude));
        if(Math.abs(latitude) > 180)
            throw new IllegalArgumentException(String.format("Invalid value for latitude: %f", latitude));

        String longSign = longitude >= 0 ? "N" : "S";
        String latSign = latitude >= 0 ? "E" : "W";
        return String.format("%s %s %s %s",
                decimalToDMS(longitude), longSign,
                decimalToDMS(latitude), latSign);
    }

    /**
     * Creates a String with dms coordinate representation.
     * @param coord float coord value
     * @return returns a formatted String (e.g. 79°58'55")
     */
    private static String decimalToDMS(float coord)
    {
        float mod = coord % 1;
        int intPart = (int)coord;
        if (intPart < 0) {
            // Convert number to positive if it's negative.
            intPart *= -1;
        }
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

        return String.format("%02d°%02d'%02d''", degrees, minutes, seconds);
    }

    /**
     * Creates decimal value coordinate from DMS
     *
     * Input: latitude or longitude in the DMS format ( example: 79° 58' 55" W)
     * Return: latitude or longitude in decimal format (float)
     * @param degrees dms degrees value
     * @param minutes dms minutes value
     * @param seconds dms seconds value
     * @param hemisphereMerid one from values {W, E, S, N}
     * @throws IllegalArgumentException for hemisphereMerid not in {W, E, S, N}
     */
    public static float dmsToDecimal(int degrees, int minutes, int seconds,
                                      String hemisphereMerid)
    {
        if(degrees < 0 || minutes < 0 || seconds < 0)
            throw new IllegalArgumentException("One or more values are negative!");

        double sign = 1.0;
        int maxDegrees = 180;

        switch (hemisphereMerid)
        {
            case "W":
                sign = -1.0;
                break;
            case "S":
                sign = -1.0;
                maxDegrees = 90;
                break;
            case "E":
                break;
            case "N":
                maxDegrees = 90;
            break;

                default:
                    throw new IllegalArgumentException("Invalid value for hemisphereMerid." +
                            "Should be one of: {W, E, S, N}.");
        }

        if(degrees > maxDegrees || (degrees == maxDegrees && (minutes > 0 || seconds > 0)))
        {
            throw new IllegalArgumentException
                    (String.format("To large value. Max value is: %d", maxDegrees));
        }

        double latOrLon = sign * (Math.floor(degrees) + Math.floor(minutes)/60.0 + seconds/3600.0);

        return (float)latOrLon;
    }
}

