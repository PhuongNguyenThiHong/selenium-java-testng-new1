package testNG;

import Listener.ScreenShort;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

@Listeners(ScreenShort.class)
public class Topic10_Listener {
    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    Random rand;
    String firstName, lastName, emailAddress, password, fullName;


    @BeforeClass
    public void initialBrowser() throws FileNotFoundException {
        driver = new FirefoxDriver();
        rand = new Random();

        firstName = "Joe";
        lastName = "Biden";
        fullName = firstName + " " + lastName;
        password = "123456789";

    }

    @Test
    public void TC_01_Register() throws InterruptedException {
        driver.get("http://live.techpanda.org/index.php/");

        emailAddress = "joebiden" + rand.nextInt(99999) + "@gmail.com";

        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);

        driver.findElement(By.cssSelector("button[title='Register']")).click();

        // Tuyệt đối
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "Thank you for registering with Main Website");

        String contactInformationText = driver.findElement(By.xpath(
                "//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();

        // Tương đối
        Assert.assertTrue(contactInformationText.contains(fullName) && contactInformationText.contains(emailAddress));

        driver.findElement(By.xpath("//h3[text()='Contact Information']/following-sibling::a")).click();

        Assert.assertEquals(driver.findElement(By.id("firstname")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.id("lastname")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("value"), emailAddress);

        // Logout
        driver.findElement(By.cssSelector("div.account-cart-wrapper>a")).click();

        driver.findElement(By.xpath("//a[@title='Log Out']")).click();

        System.out.println("Email Address: " + emailAddress);
        System.out.println("Password: " + password);


    }

    @AfterClass
    public void afterClass() throws IOException {

        driver.quit();
    }
}