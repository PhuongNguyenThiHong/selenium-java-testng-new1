package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic25_ExplicitWait_Ajax {
 WebDriver driver;

 WebDriverWait explicitWait;
 @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();
     explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));

     driver.manage().window().maximize();

 }

 //Chay loading = 5
    //voi cac ham tra ra tham so By thi se chi apply Explicit. Vi du: visibilityOfElementLocated(By.cssSelector("div#finish>h4"))
    //Voi cac ham tra ra WebElement cu the la co find Element thi se apply Implicit truoc va Explicit


 @Test
 public void TC_01_Calender_Ajax(){

     driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

     Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#ctl00_ContentPlaceholder1_Panel1"))).isDisplayed());

     By selectDate = By.cssSelector("span#ctl00_ContentPlaceholder1_Label1");

     Assert.assertTrue( explicitWait.until(ExpectedConditions.textToBe(selectDate,"No Selected Dates to display.")));

     explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td/a[text()='19']"))).click();

     explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("body.qsf-body>div.RadAjax")));

     Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe(selectDate,"Thursday, June 19, 2025")));

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
