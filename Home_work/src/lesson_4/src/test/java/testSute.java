package lesson_4.src.test.java;

import lesson_4.src.test.java.lesson_4.Calculator1Test;
import lesson_4.src.test.java.lesson_4.Calculator2Test;
import lesson_4.src.test.java.lesson_4.Calculator3Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value =Suite.class)
@Suite.SuiteClasses(value ={Calculator2Test.class, Calculator1Test.class, Calculator3Test.class})


public class testSute {
}
