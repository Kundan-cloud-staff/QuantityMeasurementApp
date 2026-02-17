package com.apps.quantitymeasurement;

import java.util.Objects;

public class Quantity <U extends IMeasurable> {

    private double value;
    private U unit;

    public Quantity(double value, U unit) {
        if(Double.isNaN(value)){
            throw  new IllegalArgumentException("Value can be numeric");
        }
        if(!Double.isFinite(value)){
            throw  new IllegalArgumentException("Value can be finite");
        }

        if(unit == null){
            throw  new IllegalArgumentException("Unit not not be null");
        }
        this.value = value;
        this.unit = unit;
    }

    public U getUnit() {
        return unit;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "value=" + value +
                ", unit=" + unit +
                ", name=" + this.getUnit().geyUnitName() +
                '}';
    }

    /**
     * convert this Quantity unit to specific target unit
     * <p>This method first converts the current value to the base unit using the
     * convertToBaseUnit method of the current unit, then converts that base value
     * to target unit using convertFromBaseUnit method of target unit</p>
     * @param targetUnit
     * @return converted value in the target unit
     * @throws IllegalArgumentException if the units are incompatible
     */
    public <U extends IMeasurable> double convertTo(U targetUnit) {

        if(unit == null || targetUnit == null){
            throw  new IllegalArgumentException("Source unit or target unit can not be null");
        }
        //convert to base unit
        double valueInBaseUnit = unit.convertToBaseUnit(value);

        //convert base unit to target unit
        double result = targetUnit.convertFromBaseUnit(valueInBaseUnit);
        return  Math.round(result*1000)/1000.0;

    }

    /**
     * Adds this Quantity to another Quantity of the same unit type
     *
     * <p> This method converts both quantities to their base unit, add the values,
     * and then converts the sum back to the unit of this Quantity</p>
     * @param others the other quantity to add
     * @return a new Quantity representing the sum
     * @throws IllegalArgumentException if units are incompatible
     */
    public Quantity<U> add(Quantity<U> others ){

        double baseInValue = unit.convertToBaseUnit(value);
        double convertGivenQuantityToBaseInValue = others.getUnit().convertToBaseUnit(others.getValue());

        double sum = baseInValue + convertGivenQuantityToBaseInValue;

        //convert sum to back to first operand unit
        double requiredUnitSumValue = Math.round(unit.convertFromBaseUnit(sum)*100)/100.0;

        return new Quantity<>(requiredUnitSumValue,unit);
    }

    /**
     * Adds this Quantity to another quantity of the same unit type
     * and return in the specific target
     * @param other
     * @param targetUnit
     * @return
     */
    public Quantity<U> add(Quantity<U> other, U targetUnit){

        //Quantity<U> quantity =  add(other);
        double baseInValue = unit.convertToBaseUnit(value);
        double convertGivenQuantityToBaseInValue = other.getUnit().convertToBaseUnit(other.getValue());

        double sum = baseInValue + convertGivenQuantityToBaseInValue;
        double requiredTargetUnitValue = Math.round(targetUnit.convertFromBaseUnit(sum))*100/100.0;
        return new Quantity<>(requiredTargetUnitValue, targetUnit);

    }

    /*@Override
    public boolean equals(Object o) {
        if (!(o instanceof Quantity<?> quantity)) return false;
        return  Double.compare(unit.convertToBaseUnit(value), quantity.unit.convertToBaseUnit(quantity.value)) ==0;
    }*/

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Quantity<?> quantity = (Quantity<?>) o;
        return Double.compare(unit.convertToBaseUnit(value), quantity.unit.convertToBaseUnit(quantity.value)) ==0;
    }

    public boolean compare(Quantity<?> quantity) {
      return  Double.compare(unit.convertToBaseUnit(value), quantity.unit.convertFromBaseUnit(quantity.value)) ==0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    public static void main(String[] args) {

        //convert and equals method test
        Quantity<LengthUnit> lengthInFeet = new Quantity<>(1.0,LengthUnit.FEET);
        double result = lengthInFeet.convertTo(LengthUnit.INCHES);

        System.out.println(result);
        System.out.println(lengthInFeet.equals(lengthInFeet));
        System.out.println((new Quantity<>(1.0,LengthUnit.FEET).equals(new Quantity<>(12.0,LengthUnit.INCHES))));

        Quantity<LengthUnit> lengthInInches = new Quantity<>(1.0,LengthUnit.INCHES);
        double result1 = lengthInInches.convertTo(LengthUnit.FEET);
        System.out.println(result1);
        System.out.println(new Quantity<>(1.0,WeightUnit.KILOGRAM).equals(new Quantity<>(1000.0,WeightUnit.GRAM)));

        //add quantity based on first operand
        Quantity<LengthUnit> addFirstOperandLengthUnit =  (new Quantity<>(1.0,LengthUnit.FEET)).add(new Quantity<>(12.0,LengthUnit.INCHES));
        System.out.println(addFirstOperandLengthUnit);

        Quantity<WeightUnit> addFirstOperandWeightUnit =  (new Quantity<>(1.0,WeightUnit.KILOGRAM)).add(new Quantity<>(1000.0,WeightUnit.GRAM));
        System.out.println(addFirstOperandWeightUnit);

        //add quantity based on target
        Quantity<LengthUnit> addFirstOperandLengthUnitWithTarget =  (new Quantity<>(1.0,LengthUnit.FEET)).add(new Quantity<>(12.0,LengthUnit.INCHES), LengthUnit.YARD);
        System.out.println(addFirstOperandLengthUnitWithTarget);

        Quantity<WeightUnit> addFirstOperandWeightUnitWithTarget =  (new Quantity<>(1.0,WeightUnit.KILOGRAM)).add(new Quantity<>(1000.0,WeightUnit.GRAM), WeightUnit.GRAM);
        System.out.println(addFirstOperandWeightUnitWithTarget);


        //Input: Quantity(1.0, POUND).add(Quantity(453.592, GRAM), POUND) → Output: Quantity(~2.0, POUND)
        Quantity<WeightUnit> addWeightUnitWithTargetPound = new Quantity<>(1.0,WeightUnit.POUND).add(new Quantity<>(453.592, WeightUnit.GRAM), WeightUnit.POUND);
        System.out.println(addWeightUnitWithTargetPound);

        //Input: Quantity(1.0, POUND).add(Quantity(453.592, GRAM), POUND) → Output: Quantity(~2.0, POUND)
        Quantity<WeightUnit> addFirstOperandWeightUnitPound = new Quantity<>(1.0,WeightUnit.POUND).add(new Quantity<>(1.0, WeightUnit.POUND));
        System.out.println(addFirstOperandWeightUnitPound);
    }
}
