package product;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic01_Product {
 WebDriver driver;

 @Test(groups={"product", "regression"})
  public void TC_01_Product(){

     System.out.println("Run TC_01_Product");

 }

 @Test(groups={"product", "regression"})
 public void TC_02_Product(){

     System.out.println("Run TC_02_Product");

 }

 @Test(groups={"product", "regression"})
    public void TC_03_Product(){
     System.out.println("Run TC_03_Product");

    }


}
