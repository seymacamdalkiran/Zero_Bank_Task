package com.zerobank.stepdefinitions;

import com.zerobank.pages.PurchasePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Purchase_StepDefs {
    PurchasePage purchasePage=new PurchasePage();


    @Then("Following currencies should be available")
    public void following_currencies_should_be_available(List<String> list) {
        List<String> optionsText = purchasePage.getTextAllCurrencyOptions();
        boolean bl = optionsText.containsAll(list);
        Assert.assertTrue(bl);
    }

    @When("User tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        purchasePage.tapOnCalculateButton();
    }

    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert= Driver.get().switchTo().alert();
        String actual = alert.getText();
        String expected="Please, ensure that you have filled all the required fields with valid values.";
        Assert.assertEquals(expected, actual);
    }
}
