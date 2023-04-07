package com.zerobank.stepdefinitions;

import com.zerobank.pages.BasePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Login_StepDefs {
    LoginPage loginPage=new LoginPage();
    @Given("The user should go to the website")
    public void the_user_should_go_to_the_website() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("The user should be on the login page")
    public void the_user_should_be_on_the_login_page() {
        BasePage.click(loginPage.signinButton);
    }
    @When("The user should be login {string} and {string}")
    public void the_user_should_be_login_and(String name, String password) {
        loginPage.loginOl(name, password);

    }
    @Then("The user sould see {string} message")
    public void the_user_sould_see_message(String string) {
        String actual = loginPage.wrongWarningMessage.getText();
        Assert.assertEquals(string,actual);
    }
    @Then("The user should see username menu")
    public void the_user_should_see_username_menu() {
        Driver.get().navigate().back();
        Assert.assertTrue(loginPage.usernameText.isDisplayed());
    }

}
