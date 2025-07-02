package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Topic21_UploadFile {
 WebDriver driver;

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
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.manage().window().maximize();

 }

 @Test
  public void TC_01_UploadSingleFile() throws InterruptedException {
     driver.get("https://blueimp.github.io/jQuery-File-Upload/");

     By uploadFileElement = By.xpath("//input[@type='file']");

     driver.findElement(uploadFileElement).sendKeys(anh1Path);
     Thread.sleep(2000);

     driver.findElement(uploadFileElement).sendKeys(anh2Path);
     Thread.sleep(2000);

     driver.findElement(uploadFileElement).sendKeys(anh3Path);
     Thread.sleep(2000);

     //Verify file duoc Upload len

     Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='anh1.jpeg']")).isDisplayed());
     Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='anh2.jpeg']")).isDisplayed());
     Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='anh3.jpeg']")).isDisplayed());

     //Click button Start

     List<WebElement> startButtons = driver.findElements(By.cssSelector("table.table button.start"));
     for (WebElement startButton :startButtons){
         startButton.click();
     }

     Thread.sleep(2000);

     //Verify upload thanh cong

     Assert.assertTrue(driver.findElement(By.xpath("//a[@title='anh1.jpeg']")).isDisplayed());
     Assert.assertTrue(driver.findElement(By.xpath("//a[@title='anh2.jpeg']")).isDisplayed());
     Assert.assertTrue(driver.findElement(By.xpath("//a[@title='anh3.jpeg']")).isDisplayed());


 }

 @Test
 public void TC_02_UploadMultipleFile() throws InterruptedException {
     driver.get("https://blueimp.github.io/jQuery-File-Upload/");

     By uploadFileElement = By.xpath("//input[@type='file']");

     //Upload 1 lan nhieu file

     driver.findElement(uploadFileElement).sendKeys(anh1Path+"\n"+anh2Path+"\n"+anh3Path);
     Thread.sleep(2000);

     //Verify file duoc Upload len

     Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='anh1.jpeg']")).isDisplayed());
     Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='anh2.jpeg']")).isDisplayed());
     Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='anh3.jpeg']")).isDisplayed());

     //Click button Start

     List<WebElement> startButtons = driver.findElements(By.cssSelector("table.table button.start"));
     for (WebElement startButton :startButtons){
         startButton.click();
     }

     Thread.sleep(2000);

     //Verify upload thanh cong

     Assert.assertTrue(driver.findElement(By.xpath("//a[@title='anh1.jpeg']")).isDisplayed());
     Assert.assertTrue(driver.findElement(By.xpath("//a[@title='anh2.jpeg']")).isDisplayed());
     Assert.assertTrue(driver.findElement(By.xpath("//a[@title='anh3.jpeg']")).isDisplayed());


 }

 @Test
    public void TC_03(){


    }

 @AfterClass
    public void clearBrowser(){
     //driver.quit();
 }
}
