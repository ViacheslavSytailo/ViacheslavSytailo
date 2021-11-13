import homework7.Lucky;
import org.testng.Assert;
import org.testng.annotations.*;

public class LuckyTest {
    Lucky lucky = new Lucky();

    @DataProvider(name="correctArrayData")
    public Object[][] correct()
    {
        return new Object[][] {
                {8},
                {24},
                {84}
        };
    }

    @DataProvider(name="incorrectArrayData")
    public Object[][] incorrect()
    {
        return new Object[][] {
                {15},
                {41},
                {9}
        };
    }

@Test(dataProvider = "correctArrayData")
    public static void testCheckLucky(int number)
{

    Assert.assertEquals((number % 2), 0, "Odd number");
}

    @Test(dataProvider = "incorrectArrayData")
    public static void testCheckLucky1(int number)
    {

        Assert.assertEquals((number % 2), 1, "Odd number");
    }


@BeforeTest
    public void beforeTest()
{
    System.out.println("This is text before each test");
}

    @BeforeSuite
    public void beforeSuit() {
        System.out.println("Before all tests ….");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is text after each test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After all tests ….");
    }
}




