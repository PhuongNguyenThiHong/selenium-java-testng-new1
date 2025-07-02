package webdriver;

import graphql.com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic27_FluentWait {
 WebDriver driver;
 //KHai bao
 FluentWait<WebDriver> driverFluentWait;
// FluentWait<WebElement> elementFluentWait;
// FluentWait<String> stringFluentWait;

 @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();

     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.manage().window().maximize();

 }

 @Test
  public void TC_01(){
     driver.get("https://live.techpanda.org/index.php/customer/account/login/");

     findElement(By.id("email"));

 }

 @Test
 public void TC_02_DynamicLoading01(){
     driver.get("https://automationfc.github.io/dynamic-loading/");

     findElement(By.cssSelector("div#start>button")).click();

     Assert.assertEquals(getText(By.cssSelector("div#finish>h4")),"Hello World!");


 }

 @Test
    public void TC_03_Dynamic_Loading02(){
     driver.get("https://automationfc.github.io/dynamic-loading/");

     findElement(By.cssSelector("div#start>button")).click();

     Assert.assertTrue(isElementDisplayed(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")));


    }

    @Test
    public void TC_04_CountDown(){
        driver.get("https://automationfc.github.io/fluent-wait/");

        WebElement countdown = findElement(By.xpath("//div[@id='javascript_countdown_time']"));

        Assert.assertTrue(isMatching(countdown));
    }

    public WebElement findElement( By by){
     driverFluentWait = new FluentWait<>(driver);
     driverFluentWait.withTimeout(Duration.ofSeconds(30))
             .pollingEvery(Duration.ofMillis(100))
             .ignoring(NoSuchElementException.class);

     return driverFluentWait.until(new Function<WebDriver, WebElement>() {
         @Override
         public WebElement apply(WebDriver input) {
             return driver.findElement(by);
         }
     });
    }

    public boolean isElementDisplayed(By by){
        driverFluentWait = new FluentWait<>(driver);
        driverFluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElement(by).isDisplayed();
            }
        });
    }

    public boolean isMatching(WebElement element){
        FluentWait<WebElement> elementFluentWait = new FluentWait<>(element);
        elementFluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100));
                //.ignoring(NoSuchElementException.class);

        return elementFluentWait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement element) {
                return element.getText().endsWith("00");
            }
        });
    }

    public boolean isElementDisplayed(WebElement element){
        FluentWait<WebElement> elementFluentWait = new FluentWait<>(element);
        elementFluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        return elementFluentWait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement element) {
                return element.isDisplayed();
            }
        });
    }

    public String getText(By by){
        driverFluentWait = new FluentWait<>(driver);
        driverFluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebDriver, String>() {
            @Override
            public String apply(WebDriver driver) {
                return driver.findElement(by).getText();
            }
        });
    }

 @AfterClass
    public void clearBrowser(){
     //driver.quit();
 }
}
