package webdriver;

import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic05_WebElement_ExerciseI {
 WebDriver driver;

    @BeforeClass
  public void initialBrowsers(){
     driver = new FirefoxDriver();

 }

 @Test
  public void TC_01_Display(){

     driver.get("https://automationfc.github.io/basic-form/index.html");

     WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='email']"));

     if (emailTextbox.isDisplayed()){
         System.out.println("Email textbox is Display");
         emailTextbox.sendKeys("nhuong183@gmai.com");

     } else {
         System.out.println("Email textbox is Not Display");
     }

     WebElement ageUnder18Checkbox = driver.findElement(By.xpath("//input[@id='under_18']"));

     if (ageUnder18Checkbox.isDisplayed()){
         System.out.println("Age Under 18 checkbox is Display");

     } else {
         System.out.println("Age Under 18 is Not Display");
     }


     WebElement educationTextArea = driver.findElement(By.xpath("//textarea[@id='edu']"));

     if (educationTextArea.isDisplayed()){
         System.out.println("Education TextArea is Display");

     } else {
         System.out.println("Education TextArea is Not Display");
     }

     WebElement user5Text = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
     if (user5Text.isDisplayed()){
         System.out.println("user5Text is Display");

     } else {
         System.out.println("user5Text is Not Display");
     }

 }

 @Test
 public void TC_02_Enabled_Disabled(){

     driver.get("https://automationfc.github.io/basic-form/index.html");
     WebElement ageUnder18Checkbox = driver.findElement(By.xpath("//input[@id='under_18']"));

     if (ageUnder18Checkbox.isEnabled()){
         System.out.println("Age Under 18 checkbox is enabled");

     } else {
         System.out.println("Age Under 18 is Disabled");
     }

     WebElement password = driver.findElement(By.xpath("//input[@id='disable_password']"));

     if (password.isEnabled()){
         System.out.println("Password is enabled");

     } else {
         System.out.println("Password is Disabled");
     }

     WebElement radioButton = driver.findElement(By.xpath("//input[@id='radio-disabled']"));

     if (radioButton.isEnabled()){
         System.out.println("radioButton is enabled");

     } else {
         System.out.println("radioButton is Disabled");
     }

     WebElement job1 = driver.findElement(By.xpath("//select[@id='job1']"));

     if (job1.isEnabled()){
         System.out.println("job1 is enabled");

     } else {
         System.out.println("job1 is Disabled");
     }

     WebElement job3 = driver.findElement(By.xpath("//select[@id='job3']"));

     if (job1.isEnabled()){
         System.out.println("job3 is enabled");

     } else {
         System.out.println("job3 is Disabled");
     }

 }

 @Test
    public void TC_03_isSelected(){
     driver.get("https://automationfc.github.io/basic-form/index.html");
     WebElement ageUnder18Checkbox = driver.findElement(By.xpath("//input[@id='under_18']"));
     ageUnder18Checkbox.click();

     WebElement languageJava = driver.findElement(By.xpath("//input[@id='java']"));
     languageJava.click();

     if (ageUnder18Checkbox.isSelected()){
         System.out.println("Age Under 18 checkbox is selected");

     } else {
         System.out.println("Age Under 18 is not selected");
     }

     if (languageJava.isSelected()){
         System.out.println("Language Java is selected");

     } else {
         System.out.println("Language Java is not selected");
     }

     languageJava.click();

     if (languageJava.isSelected()){
         System.out.println("Language Java is selected");

     } else {
         System.out.println("Language Java is not selected");
     }

    }

    @Test
    public void TC_04_Register_function_at_MailChimp(){
        driver.get("https://login.mailchimp.com/signup/");
        WebElement email;
        email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("phuong123@gmail.com");

        email.sendKeys(Keys.TAB);

        WebElement password;
        password=driver.findElement(By.xpath("//input[@id='new_password']"));
        password.sendKeys("123");
        password.sendKeys(Keys.TAB);

        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check not-completed']")).isDisplayed());

    }


    @AfterClass
    public void clearBrowser(){
     //driver.quit();
 }
}
