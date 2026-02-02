package com.apps.quantitymeasurement;

public enum LengthUnit {

    FEET(12.0),
    INCHES(1.0);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

   /* public double convertToBaseUnit() {
        return LengthUnit.FEET.conversionFactor;
    }*/
   public double convertToBaseUnit(double value) {
       return value * conversionFactor;
   }
}
