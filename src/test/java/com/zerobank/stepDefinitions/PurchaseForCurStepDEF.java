package com.zerobank.stepDefinitions;

import com.zerobank.pages.Zero_PayBills;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.util.List;

public class PurchaseForCurStepDEF {
    @Given("the user accesses the Purchase foreign currency cash tab")
    public void theUserAccessesThePurchaseForeignCurrencyCashTab() {
        //Zero_PayBills zero_payBills = new Zero_PayBills();
       new Zero_PayBills().PurchaseForeignCurrencyTab();
    }

    @Then("following currencies should be available")
    public void followingCurrenciesShouldBeAvailable(List<String> expectedOptions){
       BrowserUtils.waitFor(1);
        Zero_PayBills zero_payBills = new Zero_PayBills();
        System.out.println(BrowserUtils.getElementsText(zero_payBills.currencyDropDown().getOptions()));

    List<String> actualOptions= BrowserUtils.getElementsText(zero_payBills.currencyDropDown().getOptions());
        for (String expectedOption : expectedOptions) {
            Assert.assertTrue(actualOptions.contains(expectedOption));

        }

    }

    @When("user tries to calculate cost without selecting a currency")
    public void userTriesToCalculateCostWithoutSelectingACurrency() {
        BrowserUtils.waitFor(1);
        new Zero_PayBills().currencyDropDown().selectByVisibleText("Select One");
        new Zero_PayBills().calculateCostsButton.click();
    }

    @When("user tries to calculate cost without entering a value")
    public void userTriesToCalculateCostWithoutEnteringAValue() {
        BrowserUtils.waitFor(1);
        new Zero_PayBills().AmountBox.clear();
        new Zero_PayBills().calculateCostsButton.click();

    }

    @Then("error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        BrowserUtils.waitFor(1);
        String errorMessage= "Please, ensure that you have filled all the required fields with valid values.";
        Alert alert = Driver.get().switchTo().alert();
        //System.out.println(alert.getText());
        Assert.assertEquals(errorMessage,alert.getText());
        alert.accept();

    }


}
