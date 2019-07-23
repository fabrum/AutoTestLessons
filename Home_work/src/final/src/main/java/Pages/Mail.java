package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import app.singeltonDriver;

import java.util.concurrent.TimeUnit;

public class Mail {

    @FindBy(xpath = ".//label[@class=\"container--zU301\"]")
    private WebElement emailAddresHowSends;
    @FindBy(xpath = ".//div[@role=\"textbox\"]")
    private WebElement newMailText;
    @FindBy(xpath = "(.//span[@class=\"button2__txt\"])[1]")
    private WebElement sendMail;
    @FindBy(xpath = "(.//span[@class=\"button2__txt\"])[2]")
    private WebElement saveMail;
    @FindBy(xpath = "(.//span[@class=\"button2__txt\"])[3]")
    private WebElement canselMail;

    @FindBy(xpath = ".//div[@class=\"layer-sent-page\"]")
    private WebElement emailIsSended;
    @FindBy(xpath = " .//span[@class=\"button2__wrapper\"]")
    private WebElement findButton;
    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[1]/div[1]/div/div[3]/div/div/span/span/div/input")
    private WebElement findFild;
    @FindBy(xpath = " .//span[@title=\"Пометить прочитанным\"]")
    private WebElement mailIsExist;

    @FindBy(xpath = " .//a[@class=\"llc js-tooltip-direction_letter-bottom js-letter-list-item llc_normal llc_first\"]")
    private WebElement firstMail;


    @FindBy(xpath = " (.//div[@title=\"Выделить письмо\"])[1]")
    private WebElement firstMailSelekted;

    @FindBy(xpath = ".//span[@title=\"Удалить\"]")
    private WebElement delMail;


    @FindBy(xpath = ".//a[@href=\"/drafts/\"]")
    private WebElement templMail;

    @FindBy(xpath = ".//div[@class=\"llc__background\"]")
    private WebElement draftsMailIsTrue;


    WebDriver driver;

    public Mail() {
        this.driver = singeltonDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void openNewMail() {
        driver = singeltonDriver.getDriver();
        driver.get("https://e.mail.ru/compose/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    public void enterEmailAddres(String email) {
        emailAddresHowSends.sendKeys(email + "@mail.ru");

    }


    public void enterTextEmail() {
        newMailText.sendKeys("test mail");


    }


    public void sendEmail() {

        sendMail.click();

    }


    public void saveEmail() {

        saveMail.click();

    }


    public void canselMail() {
        driver.switchTo().parentFrame();
        driver.get("https://e.mail.ru/");
        driver.switchTo().alert().accept();


    }


    public void goToDraftsMails() {
        driver.switchTo().parentFrame();

        driver.get("https://e.mail.ru/");
        driver.get("https://e.mail.ru/drafts");


    }

    public boolean emailIsSended() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(emailIsSended))
                .isDisplayed();
    }


    public void clickFind() {

        findButton.click();

    }


    public void enterFindFild(String mail) {

        findFild.sendKeys(mail);
        findFild.submit();

    }


    public boolean mailIsGet() {

        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(mailIsExist))
                .isDisplayed();
    }

    public boolean mailInDrafts() {

        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(draftsMailIsTrue))
                .isDisplayed();
    }


    public void selektedFirstMail() {

        firstMailSelekted.click();

    }

    public void deleteMail() {

        delMail.click();

    }

    public void goToDeleteMails() {

        driver.get("https://e.mail.ru/trash/");

    }





}
