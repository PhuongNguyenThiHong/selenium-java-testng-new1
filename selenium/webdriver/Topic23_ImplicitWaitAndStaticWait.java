package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic23_ImplicitWaitAndStaticWait {
 WebDriver driver;
 @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();

     driver.manage().window().maximize();

 }

 //Implicit Wait : Wait Ngầm định - Khong ro rang cho 1 trang thai nao cua element
    //Ap dung cho 2 ham FindElement va FindElements

 @Test
  public void TC_01_Dont_set(){
     driver.get("https://automationfc.github.io/dynamic-loading/");
     driver.findElement(By.xpath("//button[text()='Start']")).click();

     Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());

 }

 @Test
 public void TC_02_Less(){
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
     driver.get("https://automationfc.github.io/dynamic-loading/");
     driver.findElement(By.xpath("//button[text()='Start']")).click();

     Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());

 }

 @Test
    public void TC_03_Equal(){

     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     driver.get("https://automationfc.github.io/dynamic-loading/");
     driver.findElement(By.xpath("//button[text()='Start']")).click();

     Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());

    }

    @Test
    public void TC_04_Greater(){

        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());


    }

 @AfterClass
    public void clearBrowser(){
    // driver.quit();
 }
}
