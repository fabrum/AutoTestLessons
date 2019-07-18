package mailru;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class MailruSteps {
    private static final String MAIN_URL = "http://mail.ru";
    private static final String LOGIN = "testautamationmail";
    private static final String PASSWORD = "Ser!2345";
    private MailruPage mailruPage;
    private WebDriver webDriver;

    public MailruSteps()
    {
        //  System.setProperty("webdriver.chrome.driver", "D:\\courses\\1. обновленный курс\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:/Web_drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        mailruPage = new MailruPage(webDriver);
    }




    @Given("^I am on main page mail.ru$")
    public void loadMainPage()
    {
        webDriver.get(MAIN_URL);
    }

    @When("^I am Login in mail.ru$")
    public void loginAsCorrectUser()
    {
        mailruPage.enterLoginAndPass(LOGIN, PASSWORD);
    }
////////////////////////////



    @When("^I select first letter$")
    public void selectFerstMail()
    {
        mailruPage.selectFerstMail(webDriver);
    }

    @When("^I click on Spam$")
    public void goToSpam(    )
    {
        mailruPage.goToSpam(webDriver);
    }



    @Then("the list of letters in page ")
    public void seeMailrInSpam()
    {
        Assert.assertTrue(mailruPage.mailInSpam(webDriver));
    }


    @When("^I click on Spam$")
    public void openSpam(    )
    {
        mailruPage.openSpam(webDriver);
    }



    @When("^I click on  Return mail$")
    public void openMainMailPage(    )
    {
        mailruPage.openMainMailPage(webDriver);
    }



    @When("^I click on New mail$")
    public void newMailClick(    )
    {
        mailruPage.newMailClick(webDriver);
    }

    @When("^I enter 3 mail address$")
    public void enter3Mail(    )
    {
        mailruPage.enter3Mail(webDriver);
    }

    @When("^I enter text mail$")
    public void enterTextMail(    )
    {
        mailruPage.enterTextMail(webDriver);
    }


    @When("^I click on send mail$")
    public void sendEMail(    )
    {
        mailruPage.sendEMail(webDriver);
    }


    @Then("^the  email sent$")
    public void mailrIsSend()
    {
        Assert.assertTrue(mailruPage.mailrIsSend(webDriver));
    }

    @When("^I mark 3 letter$")
    public void select3Mail(    )
    {
        mailruPage.select3Mail(webDriver);
    }

    @Then("^the email is marked$")
    public void mailrIsMarked()
    {
        Assert.assertTrue(mailruPage.mailrIsMarked(webDriver));
    }




    @When("^I deselect flag$")
    public void unSelectAllMail(    )
    {
        mailruPage.unSelect3Mail(webDriver);
    }

    @Then("^the email not have a flag$")
    public void mailrIsNotMarked()
    {
        Assert.assertFalse(mailruPage.mailrIsMarked(webDriver));
    }














    @After
    public void afterClass()
    {
        webDriver.quit();
    }



}
