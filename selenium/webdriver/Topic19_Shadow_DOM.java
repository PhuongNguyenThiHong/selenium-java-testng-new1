package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic19_Shadow_DOM {
 WebDriver driver;
 @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.manage().window().maximize();

 }

 @Test
  public void TC_01(){

     //Khong apply voi xpath. chi voi css
     driver.get("https://automationfc.github.io/shadow-dom");

     //Lay ra shadow host thu 1
     WebElement firstShadowHost = driver.findElement(By.cssSelector("div#shadow_host"));
     // Lay ra Element shadow root thu 1
     SearchContext firstShadowRoot = firstShadowHost.getShadowRoot();

     WebElement firstContent = firstShadowRoot.findElement(By.cssSelector("span.info"));
     Assert.assertEquals(firstContent.getText(),"some text");

     //Lay ra shadow host thu 2
     WebElement secondShadowHost= firstShadowRoot.findElement(By.cssSelector("div#nested_shadow_host"));
     //Lay ra Element shadow Root thu 2
     SearchContext secondShadowRoot =secondShadowHost.getShadowRoot();
     Assert.assertEquals(secondShadowRoot.findElement(By.cssSelector("div#nested_shadow_content>div")).getText(),"nested text");

     firstShadowRoot.findElement(By.cssSelector("input[type='text']")).sendKeys("phuong xinh gai");

     Assert.assertTrue(firstShadowRoot.findElement(By.cssSelector("a[href='scroll.html']")).isDisplayed());


 }

 @Test
 public void TC_02() throws InterruptedException {
     driver.get("https://books-pwakit.appspot.com/");
     Thread.sleep(5000);

     WebElement fristShadowHost = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']"));
     SearchContext firstShadowRoot =fristShadowHost.getShadowRoot();
     firstShadowRoot.findElement(By.cssSelector("input#input")).sendKeys("Harry Portter");

     WebElement secondShadowHost= firstShadowRoot.findElement(By.cssSelector("book-input-decorator"));
     SearchContext secondShadowRoot=secondShadowHost.getShadowRoot();

     secondShadowRoot.findElement(By.cssSelector("div.icon")).click();
     Thread.sleep(5000);

     WebElement thirdShadowHost= firstShadowRoot.findElement(By.cssSelector("book-explore._page"));
     SearchContext thirdShadowRoot=thirdShadowHost.getShadowRoot();
     Thread.sleep(2000);

     WebElement fourShadowHost= thirdShadowRoot.findElement(By.cssSelector("ul>li:nth-of-type(1)>book-item"));
     SearchContext fourShadowRoot=fourShadowHost.getShadowRoot();

     Assert.assertEquals(fourShadowRoot.findElement(By.cssSelector("h2.title")).getText(),"Harry Potter and the Sorcerer's Stone");









 }

 @Test
    public void TC_03(){


    }

 @AfterClass
    public void clearBrowser(){

     //driver.quit();
 }
}
