/**
 * QuantityMeasurementApp -UC1: Feet measurement equality
 *
 * This class is responsible for checking the equality of two numerical values
 * measured in feet in the Quantity Measurement Application.
 */

package com.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityMeasurementApp {

    //Inner class to represent Feet measurement

    public static class Feet {

        private final Double value1;
        private final Double value2;

        public Feet(Double value1, Double value2) {

            this.value1 = value1;
            this.value2 = value2;

            if(value1 == null || value2 == null) {
                throw new NullPointerException("Null Value not allowed");
            }
            if (Double.isNaN(value1) || Double.isInfinite(value1) && Double.isNaN(value2) || Double.isInfinite(value2)) {
                throw new IllegalArgumentException("Invalid double value");
            }
        }

        //Define a static method to demonstrate Feet equality check
        public static void demonstrateFeetEquaility(Double value1, Double value2) {
            boolean flag = false;
            QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(value1,value2);
            if(value1 == null || value2 == null) {
                throw new NullPointerException("Null Value not allowed");
            }
             flag = Double.compare(value1, feet.value1) == 0 && Double.compare(value2, feet.value2) == 0;
            System.out.println("Feet Equality :: "+ flag);

        }
        //override equals method for equality check

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Feet feet = (Feet) o;
            return Double.compare(value1, feet.value1) == 0 && Double.compare(value2, feet.value2) == 0;
        }
        @Override
        public int hashCode() {
            return Objects.hash(value1, value2);
        }

        public Double getValue1() {
            return value1;
        }

        public Double getValue2() {
            return value2;
        }

    }
    public static class Inches {

        private final Double value1;
        private final Double value2;

        public Inches(Double value1, Double value2) {

            this.value1 = value1;
            this.value2 = value2;

            if (Double.isNaN(value1) || Double.isInfinite(value1) && Double.isNaN(value2) || Double.isInfinite(value2)) {
                throw new IllegalArgumentException("Invalid double value");
            }
        }

        public Double getValue1() {
            return value1;
        }

        public Double getValue2() {
            return value2;
        }

        //Define a static method to demonstrate Feet equality check
        public static void demonstrateInchesEquaility(Double value1, Double value2) {
            QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(value1, value2);
            boolean flag = Double.compare(value1, inches.value1) == 0 && Double.compare(value2, inches.value2) == 0;
            System.out.println("Inches Equality :: " + flag);

        }
    }
        public static void main(String[] args) {
            boolean flag = false;
            System.out.println("Feet measurement");

            QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(10.1, 10.1);
            Feet.demonstrateFeetEquaility(feet.value1, feet.value2);

            QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(25.0, 25.0);
            Inches.demonstrateInchesEquaility(inches.value1, inches.value2);

        /*if(feet.value1 !=null && feet.value2 != null) {
            flag =  feet.value1.equals(feet.value2);
            System.out.println(flag);
        }*/

            //Different class
            //QuantityMeasurementApp.Feet feetStrigVal = new QuantityMeasurementApp.Feet(Double.parseDouble("ddd"),10.1);
            //flag =  feetStrigVal.value1.equals(feetStrigVal.value2);
            //System.out.println(flag);

            //null value
            //QuantityMeasurementApp.Feet feetNullValue = new QuantityMeasurementApp.Feet(null,10.1);
            //  flag = feetNullValue.value1.equals(feetNullValue.value2);
            //System.out.println(flag);

            QuantityMeasurementApp.Feet feetRange = new QuantityMeasurementApp.Feet(14.5, 14.5);
            if (feetRange.value1 != null && feetRange.value2 != null) {
                flag = feetRange.value1.equals(feetRange.value2);
                System.out.println(flag);
            }
        }
}
