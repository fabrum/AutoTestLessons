import com.applitools.eyes.exceptions.TestFailedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.RectangleSize;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args)  {

        //Use Chrome browser
        System.setProperty("webdriver.chrome.driver", "D:/Web_drivers/chromedriver.exe");//your own path

        WebDriver driver = new ChromeDriver();

        // Initialize the eyes SDK and set your private API key.
        Eyes eyes = new Eyes();

        // Set the API key from the env variable. Please read the "Important Note"
        // section above.
        eyes.setApiKey("tnI8QDbHvWop6GqeuUzvYn0CuX108Xz9BnCvovGcMWoUs110");



driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // Start the test by setting AUT's name, window or the page name that's being tested, viewport width and height
           eyes.open(driver, "appName3","Home work 2", new RectangleSize(1300, 900));

            // Navigate the browser to the "ACME" demo app
            driver.get("https://mail.ru");

            // Visual checkpoint #1.
            eyes.checkWindow("step 1");

            WebElement login =driver.findElement(By.xpath("//*[@id=\"mailbox:login\"]"));
            login.sendKeys("testautamationmail");
            WebElement pass =driver.findElement(By.xpath("//*[@id=\"mailbox:password\"]"));
            pass.sendKeys("Ser!2345");

            WebElement loginBox =driver.findElement(By.xpath("//*[@id=\"mailbox-container\"]"));
            eyes.checkElement(loginBox,"step2");
            pass.submit();



            eyes.checkWindow("step 3");
            WebElement newMail =driver.findElement(By.xpath(".//span[@class=\"compose-button__wrapper\"]"));
            newMail.click();

            WebElement toWhom =driver.findElement(By.xpath("(.//input[@type=\"text\"])[1]"));
            WebElement topic =driver.findElement(By.xpath("(.//input[@type=\"text\"])[2]"));
            toWhom.sendKeys("test1@test.tes");
            topic.sendKeys("home work");

            WebElement textMail = driver.findElement(By.xpath(".//div[@role=\"textbox\"]"));
           textMail.sendKeys("text mail");
             eyes.checkWindow("step 4");
            WebElement sendMail  = driver.findElement(By.xpath(".//span[@title=\"Отправить\"]"));
            sendMail.click();
             eyes.checkWindow("step 5");

         //   eyes.checkWindow("New Login window");
            //🌟 Note: You can have multiple "checkWindow" to create multiple test steps within a test.🌟
            //For example, you may want to test errors in the login window after clicking a login button,
            //In that case, you may add the following before you call eyes.close().
            //This will create a test with two test steps.
            //driver.click("login");
            //eyes.checkWindow("Login Window Error");

            // End the test.
            eyes.close();


            // Close the browser.
            driver.quit();

            // If the test was aborted before eyes.close was called, ends the test as
            // aborted.
            eyes.abortIfNotClosed();

            // End main test
            System.exit(0);
        }

    }
