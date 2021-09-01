package com.zerobank.stepDefinitions;

import com.zerobank.pages.NewPayeePage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class NewPayeeStepDef {
    @Given("Add new payee tab")
    public void addNewPayeeTab() {
        NewPayeePage newPayeePage = new NewPayeePage();
        newPayeePage.AddNewPayeeTab();

    }

    @And("creates new payee using following information")
    public void createsNewPayeeUsingFollowingInformation(Map<String,String> NewPayeeInfo) {
        BrowserUtils.waitFor(1);
       NewPayeePage newPayeePage = new NewPayeePage();



        newPayeePage.PayeeNameBox.sendKeys(NewPayeeInfo.get("Payee Name"));
        newPayeePage.PayeeAddressBox.sendKeys(NewPayeeInfo.get("Payee Address"));
        newPayeePage.AccountBox.sendKeys(NewPayeeInfo.get("Account"));
        newPayeePage.PayeeDetailsBox.sendKeys(NewPayeeInfo.get("Payee details"));

        newPayeePage.AddButton.click();

    }

    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String message) {
        NewPayeePage newPayeePage = new NewPayeePage();
        //System.out.println(message);
        //System.out.println(newPayeePage.SuccessMessage.getText());
        Assert.assertEquals(message,newPayeePage.SuccessMessage.getText() );

    }
}
