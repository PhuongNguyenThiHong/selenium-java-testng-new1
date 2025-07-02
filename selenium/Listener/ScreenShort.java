package Listener;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testNG.Topic10_Listener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenShort implements ITestListener

{
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((Topic10_Listener) testClass).getDriver();

        String screenshotPath = captureScreenshot(driver, result.getName());
        System.out.println("Test failed - Screenshot captured: " + screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    public String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //Create folder store: MAC thi can dung /. Windown \\
            String screenPath = System.getProperty("user.dir") + "/screenshot/" + screenshotName + "_" + formater.format(calendar.getTime()) + ".png";
            //Copi file
            FileUtils.copyFile(source, new File(screenPath));
            return screenPath;
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
            return e.getMessage();
        }
    }
}
