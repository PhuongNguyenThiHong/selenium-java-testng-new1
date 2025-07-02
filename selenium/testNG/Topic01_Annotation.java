package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class Topic01_Annotation {
 WebDriver driver;

 // DÙng nhiều Befor/Afer Test và Befor/Afer Class
 @BeforeClass
  public void beforeClass(){
     System.out.println("Run beforeClass");

 }


    @AfterClass
    public void afterClass(){
        System.out.println("Run afterClass");
    }

 @BeforeMethod
 public void beforeMethod(){
     System.out.println("Run beforeMethod");

 }

 @AfterMethod
    public void afterMethod(){
        System.out.println("Run afterMethod");

    }



    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Run beforeSuite");

    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("Run afterSuite");

    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Run beforeTest");

    }

    @AfterTest
    public void afterTest(){
        System.out.println("Run afterTest");

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


}
