package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(id = "user_login")
    public WebElement mail;
    @FindBy(id = "user_password")
    public WebElement passWord;
    @FindBy(id = "user_remember_me")
    public WebElement keepMeSignedIn;
    @FindBy(xpath = "//input[@class='btn btn-primary']")
    public WebElement signIn;
   // @FindBy(xpath = "//div[@class='alert alert-error']")
  //  @FindBy(xpath = "//form[@id='login_form']/div")
   // @FindBy(xpath = "//h3[text()='Troubles entering the site?']")
    @FindBy(xpath = "//div[contains(text(),'Login and/or password are wrong.')]")
    public WebElement wrongWarningMessage;


    public void loginOl(String email,String password){
        mail.sendKeys(email);
        passWord.sendKeys(password);
        click(signIn);
    }
    public void loginOl(){
        mail.sendKeys(ConfigurationReader.get("username"));
        passWord.sendKeys(ConfigurationReader.get("password"));
        click(signIn);
    }
}
