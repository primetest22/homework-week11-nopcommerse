package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {

        //find register link element
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        String expectedDisplay = "Register";
        String actualDisplay = driver.findElement(By.xpath("//a[contains(text(),'Register')]")).getText();

        //validate actual and expected message
        Assert.assertEquals("not matching", expectedDisplay, actualDisplay);
    }

    @Test
    public void userSholdRegisterAccountSuccessfully() throws InterruptedException {

        //find element for register link
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();
        //find gender radio button element
        WebElement radioBtn = driver.findElement(By.xpath("//input[@id='gender-male']"));
        radioBtn.click();

        driver.findElement(By.id("FirstName")).sendKeys("Prime");
        driver.findElement(By.id("LastName")).sendKeys("Test");
        //find dropdown element for day using select
        Select listDay = new Select(driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[1]")));
        listDay.selectByVisibleText("1");
        Thread.sleep(1000);
        //find dropdown element for month using select
        Select listMonth = new Select(driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[2]")));
        listMonth.selectByVisibleText("January");
        Thread.sleep(1000);
        ////find dropdown element for year using select
        Select listYear = new Select(driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[3]")));
        listYear.selectByVisibleText("2000");
        Thread.sleep(1000);

        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("jj1212@yahoo.com");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("nopcommerce");

        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys("nopcommerce");

        WebElement registerationLink = driver.findElement(By.id("register-button"));
        registerationLink.click();

        String expectedDisplay = "Your registration completed";
        String actualDisplay = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]")).getText();

        Assert.assertEquals("not matching", expectedDisplay, actualDisplay);

    }

    @After
    public void tearDown() {
        // driver.quit();
    }
}
