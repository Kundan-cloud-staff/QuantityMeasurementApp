package com.apps.quantitymeasurement;

import java.util.Objects;
import java.util.Optional;

public class QuantityWeight {

    private final double weightValue;
    private final WeightUnit weightUnit;

    public QuantityWeight(double weightValue, WeightUnit weightUnit) {

        if(Double.isNaN(weightValue) || !Double.isFinite(weightValue)){
            throw new IllegalArgumentException("Value must be numeric and finite");
        }

        Optional.ofNullable(weightValue)
                .orElseThrow(() -> new IllegalArgumentException("Weight Value can not be null"));

        Optional.ofNullable(weightUnit)
                .orElseThrow(() -> new IllegalArgumentException("Weight Unit can not be null"));

        this.weightValue = weightValue;
        this.weightUnit = weightUnit;
    }

    public double getWeightValue() {
        return weightValue;
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        QuantityWeight that = (QuantityWeight) o;
        return Double.compare(Math.round(this.convertToBaseUnitKG()),Math.round(that.convertToBaseUnitKG())) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weightValue, weightUnit);
    }

    @Override
    public String toString() {
        return "QuantityWeight{" +
                "weightValue=" + weightValue +
                ", weightUnit=" + weightUnit +
                '}';
    }

    public double convertToBaseUnitKG() {
        return weightUnit.convertToBaseUnitKG(weightValue);
    }
    public boolean compare(WeightUnit unit) {

        return Double.compare(this.convertToBaseUnitKG(), unit.convertToBaseUnitKG()) ==0 ;
    }

    public static double addQuantityWeightWithFirstOperand(QuantityWeight mainWeight, QuantityWeight otherWeight){

        //validation check
        Optional.ofNullable(mainWeight)
                .orElseThrow(() -> new IllegalArgumentException("QuantityWeight can not be null"));
        Optional.ofNullable(otherWeight)
                .orElseThrow(() -> new IllegalArgumentException("QuantityWeight can not be null"));

        //result in first operand's unit
        double convertedValue = convertToTFirstOperandWeightUnit(otherWeight, mainWeight.weightUnit);
        double sum = mainWeight.weightValue + convertedValue;
        return  Math.round(sum*1000)/1000.0;

    }

    public static double addQuantityWeightWithTargetUnit(QuantityWeight mainWeight, QuantityWeight otherWeight, WeightUnit targetUnit){
        QuantityWeight firstOperandTragetUnitValue =  convertToTargetWeightUnit(mainWeight, targetUnit);
        QuantityWeight SecondOperandTragetUnitValue =  convertToTargetWeightUnit(otherWeight, targetUnit);
        return firstOperandTragetUnitValue.getWeightValue()+SecondOperandTragetUnitValue.getWeightValue();
    }

    // helper method for base unit arithmetic
    private static double convertToTFirstOperandWeightUnit(QuantityWeight otherWeight, WeightUnit weightUnit) {

        double convertedValue = otherWeight.weightValue * otherWeight.weightUnit.getWeightConversionFactor();
        double result = convertedValue/weightUnit.getWeightConversionFactor();
        return  Math.round(result*1000)/1000.0;
    }

    public static QuantityWeight convertToTargetWeightUnit(QuantityWeight mainWeight, WeightUnit targetUnit) {

        //convert to base unit
        double valueInBaseUnit = mainWeight.weightValue * mainWeight.weightUnit.getWeightConversionFactor();

        //convert base unit to target unit
        double result = valueInBaseUnit/targetUnit.getWeightConversionFactor();
        result =  Math.round(result*1000)/1000.0;

        return new QuantityWeight(result,targetUnit);
    }
}
