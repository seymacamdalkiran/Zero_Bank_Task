package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchasePage extends BasePage{

    @FindBy(id = "pc_currency")
    @CacheLookup
    private WebElement currencyType;

    @FindBy(id = "pc_calculate_costs")
    private WebElement calculateCostsButton;

    public List<WebElement> getAllCurrencyOptions(){
        Select select=new Select(currencyType);
        return select.getOptions();
    }
    public List<String> getTextAllCurrencyOptions(){
        return BrowserUtils.getElementsText(getAllCurrencyOptions());
    }

    public void tapOnCalculateButton(){
        BrowserUtils.clickWithJS(calculateCostsButton);
    }
}
