
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;




public class TestLogin {

    @FindBy (xpath = "//*[@id=\"mailbox:login\"]")
    private WebElement loginfild;
    @FindBy (xpath = "//*[@id=\"mailbox:password\"]")
    private WebElement passFild;
    @FindBy (xpath = "//*[@id=\"PH_logoutLink\"]")
    private WebElement exitLink;
    @FindBy (xpath = "//*[@id=\"mailbox:error\"]")
    private WebElement errorMass;
    @FindBy (xpath = ".//div[@class=\"Description\"]")
    private WebElement errorMass2;

    @FindBy (xpath = ".//p[@class=\"c0118 c0118 c0130\"]")
    private WebElement errorMass3;
    @FindBy (xpath = "//*[@id=\"auth-form\"]")
    private WebElement form;




    WebDriver driver;
    public TestLogin ()
    {    this.driver =singeltonDriver.getDriver();
        PageFactory.initElements(driver,this);
    }

    public  void  openMailru()
    {
        driver= singeltonDriver.getDriver();
        driver.get("https://mail.ru");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public  void  loginInMailru(String login,String pass)
    {
        loginfild.sendKeys(login);
        passFild.sendKeys(pass);
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

        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(form))
                .isDisplayed();
    }



}
