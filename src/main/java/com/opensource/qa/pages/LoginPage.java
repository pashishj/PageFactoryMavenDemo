package com.opensource.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //page object factory of login page

    @FindBy(css = "input#email_create")
    private WebElement emailAddressTextBox;

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountButton;

    @FindBy(id = "email")
    private WebElement registeredEmailTextBox;

    @FindBy(name = "passwd")
    private WebElement registeredUserPasswordTextBox;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement signInButton;

   /* @FindBy(xpath = "//h1[text()='Create an account']")
    public WebElement createAccountHeading;*/

  public By createAccountHeading= By.xpath("//h1[text()='Create an account']");

    public void enterEmailtoCreateAccount(String email) {
        emailAddressTextBox.sendKeys(email);
    }

    public void clickOnCreateAccountBtn() {
        createAnAccountButton.click();
    }

    public void enterRegisterEmail(String email) {
        registeredEmailTextBox.sendKeys(email);
    }

    public void enterRegisterAccountPass(String password) {
        registeredUserPasswordTextBox.sendKeys(password);
    }

    public void clickOnSignInBtn() {
        signInButton.click();
    }

       public LoginPage() {
        PageFactory.initElements(driver, this);
    }
}
