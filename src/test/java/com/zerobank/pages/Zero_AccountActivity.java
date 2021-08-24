package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Zero_AccountActivity extends BasePage{




    public void Links(String link){

        Driver.get().findElement((By.xpath("//a[text()='"+link+"']") )).click();

    }

    @FindBy(xpath ="//select[@name='accountId']")
    public WebElement dropdown;

    public Select SelectedDropdown(){

        Select select = new Select(dropdown);

        return select;

    }








}
