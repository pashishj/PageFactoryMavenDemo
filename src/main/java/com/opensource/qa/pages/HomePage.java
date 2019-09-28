package com.opensource.qa.pages;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    public static String homePageTitle="My Store";
    public static String loginPageTitle="Login - My Store";

    @FindBy (xpath="//a[@title='Log in to your customer account']")
    WebElement signIn;

    @FindBy (css = "input#search_query_top")
    WebElement searchBox;

    @FindBy (partialLinkText = "contact")
    WebElement contactUSLink;

    @FindBy (xpath="//a[@title='Women']")
    WebElement womenTab;

    @FindBy (xpath="//a[@title='Dresses']")
    WebElement deressesTab;

    @FindBy (xpath="//a[@title='T-shirts']")
    WebElement tShirtTab;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public void signIn(){
       signIn.click();
    }

}
