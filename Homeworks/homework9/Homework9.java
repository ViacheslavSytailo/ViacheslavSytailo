package homework9;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Homework9
{

    WebDriver driver;
    private static final String URL = "https://demoqa.com/";

    @BeforeMethod
    public void setup()
    {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void firstTask()
    {
        driver.get(URL);
        Assert.assertEquals(driver.getCurrentUrl(), URL);
        WebElement banner = driver.findElement(By.xpath("//div[@class='home-banner']"));
        banner.click();

        List<String> newTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(newTab.size() - 1));

        String newUrl = driver.getCurrentUrl();
        Assert.assertEquals(driver.getCurrentUrl(), newUrl);

        Assert.assertEquals(driver.getWindowHandles().size(),2);

    }

    @Test
    public void secondTask()
    {
        driver.get(URL);
        String cardElements = driver.findElement(By.xpath("//*[contains(@class, 'top-card')]//*[contains(text(), 'Elements')]")).getText();
        String cardForms = driver.findElement(By.xpath("//*[contains(@class, 'top-card')]//*[contains(text(), 'Forms')]")).getText();
        String cardAlerts = driver.findElement(By.xpath("//*[contains(@class, 'top-card')]//*[contains(text(), 'Alerts, Frame & Windows')]")).getText();
        String cardWidgets = driver.findElement(By.xpath("//*[contains(@class, 'top-card')]//*[contains(text(), 'Widgets')]")).getText();
        String cardBook = driver.findElement(By.xpath("//*[contains(@class, 'top-card')]//*[contains(text(), 'Book Store Application')]")).getText();

        Assert.assertEquals(cardElements, "Elements");
        Assert.assertEquals(cardForms, "Forms");
        Assert.assertEquals(cardAlerts, "Alerts, Frame & Windows");
        Assert.assertEquals(cardWidgets, "Widgets");
        Assert.assertEquals(cardBook, "Book Store Application");
    }

    @Test
    public void thirdTask() throws InterruptedException {

        String userName = "Viacheslav";
        String userEmail = "testmail@testmail.com";
        String currentAddress = "adress 1";
        String permanentAddress = "adress 1";
        driver.get(URL);
        WebElement ads = driver.findElement(By.id("adplus-anchor"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", ads);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)");
        WebElement elements = driver.findElement(By.xpath("//*[contains(h5,'Elements')]"));
        elements.click();
        WebElement textbox = driver.findElement(By.xpath("//*[@class = 'btn btn-light '][@id = 'item-0']"));
        textbox.click();
        driver.findElement(By.xpath("//*[@class = 'col-md-9 col-sm-12']/input[@id = 'userName']")).sendKeys(userName);
        driver.findElement(By.xpath("//*[@class = 'col-md-9 col-sm-12']/input[@id = 'userEmail']")).sendKeys(userEmail);
        driver.findElement(By.xpath("//*[@class = 'col-md-9 col-sm-12']/textarea[@id = 'currentAddress']")).sendKeys(currentAddress);
        driver.findElement(By.xpath("//*[@class = 'col-md-9 col-sm-12']/textarea[@id = 'permanentAddress']")).sendKeys(permanentAddress);
        driver.findElement(By.xpath("//button[contains(@id, 'submit')]")).click();

        Map<String, String> map = new HashMap<>();
        List<WebElement> myTextCheck = driver.findElements(By.xpath("//div[contains(@class, 'border col-md-12 col-sm-12')]/p"));
        for (WebElement element : myTextCheck)
        {
            map.put(element.getText().split(":")[0], element.getText().split(":")[1]);
        }
        Assert.assertEquals(map.containsValue(userName), true);
        Assert.assertEquals(map.containsValue(userEmail), true);
        Assert.assertEquals(map.containsValue(currentAddress), true);
        Assert.assertEquals(map.containsValue(permanentAddress), true);

    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

}









