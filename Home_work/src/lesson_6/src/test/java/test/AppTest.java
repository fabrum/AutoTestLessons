package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class AppTest {

    @Test
    public void testMassLengthInt() {
        App app = new App();
        int [] testMass = new int [10];
        int expectedResalt = 10;
        assertEquals(expectedResalt, app.MassLength(testMass));
    }


    @Test
    public void testMassLengthInt2() {
        App app = new App();
        int [] testMass = {1, 20, 66645, 3,4,4,4,4,4,4};
        int expectedResalt = 10;
        assertEquals(expectedResalt, app.MassLength(testMass));
    }

    @Test
    public void testMassLengthString() {
        App app = new App();
        String [] testMass = {"Winter", "Spring", "Summer", "Autumn"};
        int expectedResalt = 4;
        assertEquals(expectedResalt, app.MassLength(testMass));
    }


    @Test
    public void testMaxFromArrayInt() {
        App app = new App();
        int [] testMass = {1, 20, 66645, 3};
        int expectedResalt = 66645;
        assertEquals(expectedResalt, app.MaxFromArray(testMass));
    }

    @Test
    public void testMaxFromArrayInt2Bad() {
        App app = new App();
        int [] testMass = {1, 2};
        int expectedResalt = 1;
        assertNotEquals(expectedResalt, app.MaxFromArray(testMass));
    }

    @Test
    public void testMaxFromArrayString() {
        App app = new App();
        String [] testMass = {"Winter", "apple", "dog", "Autumn"};
        String expectedResalt = "Winter";
        assertEquals(expectedResalt, app.MaxFromArray(testMass));
    }


    @Test
    public void testMaxFromArrayStringBad() {
        App app = new App();
        String [] testMass = {"Winter", "apple"};
        String expectedResalt = "apple";
        assertNotEquals(expectedResalt, app.MaxFromArray(testMass));
    }

    @Test
    public void testGetStudentId() {
        App app = new App();
        int [] grades = {1, 20, 44, 3};
        String name = "Fedor";
        int id = 001;
        app.SetStudent(grades,name,id);
        assertEquals(id, app.GetStudentId());

    }

    @Test
    public void testGetStudentName() {
        App app = new App();
        int [] grades = {1, 20, 44, 3};
        String name = "Fedor";
        int id = 001;
        app.SetStudent(grades,name,id);
        assertEquals(name, app.GetStudentName());

    }

    @Test
    public void testGetStudentGrades() {
        App app = new App();
        int [] grades = {1, 20, 44, 3};
        String name = "Fedor";
        int id = 001;
        app.SetStudent(grades,name,id);
        assertEquals(grades, app.GetStudentGrades());

    }
}