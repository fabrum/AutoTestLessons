package Cucumder;

import Pages.Main;
import app.DBOperation;
import app.singeltonDriver;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CucumberPositiveTest {

    private int pass = 2;
    private int login = 3;
    private Main main;
    private DBOperation dbOperation;









    public CucumberPositiveTest()
    {
        main = new Main();
        dbOperation = new DBOperation();

    }

    @Given("^I am on main application page$")
    public void loadMainPage()
    {
        main.openMailru();;
    }

    @When("^I login as correct user$")
    public void loginAsCorrectUser()
    {
        main.enterLiginAndPass(dbOperation.Get(1, login), dbOperation.Get(1, pass));

        main.loginInMailru();
    }




    @Then("I see logout link")
    public void seeErrorMessage()
    {
        Assert.assertTrue(main.loginIsLogined());
    }

    @After
    public void afterClass()
    {
        singeltonDriver.closeBrowser();
    }
}
