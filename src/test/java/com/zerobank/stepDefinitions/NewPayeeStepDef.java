package com.zerobank.stepDefinitions;

import com.zerobank.pages.NewPayeePage;
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
        new NewPayeePage().createNewPayee(NewPayeeInfo.get("Payee Name"),
                NewPayeeInfo.get("Payee Address"),NewPayeeInfo.get("Account"),
                NewPayeeInfo.get("Payee details"));

    }

    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String message) {
        NewPayeePage newPayeePage = new NewPayeePage();
        //System.out.println(message);
        //System.out.println(newPayeePage.SuccessMessage.getText());
        Assert.assertEquals(message,newPayeePage.SuccessMessage.getText() );

    }
}
