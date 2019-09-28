package com.qa.tests;

import Utility.UtilityClass;
import com.opensource.qa.pages.HomePage;
import com.opensource.qa.pages.TestBase;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    public static Logger log = Logger.getLogger(HomePageTest.class.getName());


    public HomePage homePage;

    HomePageTest() {
        super();
    }

    @BeforeClass
    public void setup() {
        webDriverinitialize();
        homePage= new HomePage();
        log.info("WebDriver Initialized");

    }


    @Test(priority = 0)
    public void pageTitleValidation(){
        String homePageTitle=UtilityClass.getpageTitle();
        log.info("Home Page Title is ===>"+homePageTitle);
        Assert.assertEquals(homePageTitle,HomePage.homePageTitle);
        UtilityClass.takeScreenshot(HomePageTest.class);
    }

    @Test(priority = 1)
    public void validateSigninLink(){
        homePage.signIn();
        log.info("Sign In link clicked");
        log.info("Login Page Title is ===>"+HomePage.loginPageTitle);
        Assert.assertEquals(UtilityClass.getpageTitle(),HomePage.loginPageTitle);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
