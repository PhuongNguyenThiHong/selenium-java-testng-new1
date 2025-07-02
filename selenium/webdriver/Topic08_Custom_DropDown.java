package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic08_Custom_DropDown {
 WebDriver driver;
 WebDriverWait explicitWait;
 String email, firstname,lastname, ten,password,confirmpass;
 Random random;
 Select select;

 @BeforeClass
  public void initialBrowsers(){

     //Custom DropDown: la cac the khac select /option: div/ul/li/span,...
     driver = new FirefoxDriver();
     explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
     random = new Random();
     email = "phuong"+random.nextInt(999999)+"@gmail.com";

 }

 @Test
  public void TC_01() throws InterruptedException {

     driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
     selectItemDropDown("Medium","//span[@id='speed-button']","//ul[@id='speed-menu']/li[@class='ui-menu-item']/div");
     Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']//span[@class='ui-selectmenu-text']")).getText(),"Medium");

     selectItemDropDown("5","//span[@id='number-button']","//ul[@id='number-menu']/li[@class='ui-menu-item']/div");
     Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text']")).getText(),"5");

     selectItemDropDown("Mrs.","//span[@id='salutation-button']","//ul[@id='salutation-menu']/li[@class='ui-menu-item']/div");
     Assert.assertEquals(driver.findElement(By.xpath("//span[@id='salutation-button']//span[@class='ui-selectmenu-text']")).getText(),"Mrs.");


 }

 @Test
 public void TC_02_ReVu()throws InterruptedException{
     driver.get("https://mikerodham.github.io/vue-dropdowns/");
     selectItemDropDown("Second Option","//li[@class='dropdown-toggle']","//ul[@class='dropdown-menu']/li/a");
     Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(),"Second Option");

 }

 @Test
    public void TC_03_React() throws InterruptedException {
     driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
     selectItemDropDown("Matt","//div[@class='divider default text']","//div[@class='item']//span");
     Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(),"Matt");

 }

    @Test
    public void TC_04_ReactSearchItem() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        searchItemDropDown("Australia","//input[@class='search']","//div[@role='option']//span");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(),"Australia");

    }

    private void selectItemDropDown(String textItem, String parentLocator, String childLocator) throws InterruptedException {
        // Hanh vi chung cua dropdown
        //1. Cho cho dropDown co the visible len duoc
        //2. Click vào element nao để cho DropDown xo ra
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(parentLocator))).click();
        Thread.sleep(2000);

        //3. Chờ cho all items trong DropDown xổ ra
        //4. Tìm Item đúng vs mong đợi
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childLocator)));
        //5. Click lên item đó
        for(WebElement item :allItems){
            if (item.getText().equals(textItem)){
                item.click();
                break;
            }
        }
    }

    private void searchItemDropDown(String textItem, String parentLocator, String childLocator) throws InterruptedException {
        // Hanh vi chung cua dropdown
        //1. Cho cho dropDown co the visible len duoc
        //2. Click vào element nao để cho DropDown xo ra
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parentLocator))).sendKeys(textItem);
        Thread.sleep(2000);

        //3. Chờ cho all items trong DropDown xổ ra
        //4. Tìm Item đúng vs mong đợi
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childLocator)));
        //5. Click lên item đó
        for(WebElement item :allItems){
            if (item.getText().equals(textItem)){
                item.click();
                break;
            }
        }
    }

 @AfterClass
    public void clearBrowser(){
    // driver.quit();
 }
}
