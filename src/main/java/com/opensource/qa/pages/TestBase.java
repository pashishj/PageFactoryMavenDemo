package com.opensource.qa.pages;

import Listeners.SeleniumWebDriverListener;
import config.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static Properties prop;
    public static WebDriver driver;
    public static FileInputStream fis;
    public static Logger log = Logger.getLogger(TestBase.class.getName());
    public static String log4jurl = "C:\\Users\\pashi\\Documents\\Selenium\\DemoProjects\\Opensourcecms\\src\\main\\java\\config\\log4j.properties";

    public TestBase() {

        //configure log4j property file locared at log4jurl path
        PropertyConfigurator.configure(log4jurl);

        //Create FileinputStream object to read property file.

        try {
            fis = new FileInputStream("C:\\Users\\pashi\\Documents\\Selenium\\DemoProjects\\Opensourcecms\\src\\main\\java\\config\\prop.properties");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Create Propery file object

        prop = new Properties();

        //Load input file object to property file
        try {
            prop.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void webDriverinitialize() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        log.info("Navigation to url===>" + prop.getProperty("url"));

        driver.manage().timeouts().implicitlyWait(Constants.implicitWait, TimeUnit.SECONDS);

        //Register webdriver object with WebDriverEventListener

        EventFiringWebDriver edriver=new EventFiringWebDriver(driver);

        //Create instance of class which implements WebDriverEvent Listener

        SeleniumWebDriverListener handler=new SeleniumWebDriverListener();
        edriver.register(handler);
        driver=edriver;




    }


}
