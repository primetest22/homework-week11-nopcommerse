package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        WebElement loginLink = driver.findElement(By.xpath("//a[contains(text(),'Log in')]"));
        loginLink.click();

        //this is from requirement
        String expectedMessage = "Welcome, Please Sign In!";

        //find the welcome text element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]\n"));
        String actualMessage = actualMessageElement.getText();

        //validate actual and expected message
        Assert.assertEquals("not navigate to login page", expectedMessage,actualMessage);

    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find the login element and perform click action
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        //find email element and enter text using sendkeys method
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("mayuri.ma24@gmail.com");

        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("nopcommerce");

        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();

        String expectedDisplay = "Log out";

        String actualDisplay =
        driver.findElement(By.className("ico-logout")).getText();
        System.out.println(actualDisplay);

        Assert.assertEquals("Not matching",expectedDisplay,actualDisplay);


    }
    @Test
    public void verifyTheErrorMessage(){

        // Find log in link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        // Find the email field element
        WebElement emailField = driver.findElement(By.id("Email"));
        // Sending email to email field element
        emailField.sendKeys("prime123@gmail.com");

        // Find the password field element
        WebElement passwordField = driver.findElement(By.name("Password"));
        // Sending Password to password field element
        passwordField.sendKeys("Prime123");

        //Find the login button and click on it
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();

        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();

        // Validate actual and expected message
        Assert.assertEquals("Error message not displayed", expectedErrorMessage, actualErrorMessage);
    }

    @After
    public void tearDown(){

        driver.quit();
    }


}
