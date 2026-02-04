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

    //UC5 Test cases
    @Test
    public void testConversion_FeetToInches(){
        double convertedValue = QuantityMeasurementApp.demonstrateLengthConversion(
        1.0, LengthUnit.FEET, LengthUnit.INCHES);
        Assertions.assertEquals(12.0, convertedValue);
    }

    @Test
    public void testConversion_InchesToFeet(){
        double convertedValue = QuantityMeasurementApp.demonstrateLengthConversion(
                24.0, LengthUnit.INCHES, LengthUnit.FEET);
        Assertions.assertEquals(2.0, convertedValue);
    }

    @Test
    public void testConversion_YardsToInches(){
        double convertedValue = QuantityMeasurementApp.demonstrateLengthConversion(
                1.0, LengthUnit.YARD, LengthUnit.INCHES);
        Assertions.assertEquals(36.0, convertedValue);
    }

    @Test
    public void testConversion_InchesToYards(){
        double convertedValue = QuantityMeasurementApp.demonstrateLengthConversion(
                72.0, LengthUnit.INCHES,LengthUnit.YARD);
        Assertions.assertEquals(2.0, convertedValue);
    }

    @Test
    public void testConversion_CentimetersToInches(){
        double epsilon = 1e-6;
        double convertedValue = QuantityMeasurementApp.demonstrateLengthConversion(
                2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES);
        Assertions.assertEquals(1.0, convertedValue,epsilon);
    }

    @Test
    public void testConversion_FeatToYard(){
        double convertedValue = QuantityMeasurementApp.demonstrateLengthConversion(
                6.0, LengthUnit.FEET, LengthUnit.YARD);
        Assertions.assertEquals(2.0, convertedValue);
    }

    @Test
    public void testConversion_RoundTrip_PreservesValue(){
        double convertedValue = QuantityMeasurementApp.demonstrateLengthConversion(
                QuantityMeasurementApp.demonstrateLengthConversion(
                6.0, LengthUnit.FEET, LengthUnit.YARD),LengthUnit.YARD, LengthUnit.FEET);
        Assertions.assertEquals(6.0, convertedValue);
    }

    @Test
    public void testConversion_ZeroValue(){
        double convertedValue = QuantityMeasurementApp.demonstrateLengthConversion(
                0.0, LengthUnit.FEET, LengthUnit.INCHES);
        Assertions.assertEquals(0.0, convertedValue);
    }

    @Test
    public void testConversion_NegativeValue(){
        double convertedValue = QuantityMeasurementApp.demonstrateLengthConversion(
                -1.0, LengthUnit.FEET, LengthUnit.INCHES);
        Assertions.assertEquals(-12.0, convertedValue);
    }

    @Test
    public void testConversion_InvalidUnit_Throws(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.demonstrateLengthConversion(
                    1.0, null, LengthUnit.INCHES);
        });
    }

    @Test
    public void testConversion_NaNOrInfinite_Throws(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.demonstrateLengthConversion(
                    Double.NaN, LengthUnit.FEET, LengthUnit.INCHES);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.demonstrateLengthConversion(
                    Double.POSITIVE_INFINITY, LengthUnit.FEET, LengthUnit.INCHES);
        });
    }

    @Test
    public void testUnderflowPrevention(){
        double convertedValue = QuantityMeasurementApp.demonstrateLengthConversion(
                -1.0E-6, LengthUnit.INCHES, LengthUnit.FEET);
        Assertions.assertEquals(0.0, convertedValue);
    }

    @Test
    public void testOverflowPrevention(){
        double convertedValue = QuantityMeasurementApp.demonstrateLengthConversion(
                12000000000.0, LengthUnit.FEET, LengthUnit.FEET);
        Assertions.assertEquals(12000000000.0, convertedValue);
    }

    @Test
    public void testRoundTripConversionAccuracy(){
        double convertedValue =  QuantityMeasurementApp.demonstrateLengthConversion(
                                    QuantityMeasurementApp.demonstrateLengthConversion(
                                        QuantityMeasurementApp.demonstrateLengthConversion(
                        6.0, LengthUnit.FEET, LengthUnit.YARD)
                                            ,LengthUnit.YARD, LengthUnit.INCHES)
                                                , LengthUnit.INCHES, LengthUnit.FEET);
        Assertions.assertEquals(6.0, convertedValue);

    }

    //UC6
    @Test
    public void testAddition_SameUnit_FeetPlusFeet(){
        double sum = QuantityMeasurementApp.addQuantityLength(new QuantityLength(1.0, LengthUnit.FEET),
                new QuantityLength(2.0, LengthUnit.FEET));
        Assertions.assertEquals(3.0, sum);
    }

    @Test
    public void testAddition_SameUnit_InchPlusInch(){
        double sum = QuantityMeasurementApp.addQuantityLength(new QuantityLength(6.0, LengthUnit.INCHES),
                new QuantityLength(6.0, LengthUnit.INCHES));
        Assertions.assertEquals(12.0, sum);
    }

    @Test
    public void testAddition_CrossUnit_FeetPlusInches(){
        double sum = QuantityMeasurementApp.addQuantityLength(new QuantityLength(1.0, LengthUnit.FEET),
                new QuantityLength(12.0, LengthUnit.INCHES));
        Assertions.assertEquals(2.0, sum);
    }

    @Test
    public void testAddition_CrossUnit_InchPlusFeet(){
        double sum = QuantityMeasurementApp.addQuantityLength(new QuantityLength(12.0, LengthUnit.INCHES),
                new QuantityLength(1.0, LengthUnit.FEET));
        Assertions.assertEquals(24.0, sum);
    }

    @Test
    public void testAddition_CrossUnit_YardPlusFeet(){
        double sum = QuantityMeasurementApp.addQuantityLength(new QuantityLength(1.0, LengthUnit.YARD),
                new QuantityLength(3.0, LengthUnit.FEET));
        Assertions.assertEquals(2.0, sum);
    }

    @Test
    public void testAddition_CrossUnit_CentimeterPlusInch(){
        double sum = QuantityMeasurementApp.addQuantityLength(new QuantityLength(2.54, LengthUnit.CENTIMETERS),
                new QuantityLength(1.0, LengthUnit.INCHES));
        Assertions.assertEquals(5.08, sum);
    }

    @Test
    public void testAddition_Commutativity(){
        double sum = QuantityMeasurementApp.addQuantityLength(new QuantityLength(1.0, LengthUnit.FEET),
                new QuantityLength(12.0, LengthUnit.INCHES));

        double sum1 = QuantityMeasurementApp.addQuantityLength(new QuantityLength(12.0, LengthUnit.INCHES),
                new QuantityLength(1.0, LengthUnit.FEET));
        //check equality
        QuantityLength length1 = new QuantityLength(sum, LengthUnit.FEET);
        QuantityLength length2 = new QuantityLength(sum1, LengthUnit.INCHES);
        boolean result = length1.equals(length2);
        Assertions.assertTrue(result);
    }

    @Test
    public void testAddition_WithZero(){
        double sum = QuantityMeasurementApp.addQuantityLength(new QuantityLength(5.0, LengthUnit.FEET),
                new QuantityLength(0.0, LengthUnit.INCHES));
        Assertions.assertEquals(5.0,sum);
    }

    @Test
    public void testAddition_NegativeValues(){
        double sum = QuantityMeasurementApp.addQuantityLength(new QuantityLength(5.0, LengthUnit.FEET),
                new QuantityLength(-2.0, LengthUnit.FEET));
        Assertions.assertEquals(3.0,sum);
    }

    @Test
    public void testAddition_NullSecondOperand(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.addQuantityLength(new QuantityLength(1.0, LengthUnit.FEET),
                            null);
                });

    }

    @Test
    public void testAddition_LargeValues(){
        double sum = QuantityMeasurementApp.addQuantityLength(new QuantityLength(1e6, LengthUnit.FEET),
                new QuantityLength(1e6, LengthUnit.FEET));
        Assertions.assertEquals(2e6,sum);
    }

    @Test
    public void testAddition_SmallValues(){
        double sum = QuantityMeasurementApp.addQuantityLength(new QuantityLength(0.001, LengthUnit.FEET),
                new QuantityLength(0.002, LengthUnit.FEET));
        Assertions.assertEquals(0.003,sum);
    }

    //UC7
    @Test
    public void testAddition_ExplicitTargetUnit_Feet(){
        double sum = QuantityMeasurementApp.addQuantityLengthWithTargetUnit(new QuantityLength(1.0, LengthUnit.FEET),
                new QuantityLength(12.0, LengthUnit.INCHES), LengthUnit.FEET);
        Assertions.assertEquals(2.0,sum);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Inches(){
        double sum = QuantityMeasurementApp.addQuantityLengthWithTargetUnit(new QuantityLength(1.0, LengthUnit.FEET),
                new QuantityLength(12.0, LengthUnit.INCHES), LengthUnit.INCHES);
        Assertions.assertEquals(24.0,sum);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Yards(){
        double sum = QuantityMeasurementApp.addQuantityLengthWithTargetUnit(new QuantityLength(1.0, LengthUnit.FEET),
                new QuantityLength(12.0, LengthUnit.INCHES), LengthUnit.YARD);
        Assertions.assertEquals(0.667,sum);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters(){
        double sum = QuantityMeasurementApp.addQuantityLengthWithTargetUnit(new QuantityLength(1.0, LengthUnit.INCHES),
                new QuantityLength(1.0, LengthUnit.INCHES), LengthUnit.CENTIMETERS);
        Assertions.assertEquals(5.08,sum);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsFirstOperand(){
        double sum = QuantityMeasurementApp.addQuantityLengthWithTargetUnit(new QuantityLength(2.0, LengthUnit.YARD),
                new QuantityLength(3.0, LengthUnit.FEET), LengthUnit.YARD);
        Assertions.assertEquals(3.0,sum);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsSecondOperand(){
        double sum = QuantityMeasurementApp.addQuantityLengthWithTargetUnit(new QuantityLength(2.0, LengthUnit.YARD),
                new QuantityLength(3.0, LengthUnit.FEET), LengthUnit.FEET);
        Assertions.assertEquals(9.0,sum);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Commutativity(){
        double sum = QuantityMeasurementApp.addQuantityLengthWithTargetUnit(new QuantityLength(1.0, LengthUnit.FEET),
                new QuantityLength(12.0, LengthUnit.INCHES), LengthUnit.YARD);

        double sum1 = QuantityMeasurementApp.addQuantityLengthWithTargetUnit(new QuantityLength(12.0, LengthUnit.INCHES),
                new QuantityLength(1.0, LengthUnit.FEET), LengthUnit.YARD);
        Assertions.assertEquals(sum1,sum);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_WithZero(){
        double sum = QuantityMeasurementApp.addQuantityLengthWithTargetUnit(new QuantityLength(5.0, LengthUnit.FEET),
                new QuantityLength(0.0, LengthUnit.INCHES), LengthUnit.YARD);
        Assertions.assertEquals(1.667,sum);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NegativeValues(){
        double sum = QuantityMeasurementApp.addQuantityLengthWithTargetUnit(new QuantityLength(5.0, LengthUnit.FEET),
                new QuantityLength(-2.0, LengthUnit.FEET), LengthUnit.INCHES);
        Assertions.assertEquals(36.0,sum);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NullTargetUnit(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            QuantityMeasurementApp.addQuantityLengthWithTargetUnit(new QuantityLength(1.0, LengthUnit.FEET),
                    new QuantityLength(12.0, LengthUnit.INCHES), null);
        });
    }

    @Test
    public void testAddition_ExplicitTargetUnit_LargeToSmallScale(){
        double sum = QuantityMeasurementApp.addQuantityLengthWithTargetUnit(new QuantityLength(1000.0, LengthUnit.FEET),
                new QuantityLength(500.0, LengthUnit.FEET), LengthUnit.INCHES);
        Assertions.assertEquals(18000.0,sum);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SmallToLargeScale(){
        double sum = QuantityMeasurementApp.addQuantityLengthWithTargetUnit(new QuantityLength(12.0, LengthUnit.INCHES),
                new QuantityLength(12.0, LengthUnit.INCHES), LengthUnit.YARD);
        Assertions.assertEquals(0.667,sum);
    }

    //UC8
    @Test
    public void testLengthUnitEnum_FeetConstant(){
        double result = LengthUnit.FEET.convertToBaseUnit();
        Assertions.assertEquals(1.0,result);
    }

    @Test
    public void testLengthUnitEnum_InchesConstant(){
        double result = LengthUnit.INCHES.convertToBaseUnit();
        Assertions.assertEquals(1.0,result);
    }

    @Test
    public void testLengthUnitEnum_YardsConstant(){
        double result = LengthUnit.YARD.getConversionFactor();
        Assertions.assertEquals(36.0,result);
    }

    @Test
    public void testLengthUnitEnum_CentimetersConstant(){
        double result = LengthUnit.CENTIMETERS.getConversionFactor();
        Assertions.assertEquals(0.393701,result);
    }

    @Test
    public void testConvertToBaseUnit_FeetToFeet(){
        double result = LengthUnit.FEET.convertToBaseUnit(5.0);
        Assertions.assertEquals(60.0,result);
    }

    @Test
    public void testConvertToBaseUnit_InchesToFeet(){
        double result = LengthUnit.INCHES.convertToBaseUnit(12.0);
        Assertions.assertEquals(12.0,result);
    }

    @Test
    public void testConvertToBaseUnit_YardsToFeet(){
        double result = LengthUnit.YARD.convertToBaseUnit(1.0);
        Assertions.assertEquals(36.0,result);
    }

    @Test
    public void testConvertToBaseUnit_CentimetersToFeet(){
        double result = LengthUnit.CENTIMETERS.convertToBaseUnit(30.48);
        Assertions.assertEquals(12.0,result);
    }

}
