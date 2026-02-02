package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_YardToYard_SameValue(){
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                        new QuantityLength(1.0, LengthUnit.YARD),
                new QuantityLength(1.0, LengthUnit.YARD));
        Assertions.assertTrue(result);
    }

    @Test
    public void testEquality_YardToYard_DifferentValue(){
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                        new QuantityLength(1.0, LengthUnit.YARD),
                new QuantityLength(2.0, LengthUnit.YARD));
        Assertions.assertFalse(result);
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue(){
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                new QuantityLength(1.0, LengthUnit.YARD),
                new QuantityLength(3.0, LengthUnit.FEET));
        Assertions.assertTrue(result);
    }

    @Test
    public void testEquality_FeetToYard_EquivalentValue(){
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                new QuantityLength(3.0, LengthUnit.FEET),
                new QuantityLength(1.0, LengthUnit.YARD));
        Assertions.assertTrue(result);
        }

    @Test
    public void testEquality_YardToInches_EquivalentValue(){
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                new QuantityLength(1.0, LengthUnit.YARD),
                new QuantityLength(36.0, LengthUnit.INCHES));
        Assertions.assertTrue(result);
    }

    @Test
    public void testEquality_InchesToYard_EquivalentValue(){
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                new QuantityLength(36.0, LengthUnit.INCHES),
                new QuantityLength(1.0, LengthUnit.YARD));
        Assertions.assertTrue(result);
    }

    @Test
    public void testEquality_YardToFeet_NonEquivalentValue(){
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                new QuantityLength(1.0, LengthUnit.YARD),
                new QuantityLength(2.0, LengthUnit.FEET));
        Assertions.assertFalse(result);
    }

    @Test
    public void testEquality_centimetersToInches_EquivalentValue(){
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                new QuantityLength(1.0, LengthUnit.CENTIMETERS),
                new QuantityLength(0.393701, LengthUnit.INCHES));
        Assertions.assertTrue(result);
    }

    @Test
    public void testEquality_centimetersToFeet_NonEquivalentValue(){
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                new QuantityLength(1.0, LengthUnit.CENTIMETERS),
                new QuantityLength(1.0, LengthUnit.FEET));
        Assertions.assertFalse(result);
    }

    @Test
    public void testEquality_MultiUnit_TransitiveProperty(){
        boolean resultA = QuantityMeasurementApp.demonstarateLengthComparision(
                new QuantityLength(1.0, LengthUnit.YARD),
                new QuantityLength(3.0, LengthUnit.FEET));

        boolean resultB = QuantityMeasurementApp.demonstarateLengthComparision(
                new QuantityLength(3.0, LengthUnit.FEET),
                new QuantityLength(36.0, LengthUnit.INCHES));

        boolean resultC = QuantityMeasurementApp.demonstarateLengthComparision(
                new QuantityLength(1.0, LengthUnit.YARD),
                new QuantityLength(36.0, LengthUnit.INCHES));
        Assertions.assertEquals(resultA,resultB);
        Assertions.assertEquals(resultB,resultC);
        Assertions.assertEquals(resultC,resultA);
    }

    @Test
    public void testEquality_YardWithNullUnit(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.demonstarateLengthComparision(
                    new QuantityLength(1.0, null),
                    new QuantityLength(36.0, LengthUnit.INCHES));
        });

    }
    private void throwExceptionMethod() {
        throw new IllegalArgumentException("Invalid argument");
    }

    @Test
    public void testEquality_YardSameReference(){

        QuantityLength quantityLength = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength quantityLengthRef = quantityLength;
        Assertions.assertEquals(quantityLength,quantityLengthRef);
    }

    @Test
    public void testEquality_YardNullComparison(){
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                new QuantityLength(1.0, LengthUnit.YARD),
                null);
        Assertions.assertFalse(result);
    }

    @Test
    public void testEquality_CentimetersWithNullUnit() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.demonstarateLengthComparision(
                    new QuantityLength(100.0, LengthUnit.CENTIMETERS),
                    new QuantityLength(100.0, null));
        });
    }

    @Test
    public void testEquality_CentimetersSameReference(){

        QuantityLength quantityLength = new QuantityLength(100.0, LengthUnit.CENTIMETERS);
        QuantityLength quantityLengthRef = quantityLength;
        Assertions.assertEquals(quantityLength,quantityLengthRef);
    }

    @Test
    public void testEquality_CentimetersNullComparison() {
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                new QuantityLength(1.0, LengthUnit.YARD),
                null);
        Assertions.assertFalse(result);
    }

    @Test
    public void testEquality_AllUnits_ComplexScenario() {
        boolean resultA = QuantityMeasurementApp.demonstarateLengthComparision(
                new QuantityLength(2.0, LengthUnit.YARD),
                new QuantityLength(6.0, LengthUnit.FEET));

        boolean resultB = QuantityMeasurementApp.demonstarateLengthComparision(
                new QuantityLength(6.0, LengthUnit.FEET),
                new QuantityLength(72.0, LengthUnit.INCHES));
        Assertions.assertEquals(resultA,resultB);
    }


}
