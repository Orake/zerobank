package com.zerobank.stepDefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user enters the information")
    public void the_user_enters_the_information() {

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        LoginPage loginPage = new LoginPage();
        loginPage.login();

    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        BrowserUtils.waitFor(1);
         String actualTitle =Driver.get().getTitle();
         String expectedTitle= "Zero - Account Summary";
        Assert.assertEquals(actualTitle,expectedTitle);


    }

    @When("the user enters the invalid information")
    public void theUserEntersTheInvalidInformation() {

        LoginPage loginPage= new LoginPage();
        loginPage.invalidLogin("abcdefgh","12345678");

    }

    @Then("the user should be able to see the error message login")
    public void theUserShouldBeAbleToSeeTheErrorMessageLogin() {

        LoginPage loginPage = new LoginPage();
        System.out.println(loginPage.ErrorMessage.getText());
        Assert.assertTrue(loginPage.ErrorMessage.isDisplayed());


    }
}
