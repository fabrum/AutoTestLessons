

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class test {

    private int pass = 2;
    private int login = 3;
    private  int description = 4;
    private TestLogin testLogin;

    public test()
    {

        testLogin = new TestLogin();
    }
    @Test
    public void successfulLogin()
    {
        DBOperation dbOperation = new DBOperation();
        testLogin.openMailru();
        testLogin.loginInMailru(dbOperation.Get(1, login),dbOperation.Get(1, pass));
        Assertions.assertTrue(testLogin.loginIsLogined());
        singeltonDriver.closeBrowser();
    }

    @Test
    public void failLogin1()
    {
        DBOperation dbOperation = new DBOperation();
        testLogin.openMailru();
        testLogin.loginInMailru(dbOperation.Get(2, login),dbOperation.Get(2, pass));
        Assertions.assertTrue(testLogin.loginIsFailed());
        singeltonDriver.closeBrowser();
    }
    @Test
    public void failLogin2()
    {
        DBOperation dbOperation = new DBOperation();
        testLogin.openMailru();
        testLogin.loginInMailru(dbOperation.Get(3, login),dbOperation.Get(3, pass));
        Assertions.assertTrue(testLogin.loginIsFailed2());
        singeltonDriver.closeBrowser();
    }
    @Test
    public void failLogin3()
    {
        DBOperation dbOperation = new DBOperation();
        testLogin.openMailru();
        testLogin.loginInMailru(dbOperation.Get(4, login),dbOperation.Get(4, pass));
        Assertions.assertTrue(testLogin.loginIsFailed2());
        singeltonDriver.closeBrowser();
    }


}
