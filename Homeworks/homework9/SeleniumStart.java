package homework9;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class SeleniumStart
{

    WebDriver driver;


    @BeforeMethod
    public void setup()
    {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

       WebDriverManager.chromedriver().setup();


    }

    @Test
    public void firstTest()
    {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

}
