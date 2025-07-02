package webdriver;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic09_Button {
 WebDriver driver;
 @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

 }

 @Test
  public void TC_01(){
     driver.get("https://www.fahasa.com/customer/account/create");

     driver.findElement(By.xpath("//a[text()='Đăng nhập']")).click();

     By loginButton = By.xpath("//button[@class='fhs-btn-login']");

     Assert.assertFalse(driver.findElement(loginButton).isEnabled());

    // String backgroundColorLogin= driver.findElement(loginButton).getCssValue("background-color");
     //Color colorLogin= Color.fromString(backgroundColorLogin);
     //String colorLoginHex= colorLogin.asHex().toUpperCase();
     //System.out.println(colorLoginHex);

     //Assert.assertEquals(colorLoginHex,"#000000");
     Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(),"#000000");

     driver.findElement(By.xpath("//input[@id='login_username']")).sendKeys("abc@gmail.com");
     driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("123456");

     Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(),"#C92127");
     //input[@id='login_username']
     //input[@id='login_password']



 }

 @Test
 public void TC_02(){


 }

 @Test
    public void TC_03(){


    }

 @AfterClass
    public void clearBrowser(){

    // driver.quit()
     ;
 }
}
