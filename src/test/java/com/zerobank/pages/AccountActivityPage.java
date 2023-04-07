package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountActivityPage extends BasePage{
    @FindBy(id = "aa_accountId")
    public WebElement accountSelect;
    @FindBy(tagName = "th")
    public List<WebElement> columninActivity;
    public List<String> getColumnNames(){
        return BrowserUtils.getElementsText(columninActivity);
    }
}
