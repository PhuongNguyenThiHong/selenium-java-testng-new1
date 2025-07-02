package payment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Topic01_Payment {
 WebDriver driver;

 @Test(groups={"payment", "regression"})
  public void TC_01_Payment(){

     System.out.println("Run TC_01_Payment");

 }

 @Test(groups={"payment", "regression"})
 public void TC_02_Payment(){

     System.out.println("Run TC_02_Payment");

 }

 @Test(groups={"payment", "regression"})
    public void TC_03_Payment(){
     System.out.println("Run TC_03_Payment");

    }


}
