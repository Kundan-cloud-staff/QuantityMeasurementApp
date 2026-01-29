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

    public static void main(String[] args) {

       System.out.println("Feet measurement");
       Feet feet = new Feet(10.2,10.1);
      if(feet.value1 !=null && feet.value2 != null) {
        boolean flag =  feet.value1.equals(feet.value2);
          System.out.println(flag);
      }
    }

}
