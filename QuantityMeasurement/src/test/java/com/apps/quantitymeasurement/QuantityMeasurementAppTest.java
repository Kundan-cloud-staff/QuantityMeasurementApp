package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_YardToYard_SameValue(){
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                        new Quantity<>(1.0, LengthUnit.YARD),
                new Quantity<>(1.0, LengthUnit.YARD));
        Assertions.assertTrue(result);
    }

    @Test
    public void testEquality_YardToYard_DifferentValue(){
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                        new Quantity<>(1.0, LengthUnit.YARD),
                new Quantity<>(2.0, LengthUnit.YARD));
        Assertions.assertFalse(result);
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue(){
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                new Quantity<>(1.0, LengthUnit.YARD),
                new Quantity<>(3.0, LengthUnit.FEET));
        Assertions.assertTrue(result);
    }

    @Test
    public void testEquality_FeetToYard_EquivalentValue(){
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                new Quantity<>(3.0, LengthUnit.FEET),
                new Quantity<>(1.0, LengthUnit.YARD));
        Assertions.assertTrue(result);
        }

    @Test
    public void testEquality_YardToInches_EquivalentValue(){
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                new Quantity<>(1.0, LengthUnit.YARD),
                new Quantity<>(36.0, LengthUnit.INCHES));
        Assertions.assertTrue(result);
    }

    @Test
    public void testEquality_InchesToYard_EquivalentValue(){
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                new Quantity<>(36.0, LengthUnit.INCHES),
                new Quantity<>(1.0, LengthUnit.YARD));
        Assertions.assertTrue(result);
    }

    @Test
    public void testEquality_YardToFeet_NonEquivalentValue(){
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                new Quantity<>(1.0, LengthUnit.YARD),
                new Quantity<>(2.0, LengthUnit.FEET));
        Assertions.assertFalse(result);
    }

    @Test
    public void testEquality_centimetersToInches_EquivalentValue(){
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                new Quantity<>(1.0, LengthUnit.CENTIMETERS),
                new Quantity<>(0.393701, LengthUnit.INCHES));
        Assertions.assertTrue(result);
    }

    @Test
    public void testEquality_centimetersToFeet_NonEquivalentValue(){
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                new Quantity<>(1.0, LengthUnit.CENTIMETERS),
                new Quantity<>(1.0, LengthUnit.FEET));
        Assertions.assertFalse(result);
    }

    @Test
    public void testEquality_MultiUnit_TransitiveProperty(){
        boolean resultA = QuantityMeasurementApp.demonstarateLengthComparision(
                new Quantity<>(1.0, LengthUnit.YARD),
                new Quantity<>(3.0, LengthUnit.FEET));

        boolean resultB = QuantityMeasurementApp.demonstarateLengthComparision(
                new Quantity<>(3.0, LengthUnit.FEET),
                new Quantity<>(36.0, LengthUnit.INCHES));

        boolean resultC = QuantityMeasurementApp.demonstarateLengthComparision(
                new Quantity<>(1.0, LengthUnit.YARD),
                new Quantity<>(36.0, LengthUnit.INCHES));
        Assertions.assertEquals(resultA,resultB);
        Assertions.assertEquals(resultB,resultC);
        Assertions.assertEquals(resultC,resultA);
    }

    @Test
    public void testEquality_YardWithNullUnit(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.demonstarateLengthComparision(
                    new Quantity<>(1.0, null),
                    new Quantity<>(36.0, LengthUnit.INCHES));
        });

    }
    private void throwExceptionMethod() {
        throw new IllegalArgumentException("Invalid argument");
    }

    @Test
    public void testEquality_YardSameReference(){

        Quantity<LengthUnit> quantityLength = new Quantity<>(1.0, LengthUnit.YARD);
        Quantity<LengthUnit> quantityLengthRef = quantityLength;
        Assertions.assertEquals(quantityLength,quantityLengthRef);
    }

    @Test
    public void testEquality_YardNullComparison(){
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                new Quantity<>(1.0, LengthUnit.YARD),
                null);
        Assertions.assertFalse(result);
    }

    @Test
    public void testEquality_CentimetersWithNullUnit() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.demonstarateLengthComparision(
                    new Quantity<>(100.0, LengthUnit.CENTIMETERS),
                    new Quantity<>(100.0, null));
        });
    }

    @Test
    public void testEquality_CentimetersSameReference(){

        Quantity<LengthUnit> quantityLength = new Quantity<>(100.0, LengthUnit.CENTIMETERS);
        Quantity<LengthUnit> quantityLengthRef = quantityLength;
        Assertions.assertEquals(quantityLength,quantityLengthRef);
    }

    @Test
    public void testEquality_CentimetersNullComparison() {
        boolean result = QuantityMeasurementApp.demonstarateLengthComparision(
                new Quantity<>(1.0, LengthUnit.YARD),
                null);
        Assertions.assertFalse(result);
    }

    @Test
    public void testEquality_AllUnits_ComplexScenario() {
        boolean resultA = QuantityMeasurementApp.demonstarateLengthComparision(
                new Quantity<>(2.0, LengthUnit.YARD),
                new Quantity<>(6.0, LengthUnit.FEET));

        boolean resultB = QuantityMeasurementApp.demonstarateLengthComparision(
                new Quantity<>(6.0, LengthUnit.FEET),
                new Quantity<>(72.0, LengthUnit.INCHES));
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

    //UC9
    @Test
    public void testEquality_KilogramToKilogram_SameValue(){
        boolean result = QuantityMeasurementApp.demonstarateWeightEquality(new QuantityWeight(1.0,WeightUnit.KILOGRAM),new QuantityWeight(1.0,WeightUnit.KILOGRAM));
        Assertions.assertTrue(result);
    }

    @Test
    public void testEquality_KilogramToKilogram_DifferentValue(){
        boolean result = QuantityMeasurementApp.demonstarateWeightEquality(new QuantityWeight(1.0,WeightUnit.KILOGRAM),
                new QuantityWeight(2.0,WeightUnit.KILOGRAM));
        Assertions.assertFalse(result);
    }

    @Test
    public void testEquality_KilogramToGram_EquivalentValue(){
        boolean result = QuantityMeasurementApp.demonstarateWeightEquality(new QuantityWeight(1.0,WeightUnit.KILOGRAM),
                new QuantityWeight(1000.0,WeightUnit.GRAM));
        Assertions.assertTrue(result);
    }

    @Test
    public void testEquality_GramToKilogram_EquivalentValue(){
        boolean result = QuantityMeasurementApp.demonstarateWeightEquality(new QuantityWeight(1000.0,WeightUnit.GRAM),
                new QuantityWeight(1.0,WeightUnit.KILOGRAM));
        Assertions.assertTrue(result);
    }

    @Test
    public void testEquality_WeightVsLength_Incompatible(){
        boolean result = QuantityMeasurementApp.incompatibilityCheck(new QuantityWeight(1.0,WeightUnit.KILOGRAM),
                new QuantityLength(1.0,LengthUnit.FEET));
        Assertions.assertFalse(result);
    }

    @Test
    public void testEquality_NullComparison(){
        boolean result = QuantityMeasurementApp.demonstarateWeightEquality(new QuantityWeight(1000.0,WeightUnit.GRAM),
                null);
        Assertions.assertFalse(result);
    }

    @Test
    public void testEquality_SameReference(){
        QuantityWeight quantityWeight = new QuantityWeight(1000.0,WeightUnit.GRAM);
        QuantityWeight copyQuantityWeight = quantityWeight;
        boolean result = QuantityMeasurementApp.demonstarateWeightEquality(quantityWeight,
                copyQuantityWeight);
        Assertions.assertTrue(result);
    }

    @Test
    public void testEquality_NullUnit(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> { QuantityMeasurementApp
                        .demonstarateWeightEquality(new QuantityWeight(1.0,null),
                                new QuantityWeight(1.0,WeightUnit.KILOGRAM));
        });

    }

    @Test
    public void testEquality_TransitiveProperty(){
        boolean result = QuantityMeasurementApp.demonstarateWeightEquality(new QuantityWeight(1.0,WeightUnit.KILOGRAM),
                new QuantityWeight(1000.0,WeightUnit.GRAM))
                && QuantityMeasurementApp.demonstarateWeightEquality(new QuantityWeight(1000.0,WeightUnit.GRAM),
                new QuantityWeight(1.0,WeightUnit.KILOGRAM))
                && QuantityMeasurementApp.demonstarateWeightEquality(new QuantityWeight(1.0,WeightUnit.KILOGRAM),
                new QuantityWeight(1.0,WeightUnit.KILOGRAM));
        Assertions.assertTrue(result);
    }

    @Test
    public void testEquality_ZeroValue(){
        boolean result = QuantityMeasurementApp.demonstarateWeightEquality(new QuantityWeight(0.0,WeightUnit.KILOGRAM),
                new QuantityWeight(0.0,WeightUnit.GRAM));
        Assertions.assertTrue(result);
    }

    @Test
    public void testEquality_NegativeWeight(){
        boolean result = QuantityMeasurementApp.demonstarateWeightEquality(new QuantityWeight(-1.0,WeightUnit.KILOGRAM),
                new QuantityWeight(-1000.0,WeightUnit.GRAM));
        Assertions.assertTrue(result);
    }

    @Test
    public void testEquality_LargeWeightValue(){
        boolean result = QuantityMeasurementApp.demonstarateWeightEquality(new QuantityWeight(-1000000.0,WeightUnit.GRAM),
                new QuantityWeight(-1000.0,WeightUnit.KILOGRAM));
        Assertions.assertTrue(result);
    }

    @Test
    public void testEquality_SmallWeightValue(){
        boolean result = QuantityMeasurementApp.demonstarateWeightEquality(new QuantityWeight(-0.001,WeightUnit.KILOGRAM),
                new QuantityWeight(-1.0,WeightUnit.GRAM));
        Assertions.assertTrue(result);
    }

    @Test
    public void testConversion_PoundToKilogram(){
        QuantityWeight result = QuantityMeasurementApp.demonstrateWeightUnitConversion(new QuantityWeight(2.20462,WeightUnit.POUND),
                WeightUnit.KILOGRAM);
        Assertions.assertEquals(1.0, result.getWeightValue());
    }

    @Test
    public void testConversion_KilogramToPound(){
        QuantityWeight result = QuantityMeasurementApp.demonstrateWeightUnitConversion(new QuantityWeight(1.0,WeightUnit.KILOGRAM),
                WeightUnit.POUND);
        Assertions.assertEquals(2.205, result.getWeightValue());
    }

    @Test
    public void testConversion_SameUnit(){
        QuantityWeight result = QuantityMeasurementApp.demonstrateWeightUnitConversion(new QuantityWeight(5.0,WeightUnit.KILOGRAM),
                WeightUnit.KILOGRAM);
        Assertions.assertEquals(5.0, result.getWeightValue());
    }

    @Test
    public void testConversion_ZeroValueForWeightQuantity(){
        QuantityWeight result = QuantityMeasurementApp.demonstrateWeightUnitConversion(new QuantityWeight(0.0,WeightUnit.KILOGRAM),
                WeightUnit.GRAM);
        Assertions.assertEquals(0.0, result.getWeightValue());
    }

    @Test
    public void testConversion_NegativeValueForWeightQuantity(){
        QuantityWeight result = QuantityMeasurementApp.demonstrateWeightUnitConversion(new QuantityWeight(-1.0,WeightUnit.KILOGRAM),
                WeightUnit.GRAM);
        Assertions.assertEquals(-1000.0, result.getWeightValue());
    }

    @Test
    public void testConversion_RoundTripForWeightQuantity(){
        QuantityWeight result = QuantityMeasurementApp.demonstrateWeightUnitConversion(new QuantityWeight(1.5,WeightUnit.KILOGRAM),
                WeightUnit.KILOGRAM);
        Assertions.assertEquals(1.5, result.getWeightValue());
    }

    @Test
    public void testAddition_SameUnit_KilogramPlusKilogram(){
        double result = QuantityMeasurementApp.addQuantityWeightWithFirstOperand(new QuantityWeight(1.0,WeightUnit.KILOGRAM),
                new QuantityWeight(2.0,WeightUnit.KILOGRAM));
        Assertions.assertEquals(3.0, result);
    }

    @Test
    public void testAddition_CrossUnit_KilogramPlusGram(){
        boolean result = QuantityMeasurementApp.demonstarateWeightEquality(new QuantityWeight(1.0,WeightUnit.KILOGRAM),
                new QuantityWeight(1.0,WeightUnit.KILOGRAM));
        Assertions.assertTrue(result);
    }

    @Test
    public void testLengthUnitEnum_InchesConstantForWeightQuantity(){
        double result = QuantityMeasurementApp.addQuantityWeightWithFirstOperand(new QuantityWeight(1.0,WeightUnit.KILOGRAM),
                new QuantityWeight(2.0,WeightUnit.KILOGRAM));
        Assertions.assertEquals(3.0, result);
    }

    @Test
    public void testAddition_CrossUnit_PoundPlusKilogram(){
        double result = QuantityMeasurementApp.addQuantityWeightWithFirstOperand(new QuantityWeight(2.20462,WeightUnit.POUND),
                new QuantityWeight(1.0,WeightUnit.KILOGRAM));
        Assertions.assertEquals(4.41, result);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Kilogram(){
        double result = QuantityMeasurementApp.addQuantityWeightWithTargetUnit(new QuantityWeight(1.0,WeightUnit.KILOGRAM),
                new QuantityWeight(1000.0,WeightUnit.GRAM), WeightUnit.GRAM);
        Assertions.assertEquals(2000.0, result);
    }

    @Test
    public void testAddition_CommutativityForWeightQuantity(){
        double result = QuantityMeasurementApp.addQuantityWeightWithFirstOperand(
                            new QuantityWeight(1.0,WeightUnit.KILOGRAM),
                            new QuantityWeight(1000.0,WeightUnit.GRAM));
        double result1 = QuantityMeasurementApp.addQuantityWeightWithTargetUnit(new QuantityWeight(1000.0,WeightUnit.GRAM),
                                new QuantityWeight(1.0,WeightUnit.KILOGRAM),WeightUnit.KILOGRAM);
        Assertions.assertEquals(result1, result);
    }

    @Test
    public void testAddition_WithZeroForWeightQuantity(){
        double result = QuantityMeasurementApp.addQuantityWeightWithFirstOperand(new QuantityWeight(5.0,WeightUnit.KILOGRAM),
                new QuantityWeight(0.0,WeightUnit.GRAM));
        Assertions.assertEquals(5.0, result);
    }

    @Test
    public void testAddition_NegativeValuesForWeightQuantity(){
        double result = QuantityMeasurementApp.addQuantityWeightWithFirstOperand(new QuantityWeight(5.0,WeightUnit.KILOGRAM),
                new QuantityWeight(-2000.0,WeightUnit.GRAM));
        Assertions.assertEquals(3.0, result);
    }

    @Test
    public void testAddition_LargeValuesForWeightQuantity(){
        double result = QuantityMeasurementApp.addQuantityWeightWithFirstOperand(new QuantityWeight(1e6,WeightUnit.KILOGRAM),
                new QuantityWeight(1e6,WeightUnit.KILOGRAM));
        Assertions.assertEquals(2e6, result);
    }

    //UC10 Test cases
    @Test
    public void testMeasurableInterface_LengthUnitImplementation(){

        //Verifies that LengthUnit correctly implements IMeasurable interface
        //Test All interface methods are present and functional.

        double baseUnitVal = LengthUnit.FEET.convertToBaseUnit();
        double baseUnitValWithParam = LengthUnit.FEET.convertToBaseUnit(2.0);

        double conversionFactor = LengthUnit.FEET.getConversionFactor();

        double convertFromBaseUnit =LengthUnit.FEET.convertFromBaseUnit(12.0);
        Assertions.assertEquals(1.0, baseUnitVal);
        Assertions.assertEquals(24.0, baseUnitValWithParam);
        Assertions.assertEquals(12.0, conversionFactor);
        Assertions.assertEquals(1.0, convertFromBaseUnit);
    }

    @Test
    public void testMeasurableInterface_WeightUnitImplementation() {

        double baseUnitVal = WeightUnit.KILOGRAM.convertToBaseUnit(2.0);

        double conversionFactor = WeightUnit.GRAM.getConversionFactor();

        double convertFromBaseUnit =WeightUnit.POUND.convertFromBaseUnit(1.0);
        Assertions.assertEquals(2.0, baseUnitVal);
        Assertions.assertEquals(0.001, conversionFactor);
        Assertions.assertEquals(2.2046244201837775, convertFromBaseUnit);
    }

    @Test
    public void testMeasurableInterface_ConsistentBehaviour() {

        double baseUnitVal = WeightUnit.KILOGRAM.convertToBaseUnit(2.0);

        double conversionFactor = LengthUnit.YARD.getConversionFactor();

        double convertFromBaseUnit =WeightUnit.POUND.convertFromBaseUnit(1.0);
        Assertions.assertEquals(2.0, baseUnitVal);
        Assertions.assertEquals(36.0, conversionFactor);
    }

    @Test
    public void testGenericQuantity_LengthOperations_Equality() {

        Quantity<LengthUnit> lengthUnitQuantity = new Quantity<>(1.0, LengthUnit.FEET);

        QuantityLength quantityLength = new QuantityLength(1.0, LengthUnit.FEET);

        Assertions.assertEquals(lengthUnitQuantity.getValue(),quantityLength.getValue());
    }

    @Test
    public void testGenericQuantity_WeightOperations_Equality() {

        Quantity<WeightUnit> weightQuantity = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        QuantityWeight quantityWeight = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        Assertions.assertEquals(weightQuantity.getValue(),quantityWeight.getWeightValue());
    }
    @Test
    public void testGenericQuantity_LengthOperations_Conversion() {

        Quantity<LengthUnit> lengthUnitQuantity = new Quantity<>(1.0, LengthUnit.FEET);
        double quantityInInches = lengthUnitQuantity.convertTo(LengthUnit.INCHES);
        Assertions.assertEquals(12.0,quantityInInches);
    }

    @Test
    public void testGenericQuantity_WeightOperations_Conversion() {

        Quantity<WeightUnit> weightUnitQuantity = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        double quantityInGrams = weightUnitQuantity.convertTo(WeightUnit.GRAM);
        Assertions.assertEquals(1000.0,quantityInGrams);
    }

    @Test
    public void testGenericQuantity_LengthOperations_Addition() {

        Quantity<LengthUnit> lengthUnitQuantity = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> quantity = lengthUnitQuantity.add(new Quantity<>(12.0,LengthUnit.INCHES), LengthUnit.FEET);
        Assertions.assertEquals(2.0,quantity.getValue());
    }
    @Test
    public void testGenericQuantity_WeightOperations_Addition() {

        Quantity<WeightUnit> weightUnitQuantity = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> quantity = weightUnitQuantity.add(new Quantity<>(1000.0,WeightUnit.GRAM), WeightUnit.KILOGRAM);
        Assertions.assertEquals(2.0,quantity.getValue());
    }

    @Test
    public void testCrossCategoryPrevention_LengthVsWeight() {

        Quantity<WeightUnit> weightUnitQuantity = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<LengthUnit> lengthUnitQuantity = new Quantity<>(1.0, LengthUnit.FEET);
        boolean flag = weightUnitQuantity.equals(lengthUnitQuantity);
        Assertions.assertFalse(flag);
    }

    @Test
    public void testCrossCategoryPrevention_CompilerTypeSaftey() {

        //compile-time error
       // Quantity<WeightUnit> weightUnitQuantity = new Quantity<LengthUnit>(1.0, LengthUnit.FEET);

    }

    @Test
    public void testGenericQuantity_ConstractorValidation_NullUnit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Quantity<>(1.0, null);
        });
    }

    @Test
    public void testGenericQuantity_Conversion_AllUnitCombination() {

        Quantity<LengthUnit> lengthUnitQuantity = new Quantity<>(1.0, LengthUnit.FEET);
        Assertions.assertEquals(1.0, lengthUnitQuantity.convertTo(LengthUnit.FEET));
        Assertions.assertEquals(12.0, lengthUnitQuantity.convertTo(LengthUnit.INCHES));
        Assertions.assertEquals(30.48, lengthUnitQuantity.convertTo(LengthUnit.CENTIMETERS));
        Assertions.assertEquals(0.333, lengthUnitQuantity.convertTo(LengthUnit.YARD));

        Quantity<WeightUnit> weightUnitQuantityKG = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Assertions.assertEquals(1.0, weightUnitQuantityKG.convertTo(WeightUnit.KILOGRAM));
        Assertions.assertEquals(1000.0, weightUnitQuantityKG.convertTo(WeightUnit.GRAM));
        Assertions.assertEquals(2.205, weightUnitQuantityKG.convertTo(WeightUnit.POUND));
    }

    //15
    @Test
    public void testGenericQuantity_AdditionAllUnitCombinations() {
        //same and different unit cross categories
        Quantity<LengthUnit> feetUnitCheck = new Quantity<>(1.0, LengthUnit.FEET).add(new Quantity<>(1.0, LengthUnit.FEET));
        Quantity<LengthUnit> inchesUnitCheck = new Quantity<>(12.0, LengthUnit.INCHES).add(new Quantity<>(12.0, LengthUnit.INCHES));
        Quantity<LengthUnit> yardUnitCheck = new Quantity<>(1.0, LengthUnit.YARD).add(new Quantity<>(1.0, LengthUnit.YARD));
        Quantity<LengthUnit> centimeterUnitCheck = new Quantity<>(200.0, LengthUnit.CENTIMETERS).add(new Quantity<>(100.0, LengthUnit.CENTIMETERS));

        Assertions.assertEquals(2.0, feetUnitCheck.getValue());
        Assertions.assertEquals(24.0, inchesUnitCheck.getValue());
        Assertions.assertEquals(2.0, yardUnitCheck.getValue());
        Assertions.assertEquals(300.0, centimeterUnitCheck.getValue());

        Quantity<WeightUnit> kgUnitCheck = new Quantity<>(1.0, WeightUnit.KILOGRAM).add(new Quantity<>(5.0, WeightUnit.KILOGRAM));
        Quantity<WeightUnit> gramUnitCheck = new Quantity<>(100.0, WeightUnit.GRAM).add(new Quantity<>(1000.0, WeightUnit.GRAM));
        Quantity<WeightUnit> poundUnitCheck = new Quantity<>(1.0, WeightUnit.POUND).add(new Quantity<>(10.0, WeightUnit.POUND));

        Assertions.assertEquals(6.0, kgUnitCheck.getValue());
        Assertions.assertEquals(1100.0, gramUnitCheck.getValue());
        Assertions.assertEquals(11.0, poundUnitCheck.getValue());

    }

    @Test
    public void testTypeWildcard_FlexibleSignature() {
        Quantity<?> quantityFeet = new Quantity<IMeasurable>(1.0, LengthUnit.FEET);
        Quantity<?> quantityInches = new Quantity<IMeasurable>(12.0, LengthUnit.INCHES);
        boolean flag = quantityFeet.compare(quantityInches);
        Assertions.assertTrue(flag);

        Quantity<?> quantityKg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<?> quantityGram = new Quantity<>(1000.0, WeightUnit.GRAM);
        boolean flag1 = quantityFeet.compare(quantityInches);
        Assertions.assertTrue(flag1);
    }
}
