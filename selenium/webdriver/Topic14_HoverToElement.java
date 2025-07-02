package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic14_HoverToElement {
 WebDriver driver;
 Actions action;
 @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();
     action = new Actions(driver);
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
     driver.manage().window().maximize();

 }

 @Test
  public void TC_01() throws InterruptedException {
     driver.get("https://automationfc.github.io/jquery-tooltip/");

     action.moveToElement(driver.findElement(By.xpath("//input[@id='age']")));
     action.perform();

     Thread.sleep(2000);

     By tooltip=By.xpath("//div[@class='ui-tooltip-content']");

     Assert.assertEquals(driver.findElement(tooltip).getText(),"We ask for your age only for statistical purposes.");

 }

 @Test
 public void TC_02_MovetoElement_Kids()throws InterruptedException{
     driver.get("https://www.myntra.com/");
     WebElement tooltipKids= driver.findElement(By.xpath("//a[@class='desktop-main' and text()='Kids']"));
     action.moveToElement(tooltipKids).perform();
     Thread.sleep(2000);
     WebElement bathRoom =driver.findElement(By.xpath("//a[@class='desktop-categoryName' and text()='Home & Bath']"));

     action.click(bathRoom).perform();
     Thread.sleep(2000);
     Assert.assertEquals(driver.findElement(By.xpath("//span[@class='breadcrumbs-crumb']")).getText(),"Kids Home Bath");

 }

 @Test
    public void TC_03_MoveToFasha() throws InterruptedException {
     driver.get("https://www.fahasa.com/");
     WebElement tooltipMenu =driver.findElement(By.xpath("//span[@class='icon_menu']"));

     action.moveToElement(tooltipMenu).perform();
     Thread.sleep(2000);

     WebElement tooltipSach=driver.findElement(By.xpath("//div[@class='fhs_menu_content fhs_column_left']//span[text()='VĂN HỌC']"));
     action.click(tooltipSach).perform();
     Thread.sleep(2000);

     Assert.assertEquals
             (driver.findElement(By.xpath("//a[text()='Sách tiếng Việt']/parent::li//following-sibling::li/strong")).getText(),
             "VĂN HỌC");

    }

 @AfterClass
    public void clearBrowser(){
    // driver.quit();
 }
}
