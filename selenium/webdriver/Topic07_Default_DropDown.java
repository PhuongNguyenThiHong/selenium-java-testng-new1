package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.util.List;
import java.util.Random;

public class Topic07_Default_DropDown {
 WebDriver driver;
 String email, firstname,lastname, ten,password,confirmpass;
 Random random;
 Select select;

 @BeforeClass
  public void initialBrowsers(){

     //Default_DropDown: thi su dung cac the select/option
     driver = new FirefoxDriver();
     random = new Random();
     email = "phuong"+random.nextInt(999999)+"@gmail.com";
     firstname="phuong";
     lastname="nguyen";
     ten=firstname+" "+lastname;
     password="123456";
     confirmpass="123456";


 }

 @Test
  public void TC_01(){
     driver.get("https://www.facebook.com/r.php?entry_point=login");

     //Wait cho Dropdown xuat hien
     select = new Select(driver.findElement(By.xpath("//select[@id='day']")));
     //Chon 1 item
     select.selectByValue("25");

     //Assert verify xem da duoc chon dung hay chua
     Assert.assertEquals(select.getFirstSelectedOption().getText(),"25");

     //xem xem Dropdown co tra ve multiple hay khong
     //tra ve true --> multiple
     //tra ve fail --->single
     Assert.assertFalse(select.isMultiple());

     //kiem tra xem co bao nhieu option
     Assert.assertEquals(select.getOptions().size(),31);

     select = new Select (driver.findElement(By.xpath("//select[@id='month']")));
     select.selectByVisibleText("Apr");
     Assert.assertEquals(select.getFirstSelectedOption().getText(),"Apr");

     select = new Select (driver.findElement(By.xpath("//select[@id='year']")));
     select.selectByVisibleText("2000");
     Assert.assertEquals(select.getFirstSelectedOption().getText(),"2000");

 }

 @Test
 public void TC_02_NopComer(){
     driver.get("https://demo.nopcommerce.com/register");
     //
     driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstname);
     driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastname);
     driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
     driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
     driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(confirmpass);

     driver.findElement(By.xpath("//button[@id='register-button']")).click();
     ///
     Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(),"Your registration completed");

     //
     driver.findElement(By.xpath("//a[@class='ico-account']")).click();

     Assert.assertEquals(driver.findElement(By.xpath("//input[@id='FirstName']")).getAttribute("value"),firstname);
     Assert.assertEquals(driver.findElement(By.xpath("//input[@id='LastName']")).getAttribute("value"),lastname);

     Assert.assertEquals(driver.findElement(By.xpath("//input[@id='Email']")).getAttribute("value"),email);
 }

 @Test
    public void TC_03_rode(){
     driver.get("https://www.rode.com/wheretobuy");

     select= new Select(driver.findElement(By.xpath("//select[@id='country']")));

     Assert.assertFalse(select.isMultiple());

     select.selectByVisibleText("Vietnam");

     driver.findElement(By.xpath("//input[@id='map_search_query']")).sendKeys("HO CHI MINH");

     driver.findElement(By.xpath("//button[text()='Search']")).click();

     List<WebElement> dealer = driver.findElements(By.xpath("//h3[text()='Dealers']/following-sibling::div//h4"));

     Assert.assertEquals(dealer.size(),16);

     for ( WebElement element1 : dealer){
         System.out.println(element1.getText());
     }

  //   for (int i = 0; i < dealer.size() ; i++) {

    //     WebElement element = dealer.get(i);

   //      System.out.println(element.getText());
   //  }

    }

 @AfterClass
    public void clearBrowser(){
    // driver.quit();
 }
}
