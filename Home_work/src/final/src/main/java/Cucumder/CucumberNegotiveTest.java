package Cucumder;



import Pages.Main;

import app.DBOperation;

import app.singeltonDriver;
import org.junit.Assert;


import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberNegotiveTest {


    private int pass = 2;
    private int login = 3;
    private Main main;
    private DBOperation dbOperation;






    public CucumberNegotiveTest()
    {
        main = new Main();
        dbOperation = new DBOperation();

    }

    @Given("^I am on main application page$")
    public void loadMainPage()
    {
        main.openMailru();;
    }

    @When("^enter valid pass and wrong user Mail$")
    public void loginAsCorrectUser()
    {
        main.enterLiginAndPass(dbOperation.Get(2, login), dbOperation.Get(2, pass));
        main.loginInMailru();
    }




    @Then("I see error massage")
    public void seeErrorMessage()
    {
        Assert.assertTrue(main.loginIsFailed());
    }

    @After
    public void afterClass()
    {
        singeltonDriver.closeBrowser();
    }
}
