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

public class Topic17_PopUp {
 WebDriver driver;
 @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
     driver.manage().window().maximize();

 }


//  Fix Popup: User co quyen mo len popup or khong - vi du nhu popup dang nhap, PopUp dang ky
    //Random Popup : User khong co quyen mo popup len
    // - vi quyen mo la do Admin setting, tu dong bat len khi mo page (vi du nhu PopUp quang cao)
    //TH1: No se luon hien thi, minh co the close va action tiep
    //TH2: No khong hien thi

 @Test
  public void TC_01_NgoaiNgu24h() throws InterruptedException {
     driver.get("https://ngoaingu24h.vn/");
     driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
     Thread.sleep(2000);
      By popUpDangky = By.xpath("//div[@id='custom-dialog']");

     Assert.assertTrue(driver.findElement(popUpDangky).isDisplayed());

     driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("automationfc");
     driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("123456");
     driver.findElement(By.xpath("//div[@id='custom-dialog']//button[@type='submit']")).click();
     Thread.sleep(2000);
     Assert.assertEquals(driver.findElement(By.cssSelector("div.SnackbarItem-message")).getText(),"Bạn đã nhập sai tài khoản hoặc mật khẩu!");

     driver.findElement(By.cssSelector("button.MuiButtonBase-root.close-btn")).click();
     Thread.sleep(3000);

     Assert.assertEquals(driver.findElements(popUpDangky).size(),0);

 }

 @Test
 public void TC_02_KynaEnglish() throws InterruptedException {

     driver.get("https://skills.kynaenglish.vn/dang-nhap");

     By popupKyna = By.cssSelector("div#k-popup-account-login");

     Assert.assertTrue(driver.findElement(popupKyna).isDisplayed());

     driver.findElement(By.cssSelector("input#user-login")).sendKeys("phuong123");
     driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456");
     driver.findElement(By.cssSelector("button#btn-submit-login")).click();
     Thread.sleep(2000);

     Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(),"Sai tên đăng nhập hoặc mật khẩu");

 }

 @Test
    public void TC_03_tiki() throws InterruptedException {
     driver.get("https://tiki.vn/");

     By popupTiki = By.cssSelector("div#VIP_BUNDLE");

     Assert.assertTrue(driver.findElement(popupTiki).isDisplayed());

     driver.findElement(By.xpath("//img[@alt='close-icon']")).click();

     Thread.sleep(2000);

     Assert.assertEquals(driver.findElements(popupTiki).size(),0);

     driver.findElement(By.xpath("//span[text()='Tài khoản']")).click();

     By popupDangNhap = By.xpath("//div[@role='dialog']");
     Assert.assertTrue(driver.findElement(popupDangNhap).isDisplayed());

     driver.findElement(By.cssSelector("p.login-with-email")).click();
     Thread.sleep(2000);

     driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
     Thread.sleep(2000);

     Assert.assertEquals(driver.findElement(By.xpath("//span[@class='error-mess'][1]")).getText(),"Email không được để trống");
     Assert.assertEquals(driver.findElement(By.xpath("//span[@class='error-mess'][2]")).getText(),"Mật khẩu không được để trống");
     driver.findElement(By.cssSelector("img.close-img")).click();
     Thread.sleep(2000);

     Assert.assertEquals(driver.findElements(popupDangNhap).size(),0);

    }

    // Random Popup
    @Test
    public void TC_04_RandonPopUp() throws InterruptedException {
        driver.get("https://www.javacodegeeks.com/");

        By popUpBook = By.xpath("//div[contains(@data-title,'Newsletter') and not(contains(@style,'display:none'))]");

        if(driver.findElements(popUpBook).size()>0 && driver.findElements(popUpBook).get(0).isDisplayed()){
            driver.findElement(By.xpath("//div[contains(@data-title,'Newsletter') and not(contains(@style,'display:none'))]//a[@onclick='return lepopup_close();']")).click();
            Thread.sleep(2000);

        }

        driver.findElement(By.cssSelector("input#search-input")).sendKeys("selenium");
        driver.findElement(By.cssSelector("button#search-submit")).click();
        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.cssSelector("header h1.page-title")).isDisplayed());
    }

    @Test
    public void TC_05_RandonPopUp() throws InterruptedException {
        driver.get("https://vnk.edu.vn/");

        By popUpAd = By.cssSelector("div.popmake-content");
        if(driver.findElements(popUpAd).size()>0 && driver.findElements(popUpAd).get(0).isDisplayed()){
            driver.findElement(By.cssSelector("button.popmake-close")).click();
            Thread.sleep(2000);

        }

        driver.findElement(By.xpath("//div[@class='navbar-collapse collapse']//a[text()='Liên hệ']")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Liên hệ']")).isDisplayed());

    }
    @Test
    public void TC_06_RandonPopUp() throws InterruptedException {
        driver.get("https://dehieu.vn/");

        By popupDehieu =By.cssSelector("div.modal-content");

        if(driver.findElements(popupDehieu).size()>0&&driver.findElements(popupDehieu).get(0).isDisplayed()){
            driver.findElement(By.cssSelector("button.close")).click();
            Thread.sleep(2000);
        }

        driver.findElement(By.cssSelector("input.search-form")).sendKeys("Thiết kế tủ điện");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.xpath("//a[@title='Thiết kế tủ điện']")).isDisplayed());



    }


 @AfterClass
    public void clearBrowser(){

     //driver.quit();
 }
}
