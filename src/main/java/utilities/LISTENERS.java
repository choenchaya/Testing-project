package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.swing.*;
import java.io.File;

public class LISTENERS extends CommonOps implements ITestListener {

    public void onStart(ITestContext execution) {
        System.out.println("---------------------- Starting Execution ------------------");
    }

    public void onFinish(ITestContext execution) {
        System.out.println("---------------------- Ending Execution ------------------");
    }

    public void onTestStart(ITestResult test) {
        System.out.println("---------------------- Test: " + test.getName() + " Started ------------------");
    }

    public void onTestSuccess(ITestResult test) {
        if (!Platform.equalsIgnoreCase("api")) {

            System.out.println("---------------------- Test: " + test.getName() + " Passed ------------------");
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            File file= new File("./test-recordings/"+test.getName()+".avi");
            if (file.delete())
                System.out.println("File Deleted Successfully");
            else
                System.out.println("Failed to Delete File");
        }

    }

    public void onTestFailure(ITestResult test) {
        if (!Platform.equalsIgnoreCase("api")) {
            System.out.println("---------------------- Test "  + test.getName() + " Failed ------------------");
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            saveScreenshot();
        }

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
    }

    public void onTestSkipped(ITestResult test) {
        // TODO Auto-generated method stub
    }
    @Attachment(value = "Page Screen Shot", type = "image/png")
    public byte[] saveScreenshot(){
        if (!Platform.equalsIgnoreCase("mobile"))

            return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

        else
            return ((TakesScreenshot)mobileDriver).getScreenshotAs(OutputType.BYTES);

    }
}
