package homework11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Homework11 {
    WebDriver driver;
    private static final String URL = "https://demoqa.com/";

    @BeforeMethod
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", Paths.get("target").toFile().getAbsolutePath());
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

    }

    @Test
    public void downloadUpload() {
        driver.get(URL);
        WebElement ads = driver.findElement(By.id("adplus-anchor"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", ads);
        jsExecutor.executeScript("window.scrollBy(0,900)");
        driver.findElement(By.xpath("//*[contains(h5,'Elements')]")).click();
        driver.findElement(By.xpath("//*[@class = 'element-group'][1]//*[@id='item-7']")).click();
        driver.findElement(By.id("downloadButton")).click();
        File file = new File("target/sampleFile.jpeg");
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(3));
        wait.until( x -> file.exists());
        //Заюзав цей метод очікування, оскільки без очікувань мій файл лишається в форматі .crdownload(не встигає захешуватись)
        // Ну і Thread.sleep ми в цьому ДЗ не використовуємо, а явні очікування з лекції ми заюзати не можемо(нема підв'язки під веб, проблема в очікуванні вже підвантаження файлу на локальній машині), то використав от це цікаве рішення.
        driver.findElement(By.id("uploadFile")).sendKeys(file.getAbsolutePath());
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

}
