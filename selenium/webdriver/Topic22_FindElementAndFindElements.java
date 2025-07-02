package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic22_FindElementAndFindElements {
 WebDriver driver;
 @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();
     driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fregister");
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
     driver.manage().window().maximize();

 }

 @Test
  public void TC_01_FindElement(){

     // Tim thay 1 element
     //Tra ra ngay sau 0.5 s time thay,  khong can doi het time timeOut la 13s neu time thay
    // driver.findElement(By.cssSelector("input#FirstName"));

     //Tim thay nhieu element
     //Tra ve element dau tien
    // driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Phuong xinh gai");

     //Khong tim thay element nao
     //Tra ve Fail case va show Loi: NoSuchElement Exception
     //Tim lai ma thay thi ko cho het timeOut 13s
     //Cu 0.5s lai time lai xem thay khong, tim toi khi het 13 s

     driver.findElement(By.cssSelector("input#RememberMe")).click();

 }

 @Test
 public void TC_02_FindElements(){

     //1. Tim thay 1 element
     //Tra ve kich co size 1 thanh phan

     List<WebElement> listElements = driver.findElements(By.cssSelector("input#FirstName"));
     System.out.println("Kich co size la:"+listElements.size());

     //2. Tim thay nhieu element
     //Tra ve kich co size la n element
     listElements = driver.findElements(By.cssSelector("input[type='text']"));
     System.out.println("Kich co size la:"+listElements.size());

     //3. Khong tim thay element nao
     // Tra ve kich co size la 0 element va ko Danh Fail case
     listElements = driver.findElements(By.cssSelector("input#RememberMe"));
     System.out.println("Kich co size la:"+listElements.size());

 }

 @Test
    public void TC_03(){


    }

 @AfterClass
    public void clearBrowser(){

     //driver.quit();
 }
}
