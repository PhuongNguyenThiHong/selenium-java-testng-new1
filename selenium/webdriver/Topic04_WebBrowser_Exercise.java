package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic04_WebBrowser_Exercise {
 WebDriver driver;
 @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();

 }

 @Test
  public void TC_01_Url(){
     driver.get("http://live.techpanda.org/");
     driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
     driver.getCurrentUrl();

     Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");

     driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

     Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");

 }

 @Test
 public void TC_02_Title(){
     driver.get("http://live.techpanda.org/");
     driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
     driver.getTitle();

     Assert.assertEquals(driver.getTitle(),"Customer Login");

     driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

     Assert.assertEquals(driver.getTitle(),"Create New Customer Account");

 }

 @Test
    public void TC_03_Navigation(){
     driver.get("http://live.techpanda.org/");
     driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
     driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

     Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");

     driver.navigate().back();

     Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");

     driver.navigate().forward();

     Assert.assertEquals(driver.getTitle(),"Create New Customer Account");

    }

    @Test
    public void TC_04_Get_Page_Source_Code(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));

    }


 @AfterClass
    public void clearBrowser(){

    // driver.quit();
 }
}
