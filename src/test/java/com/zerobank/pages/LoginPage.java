package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{



    @FindBy(id ="user_login")
    public WebElement username;

    @FindBy(id="user_password")
    public WebElement password;

    @FindBy(name="submit")
    public WebElement SignIn;

   @FindBy(xpath = "//a[@id='proceed-link']")
   public  WebElement ProceedButton;

    @FindBy(xpath="//button[@id='details-button']")
    public WebElement AdvancedButton;

    @FindBy(xpath = "(//form[@id='login_form']/div)[1]")
    public WebElement ErrorMessage;



    public void login(){
        username.sendKeys("username");
        password.sendKeys("password");
        SignIn.click();
        BrowserUtils.waitFor(2);
        AdvancedButton.click();
        BrowserUtils.waitForClickablility(ProceedButton,1);
        ProceedButton.click();



    }

    public void invalidLogin(String invalidusername, String invalidpassword){
        username.sendKeys(invalidusername);
        password.sendKeys(invalidpassword);
        SignIn.click();

    }

}
