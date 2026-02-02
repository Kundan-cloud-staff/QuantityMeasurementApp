package com.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {

        if(Double.isNaN(value)){
            throw new IllegalArgumentException("Value must be numeric");
        }
        if(!Double.isFinite(value)){
            throw  new IllegalArgumentException("Value should be finite");
        }
        this.value = value;
        this.unit = unit;
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
        return Double.compare(this.convertToBaseUnit(),otherLength.convertToBaseUnit()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}
