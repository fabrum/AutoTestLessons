

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;

public class singeltonDriver {
    private static WebDriver driver;
    private singeltonDriver(){}

    public static WebDriver getDriver(){
        if (driver==null){
            System.setProperty("webdriver.chrome.driver", "D:/Web_drivers/chromedriver.exe");//your own path
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void closeBrowser(){
        if (driver == null) {
            return;
        }
        driver.quit();
        driver = null;
    }

}