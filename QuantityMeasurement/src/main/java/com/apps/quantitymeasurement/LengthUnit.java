package com.apps.quantitymeasurement;

public enum LengthUnit implements IMeasurable {

    FEET(12.0),
    INCHES(1.0),
    YARD(36.0),
    CENTIMETERS(0.393701);


    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double convertToBaseUnit() {
        return LengthUnit.INCHES.conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
       return (double) Math.round(value * conversionFactor * 1000) /1000.0;
   }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue/conversionFactor;

    }

    @Override
    public String geyUnitName() {
        return this.name();
    }

    @Override
    public String toString() {
        return "LengthUnit{" +
                "conversionFactor=" + conversionFactor +
                 ",UnitName=" + this.name() +
                '}';
    }
}
