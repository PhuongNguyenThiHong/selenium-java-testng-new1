package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic18_Window_Tab {
 WebDriver driver;
 Select select;
 @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.manage().window().maximize();

 }

 @Test
  public void TC_01_2Tab() throws InterruptedException {
     driver.get("https://automationfc.github.io/basic-form/index.html");
     String githubId= driver.getWindowHandle();
     System.out.println("Github id la: "+githubId);

     driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();

     switchToWindowById(githubId);

     driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("java selenium nhe");

     String googleWindownId= driver.getWindowHandle();

     switchToWindowById(googleWindownId);

     driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
     Thread.sleep(2000);

     switchToWindowByTitle("Facebook – log in or sign up");

     driver.findElement(By.cssSelector("input#email")).sendKeys("phuong@gmail.com");

     switchToWindowByTitle("Selenium WebDriver");

     driver.findElement(By.xpath("//a[text()='LAZADA']")).click();
     Thread.sleep(2000);

     closeWindowByID(githubId);


 }


    private void closeWindowByID(String fristWindow) throws InterruptedException {
        Set <String> allWindownIDs =driver.getWindowHandles();
        for (String id :allWindownIDs){
            if(!id.equals(fristWindow)){
                driver.switchTo().window(id);
                Thread.sleep(2000);
                driver.close();
            }
        }

        driver.switchTo().window(fristWindow);
    }


    private void switchToWindowByTitle(String expectedTitle) {
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id: allWindowIDs){
            driver.switchTo().window(id);
            String pageTitle= driver.getTitle();
            if(pageTitle.equals(expectedTitle)){
                break;

            }
        }
    }

    private void switchToWindowById (String windownId) {
        Set<String> allWindows = driver.getWindowHandles();
        for(String id: allWindows){
               if(!id.equals(windownId)) {
                   driver.switchTo().window(id);
               }
        }
    }

    @Test
 public void TC_02_openTabPanda() throws InterruptedException {
     driver.get("http://live.techpanda.org/");
     driver.findElement(By.xpath("//a[text()='Mobile']")).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//a[text()='Sony Xperia']//parent::h2[@class='product-name']" +
             "//following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg")).getText(),"The product Sony Xperia has been added to comparison list.");
     driver.findElement(By.xpath("//a[text()='Samsung Galaxy']//parent::h2[@class='product-name']" +
             "//following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();

        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg")).getText(),"The product Samsung Galaxy has been added to comparison list.");

     driver.findElement(By.cssSelector("button[title='Compare']")).click();
        Thread.sleep(2000);

     switchToWindowByTitle("Products Comparison List - Magento Commerce");
     driver.findElement(By.cssSelector("button[title='Close Window']")).click();
        Thread.sleep(2000);

        switchToWindowByTitle("Mobile");

        driver.findElement(By.xpath("//a[text()='Clear All']")).click();

        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg")).getText(),"The comparison list was cleared.");


 }

 @Test
    public void TC_03_openTabCambride() throws InterruptedException {
     driver.get("https://dictionary.cambridge.org/vi/");

     driver.findElement(By.cssSelector("span.cdo-login-button")).click();

     Thread.sleep(2000);

     switchToWindowByTitle("Login");

     driver.findElement(By.cssSelector("input[value='Log in']")).click();

     Thread.sleep(2000);
     Assert.assertEquals(driver.findElement(By.xpath("//input[@aria-label='Email']//following-sibling::span[@data-bound-to='loginID']")).getText()
             ,"This field is required");


     Assert.assertEquals(driver.findElement(By.xpath("//input[@aria-label='Password']//following-sibling::span[@data-screenset-roles='instance']")).getText()
             ,"This field is required");

     driver.close();
     Thread.sleep(2000);

     switchToWindowByTitle("Cambridge Dictionary | Từ điển tiếng Anh, Bản dịch & Từ điển từ đồng nghĩa");

     driver.findElement(By.cssSelector("input[aria-label='Tìm kiếm']")).sendKeys("automation");
     driver.findElement(By.cssSelector("button[title='Tìm kiếm']")).click();
     Thread.sleep(2000);

     Assert.assertEquals(driver.findElement(By.cssSelector("div#cald4-1~div.pos-header span[class='hw dhw']")).getText(),"automation");

    }

    @Test
    public void TC_04_Testcase16() throws InterruptedException {
        driver.get("https://courses.dce.harvard.edu/");
        String parentId= driver.getWindowHandle();
        System.out.println("Github id la: "+parentId);
        driver.findElement(By.cssSelector("a[data-action='login']")).click();
        Thread.sleep(6000);

       switchToWindowById(parentId);

        //switchToWindowByTitle("Harvard Division of Continuing Education Login Portal");
        String childTitle =driver.getTitle();
        System.out.println("child Titlte: "+childTitle);
        //Harvard Division of Continuing Education Login Portal

        String childID= driver.getWindowHandle();
        System.out.println("child id la: "+childID);
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@title='Harvard DCE']//following-sibling::h1")).getText(),
                "DCE Login Portal");

        driver.close();
        Thread.sleep(3000);
        switchToWindowByTitle("DCE Course Search");
        //81ead0d6-a691-440e-97d0-afc3e3a88192
         Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("p.sam-wait__message")).getText(),"Authentication was not successful. Please try again.");

        driver.findElement(By.cssSelector("button.sam-wait__close")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("input.form-control")).sendKeys("Data Science: An Artificial Ecosystem");

        select = new Select(driver.findElement(By.cssSelector("select#crit-summer_school")));
        select.selectByVisibleText("Harvard College");

        driver.findElement(By.cssSelector("button#search-button")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("span.result__title")).getText(),"Data Science: An Artificial Ecosystem");

    }

 @AfterClass
    public void clearBrowser(){
     //driver.quit();
 }
}
