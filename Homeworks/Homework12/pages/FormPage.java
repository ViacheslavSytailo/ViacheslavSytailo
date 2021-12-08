package Homework12.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class FormPage
{
    WebDriver driver;

    By buttonPracticeForm = By.xpath("//*[@class = 'btn btn-light ']//*[contains(text(), 'Practice Form')]");
    By fieldFirstName = By.id("firstName");
    By fieldLastName = By.id("lastName");
    By fieldUserEmail = By.id("userEmail");
    By btnGenderButton = By.className("custom-radio");
    By fieldUserNumber = By.id("userNumber");
    By btnBirth = By.id("dateOfBirthInput");
    By dropdownSubjectInp = By.id("subjectsInput");
    By btnHobbiesButton = By.xpath("//*[@class = 'custom-control-label'][contains(text(), 'Music')]");
    By fieldCurrentAdress = By.id("currentAddress");
    By bntSubmit = By.id("submit");

    public FormPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickButtonPracticeForm ()
    {
        driver.findElement(buttonPracticeForm).click();
    }

    public void setFieldFirstName (String firstName)
    {
        driver.findElement(fieldFirstName).sendKeys(firstName);
    }

    public void setFieldLastName (String lastName)
    {
        driver.findElement(fieldLastName).sendKeys(lastName);
    }

    public void setFieldUserEmail (String userEmail)
    {
        driver.findElement(fieldUserEmail).sendKeys(userEmail);
    }

    public void clickBtnGenderButton ()
    {
        driver.findElement(btnGenderButton).click();
    }

    public void setFieldUserNumber (String userNumber)
    {
        driver.findElement(fieldUserNumber).sendKeys(userNumber);
    }

    public void birthClear ()
    {
        driver.findElement(btnBirth).clear();
    }

    public void setMonth (String inputMonth)
    {
        WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
        Select monthCombo = new Select(month);
        monthCombo.selectByVisibleText(inputMonth);
    }

    public void setYear (String inputYear)
    {
        WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
        Select yearCombo = new Select(year);
        yearCombo.selectByVisibleText(inputYear);
    }
// Для двох методів зверху не вдалося прописати "шаблонно" локатори, оскільки механізм вибору тут специфічний, тому сподіваюсь, що принаймні можливість ввести місяць та рік буде зарахованою:)


    public void setBirthday ()
    {
        driver.findElement(By.xpath("//div[contains(text(), '21')]")).click();
    }
// Цей метод довелося вписати наглухо, оскільки на цьому етапі форма дуже костильна і вставити стрінгу в ікспас не є можливим
// Підозрюю що це якось можна було б провернути, не будь воно на цьому етапі таким проблемним, але поки так, як є :(


    public void clickDropdownSubjectInp ()
    {
        driver.findElement(dropdownSubjectInp).click();
    }

    public void setDropdownSubjectInp (String hobby)
    {
        driver.findElement(dropdownSubjectInp).sendKeys(hobby);
        driver.findElement(dropdownSubjectInp).sendKeys(Keys.ENTER);
    }

    public void clickBtnHobbiesButton ()
    {
        driver.findElement(btnHobbiesButton).click();
    }

    public void fileUploading (String pathname)
    {
        File file = new File(pathname);
        driver.findElement(By.id("uploadPicture")).sendKeys(file.getAbsolutePath());
    }

    public void setFieldCurrentAdress (String adress)
    {
        driver.findElement(fieldCurrentAdress).sendKeys(adress);
    }

    public void setStateAndCity ()
    {
        ((JavascriptExecutor) driver).executeScript("scroll(0,600)"); // довго думав, куди екзек'ютор вставити - вирішив сюди, оскільки цей блок без нього все одно не працюватиме, тому щоб в кожному тесті його не впихувати, лишив тут.
        driver.findElement(By.cssSelector("#state")).click();
        WebElement state = driver.findElement(By.xpath("//div[contains(text(), 'NCR')]"));
        Actions action = new Actions(driver);
        action.moveToElement(state).click().build().perform();
        driver.findElement(By.id("city")).click();
        WebElement city = driver.findElement(By.xpath("//div[contains(text(), 'Noida')]"));
        action.moveToElement(city).click().build().perform();
    }
// тут аналогічна ситуація з датою народження - ми прописуємо значення прямо в ікспасі, так як ви нам на прикладі давали, тому не бачу сенсу їх розділяти і одним суцільним методом їх вніс.

    public void clickSubmit ()
    {
        driver.findElement(bntSubmit).click();
    }









}
