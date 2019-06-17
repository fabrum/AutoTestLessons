package lesson_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    public  void integerDivision() {
        Calculator calculator = new Calculator();
        int expectedResalt = 2;
        int numb1 = 4;
        int numb2 = 2;
        Assertions.assertEquals(expectedResalt, calculator.IntegerDivision(numb1, numb2));
    }

    @Test
    public void integerDivision1() {
        Calculator calculator = new Calculator();
        int numb1 = 4;
        int numb2 = 0;
        Throwable exception = assertThrows(ArithmeticException.class, () -> {
                    calculator.IntegerDivision(numb1, numb2);
                }
        );
        assertEquals("/ by zero", exception.getMessage());
    }


    @Test
    public  void summ() {
        Calculator calculator = new Calculator();
        int expectedResalt = 6;
        int numb1 = 4;
        int numb2 = 2;
        Assertions.assertEquals(expectedResalt, calculator.Summ(numb1, numb2));
    }

    @ParameterizedTest
    @CsvSource({"25,4,1", "75,4,3"})
    public  void percertOfNumberParameter(int expectedProcent, int AllNumb, int PartNumb) {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(expectedProcent, calculator.PercertOfNumber(AllNumb, PartNumb), "bad percent");
    }

    @Test
    public   void percertOfNumber() {
        Calculator calculator = new Calculator();
        int expectedResalt = 50;
        int numb1 = 4;
        int numb2 = 2;
        Assertions.assertEquals(expectedResalt, calculator.PercertOfNumber(numb1, numb2), "bad percent");
    }

    @Disabled("I wont that")
    @Test
    public  void percertOfNumberRepeat() {
        Calculator calculator = new Calculator();
        int expectedResalt = 50;
        int numb1 = 4;
        int numb2 = 2;
        Assertions.assertEquals(expectedResalt, calculator.PercertOfNumber(numb1, numb2), "bad percent");
    }

    @DisplayName("check summ a+b")
    @Test
    public  void summ1() {
        Calculator calculator = new Calculator();
        double expectedResalt = 8.8;
        double numb1 = 6.6;
        double numb2 = 2.2;
        System.out.println("checked a + b a=" + numb1 + " b=" + numb2 + " : expected result =" + expectedResalt + ": actual result=" + calculator.Summ(numb1, numb2));
        Assertions.assertEquals(expectedResalt, calculator.Summ(numb1, numb2));
        System.out.println("Test is was successful");
    }

    @Test
    public   void cube() {
        Calculator calculator = new Calculator();
        int expectedResalt = 64;
        int numb1 = 4;
        Assertions.assertEquals(expectedResalt, calculator.Cube(numb1));
    }

    @Test
    void cube_negotiv() {
        Calculator calculator = new Calculator();
        int expectedResalt = 16;
        int numb1 = 4;
        Assertions.assertNotEquals(expectedResalt, calculator.Cube(numb1));
    }
}