package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic20_JSExecutor {
 WebDriver driver;
 JavascriptExecutor jsExecutor;
 WebDriverWait explicitWait;
 Random random;
 String email;

 @BeforeClass
  public void initialBrowsers(){
     driver = new ChromeDriver();
     jsExecutor = (JavascriptExecutor) driver;
     explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15));

     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.manage().window().maximize();

     random = new Random();
     email="abc"+random.nextInt(9999)+"@gmail.com";

 }

 @Test
  public void TC_01() throws InterruptedException {

     jsExecutor.executeScript("window.location='https://live.techpanda.org/'");

     explicitWait.until(ExpectedConditions.urlToBe("https://live.techpanda.org/"));
     String domainPanda = (String) jsExecutor.executeScript("return document.domain;");
     Assert.assertEquals(domainPanda,"live.techpanda.org");

     String urlPanda = (String) jsExecutor.executeScript("return document.URL;");
     Assert.assertEquals(urlPanda,"https://live.techpanda.org/");

     explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Mobile']")));

     jsExecutor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[text()='Mobile']")));

     explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(
             "//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button")));
     jsExecutor.executeScript("arguments[0].click();",driver.findElement(By.xpath(
             "//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button")));

     Thread.sleep(3000);

     String samsungText = (String) jsExecutor.executeScript("return document.documentElement.innerText;");

     Assert.assertTrue(samsungText.contains("Samsung Galaxy was added to your shopping cart."));

     //step7:
     jsExecutor.executeScript("arguments[0].click();",driver.findElement(By.xpath(
             "//a[text()='Customer Service']")));

     Thread.sleep(3000);

     jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//input[@id='newsletter']")));
     Thread.sleep(3000);
     jsExecutor.executeScript("arguments[0].setAttribute('value','"+email+"')",driver.findElement(By.xpath("//input[@id='newsletter']")));
     Thread.sleep(3000);
     jsExecutor.executeScript("arguments[0].click();",driver.findElement(By.xpath(
             "//button[@title='Subscribe']")));
     Thread.sleep(3000);

     Alert alert= explicitWait.until(ExpectedConditions.alertIsPresent());
     alert.accept();
     Thread.sleep(3000);

     String thankYouText = (String) jsExecutor.executeScript("return document.documentElement.innerText;");

     Assert.assertTrue(thankYouText.contains("Thank you for your subscription."));

 }

 @Test
 public void TC_02() throws InterruptedException {

     navigateToUrlByJS("https://live.techpanda.org/");

     explicitWait.until(ExpectedConditions.urlToBe("https://live.techpanda.org/"));

     Assert.assertEquals(getDomain(),"live.techpanda.org");

     Assert.assertEquals(getURL(),"https://live.techpanda.org/");

     explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Mobile']")));

     clickToElementByJS("//a[text()='Mobile']");

     explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(
             "//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button")));

     clickToElementByJS("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");

     Thread.sleep(3000);

     Assert.assertTrue(getInnerText().contains("Samsung Galaxy was added to your shopping cart."));

     //step7:
     clickToElementByJS("//a[text()='Customer Service']");

     Thread.sleep(3000);

     scrollToElementOnTop("//input[@id='newsletter']");

     Thread.sleep(3000);
     setAttributeInDOM("//input[@id='newsletter']","value",email);
     Thread.sleep(3000);
     clickToElementByJS("//button[@title='Subscribe']");
     Thread.sleep(3000);

     Alert alert= explicitWait.until(ExpectedConditions.alertIsPresent());
     alert.accept();
     Thread.sleep(3000);

     Assert.assertTrue(getInnerText().contains("Thank you for your subscription."));

 }

 @Test
    public void TC_03_Rode(){
     driver.get("https://account.rode.com/login");

     WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

     //empty email
     loginButton.click();

     String emailMessage = getElementValidationMessage("//input[@id='email']");

     Assert.assertEquals(emailMessage,"Please fill out this field.");

     //invalid Email
     String invalidEmail = "aaa@";

     driver.findElement(By.xpath("//input[@id='email']")).sendKeys(invalidEmail);
     loginButton.click();

     String invalidEmailMessage = getElementValidationMessage("//input[@id='email']");

     if (driver.toString().contains("ChromeDriver")){
         Assert.assertEquals(invalidEmailMessage,"Please enter a part following '@'. 'aaa@' is incomplete.");

     } else {
         Assert.assertEquals(invalidEmailMessage,"Please enter an email address.");
     }




    }

    public Object executeForBrowser(String javaScript) {
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText() {
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(String textExpected) {
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage() {
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void sleepInSecond(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void navigateToUrlByJS(String url) {
        jsExecutor.executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public String getDomain() {
        return (String) jsExecutor.executeScript("return document.domain;");
    }

    public String getURL() {
        return (String) jsExecutor.executeScript("return document.URL;");
    }

    public void hightlightElement(String locator) {
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(String locator) {
        jsExecutor.executeScript("arguments[0].click();", getElement(locator));
        sleepInSecond(3);
    }

    public String getElementTextByJS(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].textContent;", getElement(locator));
    }

    public void scrollToElementOnTop(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void scrollToElementOnDown(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
    }

    public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
    }

    public void sendkeyToElementByJS(String locator, String value) {
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public String getAttributeInDOM(String locator, String attributeName) {
        return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(locator));
    }

    public String getElementValidationMessage(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

    public boolean isImageLoaded(String locator) {
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
        return status;
    }

    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }

 @AfterClass
    public void clearBrowser(){
     //driver.quit();
 }
}
