


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.mail;

import java.util.concurrent.TimeUnit;



public class Task10Test {


    private WebDriver driver;
    private pages.mail mail;
    @BeforeClass
    public void Befor() {
        System.setProperty("webdriver.chrome.driver", "D:/Web_drivers/chromedriver.exe");//your own path
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.mail.ru/");
        mail = new mail(driver);
        mail.enterLoginAndPass("testautamationmail","Ser!2345");

    }

    @Test
    public void mailAddToSpam()
    {

        mail.goToSpam(driver);

    }


    @Test
    public void mailRemoveToSpam()
    {

        mail.removeFromSpam(driver);

    }


    @Test
    public void sendMails()
    {

        mail.sendMail(driver);

    }
@Test
    public void select3MailAndUnselect()
{

    mail.selectMail(driver);
    mail.unSelectMail(driver);

}



}
