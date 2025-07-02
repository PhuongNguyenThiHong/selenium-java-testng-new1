package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic21_Wait_Element_Status {
 WebDriver driver;
 WebDriverWait explicitWait;
 @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();
     explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15));
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
     driver.manage().window().maximize();

 }

 @Test
  public void TC_01_Visible_Display(){
     driver.get("https://alada.vn/tai-khoan/dang-ky.html");


 }

 @Test
 public void TC_02_Invisible_Undisplay(){


 }

 @Test
    public void TC_03_Present(){


    }

    @Test
    public void TC_04_Staleness(){


    }

 @AfterClass
    public void clearBrowser(){

     //driver.quit();
 }
}
