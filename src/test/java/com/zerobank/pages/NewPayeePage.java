package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPayeePage extends BasePage {

    @FindBy (xpath = "//a[text()='Pay Bills']")
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

    public void AddNewPayeeTab(){
        PayBillsTab.click();
        BrowserUtils.waitFor(1);
        AddNewPayeeTab.click();

    }
    public void createNewPayee(String name, String address, String account, String details){
        BrowserUtils.waitForPageToLoad(1);
        PayeeNameBox.sendKeys(name);
        PayeeAddressBox.sendKeys(address);
        AccountBox.sendKeys(account);
        PayeeDetailsBox.sendKeys(details);
        AddButton.click();

    }

}
