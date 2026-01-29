package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {

    public static class Inch {

        private final Double value1;
        private final Double value2;

        public Inch(Double value1, Double value2) {
            this.value1 = value1;
            this.value2 = value2;
        }
    }

    @Test
    public void testFeetEquality_SameValue(){

        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(10.1,10.1);
        Assertions.assertEquals(feet.getValue1(),feet.getValue2());
    }

    @Test
    public void testFeetEquality_DifferentValue(){

        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(10.1,20.1);
        Assertions.assertNotEquals(feet.getValue1(),feet.getValue2());
    }

    @Test
    public void testFeetEquality_NullComparision(){

        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(null,20.1);
        Assertions.assertNull(feet.getValue1());
    }

    @Test
    public void testFeetEquality_DifferentClass(){

        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(10.1,20.1);
        Inch inch = new Inch(16.1,18.1);
        Assertions.assertNotEquals(feet.getValue1(),inch.value1);
        Assertions.assertNotEquals(feet.getValue2(),inch.value2);
    }

    @Test
    public void testFeetEquality_SameReference(){
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(10.1,20.1);
        QuantityMeasurementApp.Feet feet2 = feet;
        Assertions.assertEquals(feet.getValue1(),feet2.getValue1());
        Assertions.assertEquals(feet.getValue2(),feet2.getValue2());

    }
}
