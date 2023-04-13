package com.zerobank.stepdefinitions;

import com.zerobank.pages.AddNewPayeePage;
import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayee_StepDefs {
    AddNewPayeePage addNewPayeePage=new AddNewPayeePage();
    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> dataTable) {
        addNewPayeePage.getPayeeName().sendKeys(dataTable.get("Payee Name"));
        addNewPayeePage.getPayeeAddress().sendKeys(dataTable.get("Payee Address"));
        addNewPayeePage.getAccount().sendKeys(dataTable.get("Account"));
        addNewPayeePage.getPayeeDetails().sendKeys(dataTable.get("Payee details"));
    }
    @When("Taps on add button")
    public void taps_on_add_button() {
        addNewPayeePage.clickAddButton();
    }
    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was should successfully created should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_should_successfully_created_should_be_displayed() {
        String actual = addNewPayeePage.getPayeeMessageText();
        String expected="The new payee The Law Offices of Hyde, Price & Scharks was successfully created.";
        Assert.assertEquals(expected, actual);
    }
}
