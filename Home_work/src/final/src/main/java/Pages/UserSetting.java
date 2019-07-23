package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import app.singeltonDriver;


public class UserSetting {

    @FindBy(xpath = "//*[@id=\"PH_user-email\"]")
    private WebElement userMenu;

    @FindBy(xpath = ".//a[@href=\"https://e.mail.ru/settings/userinfo\"]")
    private WebElement userSettings;

    @FindBy(xpath = "   //*[@id=\"FirstName\"]")
    private WebElement userFirstNameFild;
    @FindBy(xpath = "  //*[@id=\"LastName\"]")
    private WebElement userLastNameFild;

    @FindBy(xpath = "(.//span[@class=\"btn__text\"])[5]")
    private WebElement buttonSave;

    @FindBy(xpath = " .//div[@class=\"x-ph__auth_list__item__info__email__text\"]")
    private WebElement userNameIsSee;


    WebDriver driver;

    public UserSetting() {
        this.driver = singeltonDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void openUserMenu() {
        driver = singeltonDriver.getDriver();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(userMenu))
                .isDisplayed();

        userMenu.click();}

    public void goToSettingUser() {

        userMenu.click();

        userSettings.click();


    }

    public void editFirstNameFild(String name){
        userFirstNameFild.clear();
        userFirstNameFild.sendKeys(name);

    }
    public void editLastNameFild(String name){
        userLastNameFild.clear();
        userLastNameFild.sendKeys(name);

    }

    public void editSave(){
        buttonSave.click();

    }


    public String cheackEditName(){


     return userNameIsSee.getText();

    }



}
