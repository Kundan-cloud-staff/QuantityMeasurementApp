package com.apps.quantitymeasurement;

public interface IMeasurable {

    /**
     * returns conversion factor relative to base unit
     * @return the conversion factor to base unit
     */
    public double getConversionFactor();

    //converts value to base unit
    public double convertToBaseUnit(double value);

    //converts from base unit to this unit
    public double convertFromBaseUnit(double baseValue);

    //returns readable unit name
    public String geyUnitName();


}
