package com.apps.quantitymeasurement;

public enum LengthUnit {

    FEET(12.0),
    INCHES(1.0),
    YARD(36.0),
    CENTIMETERS(0.393701);


    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public String toString() {
        return "LengthUnit{" +
                "conversionFactor=" + conversionFactor +
                '}';
    }

    public double convertToBaseUnit() {
        return LengthUnit.INCHES.conversionFactor;
    }
   public double convertToBaseUnit(double value) {
       return (double) Math.round(value * conversionFactor * 1000) /1000;
   }

}
