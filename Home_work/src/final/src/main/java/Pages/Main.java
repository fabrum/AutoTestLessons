package Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import app.singeltonDriver;

import java.util.concurrent.TimeUnit;



public class Main {


    @FindBy (xpath = "//*[@id=\"mailbox:login\"]")
    private WebElement loginfild;
    @FindBy (xpath = "//*[@id=\"mailbox:password\"]")
    private WebElement passFild;
    @FindBy (xpath = "//*[@id=\"PH_logoutLink\"]")
    private WebElement exitLink;
    @FindBy (xpath = ".//a[@id='PH_logoutLink']")
    private WebElement exitLink2;
    @FindBy (xpath = "//*[@id=\"mailbox:error\"]")
    private WebElement errorMass;
    @FindBy (xpath = "//*[@id=\"auth-form\"]")
    private WebElement seeAythForm;



    WebDriver driver;
    public Main ()
    {    this.driver = singeltonDriver.getDriver();
        PageFactory.initElements(driver,this);
    }

    public  void  openMailru()
    {
        driver= singeltonDriver.getDriver();
        driver.get("https://mail.ru");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

    }

    public  void  enterLiginAndPass(String login,String pass)
    {
        loginfild.sendKeys(login);
        passFild.sendKeys(pass);


    }


    public  void  loginInMailru()
    {

        passFild.submit();

    }



    public  boolean  loginIsLogined()
    {
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(exitLink))
                .isDisplayed();
    }

    public  boolean  loginIsFailed()
    {

        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(errorMass))
                .isDisplayed();
    }

    public  boolean  loginIsFailed2()
    {

        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(seeAythForm))
                .isDisplayed();
    }
    public  void   logout()
    {

        exitLink.click();

    }
    public  boolean  logoutIsDone()
    {
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(seeAythForm))
                .isDisplayed();
    }






}
