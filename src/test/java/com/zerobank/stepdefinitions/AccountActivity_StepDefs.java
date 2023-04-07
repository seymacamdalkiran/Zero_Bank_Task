package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivity_StepDefs {
    AccountActivityPage accountActivityPage=new AccountActivityPage();
    @Then("Verify that default account type")
    public void verify_that_default_account_type() {
        WebElement accountSelect = accountActivityPage.accountSelect;
        Select select=new Select(accountSelect);
        String actual = select.getFirstSelectedOption().getText();
        String expected="Savings";
        Assert.assertEquals(expected, actual);
    }
    @Then("Verify that account drop down menu")
    public void verify_that_account_drop_down_menu(List<String> expected) {
        WebElement accountSelect = accountActivityPage.accountSelect;
        Select select=new Select(accountSelect);
        List<WebElement> options = select.getOptions();
         List<String> actual = BrowserUtils.getElementsText(options);
        Assert.assertEquals(expected,actual);
    }
    @Then("Validate all column are on the page")
    public void validate_all_column_are_on_the_page(List<String> expected) {
        List<String> actual = accountActivityPage.getColumnNames();
        Assert.assertEquals(actual,expected);
    }
}
