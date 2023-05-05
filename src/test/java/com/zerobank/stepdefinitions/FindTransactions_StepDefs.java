package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class FindTransactions_StepDefs {
    FindTransactionsPage findTransactionsPage=new FindTransactionsPage();

    @When("The user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String from, String to) {
        findTransactionsPage.sendKeysToDates(from, to);
    }

    @When("Clicks search")
    public void clicks_search() {
        findTransactionsPage.tapOnTheFindButton();
    }
    @Then("Results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String string, String string2) throws ParseException {
        boolean dateBetweenFromAndTo = findTransactionsPage.isDateBetweenFromAndTo(string, string2);
        Assert.assertTrue(dateBetweenFromAndTo);
    }
    @Then("The results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() throws ParseException {
        boolean dateOrdered = findTransactionsPage.isDateOrdered();
        Assert.assertTrue(dateOrdered);
    }
    @When("The user enters description {string}")
    public void the_user_enters_description(String string) {
        findTransactionsPage.sendKeysToDescription(string);
    }

    @Then("Results table should only show descriptions containing “ONLINE”")
    public void results_table_should_only_show_descriptions_containing_ONLINE() {
        List<String> listDescriptions=findTransactionsPage.getAllTextFromDescriptions();
/*        boolean bl=true;
        for (int i = 0; i < listDescriptions.size(); i++) {
            if(!listDescriptions.get(i).contains("ONLINE")){
                bl =false;
                break;
            }
        }
        Assert.assertTrue(bl);
 */
        Assert.assertTrue(listDescriptions.stream().allMatch(n -> n.contains("ONLINE")));
    }
    @Then("Results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        int size = findTransactionsPage.getAllTextFromDeposit().size();
        Assert.assertTrue(size>0);
    }
    @Then("Results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        int size = findTransactionsPage.getAllTextFromWithdrawal().size();
        Assert.assertTrue(size>0);
    }
    @When("The user selects type {string} and clicks on Find")
    public void the_user_selects_type_and_clicks_on_Find(String string) {
        findTransactionsPage.selectType(string);
    }
    @Then("Results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        int size = findTransactionsPage.getAllTextFromWithdrawal().size();
        Assert.assertFalse(size>0);
    }
    @Then("Results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_deposit() {
        int size = findTransactionsPage.getAllTextFromDeposit().size();
        Assert.assertFalse(size>0);
    }

    @When("The user enters date range from “{int}-{int}-{int}” to “{int}-{int}-{int}”")
    public void the_user_enters_date_range_from_to(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6) {
        BrowserUtils.waitFor(5);
        findTransactionsPage.sendKeysToDates(int1, int2, int3,int4,int5,int6);
    }
}
