package homework10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class Homework10
{
    WebDriver driver;
    private static final String URL = "https://demoqa.com/";

    @BeforeMethod
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void firstTask()  {
        driver.get(URL);
        WebElement ads = driver.findElement(By.id("adplus-anchor"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", ads);
        jsExecutor.executeScript("window.scrollBy(0,900)");
        driver.findElement(By.xpath("//*[contains(h5, 'Forms')]")).click();
        driver.findElement(By.xpath("//*[@class = 'btn btn-light ']//*[contains(text(), 'Practice Form')]")).click();
        driver.findElement(By.id("firstName")).sendKeys("Octavian");
        driver.findElement(By.id("lastName")).sendKeys("August");
        driver.findElement(By.id("userEmail")).sendKeys("romanempire@spqr.com");
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,100)");
        driver.findElement(By.className("custom-radio")).click();
        driver.findElement(By.id("userNumber")).sendKeys("1234567890");
        WebElement birth = driver.findElement(By.id("dateOfBirthInput"));
        birth.clear();

        WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
        Select monthCombo = new Select(month);
        monthCombo.selectByVisibleText("June");

        WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
        Select yearCombo = new Select(year);
        yearCombo.selectByVisibleText("1993");
        ((JavascriptExecutor) driver).executeScript("scroll(0,200)");
        driver.findElement(By.xpath("//div[contains(text(), '21')]")).click();
        WebElement subjectInp = driver.findElement(By.id("subjectsInput"));
        subjectInp.click();
        subjectInp.sendKeys("English");
        subjectInp.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@class = 'custom-control-label'][contains(text(), 'Music')]")).click();


        File file = new File("C:/Users/38067/Desktop/Automation QA/Project/ViacheslavSytailo/target/Test_image.jpg");
        driver.findElement(By.id("uploadPicture")).sendKeys(file.getAbsolutePath());

        driver.findElement(By.id("currentAddress")).sendKeys("Kyiv, Lomonosova str.");
        System.out.println("Filling 'State' text field");((JavascriptExecutor) driver).executeScript("scroll(0,600)");
        driver.findElement(By.cssSelector("#state")).click();
        WebElement state = driver.findElement(By.xpath("//div[contains(text(), 'NCR')]"));
        Actions action = new Actions(driver);
        action.moveToElement(state).click().build().perform();
        driver.findElement(By.id("city")).click();
        WebElement city = driver.findElement(By.xpath("//div[contains(text(), 'Noida')]"));
        action.moveToElement(city).click().build().perform();
        driver.findElement(By.id("submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class = 'modal-content']")).isDisplayed(), true);
    }

    @Test
    public void secondTask()
    {
        driver.get(URL);
        WebElement ads = driver.findElement(By.id("adplus-anchor"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", ads);
        jsExecutor.executeScript("window.scrollBy(0,900)");
        driver.findElement(By.xpath("//*[contains(h5,'Elements')]")).click();
        driver.findElement(By.cssSelector("#item-1")).click(); // підозрюю що, можливо, не найлаконічніший локатор, але цікаво було з css селекторами погратись
        driver.findElement(By.xpath("//*[@class = 'rct-icon rct-icon-expand-all']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class = 'rct-title'][contains(text(), 'Word File.doc')]")).isSelected(), false);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class = 'rct-title'][contains(text(), 'Excel File.doc')]")).isSelected(), false);
        driver.findElement(By.xpath("//*[@class = 'rct-title'][contains(text(), 'Word File.doc')]")).click();
        //Assert.assertEquals(driver.findElement(By.xpath("//*[@class = 'text-success'][contains(text(), 'downloads')]")).isDisplayed(), true);
        // В умовах задачі вказано: "Перевірити що напис нижче має слово downloads". В моєму випадку при кліку на Word File.doc я бачу повідомлення: You have selected: wordFile
        // Себто елементу downloads, як вказано в задачі, в мене просто немає і тому вказаний тест впаде.
        // Наскільки я розумію, треба було перевірити успішність success flow(в данному випадку повідомлення про успішний вибір чекбокса).
        // Можливо, змінились налаштування сайту, але на свій випадок спеціально прописав ось цю строку, а ту, яка була в умові задачі, приховав:
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class = 'text-success'][contains(text(), 'wordFile')]")).isDisplayed(), true);

    }

    @Test
    public void thirdTask()
    {
        driver.get(URL);
        WebElement ads = driver.findElement(By.id("adplus-anchor"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", ads);
        jsExecutor.executeScript("window.scrollBy(0,900)");
        driver.findElement(By.xpath("//*[contains(h5,'Elements')]")).click();
        driver.findElement(By.xpath("//*[@id = 'item-4']/*[contains(text(), 'Buttons')]")).click();
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(By.id("doubleClickBtn"))).perform();
        Assert.assertEquals(driver.findElement(By.id("doubleClickMessage")).isDisplayed(), true);
        actions.contextClick(driver.findElement(By.id("rightClickBtn"))).perform();
        Assert.assertEquals(driver.findElement(By.id("rightClickMessage")).isDisplayed(),true);
        actions.click(driver.findElement(By.cssSelector(".mt-4 > button:not(#rightClickBtn.btn.btn-primary)"))).perform();
        Assert.assertEquals(driver.findElement(By.id("dynamicClickMessage")).isDisplayed(),true);

    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }


}
