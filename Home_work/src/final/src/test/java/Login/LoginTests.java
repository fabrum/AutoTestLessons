package Login;


import java.io.IOException;
import Pages.Main;
import app.Applitoolse;
import app.DBOperation;
import app.FasadBadLogin;
import app.singeltonDriver;
import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.Test;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

public class LoginTests {


    private int pass = 2;
    private int login = 3;
    private int description = 4;
    private Main main;
    private DBOperation dbOperation;
    private Applitoolse applitoolse;
    private static final Logger log = Logger.getLogger(LoginTests.class);

    public LoginTests() {

        main = new Main();
        dbOperation = new DBOperation();
        applitoolse = new Applitoolse();
    }

    @Test
    public void successfulLogin() {

        applitoolse.setEyes("loginTest", "success login1");
        main.openMailru();
        applitoolse.skrinshot("step1");
        log.info("step 1: open mail.ru");
        main.enterLiginAndPass(dbOperation.Get(1, login), dbOperation.Get(1, pass));
        applitoolse.skrinshot("step2");
        log.info("step 2.1: enter pass and user Mail");
        main.loginInMailru();
        log.info("step 2.2: click 'enter'");
        Assert.assertTrue(main.loginIsLogined());
        applitoolse.skrinshot("step3");
        log.info("step 3: check the login is success");

        applitoolse.closeEyes();
        singeltonDriver.closeBrowser();

    }

    @Test
    public void failLogin1() throws ParserConfigurationException, XMLStreamException, SAXException, IOException {

        FasadBadLogin.setBadLogin(1,"type1");

    }

    @Test
    public void failLogin2() throws ParserConfigurationException, XMLStreamException, SAXException, IOException {
        FasadBadLogin.setBadLogin(2,"type2");

    }

    @Test
    public void failLogin3() throws ParserConfigurationException, XMLStreamException, SAXException, IOException {
        FasadBadLogin.setBadLogin(3,"type2");

    }


    @Test
    public void failLogout() {
        applitoolse.setEyes("loginTest", "Logout");
        main.openMailru();
        applitoolse.skrinshot("step1");
        log.info("step 1: open mail.ru");
        main.enterLiginAndPass(dbOperation.Get(1, login), dbOperation.Get(1, pass));
        applitoolse.skrinshot("step2");
        main.loginInMailru();
        log.info("step 2: enter pass and user Mail and login");
        Assert.assertTrue(main.loginIsLogined());
        applitoolse.skrinshot("step3");
        log.info("step 3: check the login is success");
        main.logout();
        log.info("step 4:  click on logout");
        Assert.assertTrue(main.logoutIsDone());
        log.info("step 5: check the logout is success");
        applitoolse.skrinshot("step4");
        applitoolse.closeEyes();
        singeltonDriver.closeBrowser();
    }
}
