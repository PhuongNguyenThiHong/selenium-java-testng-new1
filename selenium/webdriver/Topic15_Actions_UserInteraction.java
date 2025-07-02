package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic15_Actions_UserInteraction {
 WebDriver driver;
 Actions actions; //Khai bao
 Keys keys;
 String osName = System.getProperty("os.name");

 @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();
     actions = new Actions(driver); //Khoi tao
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.manage().window().maximize();

     if (osName.startsWith("Window")){
         keys = Keys.CONTROL;
     } else {
         keys=Keys.COMMAND;
     }

 }

 @Test
  public void TC_01_ClickAndHold() throws InterruptedException {
     driver.get("https://automationfc.github.io/jquery-selectable/");

     List<WebElement> elementsAll = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
     Assert.assertEquals(elementsAll.size(),20);

     actions.clickAndHold(elementsAll.get(0)).moveToElement(elementsAll.get(3)).release().perform();
     Thread.sleep(2000);

     List<WebElement> elementsChoice=driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee ui-selected']"));

     Assert.assertEquals(elementsChoice.size(),4);

 }

 @Test
 public void TC_02_ClickAndSelect() throws InterruptedException {
     driver.get("https://automationfc.github.io/jquery-selectable/");
     List<WebElement> elementsAll1 = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
     actions.keyDown(keys).perform();
     Thread.sleep(2000);
     actions.click(elementsAll1.get(1));
     actions.click(elementsAll1.get(4));
     actions.click(elementsAll1.get(8));
     actions.click(elementsAll1.get(2));
     actions.click(elementsAll1.get(11));
     actions.keyUp(keys).perform();
     Thread.sleep(2000);

     List<WebElement> elementsChoice1=driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee ui-selected']"));

     Assert.assertEquals(elementsChoice1.size(),5);


 }

 @Test
    public void TC_03_DoubleClick() throws InterruptedException {

     driver.get("https://automationfc.github.io/basic-form/index.html");
     actions.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform(); //Goi ham
     Thread.sleep(2000);
     Assert.assertEquals(driver.findElement(By.xpath("//p[@id='demo']")).getText(),"Hello Automation Guys!");


    }

 @AfterClass
    public void clearBrowser(){
    // driver.quit();
 }
}
