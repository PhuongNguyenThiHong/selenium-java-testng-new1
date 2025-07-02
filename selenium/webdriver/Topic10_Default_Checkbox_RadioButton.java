package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic10_Default_Checkbox_RadioButton {
 WebDriver driver;
 @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.manage().window().maximize();

 }

 @Test
  public void TC_01(){
     //Ham IsSelected chi ap dung cho the input
     //CHeck box: can thao tac len the input
     //Custom Checkbox: cung la the input nhung bi an, bi the khac de len, chi khac default la co or khong hien thi
     driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");

     By dualZonecheckbox= By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");
     //selected
     if(!driver.findElement(dualZonecheckbox).isSelected()){
         driver.findElement(dualZonecheckbox).click();
     }
     Assert.assertTrue(driver.findElement(dualZonecheckbox).isSelected());

     //DeSelected
     if(driver.findElement(dualZonecheckbox).isSelected()){
         driver.findElement(dualZonecheckbox).click();
     }
     Assert.assertFalse(driver.findElement(dualZonecheckbox).isSelected());

     driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");

     By petroLocator =By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");
     if(!driver.findElement(petroLocator).isSelected()){
         driver.findElement(petroLocator).click();
     }
     Assert.assertTrue(driver.findElement(petroLocator).isSelected());

 }

 @Test
 public void TC_02(){
     driver.get("https://material.angular.io/components/radio/examples");
     By summerLocator = By.xpath("//input[@value='Summer']");

     if(!driver.findElement(summerLocator).isSelected()){
         driver.findElement(summerLocator).click();
     }
     Assert.assertTrue(driver.findElement(summerLocator).isSelected());


 }

 @Test
    public void TC_03(){

     driver.get("https://material.angular.io/components/checkbox/examples");

     //Checkbox
     By checkBox =By.xpath("//label[text()='Checked']/preceding-sibling::div/input");
     if(!driver.findElement(checkBox).isSelected()){
         driver.findElement(checkBox).click();
     }
     Assert.assertTrue(driver.findElement(checkBox).isSelected());

     By intermediatedCheckBox = By.xpath("//label[text()='Indeterminate']/preceding-sibling::div/input");
     if(!driver.findElement(intermediatedCheckBox).isSelected()){
         driver.findElement(intermediatedCheckBox).click();
     }
     Assert.assertTrue(driver.findElement(intermediatedCheckBox).isSelected());

     //Uncheckbox
     if(driver.findElement(checkBox).isSelected()){
         driver.findElement(checkBox).click();
     }
     Assert.assertFalse(driver.findElement(checkBox).isSelected());

     if(driver.findElement(intermediatedCheckBox).isSelected()){
         driver.findElement(intermediatedCheckBox).click();
     }
     Assert.assertFalse(driver.findElement(intermediatedCheckBox).isSelected());

    }

    @Test
    public void TC_04_Multiple_checkbox(){

        driver.get("https://automationfc.github.io/multiple-fields/");

         List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-checkbox']"));
       // chon all items
         for(WebElement check :checkboxes){
             if (!check.isSelected()){
                 check.click();
             }

         }

         for (WebElement check: checkboxes){
             Assert.assertTrue(check.isSelected());
         }

         //Bo chon all
        for(WebElement check :checkboxes){
            if (check.isSelected()){
                check.click();
            }

        }

        for (WebElement check: checkboxes){
            Assert.assertFalse(check.isSelected());
        }

        //chon 1 items
        driver.findElement(By.xpath("//input[@value='Epilepsy Seizures']")).click();
        driver.findElement(By.xpath("//input[@value='Gallstones']")).click();
        driver.findElement(By.xpath("//input[@value='Tuberculosis']")).click();

    }

 @AfterClass
    public void clearBrowser(){

     //driver.quit();
 }
}
