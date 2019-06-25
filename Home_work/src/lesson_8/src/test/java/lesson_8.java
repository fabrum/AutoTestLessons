import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class lesson_8 {

    @Test
    public void Task1() {
        System.setProperty("webdriver.chrome.driver", "D:/Web_drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com/");
        WebElement whenAreYouGoing = driver.findElement(By.xpath(".//div[@class='xp__dates xp__group']"));
        whenAreYouGoing.click();
        WebElement ferstData = driver.findElement(By.xpath(".//td[@data-date='2019-07-10']"));
        ferstData.click();
        WebElement secondData = driver.findElement(By.xpath(".//td[@data-date='2019-07-11']"));
        secondData.click();
        WebElement whereAreYouGoing = driver.findElement(By.id("ss"));
        whereAreYouGoing.sendKeys("Москва");
        whereAreYouGoing.submit();
        Assert.assertNotNull(driver.findElements(By.xpath(".//div[@data-class]")));

        driver.quit();
    }

    @Test
    public void Task2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:/Web_drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com/");
        WebElement whereAreYouGoing = driver.findElement(By.id("ss"));
        whereAreYouGoing.sendKeys("Москва");
        whereAreYouGoing.submit();
        WebElement sortHotel = driver.findElement(By.xpath(".//a[@data-category='class_and_price']"));
        sortHotel.click();
        Thread.sleep(5000);
        WebElement ferstHotel = driver.findElement(By.xpath("(.//a[@class=\"hotel_name_link url\"])[1]"));
        ferstHotel.click();
        WebElement ratingHotel = driver.findElement(By.xpath("(.//div[@class='bui-review-score__badge'])[1]"));
        double actualRatingHotel = Double.valueOf(ratingHotel.getText());
        double expectedRatingHotelOrMore = 9.0;
        Assert.assertTrue(actualRatingHotel >= expectedRatingHotelOrMore);
        driver.quit();
    }


}
