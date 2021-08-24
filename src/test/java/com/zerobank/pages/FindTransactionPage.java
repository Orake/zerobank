package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Driver;
import java.util.List;

public class FindTransactionPage extends BasePage{

    @FindBy (xpath = "//a[text()='Account Activity']")
    public WebElement AccountActivityTab;

    @FindBy (xpath = "//li[@class='ui-state-default ui-corner-top']")
    public WebElement FindTransactionsTab;

    @FindBy (id = "aa_fromDate")
    public WebElement DatesFrom;

    @FindBy (xpath = "//input[@name='toDate']")
    public WebElement DatesTo;

    @FindBy (xpath = "// button[@type='submit']")
    public WebElement findButton;

    @FindBy (xpath = "//div[@id='filtered_transactions_for_account']//tr/td[1]")
    public List<WebElement> transactionsDate;

    @FindBy (id = "aa_description")
    public WebElement descriptionBox;

    @FindBy (xpath= "//div[@id='filtered_transactions_for_account']//tr/td[2]")
    public List<WebElement> DescriptionResult;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[3]")
    public List<WebElement> DepositResult;

    @FindBy (xpath = "//div[@id='filtered_transactions_for_account']//tr/td[4]")
    public List<WebElement> WithdrawalResult;

    @FindBy(id="aa_type")
    public WebElement TypeDropdown;


    public void FindTransActionsTab(){
        AccountActivityTab.click();
        BrowserUtils.waitFor(1);
        FindTransactionsTab.click();
    }

    public void enterDates(String dateFrom, String dateTo){
        DatesFrom.clear();
        DatesFrom.sendKeys(dateFrom);
        DatesTo.clear();
        DatesTo.sendKeys(dateTo);
    }






}
