package homework9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LessonExample {
    public class SeleniumStart
    {
        WebDriver driver;
        private static final String URL = "https://demoqa.com/&quot";

        @BeforeMethod
        public void setup()
        {
// System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @Test
        public void firstUITest() throws InterruptedException
        {
            driver.get(URL); // open url
            WebElement cardElements = driver.findElement(By.xpath("//*[contains(@class, 'top-card')]//*[contains(text(), 'Elements')]"));

            cardElements.click();
            WebElement tabElements = driver.findElement(By.xpath("(//div[@class='header-text'])[1]"));
// tabElements.click();
            Thread.sleep(7000);

            WebElement textBox = driver.findElement(By.xpath("//*[@class='element-group']//*[contains(@class, 'show')]//*[@id='item-0']"));
            String text = textBox.getText();
            textBox.click();

            WebElement inputName = driver.findElement(By.id("userName"));
            WebElement submitButton = driver.findElement(By.id("submit"));
            inputName.sendKeys("Dmytro");

            submitButton.submit();

            System.out.println(text);
        }


        @AfterMethod
        public void teardown()
        {
            driver.quit();
        }
    }
}
