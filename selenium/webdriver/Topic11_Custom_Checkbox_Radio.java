package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic11_Custom_Checkbox_Radio {
 WebDriver driver;
 JavascriptExecutor javaExe ;
 @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();
     javaExe = (JavascriptExecutor) driver;
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.manage().window().maximize();


 }

 @Test
  public void TC_01_Ubunto_CheckBox(){
     driver.get("https://login.ubuntu.com/");
     By inputRadioButton=By.xpath("//input[@id='id_new_user']");
     javaExe.executeScript("arguments[0].click();", driver.findElement(inputRadioButton));

     Assert.assertTrue(driver.findElement(inputRadioButton).isSelected());

     By inputCheckbox = By.xpath("//input[@type='checkbox']");
     javaExe.executeScript("arguments[0].click()", driver.findElement(inputCheckbox));

     Assert.assertTrue(driver.findElement(inputCheckbox).isSelected());

 }

 @Test
 public void TC_02(){

     driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");

     By radioHaNoi = By.xpath("//div[@data-value='Hà Nội']");
     driver.findElement(radioHaNoi).click();
     Assert.assertEquals(driver.findElement(radioHaNoi).getAttribute("aria-checked"),"true");

 }

 @Test
    public void TC_03(){


    }

 @AfterClass
    public void clearBrowser(){

     //driver.quit();
 }
}
