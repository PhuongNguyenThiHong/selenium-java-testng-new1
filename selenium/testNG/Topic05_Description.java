package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic05_Description {
 WebDriver driver;

 // DÙng nhiều Befor/Afer Test và Befor/Afer Class
 @BeforeClass
  public void beforeClass(){

     System.out.println("beforeClass");

 }


 @Test(description = "Jira 01 - khoi tao tc")
  public void TC_01_ShouldBeCreateTC(){

     System.out.println("ShouldBeCreateTC");

 }

// @Test
 public void TC_02_ShouldBeEditTC(){

     System.out.println("ShouldBeEditTC");

 }

 @Test(enabled = false)
    public void TC_03_ShouldBeViewTC(){
     System.out.println("ShouldBeViewTC");

    }

    @Test
    public void TC_04_ShouldBeDeleteTC(){
        System.out.println("ShouldBeDeleteTC");

    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){

        System.out.println("AfterClass");
    }

}
