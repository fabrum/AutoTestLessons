package pages;

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
import java.util.concurrent.TimeUnit;

public class mail {


    @FindBy (xpath = "//*[@id=\"mailbox:login\"]")
    private WebElement loginfild;
    @FindBy (xpath = "//*[@id=\"mailbox:password\"]")
    private WebElement passFild;
    @FindBy (xpath = "//*[@id=\"PH_logoutLink\"]")
    private WebElement exitLink;
    @FindBy (xpath = "//*[@id=\"mailbox:error\"]")
    private WebElement errorMass;
    @FindBy  (xpath = "(.//div[@class=\"ll-av__container\"])[1]")
    private WebElement ferstMail;

    @FindBy  (xpath = ".//div[@title=\"Выделить письмо\"]")
    private WebElement ferstMail2;

    @FindBy  (xpath = ".//span[@title=\"Спам\"]")
    private WebElement spamAdd;
    @FindBy  (xpath = ".//span[@title=\"Не спам\"]")
    private WebElement spamNot;


    @FindBy  (xpath = ".//a[@title=\"Спам\"]")
    private WebElement spamFolder;


    @FindBy  (xpath = ".//span[@class=\"compose-button__wrapper\"]")
    private WebElement newMail;
    @FindBy  (xpath = ".//label[@class=\"container--zU301\"]")
    private WebElement whoLetter;




    @FindBy  (xpath = "(.//span[@class=\"button2__txt\"])[1]")
    private WebElement sendMail;


    @FindBy  (xpath = ".//div[@class=\"focus-zone focus-zone_fluid\"]")
    private WebElement newMailPopup;

    @FindBy  (xpath = ".//div[@role=\"textbox\"]")
    private WebElement newMailText;

    @FindBy  (xpath = ".//span[@style=\"visibility: visible;\"]")
    private WebElement sendMailZerro;


    @FindBy  (xpath = "(.//div[@class=\"ll-av__container\"])[1]")
    private WebElement selectMail1;
    @FindBy  (xpath = "(.//div[@class=\"ll-av__container\"])[2]")
    private WebElement selectMail2;
    @FindBy  (xpath = "(.//div[@class=\"ll-av__container\"])[3]")
    private WebElement selectMail3;


    @FindBy  (xpath = "(.//span[@class=\"button2__wrapper\"])[1]")
    private WebElement unSelect;



    WebDriver driver;
    public mail (WebDriver webDriver)
    {    this.driver =webDriver;
        PageFactory.initElements(webDriver,this);
    }


    public  void     selectMail(WebDriver driver)
    {

        driver.get(" https://e.mail.ru/inbox");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        selectMail1.click();
        selectMail2.click();
        selectMail3.click();

    }


    public  void     unSelectMail(WebDriver driver) {

        unSelect.click();


    }

    public  void     sendMail(WebDriver driver)
    {

        driver.get(" https://e.mail.ru/compose/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     //   (new WebDriverWait(driver,60)).until(
     //           ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class=\"input--3slxg\"]"))
    //    );


        whoLetter.sendKeys("test1@gmail.com ");
        whoLetter.sendKeys("test2@gmail.com ");
        whoLetter.sendKeys("test3@gmail.com ");

        newMailText.sendKeys("qeqweqweqweqwe");

        sendMail.click();
   //     sendMailZerro.click();
    }








    public void enterLoginAndPass(String login,String pass)
    {
        loginfild.sendKeys(login);
        passFild.sendKeys(pass);
        passFild.submit();

    }


    public  void goToSpam(WebDriver driver)
    {
        (new WebDriverWait(driver,60)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PH_logoutLink\"]"))
        );

        ferstMail.click();
        spamAdd.click();
    }


    public  void     removeFromSpam(WebDriver driver)
    {

        //spamFolder.click();
        driver.get("https://e.mail.ru/spam/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ferstMail.click();

        spamNot.click();



    }



    public  boolean fiendExit(WebDriver driver)
    {
        (new WebDriverWait(driver,60)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PH_logoutLink\"]"))
        );
        return   exitLink.isDisplayed();
    }

    public  boolean badLigin(String login,String pass)
    {
        loginfild.sendKeys(login);
        passFild.sendKeys(pass);
        passFild.submit();
        return errorMass.isDisplayed();
    }
}
