package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic12_Alerts {
 WebDriver driver;
 WebDriverWait explicitWait;
 @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();
     explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.manage().window().maximize();

 }

 @Test
  public void TC_01_Accept_Alert(){
     driver.get("https://automationfc.github.io/basic-form/index.html");
     driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();


     Alert alert =driver.switchTo().alert();

     Assert.assertEquals(alert.getText(),"I am a JS Alert");

     alert.accept();

     Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),"You clicked an alert successfully");


 }

 @Test
 public void TC_02_Confirm_Alert(){
     driver.get("https://automationfc.github.io/basic-form/index.html");
     driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

     Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());

     Assert.assertEquals(alert.getText(),"I am a JS Confirm");

     alert.dismiss();

     Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),"You clicked: Cancel");

 }

 @Test
    public void TC_03_Prompt_Alert(){
     driver.get("https://automationfc.github.io/basic-form/index.html");
     driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

     Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());

     Assert.assertEquals(alert.getText(),"I am a JS prompt");

     String value ="Toi la Phuong";
     alert.sendKeys(value);
     alert.accept();

     Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),"You entered: "+value);


    }

 @AfterClass
    public void clearBrowser(){
    // driver.quit();
 }
}
