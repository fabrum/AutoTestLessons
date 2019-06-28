import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class lesson_9 {
    @Test
    public void Task1() throws InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long date = new Date().getTime();
        long dateStart = date + (3 * 24 * 3600 * 1000);
        long dataFinish = date + (9 * 24 * 3600 * 1000);
        // System.out.println(dateFormat.format(dateStart)+'+'+dateFormat.format(dataFinish));

        System.setProperty("webdriver.chrome.driver", "D:/Web_drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com/");
        WebElement whenAreYouGoing = driver.findElement(By.xpath(".//div[@class='xp__dates xp__group']"));
        whenAreYouGoing.click();

        WebElement ferstData = driver.findElement(By.xpath(".//td[@data-date='" + dateFormat.format(dateStart) + "']"));
        ferstData.click();
        WebElement secondData = driver.findElement(By.xpath(".//td[@data-date='" + dateFormat.format(dataFinish) + "']"));
        secondData.click();
        WebElement whereAreYouGoing = driver.findElement(By.id("ss"));
        whereAreYouGoing.sendKeys("париж");
        whereAreYouGoing.submit();

        WebElement sortHotel = driver.findElement(By.xpath(".//a[@data-category='price']"));
        sortHotel.click();
        Thread.sleep(5000);

        //  List<WebElement> listHotels =  driver.findElements(By.xpath(".//div[@class=\"bui-review-score__badge\"]"));

        List<WebElement> listHotels = driver.findElements(By.xpath(".//div[@data-score]"));
        int idMaxReiting = 0;
        double newReting;
        double maxReting;
        String ss;
        for (int i = 1; i < listHotels.size(); i++) {
            maxReting = Double.valueOf(listHotels.get(idMaxReiting).getAttribute("data-score"));

            if (listHotels.get(i).getAttribute("data-score").isEmpty()) {
                newReting = 0;
            } else {

                if (driver.findElements(By.xpath("(.//div[@data-score])[" + (i + 1) + "]//div[@class=\"bui-price-display__value prco-inline-block-maker-helper \"]")).isEmpty()) {
                    newReting = 0;
                } else {
                    newReting = Double.valueOf(listHotels.get(i).getAttribute("data-score"));
                }
            }
            if (newReting > maxReting)
                idMaxReiting = i;

        }

        WebElement findHotel = driver.findElement(By.xpath("(.//a[@class=\"hotel_name_link url\"])[" + (idMaxReiting + 1) + "]"));
        findHotel.click();
        Thread.sleep(5000);

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        WebElement selectNombers = driver.findElement(By.xpath(".//select[@class='hprt-nos-select']"));
        WebElement maxPiple = driver.findElement(By.xpath("(.//div[@class='hprt-block'])[2]//span[@class='bui-u-sr-only']"));


        Select newSelectNombers = new Select(selectNombers);

        if (Integer.valueOf(maxPiple.getText().replaceAll("\\D+", "")) == 1)
            newSelectNombers.selectByValue("2");
        else
            newSelectNombers.selectByValue("1");
        Thread.sleep(1000);

        WebElement prise = driver.findElement(By.xpath(".//div[@class='hprt-reservation-total-price']"));


        int actualResult = Integer.valueOf(prise.getText().replaceAll("\\D+", ""));
        int expectedResult = 2000;
        Assert.assertTrue(expectedResult>actualResult);
        driver.quit();
    }

    @Test
        public void Task2() throws InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long date = new Date().getTime();
        long dateStart = date + (3 * 24 * 3600 * 1000);
        long dataFinish = date + (9 * 24 * 3600 * 1000);
        // System.out.println(dateFormat.format(dateStart)+'+'+dateFormat.format(dataFinish));

        System.setProperty("webdriver.chrome.driver", "D:/Web_drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com/");

        WebElement adultsSelektor = driver.findElement(By.xpath("//*[@id=\"xp__guests__toggle\"]"));
        adultsSelektor .click();

        WebElement adultsPluse =driver.findElement(By.xpath("(.//button[@class=\"bui-button bui-button--secondary bui-stepper__add-button\"])[1]"));
        adultsPluse.click();
        adultsPluse.click();
        WebElement roomPluse =driver.findElement(By.xpath("(.//button[@class=\"bui-button bui-button--secondary bui-stepper__add-button\"])[3]"));
        roomPluse.click();


        WebElement whenAreYouGoing = driver.findElement(By.xpath(".//div[@class='xp__dates xp__group']"));
        whenAreYouGoing.click();

        WebElement ferstData = driver.findElement(By.xpath(".//td[@data-date='" + dateFormat.format(dateStart) + "']"));
        ferstData.click();
        WebElement secondData = driver.findElement(By.xpath(".//td[@data-date='" + dateFormat.format(dataFinish) + "']"));
        secondData.click();
        WebElement whereAreYouGoing = driver.findElement(By.id("ss"));
        whereAreYouGoing.sendKeys("париж");
        whereAreYouGoing.submit();


        List<WebElement> bigBudget = driver.findElements(By.xpath(".//div[@id=\"filter_price\"]//div[@class=\"bui-checkbox__label filter_item css-checkbox\"]"));
        bigBudget.get(bigBudget.size()-1).click();

        WebElement sortHotel = driver.findElement(By.xpath(".//a[@data-category='price']"));
        sortHotel.click();
        Thread.sleep(5000);

        //  List<WebElement> listHotels =  driver.findElements(By.xpath(".//div[@class=\"bui-review-score__badge\"]"));

       // List<WebElement> listHotels = driver.findElements(By.xpath(".//div[@data-score]//div[@class=\"bui-price-display__value prco-inline-block-maker-helper \"]"));
        WebElement findHotel = driver.findElement(By.xpath("(.//a[@class=\"hotel_name_link url\"])[1]"));
        List<WebElement> listHotels = driver.findElements(By.xpath(".//div[@data-score]"));
        for (int i = 0; i < listHotels.size(); i++) {
            if (driver.findElements(By.xpath("(.//div[@data-score])[" + (i + 1) + "]//div[@class=\"bui-price-display__value prco-inline-block-maker-helper \"]")).isEmpty())
            {
            }
            else {
                findHotel = driver.findElement(By.xpath("(.//a[@class=\"hotel_name_link url\"])[" + (i + 1) + "]"));
                break;
            }

        }

        findHotel.click();
        Thread.sleep(5000);



        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        WebElement selectNombers = driver.findElement(By.xpath(".//select[@class='hprt-nos-select']"));
        WebElement maxPiple = driver.findElement(By.xpath("(.//div[@class='hprt-block'])[2]//span[@class='bui-u-sr-only']"));


        Select newSelectNombers = new Select(selectNombers);
int pileInRume = Integer.valueOf(maxPiple.getText().replaceAll("\\D+", ""));

        switch (pileInRume) {
            case 1:newSelectNombers.selectByValue("4");
                break;
            case 2:newSelectNombers.selectByValue("2");
                break;
            case 3:newSelectNombers.selectByValue("2");
                break;
            case 4:newSelectNombers.selectByValue("1");
                break;
            default:newSelectNombers.selectByValue("1");
        }


        Thread.sleep(1000);

        WebElement prise = driver.findElement(By.xpath(".//div[@class='hprt-reservation-total-price']"));





        int actualResult = Integer.valueOf(prise.getText().replaceAll("\\D+", ""));
        int expectedResult = 920*4;
        Assert.assertTrue(expectedResult<actualResult);
        driver.quit();
    }


    @Test
    public void Task3() throws InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long date = new Date().getTime();
        long dateStart = date + (3 * 24 * 3600 * 1000);
        long dataFinish = date + (9 * 24 * 3600 * 1000);
        // System.out.println(dateFormat.format(dateStart)+'+'+dateFormat.format(dataFinish));

        System.setProperty("webdriver.chrome.driver", "D:/Web_drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com/");

        WebElement adultsSelektor = driver.findElement(By.xpath("//*[@id=\"xp__guests__toggle\"]"));
        adultsSelektor .click();

        WebElement adultsPluse =driver.findElement(By.xpath("(.//button[@class=\"bui-button bui-button--secondary bui-stepper__add-button\"])[1]"));
        adultsPluse.click();
        adultsPluse.click();
        WebElement roomPluse =driver.findElement(By.xpath("(.//button[@class=\"bui-button bui-button--secondary bui-stepper__add-button\"])[3]"));
        roomPluse.click();


        WebElement whenAreYouGoing = driver.findElement(By.xpath(".//div[@class='xp__dates xp__group']"));
        whenAreYouGoing.click();

        WebElement ferstData = driver.findElement(By.xpath(".//td[@data-date='" + dateFormat.format(dateStart) + "']"));
        ferstData.click();
        WebElement secondData = driver.findElement(By.xpath(".//td[@data-date='" + dateFormat.format(dataFinish) + "']"));
        secondData.click();
        WebElement whereAreYouGoing = driver.findElement(By.id("ss"));
        whereAreYouGoing.sendKeys("париж");
        whereAreYouGoing.submit();


        List<WebElement> bigBudget = driver.findElements(By.xpath(".//div[@id=\"filter_price\"]//div[@class=\"bui-checkbox__label filter_item css-checkbox\"]"));
        bigBudget.get(bigBudget.size()-1).click();

        WebElement sortHotel = driver.findElement(By.xpath(".//a[@data-category='price']"));
        sortHotel.click();
        Thread.sleep(5000);

        //  List<WebElement> listHotels =  driver.findElements(By.xpath(".//div[@class=\"bui-review-score__badge\"]"));

        // List<WebElement> listHotels = driver.findElements(By.xpath(".//div[@data-score]//div[@class=\"bui-price-display__value prco-inline-block-maker-helper \"]"));
        WebElement findHotel = driver.findElement(By.xpath("(.//a[@class=\"hotel_name_link url\"])[1]"));
        List<WebElement> listHotels = driver.findElements(By.xpath(".//div[@data-score]"));
        for (int i = 0; i < listHotels.size(); i++) {
            if (driver.findElements(By.xpath("(.//div[@data-score])[" + (i + 1) + "]//div[@class=\"bui-price-display__value prco-inline-block-maker-helper \"]")).isEmpty())
            {
            }
            else {
                findHotel = driver.findElement(By.xpath("(.//a[@class=\"hotel_name_link url\"])[" + (i + 1) + "]"));
                break;
            }

        }

        findHotel.click();
        Thread.sleep(5000);



        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        WebElement selectNombers = driver.findElement(By.xpath(".//select[@class='hprt-nos-select']"));
        WebElement maxPiple = driver.findElement(By.xpath("(.//div[@class='hprt-block'])[2]//span[@class='bui-u-sr-only']"));


        Select newSelectNombers = new Select(selectNombers);
        int pileInRume = Integer.valueOf(maxPiple.getText().replaceAll("\\D+", ""));

        switch (pileInRume) {
            case 1:newSelectNombers.selectByValue("4");
                break;
            case 2:newSelectNombers.selectByValue("2");
                break;
            case 3:newSelectNombers.selectByValue("2");
                break;
            case 4:newSelectNombers.selectByValue("1");
                break;
            default:newSelectNombers.selectByValue("1");
        }


        Thread.sleep(1000);
        WebElement  buttonReserve = driver.findElement(By.xpath(".//div[@class=\"hprt-reservation-cta\"]/button"));
        buttonReserve.click();
        Thread.sleep(5000);

        WebElement forWork = driver.findElement(By.xpath("(.//label[@class=\"traveller_type_input_label\"])[2]"));
        forWork.click();
        WebElement lastName =driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
        lastName.sendKeys("TestTester");
        WebElement emailAddress =driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailAddress.sendKeys("TestMail@gmail.com");
        WebElement emailAddressConfirm =driver.findElement(By.xpath("//*[@id=\"email_confirm\"]"));
        emailAddressConfirm.sendKeys("TestMail@gmail.com");
        WebElement nextStep = driver.findElement(By.xpath(".//div[@data-tooltip-class=\"submit_holder_button_tooltip\"]/button"));
        nextStep.click();

        Thread.sleep(5000);

        WebElement phone =driver.findElement(By.xpath("//*[@id=\"phone\"]"));
        phone.sendKeys("30330333");

        WebElement cartType =driver.findElement(By.xpath("//*[@id=\"cc_type\"]"));
        Select newCartType = new Select(cartType);
        newCartType.selectByIndex(3);
        WebElement cartNumd =driver.findElement(By.xpath("//*[@id=\"cc_number\"]"));
        cartNumd.sendKeys("4242424242424242");

        WebElement cartYear =driver.findElement(By.xpath("//*[@id=\"ccYear\"]"));
        Select newCartYear = new Select(cartYear);
        newCartYear.selectByIndex(3);

        WebElement cartMonth =driver.findElement(By.xpath("//*[@id=\"cc_month\"]"));
        Select newCartMonth = new Select(cartMonth);
        newCartMonth.selectByIndex(3);


        WebElement cvc =driver.findElement(By.xpath("//*[@id=\"cc_cvc\"]"));
        cvc.sendKeys("333");

        WebElement bayRooms =driver.findElement(By.xpath("(.//span[@class=\"bp_submit_button__copy\"])[1]"));
        bayRooms.click();


        Thread.sleep(15000);
        WebElement error =driver.findElement(By.xpath(".//div[@class=\"bui-alert bui-alert--error bui-alert--large bui-u-bleed@small\"]"));
        Assert.assertTrue(error.isDisplayed());
        driver.quit();
    }

}
