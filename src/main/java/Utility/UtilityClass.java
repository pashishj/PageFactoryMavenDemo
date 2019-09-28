package Utility;

import com.opensource.qa.pages.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class UtilityClass extends TestBase {

    public static String getpageTitle(){

        return driver.getTitle();
    }

    public static boolean checkwebElementDisplayed(By webElement){

        return driver.findElement(webElement).isDisplayed();
    }

    public static boolean checkwebElementEnabled(By webElement){

        return driver.findElement(webElement).isEnabled();
    }

    public static boolean checkwebElementSelected(By webElement){

        return driver.findElement(webElement).isSelected();
    }

    public static void takeScreenshot(Class className){

        TakesScreenshot takesScreenshot =((TakesScreenshot)driver);
        File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {

            FileUtils.copyFile(sourceFile,new File("C:\\Users\\pashi\\Documents\\Selenium\\DemoProjects\\Opensourcecms\\src\\Screenshots\\"+className+"\\"+"Test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
