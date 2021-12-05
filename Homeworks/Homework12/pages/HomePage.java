package Homework12.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage
{
    WebDriver driver;

    By formTab = By.xpath("//*[contains(h5, 'Forms')]");
    public static final String URL = "https://demoqa.com/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage()
    {
        driver.get(URL);
    }

    public void adsClear()
    {
        WebElement ads = driver.findElement(By.id("adplus-anchor"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", ads);
        jsExecutor.executeScript("window.scrollBy(0,900)");
    }


    public void clickFormsTab ()
    {
        driver.findElement(formTab).click();
    }
}
