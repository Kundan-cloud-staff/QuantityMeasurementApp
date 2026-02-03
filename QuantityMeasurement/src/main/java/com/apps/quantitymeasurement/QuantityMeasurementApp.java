/**
 * QuantityMeasurementApp -UC1: Feet measurement equality
 *
 * This class is responsible for checking the equality of two numerical values
 * measured in feet in the Quantity Measurement Application.
 */

package com.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityMeasurementApp {

    public static boolean demonstarateLengthComparision(QuantityLength length1, QuantityLength length2){
        boolean result = length1.equals(length2);
        System.out.println("demonstarateLengthComparision:: "+result);
        return result;
    }

    public static double demonstrateLengthConversion(double value, LengthUnit sourceUnit, LengthUnit targetUnit){
    double convertedValue = QuantityLength.convertToTargetUnit(value,sourceUnit,targetUnit);
    System.out.println(value +" " + sourceUnit + " == " + convertedValue + " " +targetUnit);
     return convertedValue;
    }

    public static void main(String[] args) {
       // QuantityLength lengthFeet = new QuantityLength(1.0, LengthUnit.FEET);
       // QuantityLength lengthInches = new QuantityLength(12.0, LengthUnit.INCHES);
        /*demonstarateLengthEquality(lengthFeet, lengthInches);
        demonstarateFeetEquality();
        demonstarateInchesEquality();
        demonstarateFeetInchesComparision();
        demonstarateFeetInEquality();
        demonstarateInchesInEquality();
        demonstarateMultipleFeetComparision();*/

        /*demonstarateLengthComparision(new QuantityLength(1.0, LengthUnit.FEET),
                new QuantityLength(12.0, LengthUnit.INCHES));

        demonstarateLengthComparision(new QuantityLength(1.0, LengthUnit.YARD),
                new QuantityLength(36.0, LengthUnit.INCHES));

        demonstarateLengthComparision(new QuantityLength(100.0, LengthUnit.CENTIMETERS),
                new QuantityLength(39.3701, LengthUnit.INCHES));

        demonstarateLengthComparision(new QuantityLength(3.0, LengthUnit.FEET),
                new QuantityLength(1.0, LengthUnit.YARD));

        demonstarateLengthComparision(new QuantityLength(30.48, LengthUnit.CENTIMETERS),
                new QuantityLength(1.0, LengthUnit.FEET));*/
        demonstrateLengthConversion(1.0, LengthUnit.FEET,LengthUnit.INCHES);
        demonstrateLengthConversion(3.0, LengthUnit.YARD,LengthUnit.FEET);
        demonstrateLengthConversion(36.0, LengthUnit.INCHES,LengthUnit.YARD);
        demonstrateLengthConversion(1.0, LengthUnit.CENTIMETERS,LengthUnit.INCHES);
        demonstrateLengthConversion(0.0, LengthUnit.FEET,LengthUnit.INCHES);
    }
}
