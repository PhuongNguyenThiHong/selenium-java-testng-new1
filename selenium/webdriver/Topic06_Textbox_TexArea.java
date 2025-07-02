package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

import static java.lang.Math.random;

public class Topic06_Textbox_TexArea {
 WebDriver driver;
 String email, firstname,lastname, ten;
 Random random;

 @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();
     random = new Random();
     email = "phuong"+random.nextInt(999999)+"@gmail.com";
     firstname="phuong";
     lastname="nguyen";
     ten=firstname+" "+lastname;

 }

 @Test
  public void TC_01(){
     driver.get("http://live.techpanda.org/");
     driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
     driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
     driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstname);
     driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastname);
     driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(email);
     driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
     driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123456");
     driver.findElement(By.xpath("//button[@title='Register']")).click();
////

     Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),"Thank you for registering with Main Website Store.");

     String contactInformation=
             driver.findElement(By.xpath
                     ("//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p")).getText();
     // Tuong doi
     Assert.assertTrue(contactInformation.contains(ten));
     Assert.assertTrue(contactInformation.contains(email));

     //Step 8
     driver.findElement(By.xpath("//a[text()='Mobile']")).click();
     driver.findElement(By.xpath("//h2[@class='product-name']//a[@title='Samsung Galaxy']")).click();
     driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();
//
     driver.findElement(By.xpath("//input[@id='Quality 1_3']")).click();
     driver.findElement(By.xpath("//textarea[@id='review_field']")).sendKeys("Kha tot");
     driver.findElement(By.xpath("//input[@id='summary_field']")).sendKeys("Tot");
     driver.findElement(By.xpath("//button[@title='Submit Review']")).click();
     try {
         Thread.sleep(6000);
     } catch (InterruptedException e) {
         throw new RuntimeException(e);
     }
     //
     Assert.assertEquals(driver.findElement
             (By.xpath("//li[@class='success-msg']//span")).getText(),"Your review has been accepted for moderation.");
     ;
 }

 @Test
 public void TC_02(){


 }

 @Test
    public void TC_03(){


    }

 @AfterClass
    public void clearBrowser(){
    // driver.quit();
 }
}
