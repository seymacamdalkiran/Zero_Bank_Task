package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountSummary_StepDefs {
    AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
    @Given("Go to the {string} page")
    public void go_to_the_page(String tab) {
        accountSummaryPage.homeOnlineFeedback(tab);
    }
    @When("Go to the {string} module")
    public void go_to_the_module(String module) {
        accountSummaryPage.onlineBankingModule(module);
    }
    @Then("Verify that {string} title")
    public void verify_that_title(String expected) {
        String actual = Driver.get().getTitle();
        Assert.assertEquals(expected,actual);
    }
    @Then("Validate all table are on the page")
    public void validate_all_table_are_on_the_page(List<String> tableName) {
        List<String> actual= BrowserUtils.getElementsText(accountSummaryPage.tableHeads);
        Assert.assertEquals(tableName,actual);
    }
    @Then("Validate all column are on the {string} page")
    public void validate_all_column_are_on_the_page(String headName,List<String> columnHeads) {
        List<String> actual = accountSummaryPage.accountSummaryColumnNames(headName);
        System.out.println("actual = " + actual);
        System.out.println("columnHeads = " + columnHeads);
        Assert.assertEquals(columnHeads, actual);
    }
    @Then("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String name) {
        accountSummaryPage.clickTheTableMenu(name);
    }
}
