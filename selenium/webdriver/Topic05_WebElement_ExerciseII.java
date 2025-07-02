package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic05_WebElement_ExerciseII {
 WebDriver driver;

    @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();

 }

 @Test
  public void TC_01_EmptyEmail(){

     driver.get("http://live.techpanda.org/");
     driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

     WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
     email.sendKeys("");

     WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
     password.sendKeys("");

     WebElement loginButton = driver.findElement(By.xpath("//button[@title='Login']"));
     loginButton.click();

     Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(),"This is a required field.");

     Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(),"This is a required field.");


 }

 @Test
 public void TC_02_InvalidEmail(){

     driver.get("http://live.techpanda.org/");
     driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

     WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
     email.sendKeys("abc@123.7yg");

     WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
     password.sendKeys("123456");

     WebElement loginButton = driver.findElement(By.xpath("//button[@title='Login']"));
     loginButton.click();

     Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");

 }

 @Test
    public void TC_03_passwordLess6Characters(){
     driver.get("http://live.techpanda.org/");
     driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

     WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
     email.sendKeys("abc@123.com");

     WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
     password.sendKeys("1234");

     WebElement loginButton = driver.findElement(By.xpath("//button[@title='Login']"));
     loginButton.click();

     Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");

 }

    @Test
    public void TC_04_IncorrectEmail(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("automation@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
        password.sendKeys("123123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@title='Login']"));
        loginButton.click();

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(),"Invalid login or password.");


    }

    @Test
    public void TC_04_RegisterAccount(){
        driver.get("https://login.mailchimp.com/signup/");

    }


    @AfterClass
    public void clearBrowser(){
     //driver.quit();
 }
}
