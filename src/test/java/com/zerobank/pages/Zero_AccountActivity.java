package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Zero_AccountActivity {

    public void Links(String link){

        Driver.get().findElement((By.xpath("//a[text()='"+link+"']") )).click();

    }

    public void dropdowns(String dropdown){
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.xpath("//option[text()='"+dropdown+"'])"));



    }


}
