package Homework12.tests;

import Homework12.pages.FormPage;
import Homework12.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormTest
{
    WebDriver driver;
    HomePage homePage;
    FormPage formPage;

    @BeforeTest
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void quit()
    {
        driver.quit();
    }

    @DataProvider
    public Object[][]fillFormsDataProvider()
    {
        return new Object[][]
                {
                        {"Octavian", "August", "romanempire@spqr.com", "1234567890", "June", "1993", "English", "target/Test_image.jpg", "Kyiv, Lomonosova str."}
                };
    }

    @Test(dataProvider = "fillFormsDataProvider")
    public void fillFormsTest(String firstName, String lastName, String userEmail, String userNumber, String inputMonth, String inputYear, String hobby, String pathname, String adress)
    {
        homePage = new HomePage(driver);
        formPage = new FormPage(driver);

        homePage.openPage();
        homePage.adsClear();
        homePage.clickFormsTab();

        formPage.clickButtonPracticeForm();
        formPage.setFieldFirstName(firstName);
        formPage.setFieldLastName(lastName);
        formPage.setFieldUserEmail(userEmail);
        formPage.clickBtnGenderButton();
        formPage.setFieldUserNumber(userNumber);
        formPage.birthClear();
        formPage.setMonth(inputMonth);
        formPage.setYear(inputYear);
        formPage.setBirthday();
        formPage.clickDropdownSubjectInp();
        formPage.setDropdownSubjectInp(hobby);
        formPage.fileUploading(pathname);
        formPage.setFieldCurrentAdress(adress);
        formPage.setStateAndCity();
        formPage.clickSubmit();
    }

}
