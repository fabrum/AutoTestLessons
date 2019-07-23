package app;

import org.openqa.selenium.WebDriver;

import com.applitools.eyes.selenium.Eyes;


public class Applitoolse {

    Eyes eyes ;
    String apiKye = "tnI8QDbHvWop6GqeuUzvYn0CuX108Xz9BnCvovGcMWoUs110";
    WebDriver driver;
    // Set the API key from the env variable. Please read the "Important Note"
    // section above.
    public void setEyes (String appName, String TestName) {
        eyes = new Eyes();
        eyes.setApiKey(apiKye);
        driver = singeltonDriver.getDriver();
        eyes.open(driver, appName, TestName);
      //  return  eyes;
    }


    public void skrinshot (String step) {
       eyes.checkWindow(step);
     ///   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void closeEyes () {
        eyes.close();

       // singeltonDriver.closeBrowser();

    }

}
