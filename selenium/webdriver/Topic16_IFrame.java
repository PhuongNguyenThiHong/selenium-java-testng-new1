package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic16_IFrame {
 WebDriver driver;
 Select select;
 @BeforeClass
  public void initialBrowsers(){
     driver = new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.manage().window().maximize();

 }

 @Test
  public void TC_01_iFrame_FormSite() throws InterruptedException {
     driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

     driver.findElement(By.xpath("//img[@title='Campus-Safety-Survey-Forms-and-Examples']")).click();
     Thread.sleep(2000);

     driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame-one85593366']")));

     new Select(driver.findElement(By.xpath("//select[@id='RESULT_RadioButton-2']")))
             .selectByVisibleText("Sophomore");

     new Select(driver.findElement(By.xpath("//select[@id='RESULT_RadioButton-3']")))
             .selectByVisibleText("South Dorm");

     driver.findElement(By.xpath("//label[text()='Male']")).click();

     driver.switchTo().defaultContent();
     Thread.sleep(4000);
     driver.findElement(By.cssSelector("a.menu-item-login.fs-btn--transparent-white")).click();
     Thread.sleep(4000);

     driver.findElement(By.xpath("//button[@id='login']")).click();
     Thread.sleep(4000);
     Assert.assertEquals(driver.findElement(By.xpath("//div[@id='message-error']")).getText(),"Username and password are both required.");
     

 }

 @Test
 public void TC_02_ToiDiCodeDao(){
     driver.get("https://toidicodedao.com/");

     driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@data-testid='fb:page Facebook Social Plugin']")));

     Assert.assertEquals(driver.findElement(By.xpath("//div[@class='_1drq']")).getText(),"402,047 followers");

 }

 @Test
    public void TC_03_Frame() throws InterruptedException {
     driver.get("https://netbanking.hdfcbank.com/netbanking/");

     driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='login_page']")));

     driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("phuongabc");
     driver.findElement(By.xpath("//a[@class='btn btn-primary login-btn']")).click();

     driver.switchTo().defaultContent();

     Thread.sleep(5000);
     driver.findElement(By.xpath("//input[@id='keyboard']")).sendKeys("123456");
     Thread.sleep(3000);
     driver.findElement(By.xpath("//a[@id='loginBtn']")).click();
     Thread.sleep(3000);

     Assert.assertEquals(driver.findElement(By.cssSelector("p.error-msg")).getText(),"Customer ID/IPIN (Password) is invalid. Please try again.");


    }

 @AfterClass
    public void clearBrowser(){
     //driver.quit();
 }
}
