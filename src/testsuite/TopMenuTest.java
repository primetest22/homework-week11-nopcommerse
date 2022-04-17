package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {

        //find computer element
        WebElement computerLink = driver.findElement(By.linkText("Computers"));
        computerLink.click();

        String expectedDisplay = "Computers";
        String actualDisplay = driver.findElement(By.xpath("//h1[contains(text(),'Computers')]")).getText();

        Assert.assertEquals("not matching", expectedDisplay, actualDisplay);

    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully(){

       //find electronics element
        WebElement electronicsLink = driver.findElement(By.linkText("Electronics"));
        electronicsLink.click();

        String expectedDisplay = "Electronics";
        String actualDisplay = driver.findElement(By.xpath("//h1[contains(text(),'Electronics')]")).getText();

        Assert.assertEquals("not matching", expectedDisplay,actualDisplay);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully(){

       //find apparel element
        WebElement electronicsLink = driver.findElement(By.linkText("Apparel"));
        electronicsLink.click();

        String expectedDisplay = "Apparel";
        String actualDisplay = driver.findElement(By.xpath("//h1[contains(text(),'Apparel')]")).getText();

        Assert.assertEquals("not matching", expectedDisplay,actualDisplay);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully(){

        //find digitaldownload element
        WebElement electronicsLink = driver.findElement(By.linkText("Digital downloads"));
        electronicsLink.click();

        String expectedDisplay = "Digital downloads";
        String actualDisplay = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]")).getText();

        Assert.assertEquals("not matching", expectedDisplay,actualDisplay);
    }
    @Test
    public void userShouldNavigateToBooksPageSuccessfully(){

        //find books element
        WebElement electronicsLink = driver.findElement(By.linkText("Books"));
        electronicsLink.click();

        String expectedDisplay = "Books";
        String actualDisplay = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[5]/a[1]")).getText();

        Assert.assertEquals("not matching", expectedDisplay,actualDisplay);
    }
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully(){

        //find jewelry element
        WebElement electronicsLink = driver.findElement(By.linkText("Jewelry"));
        electronicsLink.click();

        String expectedDisplay = "Jewelry";
        String actualDisplay = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[6]/a[1]")).getText();

        Assert.assertEquals("not matching", expectedDisplay,actualDisplay);
    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){

        //find gift cards element
        WebElement electronicsLink = driver.findElement(By.linkText("Gift Cards"));
        electronicsLink.click();

        String expectedDisplay = "Gift Cards";
        String actualDisplay = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]")).getText();

        Assert.assertEquals("not matching", expectedDisplay,actualDisplay);
    }
    @After
    public void tearDown() {

        driver.quit();
    }


}
