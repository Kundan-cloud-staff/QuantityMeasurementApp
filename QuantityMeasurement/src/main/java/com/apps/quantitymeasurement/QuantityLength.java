package com.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    //private static final double EPSILON = 0.0001;

    public QuantityLength(double value, LengthUnit unit) {

        if(Double.isNaN(value)){
            throw new IllegalArgumentException("Value must be numeric");
        }
        if(!Double.isFinite(value)){
            throw  new IllegalArgumentException("Value should be finite");
        }
        if(unit == null){
            throw new IllegalArgumentException("Unit must not be null");
        }
        this.value = value;
        this.unit = unit;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    public double getValue() {
        return value;
    }

    private double convertToBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    public boolean compare(QuantityLength length){
        return Double.compare(this.convertToBaseUnit(), length.convertToBaseUnit()) ==0 ;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        QuantityLength otherLength = (QuantityLength) o;
        return Double.compare(Math.round(this.convertToBaseUnit()),Math.round(otherLength.convertToBaseUnit())) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    @Override
    public String toString() {
        return "QuantityLength{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    //convert length unit to specific target unit

    public static double convertToTargetUnit(double value, LengthUnit sourceUnit,LengthUnit targetUnit){

        //validate
        validate(value, sourceUnit,targetUnit);

        //convert to base unit
        double valueInBaseUnit = value *sourceUnit.getConversionFactor();

        //convert base unit to target unit
        double result = valueInBaseUnit/targetUnit.getConversionFactor();
        return  Math.round(result*1000)/1000.0;

    }
    private static void validate(double value, LengthUnit sourceUnit,LengthUnit targetUnit) {

        if(Double.isNaN(value)){
            throw  new IllegalArgumentException("Value can be numeric");
        }
        if(!Double.isFinite(value)){
            throw  new IllegalArgumentException("Value can be finite");
        }
        if(sourceUnit==null || targetUnit == null){
            throw  new IllegalArgumentException("Source unit or target unit can not be null");
        }
    }

    public static double addQuantityLength(QuantityLength length1, QuantityLength otherLength){

        if(length1 == null || otherLength == null){
            throw new IllegalArgumentException("Length should not be null");
        }
        double convertedValue = convertToTargetUnit(otherLength.value, otherLength.unit, length1.unit);
        double sum = length1.value + convertedValue;
        return  Math.round(sum*1000)/1000.0;

    }
    //UC7: Addition with Target Unit Specification

    public static double addQuantityLengthWithTargetUnit(QuantityLength length1, QuantityLength otherLength,LengthUnit lengthUnit){

        if(length1 == null || otherLength == null || lengthUnit == null) {
            throw new IllegalArgumentException("Length should not be null");
        }
        double sum = addQuantityLength(length1,otherLength);
        return convertToTargetUnit(sum, length1.getUnit(),lengthUnit);

    }

    //UC8: Refactoring Unit Enum to Standalone with Conversion Responsibility

    //UC9: Weight Measurement Equality, Conversion, and Addition (Kilogram, Gram, Pound)
}
