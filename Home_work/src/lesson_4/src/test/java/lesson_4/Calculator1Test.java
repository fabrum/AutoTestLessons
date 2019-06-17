package lesson_4.src.test.java.lesson_4;

import lesson_4.Calculator;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class Calculator1Test {

    @Test
    public void summ() {
        Calculator calculator = new Calculator();
        int expectedResalt = 6;
        int numb1 = 4;
        int numb2 = 2;
        assertEquals(expectedResalt, calculator.Summ(numb1, numb2));
    }
}