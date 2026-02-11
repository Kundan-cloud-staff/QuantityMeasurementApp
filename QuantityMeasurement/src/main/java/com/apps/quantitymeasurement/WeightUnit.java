package com.apps.quantitymeasurement;

import java.util.Optional;

public enum WeightUnit {

    //conversion factor to base unit gram
    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);
    //MILLIGRAM(0.001),
    //TONNE(1_000_000.0);

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

    public static void main(String[] args) {
        double kilograms = 1.0;
        double grams = WeightUnit.GRAM.convertToBaseUnitKG(kilograms);
        System.out.println(kilograms+ " kilogram is " + grams + "grams");

        QuantityWeight quantityWeight = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight quantityWeight1 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        boolean flag = quantityWeight.equals(quantityWeight1);
        System.out.println(flag);
        double ponds = WeightUnit.POUND.convertToBaseUnitKG(kilograms);
        System.out.println(kilograms+ " kilogram is " + ponds + "lb");
    }
}
