package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Topic07_Parameter {
    WebDriver driver;
    By emailTextbox = By.cssSelector("input#email");
    By passwordTextbox = By.cssSelector("input#pass");
    By loginButton = By.cssSelector("button#send2");

    String username = "selenium_11_01@gmail.com";
    String password="111111";
    String domainUrl;

    @BeforeClass
    @Parameters({"server","browser"})

    public void beforeClass(String serverName, @Optional("FireFox") String browserName) {

        //Mutiple Server Name

        if(serverName.equalsIgnoreCase("Live")){
            domainUrl ="http://live.techpanda.org";


        } else if (serverName.equalsIgnoreCase("Dev")){
            domainUrl ="http://Dev.techpanda.org";

        } else{
            throw new RuntimeException("Server Name nay khong duoc ho tro");

        }
//Multiple Browser
        switch(browserName){
            case "Chrome":
                driver = new ChromeDriver();
                break;

            case "FireFox":
                driver = new FirefoxDriver();
                break;

            case "Edge":
                driver = new EdgeDriver();
                break;

            default:
                    new RuntimeException("Trinh duyet nay khong duoc ho tro");
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void shouldBeLoginToSystem() {

        driver.get(domainUrl+"/index.php/customer/account/login/");
        driver.findElement(emailTextbox).sendKeys(username);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(loginButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains(username));

        // Mua Hàng

        // Thanh Toán

        // Ship Hàng
        //log out

        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}