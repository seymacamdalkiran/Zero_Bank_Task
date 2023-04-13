package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;

import org.junit.Assert;

import java.util.Map;

public class PayBills_DtepDefs {
    PayBillsPage payBillsPage=new PayBillsPage();

    @When("Fill the amount box {string} and date box {string} and description box {string}")
    public void fill_the_amount_box_and_date_box_and_description_box(String amount, String date, String description) {
        System.out.println("once amountBox = " + payBillsPage.amountBox.getAttribute("validationMessage"));
        System.out.println("once dateBox = " + payBillsPage.dateBox.getAttribute("validationMessage"));
        payBillsPage.pay(amount, date, description);

        System.out.println("sonra amountBox = " + payBillsPage.amountBox.getAttribute("validationMessage"));
        System.out.println("sonra dateBox = " + payBillsPage.dateBox.getAttribute("validationMessage"));
    }
    @Then("User should see {string} message")
    public void user_should_see_message(String string) {
        String successMessage = payBillsPage.succesPayMessage.getText();
        Assert.assertEquals(successMessage,string);
    }
    @Then("User should be {string} success page")
    public void user_should_be_success_page(String url) {
        Assert.assertNotEquals(url, Driver.get().getCurrentUrl());
    }
    @Then("If amount box {string} or date box {string} are empty user should see {string} text")
    public void if_amount_box_or_date_box_are_empty_user_should_see_text(String account, String date, String message) {
        if(account.isEmpty()){
            String validateMessage = payBillsPage.amountBox.getAttribute("validationMessage");
            Assert.assertEquals(message,validateMessage);
        } else if (date.isEmpty()) {
            String validateMessage = payBillsPage.dateBox.getAttribute("validationMessage");
            Assert.assertEquals(message, validateMessage);
        }
    }
    @Given("Go to {string} tab")
    public void go_to_tab(String string) {
        payBillsPage.tapOnPayBilssaTabs(string);
    }

}
