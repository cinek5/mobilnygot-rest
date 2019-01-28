package com.example.cinek.utils;


import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class GeolocationDecimalToDegreesConverterTest
{
    private final float DELTA = 0.00001f;

    @Test
    public void decimalToDMSForPositiveNumbers()
    {
        String dms1 = GeolocationDecimalToDegreesConverter.decimalToDMS(10, 10);
        String dms2 = GeolocationDecimalToDegreesConverter.decimalToDMS(20.2f, 54.1f);

        assertEquals("10°00'00'' N 10°00'00'' E", dms1);
        assertEquals("20°12'00'' N 54°05'59'' E", dms2);
    }

    @Test
    public void decimalToDMSForNegativeNumbers()
    {
        String dms1 = GeolocationDecimalToDegreesConverter.decimalToDMS(-10, -10);
        String dms2 = GeolocationDecimalToDegreesConverter.decimalToDMS(-20.2f, -54.1f);

        assertEquals("10°00'00'' S 10°00'00'' W", dms1);
        assertEquals("20°12'00'' S 54°05'59'' W", dms2);
    }

    @Test
    public void decimalToDMSFor0()
    {
        String dms1 = GeolocationDecimalToDegreesConverter.decimalToDMS(0, 0);

        assertEquals("00°00'00'' N 00°00'00'' E", dms1);
    }

    @Test
    public void decimalToDMSForMax()
    {
        String dms1 = GeolocationDecimalToDegreesConverter.decimalToDMS(90, 180);

        assertEquals("90°00'00'' N 180°00'00'' E", dms1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decimalToDMSForInvalidLongitudePlus()
    {
        GeolocationDecimalToDegreesConverter.decimalToDMS(90.0001f, 50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decimalToDMSForInvalidLongitudeMinus()
    {
        GeolocationDecimalToDegreesConverter.decimalToDMS(-90.0001f, 50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decimalToDMSForInvalidLatitudePlus()
    {
        GeolocationDecimalToDegreesConverter.decimalToDMS(25, 180.0001f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decimalToDMSForInvalidLatitudeMinus()
    {
        GeolocationDecimalToDegreesConverter.decimalToDMS(25, -180.0001f);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void dmsToDecimalForPositiveSphere()
    {
        float decimalN = GeolocationDecimalToDegreesConverter.
                dmsToDecimal(10, 0, 0, "N");
        float decimalE = GeolocationDecimalToDegreesConverter
                .dmsToDecimal(20, 12, 0, "E");

        assertEquals(10f, decimalN, DELTA);
        assertEquals(20.2f, decimalE, DELTA);
    }

    @Test
    public void dmsToDecimalForNegativeSphere()
    {
        float decimalS = GeolocationDecimalToDegreesConverter.
                dmsToDecimal(10, 0, 0, "S");
        float decimalW = GeolocationDecimalToDegreesConverter
                .dmsToDecimal(20, 12, 0, "W");

        assertEquals(-10f, decimalS, DELTA);
        assertEquals(-20.2f, decimalW, DELTA);
    }

    @Test
    public void dmsToDecimalFor0()
    {
        float decimalS = GeolocationDecimalToDegreesConverter.
                dmsToDecimal(0, 0, 0, "S");
        float decimalN = GeolocationDecimalToDegreesConverter.
                dmsToDecimal(0, 0, 0, "N");

        assertEquals(0, decimalS, DELTA);
        assertEquals(0, decimalN, DELTA);
    }

    @Test
    public void dmsToDecimalForMax()
    {
        float decimalN = GeolocationDecimalToDegreesConverter.
                dmsToDecimal(90, 0, 0, "N");
        float decimalE = GeolocationDecimalToDegreesConverter.
                dmsToDecimal(180, 0, 0, "E");
        float decimalS = GeolocationDecimalToDegreesConverter.
                dmsToDecimal(90, 0, 0, "S");
        float decimalW = GeolocationDecimalToDegreesConverter.
                dmsToDecimal(180, 0, 0, "W");

        assertEquals(90, decimalN, DELTA);
        assertEquals(180, decimalE, DELTA);
        assertEquals(-90, decimalS, DELTA);
        assertEquals(-180, decimalW, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dmsToDecimalForTooLargeDegreesLongitude()
    {
        GeolocationDecimalToDegreesConverter.dmsToDecimal(91, 0, 0, "N");
    }

    @Test(expected = IllegalArgumentException.class)
    public void dmsToDecimalForTooLargeDegreesLatitude()
    {
        GeolocationDecimalToDegreesConverter.dmsToDecimal(181, 0, 0, "E");
    }

    @Test(expected = IllegalArgumentException.class)
    public void dmsToDecimalForMaxLongitudeDegreesAndSomeMinutes()
    {
        GeolocationDecimalToDegreesConverter.dmsToDecimal(90, 1, 0, "N");
    }

    @Test(expected = IllegalArgumentException.class)
    public void dmsToDecimalForMaxLongitudeDegreesAndSomeSeconds()
    {
        GeolocationDecimalToDegreesConverter.dmsToDecimal(90, 1, 0, "N");
    }

    @Test(expected = IllegalArgumentException.class)
    public void dmsToDecimalForMaxLatitudeDegreesAndSomeMinutes()
    {
        GeolocationDecimalToDegreesConverter.dmsToDecimal(180, 1, 0, "E");
    }

    @Test(expected = IllegalArgumentException.class)
    public void dmsToDecimalForMaxLatitudeDegreesAndSomeSeconds()
    {
        GeolocationDecimalToDegreesConverter.dmsToDecimal(180, 0, 1, "E");
    }

    @Test(expected = IllegalArgumentException.class)
    public void dmsToDecimalForNegativeDegrees()
    {
        GeolocationDecimalToDegreesConverter.dmsToDecimal(-1, 0, 0, "S");
    }

    @Test(expected = IllegalArgumentException.class)
    public void dmsToDecimalForNegativeMinutes()
    {
        GeolocationDecimalToDegreesConverter.dmsToDecimal(0, -1, 0, "S");
    }

    @Test(expected = IllegalArgumentException.class)
    public void dmsToDecimalForNegativeSeconds()
    {
        GeolocationDecimalToDegreesConverter.dmsToDecimal(0, 0, -1, "S");
    }

    @Test(expected = IllegalArgumentException.class)
    public void dmsToDecimalForInvalidHemisphere()
    {
        GeolocationDecimalToDegreesConverter.dmsToDecimal(0, 0, 0, "A");
    }
}
