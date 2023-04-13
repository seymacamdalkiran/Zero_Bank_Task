package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity_StepDefs {
    AccountActivityPage accountActivityPage=new AccountActivityPage();
    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String firstSelect) {
        WebElement savingSelect = accountActivityPage.defaultSelect;
        Select select=new Select(savingSelect);
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(firstSelect, actual);
    }
    @Then("Verify that account drop down menu")
    public void verify_that_account_drop_down_menu(List<String> expected) {
        WebElement accountSelect = accountActivityPage.defaultSelect;
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

    @Then("The user accesses the {string} tab")
    public void the_user_accesses_the_tab(String string) {
        accountActivityPage.selectShowOrFindTransactions(string);
    }




}
