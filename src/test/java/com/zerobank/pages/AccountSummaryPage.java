package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage{
    @FindBy(tagName = "h2")
    public List<WebElement> tableHeads;

    public List<String> accountSummaryColumnNames(String tagName){
        List<WebElement> elements = Driver.get().findElements(By.xpath("(//h2[text()='"+tagName+"']//following-sibling::div)[1]//th"));
        return BrowserUtils.getElementsText(elements);
    }
}
