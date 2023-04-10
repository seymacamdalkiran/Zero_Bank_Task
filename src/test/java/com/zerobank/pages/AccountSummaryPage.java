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
    @FindBy(xpath = "//a[text()='Savings']")
    public WebElement savings;
    @FindBy(xpath = "//a[text()='Brokerage']")
    public WebElement brokerage;
    @FindBy(xpath = "//a[text()='Checking']")
    public WebElement checking;
    @FindBy(xpath = "//a[text()='Credit Card']")
    public WebElement creditCard;
    @FindBy(xpath = "//a[text()='Loan']")
    public WebElement loan;
    public List<String> accountSummaryColumnNames(String tagName){
        List<WebElement> elements = Driver.get().findElements(By.xpath("(//h2[text()='"+tagName+"']//following-sibling::div)[1]//th"));
        return BrowserUtils.getElementsText(elements);
    }
    public void clickTheTableMenu(String name){
        Driver.get().findElement(By.xpath("//a[text()='"+name+"']")).click();
    }
}
