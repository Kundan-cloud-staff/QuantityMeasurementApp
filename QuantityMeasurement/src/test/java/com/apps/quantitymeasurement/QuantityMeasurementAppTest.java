package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {

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

    /*@Test
    public void testFeetEquality_NullComparision(){
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(null,20.1);
        Assertions.assertThrows(NullPointerException.class, () -> {
            QuantityMeasurementApp.Feet.demonstrateFeetEquaility(feet.getValue1(),feet.getValue2());
        });
    }*/

    @Test
    public void testFeetEquality_DifferentClass(){

        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(10.1,20.1);
        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(16.1,18.1);
        Assertions.assertNotEquals(feet.getValue1(),inches.getValue1());
        Assertions.assertNotEquals(feet.getValue2(),inches.getValue2());
    }

    @Test
    public void testFeetEquality_SameReference(){
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(10.1,10.1);
        QuantityMeasurementApp.Feet feet2 = feet;
        Assertions.assertEquals(feet.getValue1(),feet2.getValue1());
        Assertions.assertEquals(feet.getValue2(),feet2.getValue2());

    }
    @Test
    public void testInchedEquality_SameValue(){

        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(10.1,20.1);
        Assertions.assertNotEquals(inches.getValue1(),inches.getValue2());
    }

    @Test
    public void testInchesEquality_DifferentValue(){

        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(10.1,20.1);
        Assertions.assertNotEquals(inches.getValue1(),inches.getValue2());
    }

    @Test
    public void testInchesEquality_DifferentClass(){

        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(10.1,20.1);
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(16.1,18.1);
        Assertions.assertNotEquals(inches.getValue1(),feet.getValue1());
        Assertions.assertNotEquals(inches.getValue2(),feet.getValue2());
    }

    @Test
    public void testInchesEquality_SameReference(){
        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(10.1,10.1);
        QuantityMeasurementApp.Inches inches1 = inches;
        Assertions.assertEquals(inches.getValue1(),inches1.getValue1());
        Assertions.assertEquals(inches.getValue2(),inches1.getValue2());

    }

}
