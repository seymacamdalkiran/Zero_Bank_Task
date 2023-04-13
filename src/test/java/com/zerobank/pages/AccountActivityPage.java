package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityPage extends BasePage{
    @FindBy(id = "aa_accountId")
    @CacheLookup
    public WebElement defaultSelect;


    @FindBy(tagName = "th")
    @CacheLookup
    public List<WebElement> columninActivity;

    @FindBy(xpath = "//a[text()='Find Transactions']")
    @CacheLookup
    private WebElement findTransTab;

    @FindBy(xpath = "//a[text()='Show Transactions']")
    @CacheLookup
    private WebElement showTransTab;




    public List<String> getColumnNames(){
        return BrowserUtils.getElementsText(columninActivity);
    }
    public void selectShowOrFindTransactions(String tab){
        BrowserUtils.waitForClickablility(findTransTab,5);
        Driver.get().findElement(By.xpath("//a[text()='"+tab+"']")).click();
    }



}
