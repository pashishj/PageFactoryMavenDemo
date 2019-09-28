package com.qa.tests;

import Utility.UtilityClass;
import com.opensource.qa.pages.HomePage;
import com.opensource.qa.pages.LoginPage;
import com.opensource.qa.pages.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {

    public HomePage homePage;
    public LoginPage loginPage;
    public static Logger log = Logger.getLogger(LoginPageTests.class.getName());
    public LoginPageTests(){
        super();
    }

    @BeforeClass
    public void setup(){
        webDriverinitialize();
        homePage= new HomePage();
        log.info("WebDriver Initialized");
        homePage.signIn();
        loginPage=new LoginPage();
        UtilityClass.takeScreenshot(LoginPageTests.class);
    }

    @Test(enabled =false)
    public void validEmailCreateAnAccount(){
        loginPage.enterEmailtoCreateAccount("test12346@gmail.com");
        loginPage.clickOnCreateAccountBtn();
        Assert.assertTrue(UtilityClass.checkwebElementDisplayed(loginPage.createAccountHeading));
    }

    @Test
    public void display(){
        driver.findElement(By.xpath("//test")).click();
        System.out.println("Number is"+5/0);
    }

}
