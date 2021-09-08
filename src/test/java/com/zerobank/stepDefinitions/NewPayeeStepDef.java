package com.zerobank.stepDefinitions;

import com.zerobank.pages.Zero_PayBills;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class NewPayeeStepDef {
    @Given("Add new payee tab")
    public void addNewPayeeTab() {
        Zero_PayBills newPayeePage = new Zero_PayBills();
        newPayeePage.AddNewPayeeTab();

    }

    @And("creates new payee using following information")
    public void createsNewPayeeUsingFollowingInformation(Map<String,String> NewPayeeInfo) {
        BrowserUtils.waitFor(1);
        Zero_PayBills newPayeePage = new Zero_PayBills();



        newPayeePage.PayeeNameBox.sendKeys(NewPayeeInfo.get("Payee Name"));
        newPayeePage.PayeeAddressBox.sendKeys(NewPayeeInfo.get("Payee Address"));
        newPayeePage.AccountBox.sendKeys(NewPayeeInfo.get("Account"));
        newPayeePage.PayeeDetailsBox.sendKeys(NewPayeeInfo.get("Payee details"));

        newPayeePage.AddButton.click();

    }

    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String message) {
        Zero_PayBills newPayeePage = new Zero_PayBills();
        //System.out.println(message);
        //System.out.println(newPayeePage.SuccessMessage.getText());
        Assert.assertEquals(message,newPayeePage.SuccessMessage.getText() );

    }
}
