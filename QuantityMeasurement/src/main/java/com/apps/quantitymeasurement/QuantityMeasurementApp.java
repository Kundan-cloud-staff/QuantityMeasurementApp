/**
 * QuantityMeasurementApp -UC1: Feet measurement equality
 *
 * This class is responsible for checking the equality of two numerical values
 * measured in feet in the Quantity Measurement Application.
 */

package com.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityMeasurementApp {

   /* public static boolean demonstarateLengthEquality(QuantityLength length1, QuantityLength length2){
        boolean result = length1.compare(length2);
        System.out.println("LengthEquality:: "+result);
        return result;
    }

    public static boolean demonstarateFeetEquality(){
        QuantityLength lengthFeet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength lengthInches = new QuantityLength(1.0, LengthUnit.FEET);
        boolean result = lengthFeet.equals(lengthInches);
        System.out.println("FeetEquality:: "+result);
        return result;
    }

    public static boolean demonstarateInchesEquality(){
        QuantityLength lengthFeet = new QuantityLength(18.0, LengthUnit.INCHES);
        QuantityLength lengthInches = new QuantityLength(18.0, LengthUnit.INCHES);
        boolean result = lengthFeet.equals(lengthInches);
        System.out.println("InchesEquality:: "+result);
        return result;
    }

    public static boolean demonstarateFeetInchesComparision() {
        QuantityLength lengthFeet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength lengthInches = new QuantityLength(13.0, LengthUnit.INCHES);
        boolean result = lengthFeet.equals(lengthInches);
        System.out.println("Feet-Inches Comparision:: "+result);
        return result;

    }
    public static boolean demonstarateFeetInEquality(){
        QuantityLength lengthFeet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength lengthInches = new QuantityLength(2.0, LengthUnit.FEET);
        boolean result = lengthFeet.equals(lengthInches);
        System.out.println("Feet InEquality:: "+result);
        return result;
    }

    public static boolean demonstarateCrossUnitInEquality(){
        QuantityLength lengthFeet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength lengthInches = new QuantityLength(18.0, LengthUnit.INCHES);
        boolean result = lengthFeet.equals(lengthInches);
        System.out.println("Cross Unit InEquality:: "+result);
        return result;
    }

    public static boolean demonstarateMultipleFeetComparision(){
        QuantityLength lengthFeet = new QuantityLength(2.0, LengthUnit.FEET);
        QuantityLength lengthInches = new QuantityLength(2.0, LengthUnit.FEET);
        boolean result = lengthFeet.equals(lengthInches);
        QuantityLength lengthInches1 = new QuantityLength(10.0, LengthUnit.FEET);
        QuantityLength lengthFeet1 = new QuantityLength(10.0, LengthUnit.FEET);
        boolean result1 = lengthFeet.equals(lengthInches);

        if(result && result1){
            System.out.println("MultipleComparision:: " +true);
            return true;
        }
        return false;
    }

    public static boolean demonstarateInchesInEquality(){
        QuantityLength lengthFeet = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength lengthInches = new QuantityLength(10.0, LengthUnit.INCHES);
        boolean result = lengthFeet.equals(lengthInches);
        System.out.println("Inches InEquality:: "+result);
        return result;
    }
*/
    public static boolean demonstarateLengthComparision(QuantityLength length1, QuantityLength length2){
        boolean result = length1.equals(length2);
        System.out.println("demonstarateLengthComparision:: "+result);
        return result;
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

        demonstarateLengthComparision(new QuantityLength(1.0, LengthUnit.FEET),
                new QuantityLength(12.0, LengthUnit.INCHES));

        demonstarateLengthComparision(new QuantityLength(1.0, LengthUnit.YARD),
                new QuantityLength(36.0, LengthUnit.INCHES));

        demonstarateLengthComparision(new QuantityLength(100.0, LengthUnit.CENTIMETERS),
                new QuantityLength(39.3701, LengthUnit.INCHES));

        demonstarateLengthComparision(new QuantityLength(3.0, LengthUnit.FEET),
                new QuantityLength(1.0, LengthUnit.YARD));

        demonstarateLengthComparision(new QuantityLength(30.48, LengthUnit.CENTIMETERS),
                new QuantityLength(1.0, LengthUnit.FEET));
    }
}
