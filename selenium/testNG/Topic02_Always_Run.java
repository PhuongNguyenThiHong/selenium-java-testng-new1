package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Topic02_Always_Run {
 WebDriver driver;

 // DÙng nhiều Befor/Afer Test và Befor/Afer Class
 @BeforeClass
  public void beforeClass(){
     driver = new FirefoxDriver();

     driver.get("https://kenh14.vn");

     Assert.assertTrue(false);

 }


 @Test
  public void TC_01(){

     System.out.println("Run TC_01");

 }

 @Test
 public void TC_02(){

     System.out.println("Run TC_02");

 }

 @Test
    public void TC_03(){
     System.out.println("Run TC_03");


    }
    @AfterClass(alwaysRun = true)
    public void afterClass(){

    driver.quit();
    }

}
