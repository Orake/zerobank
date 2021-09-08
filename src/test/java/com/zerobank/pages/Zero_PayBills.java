package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Currency;
import java.util.List;

public class Zero_PayBills extends BasePage{

    @FindBy(xpath = "//a[text()='Pay Bills']")
    public WebElement PayBillsTab;

    @FindBy (xpath = "//a[text()='Add New Payee']")
    public WebElement AddNewPayeeTab;

    @FindBy (id = "np_new_payee_name")
    public WebElement PayeeNameBox;

    @FindBy (id="np_new_payee_address")
    public WebElement PayeeAddressBox;

    @FindBy(id="np_new_payee_account")
    public WebElement AccountBox;

    @FindBy(id="np_new_payee_details")
    public WebElement PayeeDetailsBox;

    @FindBy (xpath = "//input[@value='Add']")
    public WebElement AddButton;

    @FindBy (xpath = "//div[@id='alert_content']")
    public WebElement SuccessMessage;

    @FindBy (xpath = "//a[text()='Purchase Foreign Currency']")
    public WebElement PurchaseForeignCurrencyTab;

    @FindBy (id = "pc_currency")
    public WebElement CurrencyDropDown;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostsButton;

    @FindBy(id = "pc_amount")
    public WebElement AmountBox;

    public void AddNewPayeeTab(){
        PayBillsTab.click();
        BrowserUtils.waitFor(1);
        AddNewPayeeTab.click();

    }
    public void PurchaseForeignCurrencyTab(){
        PayBillsTab.click();
        BrowserUtils.waitFor(1);
        PurchaseForeignCurrencyTab.click();
    }

    public Select currencyDropDown(){
        return new Select(CurrencyDropDown);
    }


}
