package webdriver;

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

public class Topic24_ExplicitWait {
 WebDriver driver;

 WebDriverWait explicitWait;
 @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();

     driver.manage().window().maximize();

 }

 //Chay loading = 5
    //voi cac ham tra ra tham so By thi se chi apply Explicit. Vi du: visibilityOfElementLocated(By.cssSelector("div#finish>h4"))
    //Voi cac ham tra ra WebElement cu the la co find Element thi se apply Implicit truoc va Explicit


 @Test
 public void TC_01_Less(){

     explicitWait = new WebDriverWait(driver,Duration.ofSeconds(4));

     driver.get("https://automationfc.github.io/dynamic-loading/");
     driver.findElement(By.xpath("//button[text()='Start']")).click();

     explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));

     Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());

 }

 @Test
    public void TC_02_Equal(){

     explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));
     driver.get("https://automationfc.github.io/dynamic-loading/");
     driver.findElement(By.xpath("//button[text()='Start']")).click();


     explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));
     Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());

    }

    @Test
    public void TC_03_Greater(){

        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(30));

        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));
        Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());
    }

    @Test
    public void TC_04(){

        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.xpath("//button[text()='Start']")).click();

     // dung visible: cho cho 1 element xuat hien
      //  explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));

        //Dung invisible: la cho cho 1 element bien mat
       // explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));

        //Dung textToBe: Cho cho co
       explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div#finish>h4"),"Hello World!"));

        Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());

    }



 @AfterClass
    public void clearBrowser(){
    // driver.quit();
 }
}
