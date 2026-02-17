package com.apps.quantitymeasurement;

import java.util.Optional;

public enum WeightUnit implements IMeasurable {

    //conversion factor to base unit gram
    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);
    //MILLIGRAM(0.001),
    //TONNE(1_000_000.0);
    private static final double EPSILON = 0.01;
    //1e-9
    private final double weightConversionFactor;

    WeightUnit(double weightConversionFactor){
        this.weightConversionFactor = weightConversionFactor;
    }

    @Override
    public String toString() {
        return "WeightUnit{" +
                "weightConversionFactor=" + weightConversionFactor +
                '}';
    }


    public double getWeightConversionFactor() {
        return weightConversionFactor;
    }

    public double convertToBaseUnitKG() {
        return WeightUnit.KILOGRAM.weightConversionFactor;
    }

    public double convertToBaseUnitKG(double value) {
        if(Double.isNaN(value) || !Double.isFinite(value)){
            throw new IllegalArgumentException("value should not be null or infinite");
        }
        return (double) Math.round(value * weightConversionFactor * 1000) /1000.0;
    }

    public double convertFromBaseUnitKG(double baseValue) {
        return (double) Math.round((baseValue / this.weightConversionFactor) * 1000) /1000;
    }

    @Override
    public double getConversionFactor() {
        return weightConversionFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        if(Double.isNaN(value) || !Double.isFinite(value)){
            throw new IllegalArgumentException("value should not be null or infinite");
        }
        //return (double) Math.round(value * weightConversionFactor * 1000) /1000.0;
        return Math.round((value * weightConversionFactor)/ EPSILON) *EPSILON;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / weightConversionFactor;
    }

    @Override
    public String geyUnitName() {
        return this.name();
    }
}
