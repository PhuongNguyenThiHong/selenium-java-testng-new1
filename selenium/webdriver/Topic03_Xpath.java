package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic03_Xpath {
 WebDriver driver;
 @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();
     driver.get("https://alada.vn/tai-khoan/dang-ky.html");
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

 }

 @Test
  public void TC_01_EmptyData(){

     //Action
     driver.findElement(By.xpath("//button[@type='submit']")).click();

     //Assert
     Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtFirstname-error']")).getText(),"Vui lòng nhập họ tên");
     Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email");
     Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Vui lòng nhập lại địa chỉ email");
     Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Vui lòng nhập mật khẩu");
     Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Vui lòng nhập lại mật khẩu");
     Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Vui lòng nhập số điện thoại.");
 }

 @Test
 public void TC_02_InvalidEmail(){
     //Action
     driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("hong phuong");
     driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("abc@ers@.cim");
     driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("abc@ers@.cim");//
     driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123456");
     driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123456");
     driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0989878776");
     driver.findElement(By.xpath("//button[@type='submit']")).click();

     //Assert
     Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email hợp lệ");

 }

    @Test
    public void TC_03_IncorrectConfirmData(){
        //Action
        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("hong phuong");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("abc123@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("abc12@gmail.com");//
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0989878776");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Assert
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Email nhập lại không đúng");


    }

    @Test
    public void TC_04_PasswordLess6Characters(){

        //Action
        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("hong phuong");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("abc123@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("abc12@gmail.com");//
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0989878776");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Assert
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");


    }

    @Test
    public void TC_05_IncorrectConfirmPassword(){

        //Action
        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("hong phuong");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("abc123@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("abc12@gmail.com");//
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123458");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0989878776");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Assert
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Mật khẩu bạn nhập không khớp");

    }

    @Test
    public void TC_06_InvalidPhoneNumber(){

        //Action
        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("hong phuong");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("abc123@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("abc12@gmail.com");//
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0989878776");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Assert
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Số điện thoại phải từ 10-11 số.");

    }

 @AfterClass
    public void clearBrowser(){

     //driver.quit();
     
 }
}
