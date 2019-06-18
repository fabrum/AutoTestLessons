import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringOperation2Test {

    @Test
    public void testCharactersNamb() {
        StringOperation stringOperation = new StringOperation();
        String testStr = "S  Edde  e ";
        int expectedResalt = 6;
        assertEquals(expectedResalt, stringOperation.CharactersNamb(testStr));

    }

    @Test
    public void testPolindrom1() {
        StringOperation stringOperation = new StringOperation();
        String testStr = "asd f1f dsa";

        assertTrue(stringOperation.Polindrom(testStr));
    }

    @Test
    public void testPolindrom2() {
        StringOperation stringOperation = new StringOperation();
        String testStr = "asd f1f dsasd";
        assertFalse(stringOperation.Polindrom(testStr));
    }

    @Test
    public void testChangPlaseFerstAndLastWords() {
        StringOperation stringOperation = new StringOperation();
        String testStr = "tom eat som";
        String expectedResalt = "som eat tom";
        assertEquals(expectedResalt, stringOperation.ChangPlaseFerstAndLastWords(testStr));
    }

    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void testExceptionChangPlaseFerstAndLastWords() {
        StringOperation stringOperation = new StringOperation();
        String testStr = " ";
        String expectedResalt = "   ";
        assertEquals(expectedResalt, stringOperation.ChangPlaseFerstAndLastWords(testStr));
    }

    @Test
    public void testContainSergOrVasy1() {
        StringOperation stringOperation = new StringOperation();
        String testStr = "S  Vas  ye";
        assertFalse(stringOperation.ContainSergOrVasy(testStr));
    }

    @Test
    public void testContainSergOrVasy2() {
        StringOperation stringOperation = new StringOperation();
        String testStr = "S  Vasy  ye ";
        assertTrue(stringOperation.ContainSergOrVasy(testStr));
    }

    @Test(enabled = false)
    public void testContainSergOrVasy3() {
        StringOperation stringOperation = new StringOperation();
        String testStr = "S  Serg445d  ye ";
        assertTrue(stringOperation.ContainSergOrVasy(testStr));
    }

    @Test
    public void testBackwardsText() {
        StringOperation stringOperation = new StringOperation();
        String testStr = "S  Edde  e";
        String expectedResalt = "e  eddE  S";
        assertEquals(expectedResalt, stringOperation.BackwardsText(testStr));
    }


    @DataProvider(name = "polindroms")
    public Object[][] data() {
        return new Object[][]{
                {"sdf fds", new Boolean(true)},
                {"sdfw fds", false},
                {"sdf 343 fds", true},
                {"sdf 3333343fds", false},
                };
    }
    @Test(dataProvider = "polindroms")
    public void testPolindrom3(String testStr, boolean expecteResalt) {
        StringOperation stringOperation = new StringOperation();
        assertEquals(expecteResalt,stringOperation.Polindrom(testStr));
    }
}