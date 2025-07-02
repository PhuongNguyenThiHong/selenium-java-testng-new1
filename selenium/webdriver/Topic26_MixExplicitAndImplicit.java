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

import java.io.File;
import java.time.Duration;

public class Topic26_MixExplicitAndImplicit {
 WebDriver driver;
 WebDriverWait explicitWait;

    String folderPath = System.getProperty("user.dir")+ File.separator+"fileUpload"+File.separator;

    String anh1="anh1.jpeg";
    String anh2="anh2.jpeg";
    String anh3="anh3.jpeg";

    String anh1Path = folderPath+anh1;
    String anh2Path = folderPath+anh2;
    String anh3Path = folderPath+anh3;

 @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
     explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15));
     driver.manage().window().maximize();



 }

 @Test
  public void TC_01() throws InterruptedException {

     driver.get("https://gofile.io/home");

    Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.animate-spin"))));
     By uploadFileElement = By.xpath("//input[@type='file']");

     //Upload 1 lan nhieu file

     driver.findElement(uploadFileElement).sendKeys(anh1Path+"\n"+anh2Path+"\n"+anh3Path);

     Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.animate-spin"))));

     Thread.sleep(2000);

     explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.linkSuccessCard"))).click();


     //Verify file duoc Upload len
     Assert.assertTrue(driver.findElement(By.xpath("//a[@href='javascript:void(0);' and text()='anh1.jpeg']")).isDisplayed());
   Assert.assertTrue(driver.findElement(By.xpath("//a[@href='javascript:void(0);' and text()='anh1.jpeg']")).isDisplayed());
   Assert.assertTrue(driver.findElement(By.xpath("//a[@href='javascript:void(0);' and text()='anh1.jpeg']")).isDisplayed());


 }

 @Test
 public void TC_02(){


 }

 @Test
    public void TC_03(){


    }

 @AfterClass
    public void clearBrowser(){

     //driver.quit();
 }
}
