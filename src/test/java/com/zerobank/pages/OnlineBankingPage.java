package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnlineBankingPage extends BasePage{
    @FindBy(id = "account_summary_link")
    public WebElement accountSummary;
    @FindBy(id = "account_activity_link")
    public WebElement accountActivity;
    @FindBy(id = "transfer_funds_link")
    public WebElement transferFuds;
}
