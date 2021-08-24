package com.zerobank.stepDefinitions;

import com.zerobank.pages.FindTransactionPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FindTransactionsStepDefs {

    @Given("the user accesses the Find Transactions tab")
    public void theUserAccessesTheFindTransactionsTab() {
        FindTransactionPage findTransactionpage = new FindTransactionPage();
        findTransactionpage.FindTransActionsTab();

    }


    @When("the user enters date range from {string} to {string}")
    public void theUserEntersDateRangeFromTo(String dateFrom, String dateTo) {
        FindTransactionPage findTransactionPage = new FindTransactionPage();
        findTransactionPage.enterDates(dateFrom, dateTo);
    }

    @And("clicks search")
    public void clicksSearch() {
        BrowserUtils.waitFor(1);
        new FindTransactionPage().findButton.click();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void resultsTableShouldOnlyShowTransactionsDatesBetweenTo(String from, String to) throws ParseException {

        BrowserUtils.waitFor(1);

        FindTransactionPage findTransactionPage = new FindTransactionPage();

        for(WebElement each: findTransactionPage.transactionsDate){
            Assert.assertTrue(each.getText().compareTo(from)>=0);
            Assert.assertTrue(each.getText().compareTo(to)<=0);
        }
    }

    @And("the results should be sorted by most recent date")
    public void theResultsShouldBeSortedByMostRecentDate() {
        FindTransactionPage findTransactionPage = new FindTransactionPage();
        List<String> list = BrowserUtils.getElementsText(findTransactionPage.transactionsDate);
        for(int i=0; i<list.size()-1; i++){
            Assert.assertTrue(list.get(i).compareTo(list.get(i+1))>=0);
        }

    }


    @And("the results table should only not contain transactions dated {string}")
    public void theResultsTableShouldOnlyNotContainTransactionsDated(String date) {
        FindTransactionPage findTransactionPage = new FindTransactionPage();
        List<String> list = BrowserUtils.getElementsText(findTransactionPage.transactionsDate);
        System.out.println(list);
        System.out.println(date);
        Assert.assertFalse(list.contains(date));

    }


    @When("the user enters description {string}")
    public void theUserEntersDescription(String word) {
        new FindTransactionPage().descriptionBox.clear();
        new FindTransactionPage().descriptionBox.sendKeys(word);
    }


    @Then("results table should only show descriptions containing {string}")
    public void resultsTableShouldOnlyShowDescriptionsContaining(String word) {
        BrowserUtils.waitFor(1);
        FindTransactionPage findTransactionPage = new FindTransactionPage();

        List<String> list = BrowserUtils.getElementsText(findTransactionPage.DescriptionResult);
        if(list.size()==0){
            list.add("empty"); //we do this because when list is empty, compiler passes assertion loop
        }
        for (String str: list){
            Assert.assertTrue(str.contains(word));
        }
    }

    @But("results table should not show descriptions containing {string}")
    public void resultsTableShouldNotShowDescriptionsContaining(String word) {

        FindTransactionPage findTransactionPage = new FindTransactionPage();
        List<String> list = BrowserUtils.getElementsText(findTransactionPage.DescriptionResult);
           Assert.assertFalse(list.contains(word));
        }


    @Then("results table should show at least one result under Deposit")
    public void resultsTableShouldShowAtLeastOneResultUnderDeposit() {
        FindTransactionPage findTransactionPage = new FindTransactionPage();
        List<String> list = BrowserUtils.getElementsText(findTransactionPage.DepositResult);
        Assert.assertTrue(list.size()>=1);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void resultsTableShouldShowAtLeastOneResultUnderWithdrawal() {
        FindTransactionPage findTransactionPage = new FindTransactionPage();
        List<String> list = BrowserUtils.getElementsText(findTransactionPage.WithdrawalResult);
        Assert.assertTrue(list.size()>=1);


    }

    @When("user selects type {string}")
    public void userSelectsType(String type) {
        BrowserUtils.waitFor(1);
        FindTransactionPage findTransactionPage = new FindTransactionPage();
        Select select = new Select(findTransactionPage.TypeDropdown);
        select.selectByVisibleText(type);
        findTransactionPage.findButton.click();

    }


    @But("results table should show no result under Withdrawal")
    public void resultsTableShouldShowNoResultUnderWithdrawal() {
        BrowserUtils.waitFor(1);
        FindTransactionPage findTransactionPage = new FindTransactionPage();
        List<String> list = BrowserUtils.getElementsText(findTransactionPage.WithdrawalResult);
        Assert.assertFalse(list.isEmpty());

    }

    @But("results table should show no result under Deposit")
    public void resultsTableShouldShowNoResultUnderDeposit() {
        BrowserUtils.waitFor(1);
        FindTransactionPage findTransactionPage = new FindTransactionPage();
        List<String> list = BrowserUtils.getElementsText(findTransactionPage.DepositResult);
        Assert.assertFalse(list.isEmpty());

    }
}

