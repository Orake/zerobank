package com.zerobank.stepDefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.pages.Zero_AccountActivity;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityStepDefs {
    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void theUserClicksOnSavingsLinkOnTheAccountSummaryPage(String str) {
        Zero_AccountActivity zeroAccountActivity = new Zero_AccountActivity();
        zeroAccountActivity.Links(str);

    }

    @Then("the Account Activity page should be displayed")
    public void theAccountActivityPageShouldBeDisplayed() {


      String actual = Driver.get().getTitle();
      String expected = "Zero - Account Activity";

        Assert.assertEquals(actual, expected);



    }

    @And("Account drop down should have {string} selected")
    public void accountDropDownShouldHaveSavingsSelected(String str1) {
        Zero_AccountActivity dropdown = new Zero_AccountActivity();
        dropdown.dropdowns(str1);

        String actual = Driver.get().getTitle();
        String expected = "Brokerage";
        Assert.assertEquals(actual, expected);


    }
}
