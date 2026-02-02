package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality_SameValue(){
        boolean result = QuantityMeasurementApp.demonstarateFeetEquality();
        Assertions.assertTrue(result);
    }

    @Test
    public void testInchesEquality_SameValue(){
        boolean result = QuantityMeasurementApp.demonstarateInchesEquality();
        Assertions.assertTrue(result);
    }

    @Test
    public void testFeetInchesComparision(){
        boolean result = QuantityMeasurementApp.demonstarateFeetInchesComparision();
        Assertions.assertFalse(result);
    }

    @Test
    public void testFeetInEquality(){
        boolean result = QuantityMeasurementApp.demonstarateFeetInEquality();
        Assertions.assertFalse(result);
        }

    @Test
    public void testInchesInEquality(){
        boolean result = QuantityMeasurementApp.demonstarateFeetInEquality();
        Assertions.assertFalse(result);
    }

    @Test
    public void testCrossUnitInEquality(){
        boolean result = QuantityMeasurementApp.demonstarateCrossUnitInEquality();
        Assertions.assertFalse(result);
    }

    @Test
    public void testMultipleFeetComparision(){
        boolean result = QuantityMeasurementApp.demonstarateMultipleFeetComparision();
        Assertions.assertTrue(result);
    }

}
