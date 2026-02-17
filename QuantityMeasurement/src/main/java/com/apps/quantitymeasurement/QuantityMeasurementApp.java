/**
 * QuantityMeasurementApp -UC1: Feet measurement equality
 *
 * This class is responsible for checking the equality of two numerical values
 * measured in feet in the Quantity Measurement Application.
 */

package com.apps.quantitymeasurement;

import javax.swing.*;
import java.util.Objects;

public class QuantityMeasurementApp {

    public static boolean demonstarateLengthComparision(Quantity<LengthUnit> length1, Quantity<LengthUnit> length2){
        boolean result = length1.equals(length2);
        System.out.println("demonstarateLengthComparision:: "+result);
        return result;
    }

    public static double demonstrateLengthConversion(double value, LengthUnit sourceUnit, LengthUnit targetUnit){
    double convertedValue = QuantityLength.convertToTargetUnit(value,sourceUnit,targetUnit);
    System.out.println(value +" " + sourceUnit + " == " + convertedValue + " " +targetUnit);
     return convertedValue;
    }
    public static double addQuantityLength(QuantityLength sourceLength, QuantityLength otherLength){
        double  sumOfQuantityLengths = QuantityLength.addQuantityLength(sourceLength,otherLength);
        System.out.println("sumOfQuantityLengths" + sourceLength + "and "+ otherLength + " == " +sumOfQuantityLengths +""+sourceLength.getUnit());
        return sumOfQuantityLengths;
    }

    public static double addQuantityLengthWithTargetUnit(QuantityLength sourceLength, QuantityLength otherLength,LengthUnit targetUnit){
        double result = QuantityLength.addQuantityLengthWithTargetUnit(sourceLength,otherLength,targetUnit);
        System.out.println("sumOfQuantityLengthsWithTargetUnit" + sourceLength + "and "+ otherLength + "with traget Unit" + targetUnit +"== " +result +""+targetUnit);
        return result;
    }
    //UC9
    public static boolean demonstarateWeightEquality(QuantityWeight weight1, QuantityWeight weight2){
        boolean result = weight1.equals(weight2);
        if(weight1 != null && weight2 != null) {
            System.out.println("demonstarateWeightEquality::" + weight1.getWeightValue() + " " + weight1.getWeightUnit().name() + " == " + weight2.getWeightValue() + " " + weight2.getWeightUnit().name() + "-->" + result);
        }
        return result;
    }
    public static QuantityWeight demonstrateWeightUnitConversion(QuantityWeight sourceQuantity, WeightUnit targetUnit){
        QuantityWeight result = QuantityWeight.convertToTargetWeightUnit(sourceQuantity,targetUnit);
        System.out.println("demonstrateWeightUnitConversion:: "+result.getWeightValue() +" "+result.getWeightUnit().name());
        return result;
    }

    public static double addQuantityWeightWithFirstOperand(QuantityWeight mainWeight, QuantityWeight otherWeight){
        double sum = QuantityWeight.addQuantityWeightWithFirstOperand(mainWeight, otherWeight);
        System.out.println("Sum of two Qunatity Weight :: "+sum +" "+mainWeight.getWeightUnit().name());
        return sum;
    }

    public static double addQuantityWeightWithTargetUnit(QuantityWeight mainWeight, QuantityWeight otherWeight, WeightUnit targetUnit){
        double sum = QuantityWeight.addQuantityWeightWithTargetUnit(mainWeight, otherWeight, targetUnit);
        System.out.println("Sum of two Qunatity Weight :: "+sum +" "+targetUnit.name());
        return sum;
    }

    public static boolean incompatibilityCheck(QuantityWeight quantityWeight, QuantityLength quantityLength){
        boolean result = quantityWeight.equals(quantityLength);
        System.out.println("demonstarateLengthComparision:: "+result);
        return result;
    }

    //UC10

    /**
     * Demonstrate Equality Comparison between two quantities
     * @param quantity1
     * @param quantity2
     * @return
     * @param <U>
     */
    public static <U extends IMeasurable> boolean demonstrateEquality(Quantity<U> quantity1, Quantity<U> quantity2){

        boolean flag = quantity1.equals(quantity2);
        System.out.println(quantity1 +"And "+quantity2 +"is "+flag);
        return flag;
    }

    /**
     * Demonstrate conversion of a qunatity to a target unit
     * @param quantity
     * @param targetUnit
     * @return
     * @param <U>
     */
    public static <U extends IMeasurable> Quantity<U> demonstrateConversion(Quantity<U> quantity, U targetUnit){

        double targetUnitValue = quantity.convertTo(targetUnit);

        Quantity<U> requiredQuantity = new Quantity<>(targetUnitValue, targetUnit);
        System.out.println(requiredQuantity);
        return requiredQuantity;

    }

    /**
     * Demonstrate addition of two quantity and return the result in the unit of the first quantity
     * @param quantity1
     * @param quantity2
     * @return
     * @param <U>
     */
    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(Quantity<U> quantity1, Quantity<U> quantity2) {

        Quantity<U> additionOfTwoQuantity =  quantity1.add(quantity2);
        System.out.println(additionOfTwoQuantity);
        return  additionOfTwoQuantity;
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(Quantity<U> quantity1, Quantity<U> quantity2, U targetUnit) {

        Quantity<U> additionOfTwoQuantity =  quantity1.add(quantity2, targetUnit);
        System.out.println(additionOfTwoQuantity);
        return  additionOfTwoQuantity;
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
       /**
        demonstrateLengthConversion(1.0, LengthUnit.FEET,LengthUnit.INCHES);
        demonstrateLengthConversion(3.0, LengthUnit.YARD,LengthUnit.FEET);
        demonstrateLengthConversion(36.0, LengthUnit.INCHES,LengthUnit.YARD);
        demonstrateLengthConversion(1.0, LengthUnit.CENTIMETERS,LengthUnit.INCHES);
        demonstrateLengthConversion(0.0, LengthUnit.FEET,LengthUnit.INCHES);

        //UC6

        addQuantityLength(new QuantityLength(1.0, LengthUnit.FEET),new QuantityLength(2.0, LengthUnit.FEET));
        addQuantityLength(new QuantityLength(1.0, LengthUnit.FEET),new QuantityLength(12.0, LengthUnit.INCHES));
        addQuantityLength(new QuantityLength(12.0, LengthUnit.INCHES),new QuantityLength(1.0, LengthUnit.FEET));
        addQuantityLength(new QuantityLength(1.0, LengthUnit.YARD),new QuantityLength(3.0, LengthUnit.FEET));
        addQuantityLength(new QuantityLength(36.0, LengthUnit.INCHES),new QuantityLength(1.0, LengthUnit.YARD));
        addQuantityLength(new QuantityLength(2.54, LengthUnit.CENTIMETERS),new QuantityLength(1.0, LengthUnit.INCHES));
        addQuantityLength(new QuantityLength(5.0, LengthUnit.FEET),new QuantityLength(0.0, LengthUnit.INCHES));
        addQuantityLength(new QuantityLength(5.0, LengthUnit.FEET),new QuantityLength(-2.0, LengthUnit.FEET));

        //UC7
        QuantityMeasurementApp.addQuantityLengthWithTargetUnit(new QuantityLength(1.0, LengthUnit.FEET),
                new QuantityLength(12.0, LengthUnit.INCHES), LengthUnit.FEET);
*/
        //UC8: Refactoring Unit Enum to Standalone with Conversion Responsibility
        //test case added
        //UC9: Weight Measurement Equality, Conversion, and Addition (Kilogram, Gram, Pound)

        demonstarateWeightEquality(new QuantityWeight(1.0, WeightUnit.KILOGRAM),new QuantityWeight(2.0, WeightUnit.KILOGRAM));
        //1.Input: Quantity(1.0, KILOGRAM).equals(Quantity(1.0, KILOGRAM)) → Output: true
        demonstarateWeightEquality(new QuantityWeight(1.0, WeightUnit.KILOGRAM),new QuantityWeight(1.0, WeightUnit.KILOGRAM));
        //2. Input: Quantity(1.0, KILOGRAM).equals(Quantity(1000.0, GRAM)) → Output: true
        demonstarateWeightEquality(new QuantityWeight(1.0, WeightUnit.KILOGRAM),new QuantityWeight(1000.0, WeightUnit.GRAM));

        //Input: Quantity(2.0, POUND).equals(Quantity(2.0, POUND)) → Output: true
        demonstarateWeightEquality(new QuantityWeight(2.0, WeightUnit.POUND),new QuantityWeight(2.0, WeightUnit.POUND));
        //4 Input: Quantity(1.0, KILOGRAM).equals(Quantity(~2.20462, POUND)) → Output: true (within epsilon)
        demonstarateWeightEquality(new QuantityWeight(1.0, WeightUnit.KILOGRAM),new QuantityWeight(2.20462, WeightUnit.POUND));
        //Input: Quantity(500.0, GRAM).equals(Quantity(0.5, KILOGRAM)) → Output: true
        demonstarateWeightEquality(new QuantityWeight(500.0, WeightUnit.GRAM),new QuantityWeight(0.5, WeightUnit.KILOGRAM));
        //Input: Quantity(1.0, POUND).equals(Quantity(~453.592, GRAM)) → Output: true (within epsilon
        demonstarateWeightEquality(new QuantityWeight(1.0, WeightUnit.POUND),new QuantityWeight(453.592, WeightUnit.GRAM));

        //Unit Conversions
        //input: Quantity(1.0, KILOGRAM).convertTo(GRAM) → Output: Quantity(1000.0, GRAM)
        demonstrateWeightUnitConversion(new QuantityWeight(1.0,WeightUnit.KILOGRAM),WeightUnit.GRAM);
        //Input: Quantity(2.0, POUND).convertTo(KILOGRAM) → Output: Quantity(~0.907184, KILOGRAM)
        demonstrateWeightUnitConversion(new QuantityWeight(2.0,WeightUnit.POUND),WeightUnit.KILOGRAM);
        //Input: Quantity(500.0, GRAM).convertTo(POUND) → Output: Quantity(~1.10231, POUND)
        demonstrateWeightUnitConversion(new QuantityWeight(500.0,WeightUnit.GRAM),WeightUnit.POUND);
        //Input: Quantity(0.0, KILOGRAM).convertTo(GRAM) → Output: Quantity(0.0, GRAM)
        demonstrateWeightUnitConversion(new QuantityWeight(0.0,WeightUnit.KILOGRAM),WeightUnit.GRAM);

        //Addition Operations (Implicit Target Unit)
        //Input: Quantity(1.0, KILOGRAM).add(Quantity(2.0, KILOGRAM)) → Output: Quantity(3.0, KILOGRAM)
        addQuantityWeightWithFirstOperand(new QuantityWeight(1.0,WeightUnit.KILOGRAM), new QuantityWeight(2.0, WeightUnit.KILOGRAM));
        //Input: Quantity(1.0, KILOGRAM).add(Quantity(1000.0, GRAM)) → Output: Quantity(2.0, KILOGRAM)
        addQuantityWeightWithFirstOperand(new QuantityWeight(1.0,WeightUnit.KILOGRAM), new QuantityWeight(1000.0, WeightUnit.GRAM));
        //Input: Quantity(500.0, GRAM).add(Quantity(0.5, KILOGRAM)) → Output: Quantity(1000.0, GRAM)
        addQuantityWeightWithFirstOperand(new QuantityWeight(500.0,WeightUnit.GRAM), new QuantityWeight(0.5, WeightUnit.KILOGRAM));

        //Addition Operations (Explicit Target Unit)
        //Input: Quantity(1.0, KILOGRAM).add(Quantity(1000.0, GRAM), GRAM) → Output: Quantity(2000.0, GRAM)
        addQuantityWeightWithTargetUnit(new QuantityWeight(1.0,WeightUnit.KILOGRAM), new QuantityWeight(1000.0, WeightUnit.GRAM), WeightUnit.GRAM);

        //Input: Quantity(1.0, POUND).add(Quantity(453.592, GRAM), POUND) → Output: Quantity(~2.0, POUND)
        addQuantityWeightWithTargetUnit(new QuantityWeight(1.0,WeightUnit.POUND), new QuantityWeight(453.592, WeightUnit.GRAM), WeightUnit.POUND);

        //Input: Quantity(2.0, KILOGRAM).add(Quantity(4.0, POUND), KILOGRAM) → Output: Quantity(~3.82, KILOGRAM)
        addQuantityWeightWithTargetUnit(new QuantityWeight(2.0,WeightUnit.KILOGRAM), new QuantityWeight(4.0, WeightUnit.POUND), WeightUnit.KILOGRAM);
        //Category Incompatibility:
        //Input: Quantity(1.0, KILOGRAM).equals(Quantity(1.0, FOOT)) → Output: false (or exception)
        incompatibilityCheck(new QuantityWeight(1.0, WeightUnit.KILOGRAM), new QuantityLength(1.0, LengthUnit.FEET));

        //Generic Quantity Class with Unit Interface for Multi-Category Support

        Quantity<LengthUnit> lengthFeet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> lengthInches = new Quantity<>(12.0, LengthUnit.INCHES);

         demonstrateEquality(lengthFeet, lengthInches);

        demonstrateConversion(lengthFeet, LengthUnit.YARD);
        demonstrateConversion(new Quantity<WeightUnit>(1.0, WeightUnit.KILOGRAM), WeightUnit.GRAM);

        demonstrateAddition(lengthFeet, lengthInches);

        //Input: Quantity(1.0, KILOGRAM).add(Quantity(1000.0, GRAM), GRAM) → Output: Quantity(2000.0, GRAM)
        demonstrateAddition(new Quantity<WeightUnit>(1.0,WeightUnit.KILOGRAM), new Quantity<WeightUnit>(1000.0, WeightUnit.GRAM), WeightUnit.GRAM);

        //Input: Quantity(1.0, POUND).add(Quantity(453.592, GRAM), POUND) → Output: Quantity(~2.0, POUND)
        demonstrateAddition(new Quantity<WeightUnit>(1.0,WeightUnit.POUND), new Quantity<WeightUnit>(453.592, WeightUnit.GRAM), WeightUnit.POUND);

        //Input: Quantity(2.0, KILOGRAM).add(Quantity(4.0, POUND), KILOGRAM) → Output: Quantity(~3.82, KILOGRAM)
        demonstrateAddition(new Quantity<WeightUnit>(2.0,WeightUnit.KILOGRAM), new Quantity<WeightUnit>(2.20462, WeightUnit.POUND), WeightUnit.KILOGRAM);

        demonstrateAddition(new Quantity<LengthUnit>(1.0,LengthUnit.FEET), new Quantity<LengthUnit>(12.0, LengthUnit.INCHES), LengthUnit.FEET);

    }
}
